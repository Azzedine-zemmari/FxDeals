package com.demo.ProgressSoft.exception;

import java.time.LocalDateTime;

public class ApiErreur {
    private int status;
    private LocalDateTime time;
    private String message;

    public ApiErreur(int status, LocalDateTime time, String message) {
        this.status = status;
        this.time = time;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
