package com.wsms.kusaki.controller;

import com.wsms.kusaki.dto.request.GetClassStudentRequest;
import com.wsms.kusaki.model.StudentClassModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/classes")
public class StudentClassController {
    private final StudentClassModel studentClassModel;

    @RequestMapping(value = "/students", method = RequestMethod.POST,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE},
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public Object getStudentClass(final @RequestBody GetClassStudentRequest getClassStudentRequest) {
        return studentClassModel.getStudentClass(getClassStudentRequest).fold(e -> e, r -> r);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET,
            produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE},
            consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE})
    @ResponseStatus(HttpStatus.OK)
    public String test(){
        return """
                {
                    "isOkay": true
                }
                """;
    }
}
