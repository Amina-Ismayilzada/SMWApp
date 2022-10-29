//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.webapps.firstwebapp.service;

import az.webapps.firstwebapp.DB.DB;
import az.webapps.firstwebapp.dao.StudentDao;
import az.webapps.firstwebapp.entity.Student;
import az.webapps.firstwebapp.util.ApplicationUtil;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class StudentService {
    public static int size = 0;

    public StudentService() {
    }

    public static int validateNumberOfStudent(int input, Scanner sc) {
        OUTER_LOOP:
        while(true) {
            Iterator var2 = DB.students.entrySet().iterator();

            Map.Entry entry;
            do {
                if (!var2.hasNext()) {
                    System.out.print("There is no such student. Please enter the valid number:  ");
                    input = ApplicationUtil.validateStringInputAndReturnNumber(sc.nextLine());
                    continue OUTER_LOOP;
                }

                entry = (Map.Entry)var2.next();
            } while((Integer)entry.getKey() != input);

            return input;
        }
    }

    public static void setStudentInfo(Student student, Scanner sc) {
        System.out.println("----- Please enter student's data -----");
        System.out.print("\t  Name  ->  ");
        student.setName(sc.nextLine());
        System.out.print("\t  Surname  ->  ");
        student.setSurname(sc.nextLine());
        System.out.print("\t  Email  ->  ");
        student.setEmail(sc.nextLine());
        System.out.print("\t  Phone number  ->  ");
        student.setPhone(sc.nextLine());
        System.out.println();
    }

    public static void addStudent(Student student) throws SQLException {
        ++size;
        StudentDao.addStudent(student);
    }

    public static List<Student> getAllStudents() throws SQLException {
        return StudentDao.getAllStudents();
    }

    public static Student getOneStudent(int id) throws SQLException {
        return StudentDao.getOneStudent(id);
    }

    public static void updateStudent(Student student) throws SQLException {
        StudentDao.updateStudent(student);
    }

    public static void deleteStudent(int id) throws SQLException {
        StudentDao.deleteStudent(id);
        System.out.println("Successfully deleted.");
    }
}
