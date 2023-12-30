package org.example;

import java.util.Random;

public class Main {
    static Random rnd = new Random();
    static EmployeeDirectory employeeDirectory = new EmployeeDirectory();

    public static void main(String[] args) {

        addEmpCount(4);
        addEmpCount(1);

        employeeDirectory.addNewEmployee(143567,
                phoneNumbers()[rnd.nextInt(phoneNumbers().length)],
                names()[rnd.nextInt(names().length)],
                workExperience()[rnd.nextInt(workExperience().length)]);


        printBase();

        searchServiceNumber(143567);
        searchServiceNumber(144567);

        searchWorkExperience(15);
        searchWorkExperience(20);

        searchPhoneByName("Sam");
        searchPhoneByName("Mikhael");
    }

    private static String[] phoneNumbers() {
        return new String[]{
                "88008880000", "88008880001", "88008880002", "88008880003", "88008880004", "88008880005",
                "88008880006", "88008880007", "88008880008", "880088800009", "88008880010"};
    }

    private static String[] names() {
        return new String[]{"Bread", "Karl", "Annet", "Bred", "Ted", "Sam", "Jack", "Mikhael", "Tom", "Benjamin"};
    }

    private static int[] serviceNumbers() {
        int[] serviceNumbers = new int[10];
        for (int i = 0; i < serviceNumbers.length; i++) {
            serviceNumbers[i] = rnd.nextInt(999999) + 100000;
        }
        return serviceNumbers;
    }

    private static String[] workExperience() {
        String[] workExperience = new String[10];
        for (int i = 0; i < workExperience.length; i++) {
            workExperience[i] = rnd.nextInt(25) + " years";
        }
        return workExperience;
    }

    private static void printBase() {
        System.out.println("Весь справочник");
        employeeDirectory.printBase();
    }

    private static void searchServiceNumber(int num) {
        System.out.println();
        System.out.println("Поиск сотрудника по табельному номеру");
        employeeDirectory.searchServiceNumber(String.valueOf(num));
    }

    private static void searchWorkExperience(int num) {
        System.out.println();
        System.out.println("Поиск сотрудника по стажу");
        employeeDirectory.searchWorkExperience(num);
    }

    private static void searchPhoneByName(String name) {
        System.out.println();
        System.out.println("Поиск номер телефона сотрудника по имени");
        employeeDirectory.searchPhoneByName(name);
    }

    private static void addEmpCount(int num) {
        while (num > 0) {
            addEmp(employeeDirectory, rnd, phoneNumbers(), names(), serviceNumbers(), workExperience());
            num--;
        }
    }

    private static void addEmp(
            EmployeeDirectory employeeDirectory, Random rnd, String[] phoneNumbers, String[] names,
            int[] serviceNumbers, String[] workExperience) {

        employeeDirectory.addNewEmployee(
                serviceNumbers[rnd.nextInt(serviceNumbers.length)],
                phoneNumbers[rnd.nextInt(phoneNumbers.length)],
                names[rnd.nextInt(names.length)],
                workExperience[rnd.nextInt(workExperience.length)]);
    }
}
