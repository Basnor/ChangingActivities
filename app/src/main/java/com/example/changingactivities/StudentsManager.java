package com.example.changingactivities;

import java.util.ArrayList;
import java.util.List;

public class StudentsManager {
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> addStudents(Student student) {
        students.add(student);
        return students;
    }
}
