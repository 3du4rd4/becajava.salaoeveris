package br.salaoeveris.app.request;

import java.util.List;

import br.bancoeveris.app.response.BaseResponse;
import br.salaoeveris.app.model.Agendamento;


public class AgendamentoList extends BaseResponse{
	private List<Agendamento> Agendamentos;

	public List<Agendamento> Agendamentos() {
		return Agendamentos;
	}

	public void setAgendamentos(List<Agendamento> agendamentos) {
		Agendamentos = agendamentos;
	}
}