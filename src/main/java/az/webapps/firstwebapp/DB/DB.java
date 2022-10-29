//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.webapps.firstwebapp.DB;

import az.webapps.firstwebapp.entity.Student;
import az.webapps.firstwebapp.entity.Teacher;

import java.util.HashMap;
import java.util.Map;

public interface DB {
    Map<Integer, Student> students = new HashMap();
    Map<Integer, Teacher> teachers = new HashMap();
    String APP_USERNAME = "ADMIN";
    String APP_PASSWORD = "123";

    static boolean studentsListIsNotEmpty() {
        if (students.isEmpty()) {
            System.err.println("The list is empty.");
            return false;
        } else {
            return true;
        }
    }

    static boolean teachersListIsNotEmpty() {
        if (teachers.isEmpty()) {
            System.err.println("The list is empty.");
            return false;
        } else {
            return true;
        }
    }
}
