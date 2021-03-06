package br.salaoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.salaoeveris.app.request.ServicoList;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ServicoResponse;
import br.salaoeveris.app.service.ServicoService;


@RestController
@RequestMapping("/servicos")
public class ServicoController extends BaseController {

	private final ServicoService _service;

	@Autowired
	public ServicoController(ServicoService service) {
		_service = service;
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody ServicoRequest servicoRequest) {
		try {
			BaseResponse response = _service.inserir(servicoRequest);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			ServicoList servicos = _service.listar();
			return ResponseEntity.status(HttpStatus.OK).body(servicos);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
	

	@PutMapping(path = "/{id}")
	public ResponseEntity atualizar(@RequestBody ServicoRequest servicoRequest, @PathVariable Long id) {
		try {
			BaseResponse response = _service.atualizar(id, servicoRequest);
			return ResponseEntity.status(response.StatusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity deletar(@PathVariable Long id) {
		try {
			BaseResponse response = _service.deletar(id);
			return ResponseEntity.status(response.StatusCode).build();
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.StatusCode).body(errorBase);
		}
	}
}