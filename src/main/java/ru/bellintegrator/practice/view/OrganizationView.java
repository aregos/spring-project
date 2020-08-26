package ru.bellintegrator.practice.view;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class OrganizationView {

    public String id;

    @Size(min = 5)
    public String name;

    @Size(min = 5)
    public String fullName;

    public Integer inn;

    public Integer kpp;

    @Size(min = 5)
    public String address;

    @Max(10)
    @Min(6)
    public Integer phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";fullName:" + fullName + "}";
    }
}
