package heng.shi.service;

import heng.shi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findOne(Long id);

    void delete(Long id);

    User save(User user);

    User findByEmail(String email);

    User findByUsername(String username);
}
