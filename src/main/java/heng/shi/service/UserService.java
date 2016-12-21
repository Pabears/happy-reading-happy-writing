package heng.shi.service;

import heng.shi.entity.Book;
import heng.shi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shihe on 2016/12/21.
 */
public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findOne(Long id);

    User updateById(Long id);

    void delete(Long id);

    User save(User book);
}
