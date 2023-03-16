package com.example.Container1;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
//    List<Tutorial> findByAge(int age);
//    Tutorial findByTitle(String title);
//    Optional<Tutorial> a();
}
