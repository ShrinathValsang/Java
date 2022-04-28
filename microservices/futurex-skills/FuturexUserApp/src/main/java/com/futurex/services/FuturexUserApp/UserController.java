package com.futurex.services.FuturexUserApp;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.math.BigInteger;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String getUserAppHome() {
        return "Welcome to Futurex User App!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    /*@RequestMapping(method = RequestMethod.GET, value = "/user")
    public User getUser(@RequestBody UserId userId) {
        return userRepository.findOne()
    }*/

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userid}")
    public List<User> getUsersByUserid(@PathVariable("userid") BigInteger userid) {
        return userRepository.getUsersByUserid(userid);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usercourse/{courseid}")
    public List<User> getUsersByCourseid(@PathVariable("courseid") BigInteger courseid) {
        return userRepository.getUsersByCourseid(courseid);
    }
}
