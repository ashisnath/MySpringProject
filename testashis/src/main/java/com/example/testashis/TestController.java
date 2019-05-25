package com.example.testashis;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController

public class TestController {


    private static final String template = "{Ashis}";
//    private final AtomicLong counter = new AtomicLong();

    /*@GetMapping(value="/get" ,produces = "application/json")
    public ArrayList greeting() {
        List<String> a = new ArrayList<>();
        a.add("Ashis");
        a.add("Ashis1");a.add("Ashis2");

        return (ArrayList) a;
    }*/

    @GetMapping(value="/get" ,produces = "application/json")
    public List greeting() {

        Users u1=new Users();
        u1.setUname("Ashis");
        u1.setRoll("fsfs");

        Users u2=new Users();
        u2.setUname("tett");
        u2.setRoll("dsd");

        List a1= new ArrayList();
        a1.add(u1);
        a1.add(u2);

        return a1;
    }

    @RequestMapping(value="/greeting1")
    public List greeting1() {

        Users u1=new Users();
        u1.setUname("Ashis");
        u1.setRoll("fsfs");

        Users u2=new Users();
        u2.setUname("tett");
        u2.setRoll("dsd");

        List a1= new ArrayList();
        a1.add(u1);
        a1.add(u2);

        return a1;
    }


    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "Logout Successful";
    }


}
