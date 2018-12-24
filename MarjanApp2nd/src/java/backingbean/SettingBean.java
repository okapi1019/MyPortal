/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backingbean;

import entity.Rule;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import service.RuleService;

/**
 *
 * @author masaki
 */
@Named(value = "settingBean")
@RequestScoped
public class SettingBean {

    @Inject
    private RuleService ruleService;
    private List<SelectItem> rules;
    /**
     * Creates a new instance of SettingBean
     */
    public SettingBean() {
    }
    
    @PostConstruct
    private void Init(){
        this.rules = new ArrayList<>();
        List<Rule> list = this.ruleService.serchRules();
        list.forEach(i -> rules.add(new SelectItem(i, i.getName())));
    }
    
    public void 
}
