package heng.shi.controller;

import heng.shi.entity.Book;
import heng.shi.entity.Caption;
import heng.shi.entity.User;
import heng.shi.service.CaptionService;
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
@RequestMapping(value = "/caption")
public class CaptionController {
    @Autowired
    private CaptionService captionService;

    @RequestMapping(value = "/{bookId}")
    public Caption findOne(@PathVariable(value = "bookId") Long id) {
        return captionService.findOne(id);
    }

    @RequestMapping(value = "/create")
    public Caption create(Caption caption) {
        return captionService.save(caption);
    }

    @RequestMapping(value = "/delete")
    public void delete(Long id) {
        captionService.delete(id);
    }

    @RequestMapping(value = "/user/")
    public Page<Caption> findByUser(User user, @PageableDefault Pageable pageable) {
        return captionService.findByUser(user, pageable);
    }

    @RequestMapping(value = "/book/")
    public Page<Caption> findByBook(Book book, @PageableDefault Pageable pageable) {
        return captionService.findByBook(book, pageable);
    }

    @RequestMapping(value = "/parent/{parentId}")
    public Page<Caption> findByParentId(@PathVariable(value = "parentId") Long id, @PageableDefault Pageable pageable) {
        return captionService.findByParentId(id, pageable);
    }
}
