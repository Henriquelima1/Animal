/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Animal;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Meu computador
 */
public class TestePersistirAnimal {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Animal-ModelPU");
        EntityManager em = emf.createEntityManager();
        Animal animal = new Animal();
        animal.setNome("humano");
        animal.setPeso(82.00);
        animal.setEspecie("humano");
        animal.setPessoa(em.find(Pessoa.class, 1));
        
       
   
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
