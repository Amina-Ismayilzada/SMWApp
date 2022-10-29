//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.webapps.firstwebapp.service;

import az.webapps.firstwebapp.DB.DB;
import az.webapps.firstwebapp.dao.TeacherDao;
import az.webapps.firstwebapp.entity.Teacher;
import az.webapps.firstwebapp.util.ApplicationUtil;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class TeacherService {
    public static int size = 0;

    public TeacherService() {
    }

    public static int validateNumberOfTeacher(int input, Scanner sc) {
        label16:
        while(true) {
            Iterator var2 = DB.teachers.entrySet().iterator();

            Map.Entry entry;
            do {
                if (!var2.hasNext()) {
                    System.out.print("There is no such teacher. Please enter the valid number:  ");
                    input = ApplicationUtil.validateStringInputAndReturnNumber(sc.nextLine());
                    continue label16;
                }

                entry = (Map.Entry)var2.next();
            } while((Integer)entry.getKey() != input);

            return input;
        }
    }

    public static void setTeacherInfo(Teacher teacher, Scanner sc) {
        System.out.println("----- Please enter teacher's data -----");
        System.out.print("\t  Name  ->  ");
        teacher.setName(sc.nextLine());
        System.out.print("\t  Surname  ->  ");
        teacher.setSurname(sc.nextLine());
        System.out.print("\t  Email  ->  ");
        teacher.setEmail(sc.nextLine());
        System.out.print("\t  Phone number  ->  ");
        teacher.setPhone(sc.nextLine());
        System.out.println();
    }

    public static void addTeacher(Teacher teacher) throws SQLException {
        ++size;
        TeacherDao.addTeacher(teacher);
    }

    public static List<Teacher> getAllTeachers() throws SQLException {
        return TeacherDao.getAllTeachers();
    }

    public static Teacher getOneTeacher(int id) throws SQLException {
        return TeacherDao.getOneTeacher(id);
    }

    public static void updateTeacher(Teacher teacher) throws SQLException {
        TeacherDao.updateTeacher(teacher);
    }

    public static void deleteTeacher(int id) throws SQLException {
        TeacherDao.deleteTeacher(id);
    }
}
