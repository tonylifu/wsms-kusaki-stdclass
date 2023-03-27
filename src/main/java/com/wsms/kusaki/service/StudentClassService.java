package com.wsms.kusaki.service;

import com.wsms.kusaki.constant.StudentClassConstant;
import com.wsms.kusaki.dto.request.GetClassStudentRequest;
import com.wsms.kusaki.dto.response.ClassStudentResponse;
import com.wsms.kusaki.dto.response.SchoolApiErrorResponse;
import com.wsms.kusaki.dto.response.StudentResponse;
import com.wsms.kusaki.entity.Student;
import com.wsms.kusaki.enums.SchoolError;
import com.wsms.kusaki.model.StudentClassModel;
import com.wsms.kusaki.repository.RepositoryServiceI;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class StudentClassService implements StudentClassModel {
    private final RepositoryServiceI repositoryService;

    @Override
    public Either<SchoolApiErrorResponse, ClassStudentResponse> getStudentClass(GetClassStudentRequest classStudentRequest) {
        log.info("----in get students in a class-----");
        var validateParams = validateGetStudentParams(classStudentRequest);
        if (validateParams.isLeft()) {
            return Either.left(validateParams.getLeft());
        }
        String assignedClass = String.format("%s"+"%s"+"%s"+"%s",
                classStudentRequest.getClassId(), classStudentRequest.getClassAlphabeth(),
                classStudentRequest.getYear(),classStudentRequest.getTerm());

        return repositoryService.getStudents(assignedClass)
                .map(this::buildStudentClassResponse);
    }

    private Either<SchoolApiErrorResponse, Boolean> validateGetStudentParams(GetClassStudentRequest classStudentRequest) {
        if (Strings.isBlank(classStudentRequest.getClassId())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.SOMETHING_WENT_WRONG.getDescription(),
                    SchoolError.SOMETHING_WENT_WRONG.getCode(), "invalid student class"));
        }

        if (Strings.isBlank(classStudentRequest.getClassAlphabeth())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.SOMETHING_WENT_WRONG.getDescription(),
                    SchoolError.SOMETHING_WENT_WRONG.getCode(), "invalid student class letter"));
        }

        if (Strings.isBlank(classStudentRequest.getYear())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.SOMETHING_WENT_WRONG.getDescription(),
                    SchoolError.SOMETHING_WENT_WRONG.getCode(), "invalid year"));
        }

        if (Strings.isBlank(classStudentRequest.getTerm())) {
            return Either.left(StudentClassConstant.getSchoolApiErrorResponse(
                    SchoolError.SOMETHING_WENT_WRONG.getDescription(),
                    SchoolError.SOMETHING_WENT_WRONG.getCode(), "invalid term"));
        }

        return Either.right(Boolean.TRUE);
    }

    /**
     * maps List of Students to response class
     * @param students
     * @return {@link ClassStudentResponse}
     */
    private ClassStudentResponse buildStudentClassResponse(List<Student> students) {
        List<StudentResponse> studentResponses = new ArrayList<>();
        students.forEach(std -> {
            studentResponses.add(StudentResponse.builder()
                            .studentClass(std.getEntryClassAssigned())
                            .studentId(std.getId())
                            .currentBalance(repositoryService.getStudentBalance(std.getId()))
                            .fullName(std.getOtherNames()+" "+std.getSurName())
                            .isBoarder(std.getEntryBorderStatus())

                    .build());
        });
        return ClassStudentResponse.builder()
                .isError(Boolean.FALSE)
                .classStudentResponse(studentResponses)
                .build();
    }

}
