package br.salaoeveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteList;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.response.ClienteResponse;


@Service
public class ClienteService {
	final ClienteRepository _repository;

	@Autowired
	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();

		if (clienteRequest.getNome() == "") {
			base.Message = "O nome do cliente não foi preenchido.";
			return base;
		}

		if (clienteRequest.getTel() == "") {
			base.Message = "O telefone do cliente não foi preenchido.";
			return base;
		}
		if (clienteRequest.getCpf() == "") {
			base.Message = "O Cpf do cliente não foi preenchido.";
			return base;
		}
		if (clienteRequest.getEndereco() == "") {
			base.Message = "O endereço do cliente não foi preenchido";
			return base;
		}

		cliente.setNome(clienteRequest.getNome());
		cliente.setTel(clienteRequest.getTel());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setEndereco(clienteRequest.getEndereco());

		_repository.save(cliente);
		base.StatusCode = 201;
		base.Message = "Cliente inserido com sucesso.";
		return base;
	}

	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);
		ClienteResponse response = new ClienteResponse();

		if (cliente == null) {
			response.Message = "Cliente não encontrado";
			response.StatusCode = 404;
			return response;
		}

		response.setNome(cliente.get().getNome());
		response.setTel(cliente.get().getTel());
		response.setEndereco(cliente.get().getEndereco());

		response.Message = "Cliente obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

	public ClienteResponse listar() {

        //Lista de Clientes
        List<Cliente> lista = _repository.findAll();

        //Lista de Clientes do response dentro de um array
        List<ClienteResponse> listarcliresponse = new ArrayList<ClienteResponse>();

        //response recebe ClienteList novo
        ClienteList response = new ClienteList();

        //cliente recebe ClinteResponse novo
        ClienteResponse cliente = new ClienteResponse();

        //o array coloca o objeto da lista no clientelistar e varre dentro da lista
        for (Cliente clientelistar : lista) {

            //cliente recebe nova lista de ClienteResponse
            cliente = new ClienteResponse();

            cliente.setEndereco(clientelistar.getEndereco());
            cliente.setTel(clientelistar.getTel());
            cliente.setNome(clientelistar.getNome());

            listarcliresponse.add(cliente);

        }

        response.setClientes(listarcliresponse);
             

        response.StatusCode = 200;
        response.Message = "Clientes obtidos com sucesso.";

        return cliente;
    }

	public BaseResponse atualizar(Long id, ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (clienteRequest.getNome() == "") {
			base.Message = "O nome do cliente não foi preenchido.";
			return base;
		}

		if (clienteRequest.getTel() == "") {
			base.Message = "O telefone do cliente não foi preenchido.";
			return base;
		}
		if (clienteRequest.getCpf() == "") {
			base.Message = "O Cpf do cliente não foi preenchido.";
			return base;
		}
		if (clienteRequest.getEndereco() == "") {
			base.Message = "O endereço do cliente não foi preenchido";
			return base;
		}

		cliente.setId(id);
		cliente.setNome(clienteRequest.getNome());
		cliente.setTel(clienteRequest.getTel());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setEndereco(clienteRequest.getEndereco());

		_repository.save(cliente);
		base.StatusCode = 200;
		base.Message = "Cliente atualizado com sucesso.";
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