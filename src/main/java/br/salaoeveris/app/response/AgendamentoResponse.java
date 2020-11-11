package br.salaoeveris.app.response;

import java.util.Date;

public class AgendamentoResponse extends BaseResponse {
	private Long Id;
	private Date dataHora;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date date) {
		this.dataHora = date;
	}
	
	
}