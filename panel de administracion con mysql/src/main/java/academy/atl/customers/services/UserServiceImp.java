package academy.atl.customers.services;

import academy.atl.customers.entities.User;
import academy.atl.customers.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private static final String SECRET_KEY = "gj43jng9";
    @Autowired
    private UserRepository repository;

    public User getUser(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        Iterable<User> users = repository.findAll();
        for (User user:users) {
            list.add(user);
        }
        return list;
    }

    public void removeUser(Integer id) {
        repository.deleteById(id);
    }

    public void addUser(User user) {
        String hashPassword = Hashing.sha256()
                .hashString(user.getPassword() + SECRET_KEY, StandardCharsets.UTF_8)
                .toString();

        user.setPassword(hashPassword);
        repository.save(user);
    }

    public void updateUser(Integer id, User updateUser) {
        updateUser.setId(id);
        repository.save(updateUser);
    }


    public List<User> searchUser(String email, String address) {
        return repository.findByEmailOrAddress(email, address);
    }
}
