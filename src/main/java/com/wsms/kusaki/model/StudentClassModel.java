package com.wsms.kusaki.model;

import com.wsms.kusaki.dto.request.GetClassStudentRequest;
import com.wsms.kusaki.dto.response.ClassStudentResponse;
import com.wsms.kusaki.dto.response.SchoolApiErrorResponse;
import io.vavr.control.Either;

/**
 * This provides functionalities for reading student from class
 */
public interface StudentClassModel {

    /**
     * this creates a new school entity
     * @param classStudentRequest
     * @return {@link Either<SchoolApiErrorResponse, ClassStudentResponse>}
     */
    Either<SchoolApiErrorResponse, ClassStudentResponse> getStudentClass(GetClassStudentRequest classStudentRequest);

}
