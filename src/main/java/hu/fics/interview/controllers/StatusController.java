/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.fics.interview.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sapbo
 */
@RestController
public class StatusController {
    @GetMapping("/status")
    public HttpStatus response(){
        return HttpStatus.OK;
    }
}
