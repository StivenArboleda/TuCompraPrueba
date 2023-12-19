package com.tucompra.helpers;

public class ClinicaExcepcion extends RuntimeException {

    public ClinicaExcepcion(String message) {
        super(message);
    }

    public ClinicaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }

}
