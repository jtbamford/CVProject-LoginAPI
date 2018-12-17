package com.qa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.business.service.UsersService;
import com.qa.repository.domain.Users;
import com.qa.util.Constants;

@CrossOrigin
@RequestMapping(Constants.URL_BASE)
@RestController
public class UsersRest {

    @Autowired
    private UsersService usersService;

    @DeleteMapping(Constants.DELETE_URL)
    public String deleteUser(@PathVariable String username) {
    	return usersService.deleteUser(username);
    }

    @PutMapping(Constants.UPDATE_URL)
    public String updateUser(@RequestBody Users user) {
        return usersService.updateUser(user);
    }

    @PostMapping(Constants.CREATE_BASE+Constants._TRAINEE)
    public String createTrainee(@RequestBody Users user) {
        return usersService.addUser(user, Constants._TRAINEE);
    }
    
    @PostMapping(Constants.CREATE_BASE+Constants._TRAINER)
    public String createTrainer(@RequestBody Users user) {
        return usersService.addUser(user, Constants._TRAINER);
    }
    
    @PostMapping(Constants.CREATE_BASE+Constants._TRAINING_MANAGER)
    public String createTrainingManager(@RequestBody Users user) {
        return usersService.addUser(user, Constants._TRAINING_MANAGER);
    }

}
