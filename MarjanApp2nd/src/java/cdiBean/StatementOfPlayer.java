/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cdiBean;

import entity.Rule;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author masaki
 */
@SessionScoped
public class StatementOfPlayer {
    private String name;
    private String sitting;
    private String wind;
    private int point;
    private Rule rule;
    
    @PostConstruct
    private void init(){
        this.pointRule = 
        
        this.firstPlayerPoint = 30000;
        this.secondPlayerPoint = 30000;
        this.thirdPlayerPoint = 30000;
    }
}
