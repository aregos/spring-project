package ru.bellintegrator.practice.responsewrappers;

public class SuccessWrapper<T> {
    private T data;

    public SuccessWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
