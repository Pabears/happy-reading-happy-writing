package heng.shi.service;

import heng.shi.entity.Book;
import heng.shi.entity.Caption;
import heng.shi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by shihe on 2016/12/21.
 */
public interface CaptionService {
    Page<Caption> findAll(Pageable pageable);

    Caption findOne(Long id);

    void delete(Long id);

    Caption save(Caption caption);

    Page<Caption> findByUser(User user, Pageable pageable);

    Page<Caption> findByBook(Book book, Pageable pageable);

    Page<Caption> findByParentId(Long parentId, Pageable pageable);
}
