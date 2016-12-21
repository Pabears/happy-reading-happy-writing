package heng.shi.controller;

import heng.shi.entity.User;
import heng.shi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shihe on 2016/12/21.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}")
    public User findOne(@PathVariable(value = "userId") Long id) {
        return userService.findOne(id);
    }

    @RequestMapping(value = "/create")
    public User create(User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/delete")
    public void delete(Long id) {
        userService.delete(id);
    }
}
