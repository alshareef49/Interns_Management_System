package com.interns.repository;

import com.interns.entity.Mentor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MentorRepository extends CrudRepository<Mentor,Integer> {
    List<Mentor> findByNumberOfProjectMentored(Integer numberOfProjectMentored);
}
