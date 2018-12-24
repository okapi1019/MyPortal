/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Rule;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author masaki
 */
@RequestScoped
@Transactional
public class RuleService {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Rule> serchRules(){
        return  entityManager.createQuery("SELECT r FROM Rule r", Rule.class).getResultList();
    }
}
