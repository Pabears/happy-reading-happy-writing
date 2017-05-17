package heng.shi.service.impl;

import heng.shi.entity.Book;
import heng.shi.entity.Caption;
import heng.shi.entity.User;
import heng.shi.repository.CaptionRepo;
import heng.shi.service.CaptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by shihe on 2016/12/21.
 */
@Service
public class CaptionServiceImpl implements CaptionService {
    @Autowired
    private CaptionRepo captionRepo;

    @Override
    public Page<Caption> findAll(Pageable pageable) {
        return captionRepo.findAll(pageable);
    }

    @Override
    public Caption findOne(Long id) {
        return captionRepo.findOne(id);
    }


    @Override
    public void delete(Long id) {
        captionRepo.delete(id);
    }

    @Override
    public Caption save(Caption caption) {
        return captionRepo.save(caption);
    }

    @Override
    public Page<Caption> findByUser(User user, Pageable pageable) {
        return captionRepo.findByUser(user, pageable);
    }

    @Override
    public Page<Caption> findByBook(Book book, Pageable pageable) {
        return captionRepo.findByBook(book, pageable);
    }

    @Override
    public Page<Caption> findByParentId(Long parentId, Pageable pageable) {
        return captionRepo.findByParentId(parentId, pageable);
    }
}
