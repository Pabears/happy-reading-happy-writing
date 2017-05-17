package heng.shi.repository;

import heng.shi.entity.Book;
import heng.shi.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
    Page<Book> findByNameLike(String name, Pageable pageable);

    Page<Book> findByUser(User user, Pageable pageable);

}
