package com.ebay.demoironbank;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Repository
public class MyDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void saveAll(){

        List list = entityManager.createQuery("from Person").getResultList();
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("all saved");
    }
}
