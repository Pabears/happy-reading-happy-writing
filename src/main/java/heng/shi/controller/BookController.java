package heng.shi.controller;

import heng.shi.entity.Book;
import heng.shi.entity.User;
import heng.shi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shihe on 2016/12/21.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{bookId}")
    public Book findOne(@PathVariable(value = "bookId") Long id) {
        return bookService.findOne(id);
    }

    @RequestMapping(value = "/create")
    public Book create(Book book) {
        return bookService.save(book);
    }

    @RequestMapping(value = "/delete")
    public void delete(Long id) {
        bookService.delete(id);
    }

    @RequestMapping(value = "/user/")
    public Page<Book> findByUser(User user, @PageableDefault Pageable pageable) {
        return bookService.findByUser(user, pageable);
    }
}
