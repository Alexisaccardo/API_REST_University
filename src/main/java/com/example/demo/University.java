package com.example.demo;

public class University {

    public String course;
    public String teacher;
    public int number_students;
    public String schedule;
    public String semester;
    public String working_day;
    public String campus;

    public University(String course, String teacher, int number_students, String schedule, String semester, String working_day, String campus) {
        this.course = course;
        this.teacher = teacher;
        this.number_students = number_students;
        this.schedule = schedule;
        this.semester = semester;
        this.working_day = working_day;
        this.campus = campus;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getNumber_students() {
        return number_students;
    }

    public void setNumber_students(int number_students) {
        this.number_students = number_students;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getWorking_day() {
        return working_day;
    }

    public void setWorking_day(String working_day) {
        this.working_day = working_day;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }
}