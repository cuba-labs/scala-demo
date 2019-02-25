package com.company.demo.service;

import com.haulmont.cuba.security.entity.User;

import java.util.List;

public interface DemoService {
    String NAME = "demo_DemoService";

    List<User> getUsers();
}