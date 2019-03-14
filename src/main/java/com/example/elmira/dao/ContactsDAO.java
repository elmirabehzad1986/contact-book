package com.example.elmira.dao;

import com.example.elmira.entity.Contacts;

import java.util.List;

/**
 * Created by elmirabehzad on 14/3/19.
 */
public interface ContactsDAO {

    public List<Contacts> findAll();
}
