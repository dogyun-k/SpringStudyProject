package com.study.board.LAMP;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LogType {

    IN_REQ,
    OUT_REQ,
    IN_RES,
    OUT_RES,
    NOTIFY,
    ASYNC,
    IN_MSG,
    OUT_MSG

}
