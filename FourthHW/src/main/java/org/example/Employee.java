package org.example;

public class Employee {
    private final int serviceNumber;
    private final String phoneNumber;
    private final String name;
    private final String workExperience;

    public Employee(int serviceNumber, String phoneNumber, String name, String workExperience) {
        this.serviceNumber = serviceNumber;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.workExperience = workExperience;
    }

    @Override
    public String toString() {
        return serviceNumber + "," +
                phoneNumber + "," +
                name + "," +
                workExperience;
    }
}
