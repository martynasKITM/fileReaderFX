package org.example.guifilereader;

public class Student {
    private String name;
    private String studentClass;
    private double grade;

    public Student(String name, String studentClass, double grade){
        this.name = name;
        this.studentClass = studentClass;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public double getGrade() {
        return grade;
    }
}
