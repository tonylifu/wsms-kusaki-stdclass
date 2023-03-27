package com.wsms.kusaki.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClassStudentResponse {
    private List<StudentResponse> classStudentResponse;
}