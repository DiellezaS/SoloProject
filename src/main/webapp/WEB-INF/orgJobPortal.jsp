<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>JobPortal</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<nav class="navbar navbar-light">
  <div class="container-fluid">
    <img src="/images/logo.png"  width="80" height="80" class="d-inline-block align-text-center">
    <h3 class="navbar-brand "> DevsOnDeck</h3>


    <a class="navbar-brand" href="/devdashboard">Back</a>
  </div></nav>
<body style="background-image: url('/images/sk.jpg'); background-size: cover; background-repeat: no-repeat">
<div class="container-fluid">
  <div class="row">
    <div class="col-sm-12">
      <div class="row">
        <div></div>
        <h2 class="col-sm-4">Hello,<c:out value="${dev.firstName}"> <c:out value="${dev.lname}"/></c:out></h2>
        <h2 class="col-sm-9">
         Welcome to our organization :<c:out value="${org.orgName}"/></h2>

      </div>
    </div>
    <div class="row">
      <div class="col-sm-12 col-md-4">
        <div class="col-sm-7">
          <h4 class="text-center">All Your Applied Positions</h4>
          <c:forEach items="${dev.applications}" var="p">
            <div class="col-sm-12 text-center">

              <h4><a href="/position/${p.id}"><c:out value="${p.title}"/></a></h4>
            </div>
          </c:forEach>
        </div>
      </div>
      <div class="col-sm-12 col-md-6">
        <h2>Our Available Positions</h2>
        <div class="col-sm-12 scroll text-center">
          <c:forEach items="${org.openPositions}" var="p">
            <div class="col-sm-7 text-center">
              <c:out value="${p.title}"/></div>
          </c:forEach></div>
      </div>
    </div>
  </div>
</div>
</body>
</html>