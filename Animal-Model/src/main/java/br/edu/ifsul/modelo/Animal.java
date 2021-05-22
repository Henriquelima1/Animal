/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Meu computador
 */
@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_animal", sequenceName = "seq_animal_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_animal", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    @NotBlank(message = "O nome não pode ser em branco") 
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)    
    private String nome;
     @NotNull(message = "O peso deve ser informado")
    @Column(name = "peso", nullable = false)       
    private Double peso;
    @NotBlank(message = "O especie não pode ser em branco")
    @Length(max = 50, message = "O especie não pode ter mais que {max} caracteres")
    @Column(name = "especie", nullable = false, length = 50)    
    private String especie;
   
    @ManyToOne
    @JoinColumn(name= "pessoa", referencedColumnName= "id", nullable= false)
    private Pessoa pessoa;

    public Animal() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    
   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
