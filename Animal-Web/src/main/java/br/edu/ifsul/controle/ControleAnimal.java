/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;
import br.edu.ifsul.dao.AnimalDao;
import br.edu.ifsul.dao.PessoaDao;
import br.edu.ifsul.modelo.Animal;
import br.edu.ifsul.modelo.Pessoa;


import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Meu computador
 */
@Named(value = "controleAnimal")
@ViewScoped
public class ControleAnimal implements Serializable{
    @EJB
    private AnimalDao<Animal> dao;
    private Animal objeto;
     @EJB
    private PessoaDao<Pessoa> PessoaDao;

 
    
    
    public ControleAnimal(){
        
    }
    
    public String listar(){
        return "/privado/Animal/listar?faces-redirect=true";
    }
    
    
    public void novo(){
        Util.mensagemInformacao("entrou3");
        objeto = new Animal();
    }

    public PessoaDao<Pessoa> getPessoaDao() {
        return PessoaDao;
    }

    public void setPessoaDao(PessoaDao<Pessoa> PessoaDao) {
        this.PessoaDao = PessoaDao;
    }
    
    public void alterar(Object id){
        try {
            objeto = dao.getObjectByID(id);
            Util.mensagemInformacao("entrou");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void excluir(Object id){
        try {
            objeto = dao.getObjectByID(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            Util.mensagemInformacao("entrou??");
            if (objeto.getId() == null){
                Util.mensagemInformacao("vazio");
                dao.persist(objeto);
            } else {
                Util.mensagemInformacao("entrou2");
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e){
            Util.mensagemInformacao("Erro ao salvar objeto: " + Util.getMensagemErro(e));
        }
    }

    public AnimalDao<Animal> getDao() {
        return dao;
    }

    public void setDao(AnimalDao<Animal> dao) {
        this.dao = dao;
    }

    public Animal getObjeto() {
        return objeto;
    }

    public void setObjeto(Animal objeto) {
        this.objeto = objeto;
    }
    
    
}
