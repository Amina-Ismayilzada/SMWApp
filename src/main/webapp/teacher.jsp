<%@ page import="az.webapps.firstwebapp.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SMApp - Teachers</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<div class="container">
  <h1 style="text-align: center">Teachers</h1>

  <table  class="table table-hover">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NAME</th>
      <th scope="col">SURNAME</th>
      <th scope="col">PHONE</th>
      <th scope="col">EMAIL</th>
      <th scope="col"></th>
      <th scope="col"></th>
    </tr>
    <%
      List<Teacher> teacherList = (List<Teacher>) request.getAttribute("list");
      for(Teacher teacher : teacherList){
    %>
    <tr>
      <th scope="row"><%=teacher.getID()%></th>
      <td><%=teacher.getName()%></td>
      <td><%=teacher.getSurname()%></td>
      <td><%=teacher.getPhone()%></td>
      <td><%=teacher.getEmail()%></td>
      <td><a href="/WebApps/teacher-servlet?action=updateTeacherView&id=<%=teacher.getID()%>" style="color:white" type="button" class="btn btn-warning">EDIT</a></td>

      <form method="POST" action="/WebApps/teacher-servlet?action=deleteTeacher">
        <td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal<%=teacher.getID()%>">DELETE</button></td>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal<%=teacher.getID()%>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Do you really want to delete this teacher?</h5>
                <label>
                  <input name="id" value="<%=teacher.getID()%>" hidden>
                </label>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                <button type="submit" class="btn btn-primary">Yes</button>
              </div>
            </div>
          </div>
        </div>
      </form>



    </tr>
    <%
      }
    %>
  </table>

  <a href="/WebApps/teacher-servlet?action=addTeacherView" type="button" class="mb-3 btn btn-primary btn-lg btn-block">+</a>


  <a href="index.jsp">← Go back to home page</a>

</div>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>
