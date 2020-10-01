/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Grupo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Jorge
 */
public class TestePersistirGrupo {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirGrupo() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("LocadoraModelPU");
        em = emf.createEntityManager();        
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        Grupo obj = new Grupo();
        obj.setNome("Passo Fundo");
        obj.setValorDiaria(150.00);
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
