package com.wsms.kusaki.repository;

import com.wsms.kusaki.entity.Student;

import java.util.List;

public interface RepositoryServiceI {
    List<Student> getStudents(String assignedClass);

    String getStudentBalance(String id);
}
