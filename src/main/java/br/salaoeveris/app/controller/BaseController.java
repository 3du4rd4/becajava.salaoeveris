package br.salaoeveris.app.controller;

import br.bancoeveris.app.response.BaseResponse;

public class BaseController extends BaseResponse{
	
	public BaseResponse errorBase = new BaseResponse();
	
	public BaseController() {
		errorBase.StatusCode = 500;
		errorBase.Message = "Ocorreu um erro inesperado. Contate o administrador";
	}

}