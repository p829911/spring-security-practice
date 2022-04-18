package me.p829911.practice.spring.security.note;

import java.util.List;
import me.p829911.practice.spring.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUserOrderByIdDesc(User user);

    Note findByIdAndUser(Long id, User user);
}
