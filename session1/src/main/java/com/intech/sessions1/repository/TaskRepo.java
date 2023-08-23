package com.intech.sessions1.repository;

import com.intech.sessions1.entity.MyTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<MyTask,Long> {
}
