package heng.shi.service;

import heng.shi.entity.Book;
import heng.shi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shihe on 2016/12/21.
 */
public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findOne(Long id);

    Book updateById(Long id);

    void delete(Long id);

    Book save(Book book);

    Page<Book> findByNameLike(String name, Pageable pageable);

    Page<Book> findByUser(User user, Pageable pageable);
}
