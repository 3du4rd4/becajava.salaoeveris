package br.salaoeveris.app.request;

import java.util.List;

import br.bancoeveris.app.response.BaseResponse;
import br.salaoeveris.app.model.*;


public class ServicoList extends BaseResponse {
	private List<Servico> Servicos;

	public List<Servico> getServicos() {
		return Servicos;
	}

	public void setServicos(List<Servico> servicos) {
		Servicos = servicos;
	}

}