package com.restfulservices.exception;

import java.util.Date;

public class ErrorDetails {
    private Date date;
    private String description;
    private String message;

    public ErrorDetails(Date date, String description, String message) {
        this.date = date;
        this.description = description;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorDetails{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
