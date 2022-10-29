<%@ page import="az.webapps.firstwebapp.entity.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SMApp - Add Teacheer</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<div class="container">

  <h1 style="text-align: center">ADD NEW TEACHER</h1>

  <form  action="/WebApps/teacher-servlet?action=addTeacher" method="POST">


    <div class="form-group">
      <label for="formGroupName">Name</label>
      <input name="name" type="text" class="form-control" id="formGroupName" placeholder="Teacher Name">
    </div>
    <div class="form-group">
      <label for="formGroupSurname">Surname</label>
      <input name="surname" type="text" class="form-control" id="formGroupSurname" placeholder="Teacher Surname">
    </div>
    <div class="form-group">
      <label for="formGroupPhone">Phone</label>
      <input name="phone" type="text" class="form-control" id="formGroupPhone" placeholder="Teacher Phone">
    </div>
    <div class="form-group">
      <label for="formGroupEmail">Email</label>
      <input name="email" type="text" class="form-control" id="formGroupEmail" placeholder="Teacher Email">
    </div>
    <button type="submit" class="btn btn-primary btn-lg btn-block">Click to add Teacher</button>
  </form>

</div>




<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
