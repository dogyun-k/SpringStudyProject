package com.study.board.LAMP;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseType {

    SYSTEM_ERROR("S"),
    BUSINESS_ERROR("E"),
    INFORMATION_ERROR("I"),
    WARNING_ERROR("W");

    private final String value;
}
