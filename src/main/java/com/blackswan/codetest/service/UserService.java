package com.blackswan.codetest.service;

import com.blackswan.codetest.domain.Task;
import com.blackswan.codetest.domain.User;

import java.util.List;

/**
 * @author Mark Andrews
 */
public interface UserService {

    User createUser(User user);

    User updateUser(User user, Long userId);

    List<User> listAllUsers();

    User getUser(Long userId);

    Task addTaskToUser(Task task, Long userId);

    void deleteUserTask(Long userId, Long taskId);

    Task updateUserTask(Task task, Long userId, Long taskId);

    Task getUserTask(Long userId, Long taskId);

    List<Task> listUserTasks(Long userId);
}
