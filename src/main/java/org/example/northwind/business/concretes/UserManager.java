package org.example.northwind.business.concretes;

import org.example.northwind.business.abstracts.UserService;
import org.example.northwind.core.dataAccess.UserDao;
import org.example.northwind.core.entities.User;
import org.example.northwind.core.utilities.results.DataResult;
import org.example.northwind.core.utilities.results.Result;
import org.example.northwind.core.utilities.results.SuccessDataResult;
import org.example.northwind.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {
    UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao){
        this.userDao=userDao;
    }
    @Override
    public Result add(User user) {
        userDao.save(user);
        return new SuccessResult("Added user");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email),"Result");
    }
}
