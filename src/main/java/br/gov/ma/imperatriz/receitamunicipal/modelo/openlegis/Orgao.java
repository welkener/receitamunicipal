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
public class Orgao implements Serializable {

    @Id
    @SequenceGenerator(name = "Orgao", allocationSize = 1, sequenceName = "orgao_id_seq")
    @GeneratedValue(generator = "Orgao")
    private Long id;
    
    @Size(max = 200)
    @NotBlank
    private String nome;
    
  
    public Orgao() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    @Override
    public String toString() {
        return nome ;
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
        final Orgao other = (Orgao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    

}

