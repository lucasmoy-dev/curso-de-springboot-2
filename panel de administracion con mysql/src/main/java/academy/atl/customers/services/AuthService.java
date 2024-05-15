package academy.atl.customers.services;

import academy.atl.customers.entities.User;

public interface AuthService {
    User login(String email, String password);
}
