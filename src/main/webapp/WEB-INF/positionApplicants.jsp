<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Position Applicants</title>
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
    <h2 class="col-sm-4">
      <c:out value="${pos.title}"/>
    </h2>
    <a class="navbar-brand text-right" href="/logout">LogOut</a>
  </div></nav>
<body style="background-image: url('images/sk.jpg'); background-size: cover; background-repeat: no-repeat">
<div class="container-fluid">
  <div class="row">
<%--      <img style="height: 50px; width: 30%; margin: 0 auto;" src="${pos.images}">--%>

      <div class="col-sm-12 col-md-4">
        <h3 class="col-sm-12 text-center">
          <a href="/newPosition"><button class=" col-sm-10 text-center">List
            a New Position</button></a>
        </h3>
        <div class="col-sm-12">
          <h4 class="text-center">Position</h4>
        </div>
      </div>
      <div class="col-sm-12 col-md-6">
        <h2>Available Devs</h2>
        <div class="col-sm-12 scroll">
          <c:forEach items="${devs}" var="d">
            <table class="col-sm-12">
              <tr style="height: 20px">
                <td class="col-sm-3"><a href=""><c:out
                        value="${d.fname}" /> <c:out value="${d.lname}" /></a>
                <td class="col-sm-9">
                <c:forEach items="${d.myskills}" var="s">
                  <img src="${s.images}"
                       style="width: 10%; height: 25px;">
                </c:forEach></td>
              </tr>
              <tr>
                <td colspan="2" rowspan="2"><p><c:out value="${d.biography}" /></p></td>
                <td>

              </tr>
            </table>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>