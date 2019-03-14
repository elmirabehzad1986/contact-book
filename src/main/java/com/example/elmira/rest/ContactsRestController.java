package com.example.elmira.rest;

import com.example.elmira.dao.ContactsDAO;
import com.example.elmira.entity.Contacts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by elmirabehzad on 14/3/19.
 */

@RestController
@RequestMapping("/api")
public class ContactsRestController {

    private ContactsDAO contactsDAO;

    //quick and dirty:inject contacts dao

    @Autowired

    public ContactsRestController(ContactsDAO theContacts){

        this.contactsDAO = theContacts;
    }
    //expose "/contacts" and return list of contacts

    @GetMapping("/contacts")
    public List<Contacts> findAll(){
        return contactsDAO.findAll();
    }
}
