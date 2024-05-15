package academy.atl.customers.services;

import academy.atl.customers.entities.User;

import java.util.List;

public interface UserService {

    User getUser(Integer id);
    List<User> getAllUsers();
    void removeUser(Integer id);
    void addUser(User user);
    void updateUser(Integer id, User updateUser);
    List<User> searchUser(String email, String address);

}
