/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Meu computador
 */
public class TestePersistirPessoa {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Animal-ModelPU");
        EntityManager em = emf.createEntityManager();
        Pessoa pessoa = new Pessoa();
        pessoa.setAniversario(new GregorianCalendar(2000, Calendar.SEPTEMBER, 10));
        pessoa.setNome("henrique");

       
   
        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
