package br.salaoeveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Servico;
import br.salaoeveris.app.repository.ServicoRepository;
import br.salaoeveris.app.request.ServicoList;
import br.salaoeveris.app.request.ServicoRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ServicoResponse;



@Service
public class ServicoService {
	final ServicoRepository _repository;

	@Autowired
	public ServicoService(ServicoRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(ServicoRequest servicoRequest) {
		Servico servico = new Servico();
		BaseResponse base = new BaseResponse();

		if (servicoRequest.getNome() == "") {
			base.Message = "O nome do servico não foi preenchido.";
			return base;
		}

		if (servicoRequest.getValor() == 0) {
			base.Message = "O Valor do servico não foi preenchido.";
			return base;
		}

		servico.setNome(servicoRequest.getNome());
		servico.setValor(servicoRequest.getValor());

		_repository.save(servico);
		base.StatusCode = 201;
		base.Message = "Servico inserido com sucesso.";
		return base;
	}

	public ServicoList listar() {

		List<Servico> lista = _repository.findAll();

		ServicoList response = new ServicoList();
		response.setServicos(lista);
		response.StatusCode = 200;
		response.Message = "Servicos obtidos com sucesso.";

		return response;
	}

	public BaseResponse atualizar(Long id, ServicoRequest servicoRequest){
		Servico servico = new Servico();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (servicoRequest.getNome() == "") {
			base.Message = "O nome do servico não foi preenchido.";
			return base;
		}

		if (servicoRequest.getValor() == 0) {
			base.Message = "O valor do servico não foi preenchido.";
			return base;
		}

		servico.setId(id);
		servico.setNome(servicoRequest.getNome());
		servico.setValor(servicoRequest.getValor());

		_repository.save(servico);
		base.StatusCode = 200;
		base.Message = "Servico atualizado com sucesso.";
		return base;
	}

	public BaseResponse deletar(Long id) {
		BaseResponse response = new BaseResponse();

		if (id == null || id == 0) {
			response.StatusCode = 400;
			return response;
		}

		_repository.deleteById(id);
		response.StatusCode = 200;
		return response;
	}

}