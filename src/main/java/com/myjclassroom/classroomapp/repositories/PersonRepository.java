package com.myjclassroom.classroomapp.repositories;

import com.myjclassroom.classroomapp.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
