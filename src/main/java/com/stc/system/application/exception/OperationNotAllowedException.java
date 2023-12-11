package com.stc.system.application.exception;

public class OperationNotAllowedException extends RuntimeException {
    public OperationNotAllowedException() {
        super("Specified operation is not allowed, properly for lack of required permissions");
    }
}
