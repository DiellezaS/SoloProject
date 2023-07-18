<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Insert title here</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <div class="topbar col-sm-12 col-md-8 rowmap">
      <h2 class="col-sm-5 col-md-8">DevsOnDeck</h2>
      <div class="col-sm-6 col-md-3">
        <div class="col-sm-6">
          <a href="/devSignup" class="text-right">Dev Registration </a>
        </div>
        <div class="col-sm-5 text-right">
          <a href="/orgSignup"> Org Registraton</a>
        </div>
      </div>
    </div>
    <div class="card col-md-8 rowmap signup">
      <div>
        <div class="text-center" >
          <h1>Welcome Back!</h1>
          <h3>Lets find you some Candidates!</h3>
        </div>
        <div class="card-body">
        </div>
        <p>
          <c:out value="${error}" />
        </p>
        <form:form action="/orglogin" method="post" modelAttribute="organization">

          <div class=" form-group row">
            <label for="email" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10 col-md-7">
              <input type="text" class="form-control" name="email"
                     placeholder="Enter email">
            </div>
          </div>

          <div class="form-group row">
            <label for="password" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10 col-md-7">
              <input type="password" class="form-control" name="password"
                     placeholder="Enter Password">
            </div>
          </div>


          <button type="submit" class="btn btn-success">Login</button>
        </form:form>
      </div>
    </div>
  </div>
</div>
</body>
</html>