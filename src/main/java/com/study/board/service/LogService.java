package com.study.board.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.board.LAMP.CommonLampLog;
import com.study.board.LAMP.LogType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LogService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void log() throws JsonProcessingException {
        String uuid = UUID.randomUUID().toString();
        ObjectMapper mapper = new ObjectMapper();

        CommonLampLog log = CommonLampLog.of(
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                uuid,
                LogType.IN_MSG.name(),
                "Body Data",
                new CommonLampLog.ResponseLog(),
                new CommonLampLog.DestinationLog("name", "ip")
        );

        logger.info(mapper.writeValueAsString(log));
    }

}
