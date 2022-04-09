package com.sennikov.calculator.dto;

public class Response<T> implements iResponse{

    private T result;

    public Response(T result) {
        this.result = result;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
