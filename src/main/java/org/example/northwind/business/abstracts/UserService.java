package org.example.northwind.business.abstracts;

import org.example.northwind.core.entities.User;
import org.example.northwind.core.utilities.results.DataResult;
import org.example.northwind.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
