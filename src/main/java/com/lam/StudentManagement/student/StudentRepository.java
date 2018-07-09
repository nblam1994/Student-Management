package com.lam.StudentManagement.student;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@NotFound(action= NotFoundAction.IGNORE)
public interface StudentRepository extends JpaRepository<Student, String>{


}
