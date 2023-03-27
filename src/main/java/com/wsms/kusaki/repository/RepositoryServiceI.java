package com.wsms.kusaki.repository;

import com.wsms.kusaki.dto.response.SchoolApiErrorResponse;
import com.wsms.kusaki.entity.Student;
import io.vavr.control.Either;

import java.util.List;

public interface RepositoryServiceI {
    Either<SchoolApiErrorResponse, List<Student>> getStudents(String assignedClass);

    String getStudentBalance(String id);
}
