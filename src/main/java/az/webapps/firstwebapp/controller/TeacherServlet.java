package az.webapps.firstwebapp.controller;
import az.webapps.firstwebapp.entity.Teacher;
import az.webapps.firstwebapp.service.TeacherService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "teacherServlet", value = "/teacher-servlet")
public class TeacherServlet  extends HttpServlet {
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

        if(request.getParameter("action") != null){
            action = request.getParameter("action");

            if(action.equalsIgnoreCase("teacherList")){
                request.setAttribute("list", TeacherService.getAllTeachers() );
                address = "teacher.jsp";
            }
            else if (action.equalsIgnoreCase("addTeacherView")) {
                address = "addTeacher.jsp";
            }
            else if (action.equalsIgnoreCase("updateTeacherView")) {
                request.setAttribute("teacher", TeacherService.getOneTeacher(Integer.parseInt(request.getParameter("id"))));
                address = "updateTeacher.jsp";
            }
            else if (action.equalsIgnoreCase("deleteTeacher")) {
                int id = Integer.parseInt(request.getParameter("id"));
                TeacherService.deleteTeacher(id);
                isPost = true;
                address = "/WebApps/teacher-servlet?action=teacherList";
            }
            else if (action.equalsIgnoreCase("addTeacher")) {
                Teacher teacher = new Teacher();
                teacher.setName(request.getParameter("name"));
                teacher.setSurname(request.getParameter("surname"));
                teacher.setPhone(request.getParameter("phone"));
                teacher.setEmail(request.getParameter("email"));
                TeacherService.addTeacher(teacher);
                isPost = true;
                address = "/WebApps/teacher-servlet?action=teacherList";
            }
            else if (action.equalsIgnoreCase("updateTeacher")) {
                Teacher teacher = new Teacher();
                teacher.setID(Integer.parseInt(request.getParameter("id")));
                teacher.setName(request.getParameter("name"));
                teacher.setSurname(request.getParameter("surname"));
                teacher.setPhone(request.getParameter("phone"));
                teacher.setEmail(request.getParameter("email"));
                TeacherService.updateTeacher(teacher);
                isPost = true;
                address = "/WebApps/teacher-servlet?action=teacherList";
            }

            if(isPost){
                response.sendRedirect(address);
            } else{
                RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                dispatcher.forward(request,response);
            }
        }
    }
}
