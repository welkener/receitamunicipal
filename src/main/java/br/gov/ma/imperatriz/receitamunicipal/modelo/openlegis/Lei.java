package br.gov.ma.imperatriz.receitamunicipal.modelo.openlegis;

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
public class Lei implements Serializable {
    @Id
    @SequenceGenerator(name = "Lei", allocationSize = 1, sequenceName = "lei_id_seq")
    @GeneratedValue(generator = "Lei")
    private Long id;
    
    @Size(max = 200)
    @NotBlank
    private String descricao;
    
    @NotNull
    private Long numeroLei;
    
    @NotNull
    private Long ano;
    
     @Enumerated(EnumType.STRING)
    @Column(name="tipoLei")
    private TipoLei tipoLei;
  
    
    @Enumerated(EnumType.STRING)
    @Column(name="tipoEsfera")
    private TipoEsfera tipoEsfera;
  
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date publicao;
    
    @Column(name="arquivo")
    @Lob
    private byte[] arquivo;
   
    @Column(name="observacao")
    private String observacao;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="id_orgao")
    private Orgao orgao;
  
    public Lei() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    @Override
    public String toString() {
        return descricao ;
    }

    public Long getNumeroLei() {
        return numeroLei;
    }

    public void setNumeroLei(Long numeroLei) {
        this.numeroLei = numeroLei;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public TipoLei getTipoLei() {
        return tipoLei;
    }

    public void setTipoLei(TipoLei tipoLei) {
        this.tipoLei = tipoLei;
    }

    public TipoEsfera getTipoEsfera() {
        return tipoEsfera;
    }

    public void setTipoEsfera(TipoEsfera tipoEsfera) {
        this.tipoEsfera = tipoEsfera;
    }

    

    public Date getPublicao() {
        return publicao;
    }

    public void setPublicao(Date publicao) {
        this.publicao = publicao;
    }

    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Orgao getOrgao() {
        return orgao;
    }

    public void setOrgao(Orgao orgao) {
        this.orgao = orgao;
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
        final Lei other = (Lei) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

}

