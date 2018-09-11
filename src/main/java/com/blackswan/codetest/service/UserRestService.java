package com.blackswan.codetest.service;

import com.blackswan.codetest.domain.Task;
import com.blackswan.codetest.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mark Andrews
 */
@RestController
public class UserRestService {

    private final Logger logger = LoggerFactory.getLogger(UserRestService.class);

    private UserService userService;

    public UserRestService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {

        if (logger.isDebugEnabled()) {
            logger.debug("Create user :- {}", user);
        }

        return userService.createUser(user);
    }

    @PutMapping("/user/{userid}")
    public User updateUser(@RequestBody User user, @PathVariable("userid") Long userId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Update user :- {}", user);
        }

        return userService.updateUser(user, userId);
    }

    @GetMapping("/user")
    public List<User> listUsers() {

        if (logger.isDebugEnabled()) {
            logger.debug("List users.");
        }

        return userService.listAllUsers();
    }

    @GetMapping("/user/{userid}")
    public User getUser(@PathVariable("userid") Long userId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Get user {}", userId);
        }

        return userService.getUser(userId);
    }

    @PostMapping("/user/{userid}/task")
    public Task createUserTask(@RequestBody Task task, @PathVariable("userid") Long userId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Create user task, user_id = {} : task :- {}", task);
        }

        return userService.addTaskToUser(task, userId);
    }

    @PutMapping("/user/{userid}/task/{taskid}")
    public Task createUserTask(@RequestBody Task task, @PathVariable("userid") Long userId, @PathVariable("taskid") Long taskId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Update user task, user_id = {} : task :- ", task);
        }

        return userService.updateUserTask(task, userId, taskId);
    }

    @DeleteMapping("/user/{userid}/task/{taskid}")
    public void deleteUserTask(@PathVariable("userid") Long userId, @PathVariable("taskid") Long taskId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Delete user task, user_id = {} : task_id = {}", userId, taskId);
        }

        userService.deleteUserTask(userId, taskId);
    }

    @GetMapping("/user/{userid}/task/{taskid}")
    public Task getUserTask(@PathVariable("userid") Long userId, @PathVariable("taskid") Long taskId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Get user task, user_id = {} task_id = {}", userId, taskId);
        }

        return userService.getUserTask(userId, taskId);
    }

    @GetMapping("/user/{userid}/task")
    public List<Task> getUserTasks(@PathVariable("userid") Long userId) {

        if (logger.isDebugEnabled()) {
            logger.debug("Get user tasks, user_id = {}}", userId);
        }

        return userService.listUserTasks(userId);
    }

}