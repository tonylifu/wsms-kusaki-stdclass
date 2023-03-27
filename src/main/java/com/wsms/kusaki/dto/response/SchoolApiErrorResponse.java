package com.wsms.kusaki.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolApiErrorResponse {
    private String errorMessage;
    private String errorCode;
    private String failureReason;
}
