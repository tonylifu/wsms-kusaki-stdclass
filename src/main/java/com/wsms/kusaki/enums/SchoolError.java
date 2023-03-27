package com.wsms.kusaki.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * This class contains details of failed messages and associated failure codes
 */
@RequiredArgsConstructor
@Getter
public enum SchoolError {

    CLASS_EMPTY_ERROR("0010", "class may be empty or invalid parameters have been passed"),
    SOMETHING_WENT_WRONG("0099", "something went wrong");

    private final String code;
    private final String description;

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
