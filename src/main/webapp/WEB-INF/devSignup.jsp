<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Developer Signup</title>
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
        <a href="/devlogin" class="text-right navbar-brand">Dev Login</a>

        <a href="/orglogin" class="text-right navbar-brand"> Org Login</a>

      </div>
    </nav>

    <div class="card col-md-8 rowmap signup">
      <h1 class="text-center">Developer Sign Up</h1>
      <div class="card-body">

        <form:form action="/register" method="POST"
                   modelAttribute="newDev">
          <div class="col-sm-12">
            <form:label path="fname" for="fname" class="col-sm-2 col-md-2">First Name:</form:label>
            <form:input path="fname" class="col-sm-9 col-md-3" />
            <form:label path="lname" class="col-sm-2 col-md-2">Last Name:</form:label>
            <form:input path="lname" class=" col-sm-9 col-md-4" />
          </div>
          <form:label path="email" class="col-sm-2">Email address:</form:label>
          <form:input path="email" class=" col-sm-9" />

          <form:label path="address" class="col-sm-2">Address:</form:label>
          <form:input path="address" class="col-sm-9" />
          <form:label path="city" class="col-sm-2">City:</form:label>
          <form:input path="city" class=" col-sm-6" />



          <form:label path="state" class="">State:
          </form:label>

          <form:select path="state" class="col-sm-2"
                       aria-label="Default select example">
            <option value="AK">AK</option>
            <option value="AL">AL</option>
            <option value="AR">AR</option>
            <option value="AZ">AZ</option>
            <option value="CA">CA</option>
            <option value="CO">CO</option>
            <option value="CT">CT</option>
            <option value="DC">DC</option>



          </form:select>

          <form:label path="password" class="col-sm-2">Password:</form:label>
          <form:input type="password" path="password" class=" col-sm-9" />
          <form:label path="passConfirm" class="col-sm-2">Confirm:</form:label>
          <form:input type="password" path="passConfirm" class="col-sm-9" />


          <button type="submit" class="btn btn-success">Register</button>
        </form:form>
        <a href="/orgSignup" class="text-center">Need to Sign Up an
          Organization?</a>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/basic.js"></script>
</body>
</html>