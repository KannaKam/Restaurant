package com.olgibaba.restaurant.payload.response;

public class ResponseMessages {

    private int status;
    private String header;
    private String message;

    public ResponseMessages(int status, String header, String message) {
        this.status = status;
        this.header = header;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
