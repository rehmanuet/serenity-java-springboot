package com.lab.tas.context;

import com.lab.tas.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ScenarioContext {
    private Map<String, User> users;

    public ScenarioContext(@Autowired Map<String, User> users) {
        this.users = users;
    }

    public User getUser(String name) {
        return this.users.get(name);
    }
}