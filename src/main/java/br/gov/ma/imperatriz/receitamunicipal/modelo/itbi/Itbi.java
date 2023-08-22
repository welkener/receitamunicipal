package br.gov.ma.imperatriz.receitamunicipal.modelo.itbi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Ayslan
 */
@Entity
public class Itbi implements Serializable {
   
    @Id
    @SequenceGenerator(name = "Itbi", allocationSize = 1, sequenceName = "itbi_id_seq")
    @GeneratedValue(generator = "Itbi")
    private Long id;
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Size(max = 100)
    @NotBlank
    private String inscricaoCadastral;
    
    @Size(max = 100)
    @NotBlank
    private String endereco;
     
    @Size(max = 100)
    @NotBlank
    private String bairro;
    
     @Size(max = 100)
    @NotBlank
    private String natureza;
        
   
   
    @NotBlank 
    private Double areaTerreno;
    
    private Double areaEdificada;
    
    
    @NotNull(message = "é obrigatório")
    @Column(name = "valor_declarado", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDeclarado;
    
    @NotNull(message = "é obrigatório")
    @Column(name = "valor_transferencia", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorTransferencia;
    
    @NotNull(message = "é obrigatório")
    @Column(name = "valor_itbi", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorItbi;
    
    @NotNull(message = "é obrigatório")
    @Column(name = "valor_m2", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorM2;
    
    @Enumerated(EnumType.STRING)
    @Column(name="tipoImovel")
    private TipoImovel tipoImovel;
   
    @Column(name="observacao")
    private String observacao;
    
  
    public Itbi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return inscricaoCadastral ;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getInscricaoCadastral() {
        return inscricaoCadastral;
    }

    public void setInscricaoCadastral(String inscricaoCadastral) {
        this.inscricaoCadastral = inscricaoCadastral;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public Double getAreaTerreno() {
        return areaTerreno;
    }

    public void setAreaTerreno(Double areaTerreno) {
        this.areaTerreno = areaTerreno;
    }

    public Double getAreaEdificada() {
        return areaEdificada;
    }

    public void setAreaEdificada(Double areaEdificada) {
        this.areaEdificada = areaEdificada;
    }

    public BigDecimal getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(BigDecimal valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public BigDecimal getValorTransferencia() {
        return valorTransferencia;
    }

    public void setValorTransferencia(BigDecimal valorTransferencia) {
        this.valorTransferencia = valorTransferencia;
    }

    public BigDecimal getValorItbi() {
        return valorItbi;
    }

    public void setValorItbi(BigDecimal valorItbi) {
        this.valorItbi = valorItbi;
    }

    public BigDecimal getValorM2() {
        return valorM2;
    }

    public void setValorM2(BigDecimal valorM2) {
        this.valorM2 = valorM2;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Itbi other = (Itbi) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

}

