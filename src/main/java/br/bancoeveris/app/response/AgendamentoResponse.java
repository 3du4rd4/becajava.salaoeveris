package br.bancoeveris.app.response;

import java.sql.Date;

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
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	
	
}