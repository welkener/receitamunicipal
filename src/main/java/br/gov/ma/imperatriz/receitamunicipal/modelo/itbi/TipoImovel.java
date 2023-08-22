/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ma.imperatriz.receitamunicipal.modelo.itbi;

/**
 *
 * @author dalfredewelkenerlima
 */
public enum TipoImovel {
    RESIDENCIAL("Residencial"),
    COMERCIAL("Comercial"),
    INDUSTRIAL("Industrial"),
   OUTROS("Outros");
   
   private String descricao;
	
	private TipoImovel(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
}
}
