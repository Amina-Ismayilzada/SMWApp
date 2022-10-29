package az.webapps.firstwebapp.controller;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import az.webapps.firstwebapp.dao.StudentDao;
import az.webapps.firstwebapp.entity.Student;
import az.webapps.firstwebapp.service.StudentService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "studentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            processRequest(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            processRequest(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String action = null;
        String address = null;
        boolean isPost = false;

        if (request.getParameter("action") != null) {
            action = request.getParameter("action");

            if (action.equalsIgnoreCase("studentList")) {
                request.setAttribute("list", StudentService.getAllStudents());
                address = "student.jsp";
            } else if (action.equalsIgnoreCase("addStudentView")) {
                address = "addStudent.jsp";
            } else if (action.equalsIgnoreCase("updateStudentView")) {
                request.setAttribute("student", StudentService.getOneStudent(Integer.parseInt(request.getParameter("id"))));
                address = "updateStudent.jsp";
            } else if (action.equalsIgnoreCase("deleteStudent")) {
                int id = Integer.parseInt(request.getParameter("id"));
                StudentService.deleteStudent(id);
                isPost = true;
                address = "/WebApps/student-servlet?action=studentList";
            } else if (action.equalsIgnoreCase("addStudent")) {
                Student student = new Student();
                student.setName(request.getParameter("name"));
                student.setSurname(request.getParameter("surname"));
                student.setPhone(request.getParameter("phone"));
                student.setEmail(request.getParameter("email"));
                StudentService.addStudent(student);
                isPost = true;
                address = "/WebApps/student-servlet?action=studentList";
            } else if (action.equalsIgnoreCase("updateStudent")) {
                Student student = new Student();
                student.setID(Integer.parseInt(request.getParameter("id")));
                student.setName(request.getParameter("name"));
                student.setSurname(request.getParameter("surname"));
                student.setPhone(request.getParameter("phone"));
                student.setEmail(request.getParameter("email"));
                StudentService.updateStudent(student);
                isPost = true;
                address = "/WebApps/student-servlet?action=studentList";
            }

            if (isPost) {
                response.sendRedirect(address);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request, response);
            }
    }
    }
}