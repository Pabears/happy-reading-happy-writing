package heng.shi.service.impl;

import heng.shi.entity.Book;
import heng.shi.entity.User;
import heng.shi.repository.BookRepo;
import heng.shi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by shihe on 2016/12/21.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    @Override
    public Book findOne(Long id) {
        return bookRepo.findOne(id);
    }

    @Override
    public void delete(Long id) {
        bookRepo.delete(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Page<Book> findByNameLike(String name, Pageable pageable) {
        return bookRepo.findByNameLike(name, pageable);
    }

    @Override
    public Page<Book> findByUser(User user, Pageable pageable) {
        return bookRepo.findByUser(user, pageable);
    }
}
