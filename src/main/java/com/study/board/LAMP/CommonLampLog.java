package com.study.board.LAMP;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
public class CommonLampLog {

    private String timestamp;
    private String service;
    private String operation;
    private String transactionId;
    private String logType;
    private String payload;
    private HostLog host;
    private ResponseLog response;
    private DestinationLog destination;

    public CommonLampLog(
            String timestamp,
            String service,
            String operation,
            String transactionId,
            String logType,
            String payload,
            HostLog host,
            ResponseLog response,
            DestinationLog destination
    ) {
        this.timestamp = timestamp;
        this.service = service;
        this.operation = operation;
        this.transactionId = transactionId;
        this.logType = logType;
        this.payload = payload;
        this.host = host;
        this.response = response;
        this.destination = destination;
    }

    public static CommonLampLog of(
            String operation,
            String uuid,
            String logType,
            String payload,
            ResponseLog response,
            DestinationLog destination
    ) {
        HostLog host = new HostLog();
        return new CommonLampLog(
                getLampFormatTimestamp(LocalDateTime.now()),
                ServiceCodeType.OPEN_API_CODE.getCode(),
                operation,
                host.getName() + "_" + uuid,
                logType,
                payload,
                host,
                response,
                destination
        );
    }

    private static String getLampFormatTimestamp(LocalDateTime timestamp) {
        return timestamp.toString().replace("T", " ").substring(0, 23);
    }


    @Getter
    @NoArgsConstructor
    public static class ResponseLog {
        private String type;
        private String code;
        private String desc;
        private String duration;

        public ResponseLog(String type, String code, String desc, String duration) {
            this.type = type;
            this.code = code;
            this.desc = desc;
            this.duration = duration;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class DestinationLog {
        private String name;
        private String ip;

        public DestinationLog(String name, String ip) {
            this.name = name;
            this.ip = ip;
        }
    }

    @Getter
    public static class HostLog {
        private String name;
        private String ip;

        public HostLog() {
            try {
                this.name = InetAddress.getLocalHost().getHostName();
                this.ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
    }
}
