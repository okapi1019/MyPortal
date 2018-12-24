/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author masaki
 */
@Named(value = "form1Bean")
@RequestScoped
public class Form1Bean {

    private String ask;
    /**
     * Creates a new instance of Form1Bean
     */
    public Form1Bean() {
    }

    /**
     * @return the ask
     */
    public String getAsk() {
        return ask;
    }

    /**
     * @param ask the ask to set
     */
    public void setAsk(String ask) {
        this.ask = ask;
    }
    
    public String execute(){
        this.ask = "テキストの入力、ありがとう";
        return  "";
    }
    
}
