package heng.shi.repository;

import heng.shi.entity.Caption;
import heng.shi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaptionRepo extends JpaRepository<Caption, Long> {
    Caption findByUser(User user);
    Page<Caption> findByParentId(long parentId,Pageable pageable);

}
