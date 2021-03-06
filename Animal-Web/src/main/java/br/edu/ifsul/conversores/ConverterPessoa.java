/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.conversores;



import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Meu computador
 */
@Named(value = "converterPessoa")
@RequestScoped
public class ConverterPessoa implements Serializable, Converter {

    @PersistenceContext(unitName = "Animal-WebPU")
    protected EntityManager em;

    // converte da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione uma pessoa")) {
            return null;
        }else{
        return em.find(Pessoa.class,  Integer.parseInt(string));
        }
    }

    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if (t == null) {
            return null;
        }
        Pessoa obj = (Pessoa) t;
        //return obj.getId().toString();
        return String.valueOf(obj.getId());
    }

}
