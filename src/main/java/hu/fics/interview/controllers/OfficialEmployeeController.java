/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.fics.interview.controllers;

import hu.fics.interview.model.Email;
import hu.fics.interview.model.OfficialEmployee;
import hu.fics.interview.repository.EmailRepository;
import hu.fics.interview.repository.OfficialEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficialEmployeeController {
    private OfficialEmployeeRepository oer;
    private EmailRepository er;
        
    
    @Autowired
    public void setOfficialEmployeeRepository(OfficialEmployeeRepository oer){
        this.oer = oer;
    }
    @Autowired
    public void setEmailRepository(EmailRepository er){
        this.er = er;
    }
    
    @PostMapping("/create")
    public void newEmployee(@RequestBody OfficialEmployee oe){
        oer.save(oe);
        er.save(new Email(oe.getFirstName().toLowerCase()+"."+oe.getLastName().toLowerCase()+"@idomsoft.hu",oe));
    }
}
