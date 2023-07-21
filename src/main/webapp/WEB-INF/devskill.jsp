<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="background-image" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Developer Skills</title>

    <link
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
          crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<nav class="navbar navbar-light">
    <div class="container-fluid">
        <%--        <h2 class="col-sm-4">--%>
        <%--          <c:out value="${dev.fname}">--%>
        <%--            <c:out value="${dev.lname}"/>--%>
        <%--          </c:out>--%>
        <%--        </h2>--%>
        <a class="navbar-brand" href="">
            <img src="images/logo.png" alt="" width="80" height="80" class="d-inline-block align-text-center">
            DevsOnDeck
        </a>

        <a class="navbar-brand text-right" href="/logout">LogOut</a>

    </div>
</nav>
<body  style="background-image: url('images/sk.jpg'); background-size: cover; background-repeat: no-repeat">
<div class="container">
  <div class="row">

    <div class="card bg-transparent bg-gradient ">
      <div class="text-center skillbar col-sm-12">
        <h1>Add Your Skills</h1>
        <div class="progress">
          <div class="progress-bar" role="progressbar"
               style="width: ${dev.myskills.size()*20}%; " aria-valuenow="50"
               aria-valuemin="0" aria-valuemax="100">${dev.myskills.size()*20}%</div>
        </div>
      </div>
      <form:errors path="developer.*" />
      <div class="card-body "></div>
      <div class="  row rowmap signup">
        <div class="col-sm-8">

          <label  class="col-sm-5 col-md-5 col-form-label skillblock"><h4>${dev.fname},Pick
            Your Top 5 Languages</h4></label>

          <div class="col-sm-5 scroll">
            <c:forEach items="${dev.myskills}" var="s">
              <img style="height: 50px; width: 20%; margin: 0 auto;" src="${s.images}">
<%--                            <button--%>
<%--                                    path="posSkills" value="${s.id}" label="${s.name} "--%>
<%--                                    class=" text-center"></button>--%>
                          </c:forEach>
                        </div>
                      </div>
        <form:form  action="/addskill"  method="post" modelAttribute="newS">
          <c:forEach items="${skills}" var="s">
            <button type="submit" name="skillname" value="${s.id}">

             <img class="imgblock " style="height: 70px; width: 50%; margin: 0 auto;" src="${s.images}">

            </button>
          </c:forEach>
        </form:form>
                      <form:form action="/addBio" method="Post"
                                 modelAttribute="dev">

                        <div class=" form-group col-sm-7 ">
                          <div class="row col-sm-9">
                            <form:hidden path="fname" value="${dev.fname}" />
                            <form:hidden path="lname" value="${dev.lname}" />
                            <form:hidden path="address" value="${dev.address}" />
                            <form:hidden path="state" value="${dev.state}" />
                            <form:hidden path="city" value="${dev.city}" />
                            <form:hidden path="passConfirm" value="${dev.password}" />
                            <form:hidden path="password" value="${dev.password}" />
                            <form:hidden path="email" value="${dev.email}" />

                              <div class="col-sm-12 ">
                                  <div class="form-group ">
                                      <label for="biography" class=" col-form-label">Short
                                          Biography:</label>

                                      <form:textarea type="textarea" class="form-control"
                                                     path="biography" name="biography"
                                                     placeholder="${dev.biography}" style="height: 300px; width:200%" />

                                  </div>
                              </div>


                          </div>
                        </div>


                        <input type="submit" value="Go to Dashboard"
                                class="btn btn-success text-center middle col-sm-6">
                        <a href="/devdashboard"><button type="button"
                                                        class="btn btn-secondary text-center middle col-sm-4">Skip
                          this step</button></a>
                      </form:form>

                    </div>
                  </div>
                </div>
              </div>
              </body>
              </html>