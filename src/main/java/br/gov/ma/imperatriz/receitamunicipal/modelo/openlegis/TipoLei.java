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
public enum TipoLei {
    LEI_COMPLEMENTAR("Lei Complementar"),
        LEI_ORDINARIA("Lei Ordinaria"),
        DECRETO("Decreto"),
        PORTARIA("Portaria"),
        CONVENIO("Convenio"),
        INSTRUCAO_NORMATIVA("Instrucao Normativa"),
        OUTROS("outros");
   
   private String descricao;
	
	private TipoLei(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
}
}
