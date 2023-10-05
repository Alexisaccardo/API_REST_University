package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class Controlador {

    String course_ = "No se encuentra el curso especificado";

    @PostMapping("/register")
    public University register(@RequestBody University university) throws SQLException, ClassNotFoundException {

        String course = university.getCourse();
        String teacher = university.getTeacher();
        int number_students = university.getNumber_students();
        String schedule = university.getSchedule();
        String semester = university.getSemester();
        String working_day = university.getWorking_day();
        String campus = university.getCampus();

        if (teacher == null || teacher.equals("") || teacher.length() < 0 || number_students <= 0 || schedule == null ||
                schedule.equals("") || schedule.length() < 0 || semester == null || semester.equals("") ||
                semester.length() < 0 || working_day == null || working_day.equals("") || working_day.length() < 0 ||
                campus == null || campus.equals("") || campus.length() < 0) {

            return new University(null, null, 0, null, null, null, null);

        } else {
            BD bd = new BD();
            university = bd.register(course, teacher, number_students, schedule, semester, working_day, campus);
        }

        return university;
    }

    @PostMapping("/edit")
    public University edit(@RequestBody University university) throws SQLException, ClassNotFoundException {

        String course = university.getCourse();
        String teacher = university.getTeacher();
        int number_students = university.getNumber_students();
        String schedule = university.getSchedule();
        String semester = university.getSemester();
        String working_day = university.getWorking_day();
        String campus = university.getCampus();

        if (teacher == null || teacher.equals("") || teacher.length() < 0 || number_students <= 0 || schedule == null ||
                schedule.equals("") || schedule.length() < 0 || semester == null || semester.equals("") ||
                semester.length() < 0 || working_day == null || working_day.equals("") || working_day.length() < 0 ||
                campus == null || campus.equals("") || campus.length() < 0) {

            return new University(null, null, 0, null, null, null, null);

        } else {
            BD bd = new BD();
            university = bd.Edit(course, teacher, number_students, schedule, semester, working_day, campus);
        }
        return university;
    }

    @GetMapping("/search_course")
    public List<University> search_course() throws SQLException, ClassNotFoundException {
        BD bd = new BD();
        List<University> list = bd.Select_course();

        return list;
    }

    @GetMapping("/search_one/{course}")
    public University search_user(@PathVariable String course) throws SQLException, ClassNotFoundException {

        University university;

        if (course == null || course.equals("") || course.length() < 0) {

            return new University(course_, null, 0, null, null, null, null);

        } else {

            BD bd = new BD();
            university = bd.Select_user(course);
            if (university==null){
                return new University(course_, null, 0, null, null, null, null);
            }
        }


        return university;

    }
    @DeleteMapping("/delete_course")
    public University delete_course(@RequestBody University university) throws SQLException, ClassNotFoundException {

        String course = university.getCourse();
        if (university.getCourse() == null || university.getCourse().equals("") || university.getCourse().length()<0) {
            return new University(null, null, 0, null, null, null, null);
        }else {

            BD bd = new BD();
            int f = bd.Delete(course);
            if (f==0){
                return new University(course_, null, 0, null, null, null, null);
            }else {

            }
        }

        return university;
    }
}
