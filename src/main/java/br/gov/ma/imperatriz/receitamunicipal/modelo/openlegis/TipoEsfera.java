/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis;

/**
 *
 * @author dalfredewelkenerlima
 */
public enum TipoEsfera {
        FEDERAL("Federal"),
        ESTADUAL("Estadual"),
        MUNICIPAL("Municipal"),
        JUDICIAL("Judicial"),
        OUTROS("Outros");
   
   private String descricao;
	
	private TipoEsfera(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
}  
}
