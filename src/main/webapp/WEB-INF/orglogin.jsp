<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Org Log in</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body style="background-image: url('images/back.jpg'); background-size: cover; background-repeat: no-repeat">
<div class="container-fluid">
  <div class="row">
    <nav class="navbar navbar-light">
      <div class="container-fluid">
        <a class="navbar-brand" href="">
          <img src="images/logo.png" alt="" width="80" height="80" class="d-inline-block align-text-center">
          DevsOnDeck
        </a>
        <a href="/register" class="text-right navbar-brand">Dev Registration</a>

        <a href="/orgsignup" class="text-right navbar-brand"> Org Registraton</a>

      </div>
    </nav>
    <div class="card  col-md-8 rowmap signup">
      <div>
        <div class="text-center" >
          <h1>Welcome Back!</h1>
          <h3>Lets find you some Candidates!</h3>
        </div>
        <div class="card-body">
        </div>
<%--        <p>--%>
<%--          <c:out value="${error}" />--%>
<%--        </p>--%>
        <form:form action="/orglogin" method="post" modelAttribute="loginNew">
          <div class="d-flex flex-row justify-content-center align-items-center">
            <p class="col-sm-2">
              <form:label path="email" class="ms-2 fw-semibold col-form-label fs-2 text">Email</form:label>
            </p>
            <form:errors path="email" class="errors text-danger"/>
            <form:input path="email" type="text" class="form-control"/>
          </div>
          <div class="d-flex flex-row justify-content-center align-items-center">
            <p class="col-sm-2">
              <form:label path="password" class="ms-2 fw-semibold col-form-label fs-2 text">Password</form:label>
            </p>
            <form:input path="password" type="password" class="form-control"/>
            <form:errors path="password" class="errors text-danger"/>
          </div>
          <button type="submit" class="btn btn-success">Login</button>
        </form:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>