package br.senac.sp.gcp.controller.response;

public class HelloWorldResponse {

    private String message;

    public HelloWorldResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public HelloWorldResponse setMessage(String message) {
        this.message = message;
        return this;
    }

}