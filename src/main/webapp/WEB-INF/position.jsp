<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Position</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<nav class="navbar navbar-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="">
      <img src="images/logo.png" alt="" width="80" height="80" class="d-inline-block align-text-center">
      DevsOnDeck
    </a>
    <a class="navbar-brand" href="/devdashboard">Back</a>
  </div></nav>
<body style="background-image: url('images/sk.jpg'); background-size: cover; background-repeat: no-repeat">
<div class="container">
  <div class="row bg-success">
    <div class="col-sm-8 col-md-8 text-center posback ">
      <h3>Position: <c:out value="${pos.title}"/></h3>
    </div>
    <div class="col-sm-12 col-md-8 text-center ">
      <h3 class="col-sm-12 text-center">Position Description: <c:out value="${pos.description}"/></h3>

      <a href="/apply/${pos.id}"><button type="submit" class="btn btn-success text-center middle col-sm-5">Apply</button></a>

    </div>
  </div>
</div>
</body>
</html>