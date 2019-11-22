package org.esteban.demoapp.controller;

public class ResponseDto {

    private String app;
    private String version;

    public ResponseDto(String version) {
        this.version = version;
        app = "Demo";
    }

    public String getVersion() {
        return version;
    }


    public String getApp() {
        return app;
    }
}
