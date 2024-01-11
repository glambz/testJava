package com.test.testjava.dao;

import com.test.testjava.dto.UserJobDTO;
import com.test.testjava.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.LinkedList;
import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<UserJobDTO> getJobByUserId(long id);
}