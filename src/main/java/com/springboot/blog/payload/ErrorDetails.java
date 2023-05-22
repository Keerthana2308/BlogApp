package com.springboot.blog.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timestamp;
    private  String messgae;
    private  String details;

    public ErrorDetails(Date timestamp, String messgae, String details) {
        this.timestamp = timestamp;
        this.messgae = messgae;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessgae() {
        return messgae;
    }

    public String getDetails() {
        return details;
    }
}
