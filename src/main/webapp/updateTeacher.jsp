<%@ page import="az.webapps.firstwebapp.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SMApp - Update Teacher</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">
  <%
    Teacher teacher = (Teacher) request.getAttribute("teacher");
  %>

  <h1 style="text-align: center">UPDATE TEACHER</h1>
  <form action="/WebApps/teacher-servlet?action=updateTeacher" method="POST">
    <div class="form-group">
      <label for="formGroupID">ID</label>
      <input name="id" type="text" class="form-control" id="formGroupID"  value="<%=teacher.getID()%>">
    </div>
    <div class="form-group">
      <label for="formGroupName">Name</label>
      <input name="name" type="text" class="form-control" id="formGroupName" value="<%=teacher.getName()%>">
    </div>
    <div class="form-group">
      <label for="formGroupSurname">Surname</label>
      <input name="surname" type="text" class="form-control" id="formGroupSurname" value="<%=teacher.getSurname()%>">
    </div>
    <div class="form-group">
      <label for="formGroupPhone">Phone</label>
      <input name="phone" type="text" class="form-control" id="formGroupPhone" value="<%=teacher.getPhone()%>">
    </div>
    <div class="form-group">
      <label for="formGroupEmail">Email</label>
      <input name="email" type="text" class="form-control" id="formGroupEmail" value="<%=teacher.getEmail()%>">
    </div>

    <button type="submit" class="btn btn-primary btn-lg btn-block">Click to update teacher</button>

  </form>

</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
