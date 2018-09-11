package com.blackswan.codetest.service;

import com.blackswan.codetest.NotFoundException;
import com.blackswan.codetest.domain.Task;
import com.blackswan.codetest.domain.User;
import com.blackswan.codetest.repo.TaskRepository;
import com.blackswan.codetest.repo.UserRepository;
import com.blackswan.codetest.util.CopyUtils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Mark Andrews
 */
@Service
public class UserRepositoryService implements UserService {

    private UserRepository userRepository;

    private TaskRepository taskRepository;

    public UserRepositoryService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Long userId) {

        User storedUser = this.fetchUser(userId);
        BeanUtils.copyProperties(user, storedUser, CopyUtils.getNullPropertyNames(user));

        return userRepository.save(storedUser);
    }

    @Override
    public List<User> listAllUsers() {

        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);

        return userList;
    }

    @Override
    public User getUser(Long userId) {

        return this.fetchUser(userId);
    }

    @Override
    public Task addTaskToUser(Task task, Long userId) {

        User user = this.fetchUser(userId);

        task.setUser(user);
        Task newTask = taskRepository.save(task);

        user.getTasks().add(newTask);
        userRepository.save(user);

        return newTask;
    }

    @Override
    public Task updateUserTask(Task task, Long userId, Long taskId) {

        Task storedtask = this.fetchUserTask(userId, taskId);
        BeanUtils.copyProperties(task, storedtask, CopyUtils.getNullPropertyNames(task));

        return taskRepository.save(storedtask);
    }

    @Override
    public void deleteUserTask(Long userId, Long taskId) {

        Task storedtask = this.fetchUserTask(userId, taskId);

        taskRepository.delete(storedtask);
    }

    @Override
    public Task getUserTask(Long userId, Long taskId) {
        return this.fetchUserTask(userId, taskId);
    }

    @Override
    public List<Task> listUserTasks(Long userId) {
        return this.fetchUser(userId).getTasks();
    }

    private User fetchUser(Long userId) {

        Optional<User> resultOpt = userRepository.findById(userId);
        if (!resultOpt.isPresent()) {
            throw new NotFoundException("User "+userId+" not found.");
        }

        return resultOpt.get();
    }

    private Task fetchUserTask(Long userId, Long taskId) {

        User user = this.fetchUser(userId);
        Optional<Task> resultOpt = taskRepository.findUserTask(taskId, user);
        if (!resultOpt.isPresent()) {
            throw new NotFoundException("Task "+taskId+" not found.");
        }

        return resultOpt.get();
    }
}
