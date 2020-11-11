package br.salaoeveris.app.request;

import java.util.List;

import br.bancoeveris.app.response.BaseResponse;
import br.salaoeveris.app.model.Cliente;


public class ClienteList extends BaseResponse {
	
	private List<Cliente> Clientes;

	public List<Cliente> getClientes() {
		return Clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		Clientes = clientes;
	}

}