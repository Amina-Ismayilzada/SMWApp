<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>SMApp - Home Page</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Playfair Display">

</head>
<style>
    h1 {
        font-family: "Playfair Display";
        text-align: center;
        text-shadow: 3px 3px 3px #ababab;
        margin: 25px 50px 20px 100px;
        color: darkblue;
    }
    h3{
        text-align: center;
        color: darkgreen;
    }
</style>
<body>
    <h1>SMApp - Home Page</h1>
    <h3><a  href="/WebApps/student-servlet?action=studentList" >Students</a></h3>

    <h3><a  href="/WebApps/teacher-servlet?action=teacherList">Teachers</a></h3>

</body>
</html>