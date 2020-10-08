/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Cliente;
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
public class TestePersistirCliente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirCliente() {
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
        Cliente obj = new Cliente();
        obj.setNome("Jorge Bavaresco");
        obj.setRg("9876534263");
        obj.setCpf("793.238.620-96");
        obj.setTelefone("(54)7654-0987");
        obj.setEndereco("Av brasil 1000");
        obj.setBairro("Centro");
        obj.setCep("99887-987");
        Cidade cid = new Cidade();
        cid.setNome("Passo Fundo");
        cid.setEstado("Rio Grande do Sul");
        obj.setCidade(cid);
        
        
        em.getTransaction().begin();
        em.persist(cid);
        em.persist(obj);
        em.getTransaction().commit();        
    }
    
}
