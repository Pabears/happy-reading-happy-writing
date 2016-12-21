package heng.shi.service.impl;

import heng.shi.entity.User;
import heng.shi.repository.UserRepo;
import heng.shi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shihe on 2016/12/21.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public User findOne(Long id) {
        return userRepo.findOne(id);
    }

    @Override
    public void delete(Long id) {
        userRepo.delete(id);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
