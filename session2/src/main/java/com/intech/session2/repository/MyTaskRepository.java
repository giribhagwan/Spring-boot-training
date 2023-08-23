package com.intech.session2.repository;

import com.intech.session2.domain.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyTaskRepository extends JpaRepository<MyTask,Long> {
    List<MyTask> findByAuthor(String author);
}
