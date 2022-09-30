package com.example.sample1.controller;

import com.example.sample1.constants.AnPhatConstants;
import com.example.sample1.model.User;
import com.example.sample1.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
//@RequestMapping(AnPhatConstants.BASE_URL_ADMIN)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation(value = "This method is used to get the test.")
    public ResponseEntity<?> getUser(@RequestParam String user) {
        User user1 = userService.getUser(user);
        return ResponseEntity.ok(user1);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        return "test";
    }

}
