<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Developer Dashboard</title>
  <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head >
<nav class="navbar navbar-dark">
  <div class="container-fluid navbar-dark">
    <a class="navbar-brand" href="">
      <img src="images/logo.png" alt="" width="80" height="80" class="d-inline-block align-text-center ">
      DevsOnDeck
    </a>
    <a class="navbar-brand text-right" href="/logout">LogOut</a>

  </div>
</nav>
<body style="background-image: url('images/sk.jpg'); background-size: cover; background-repeat: no-repeat">
<div class="container-fluid">
  <div class="row">

    <div class="row ">
      <div class="col-sm-12 col-md-3">
        <div class="col-sm-12 rowmap">
          <h4 class="text-center signup">Organizations</h4>
          <c:forEach items="${orgs}" var="o">
            <div class="col-sm-12 text-center ">
              <h4><a href="/organization/${o.id}" >
                <c:out value="${o.orgName}"/></a></h4>
            </div>
          </c:forEach>
        </div>
      </div>
      <div class="col-sm-10  col-md-6 rowmap">
        <h2 class="signup text-center">Available Positions</h2>
        <div class="col-sm-12  text-center ">
          <c:forEach items="${positions}" var="p">

            <div class="col-sm-7 text-center ">

              <a href="/position/${p.id}"  >
                <h4 ><c:out value="${p.title}"/></h4>
              </a>
            </div>
          </c:forEach></div>
      </div>
      <div class="col-sm-12 col-md-3 rowmap">
        <div class="col-sm-12">
          <h4 class="text-center signup">Applied Positions</h4>
          <c:forEach items="${dev.applications}" var="a">
            <div class="col-sm-12 text-center">

              <h4><a href="" ><c:out value="${a.title}"/></a>, <c:out value="${a.organization.orgName}"/></h4>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>