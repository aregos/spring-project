package ru.bellintegrator.practice.responsewrappers;

import java.io.Serializable;

public class FailureWrapper implements Serializable {
    private String error;

    public FailureWrapper(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    @Override
    public String toString() {
        return "error:" + error;
    }
}
