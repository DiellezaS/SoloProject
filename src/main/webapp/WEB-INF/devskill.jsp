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
  <div class="row ">

    <div class="card col-md-6">
      <div class="col-sm-12">
        <div class="row topbar col-sm-12">
          <h2 class="col-sm-4">
            <c:out value="${dev.fname}">
              <c:out value="${dev.lname}"></c:out>
            </c:out>
          </h2>
          <h2 class="col-sm-4">DevsOnDeck</h2>
          <h3 class="col-sm-4 text-right">
            <a href="/devlogin" class="text-right">Logout</a>
          </h3>
        </div>
      </div>
      <div class="text-center skillbar col-sm-12">
        <h1>Add Your Skills</h1>
        <div class="progress ">
          <div class="progress-bar" role="progressbar"
               style="width: ${dev.myskills.size()*10}%; " aria-valuenow="50"
               aria-valuemin="0" aria-valuemax="100">${dev.myskills.size()*10}%</div>
        </div>
      </div>
      <form:errors path="developer.*" />
      <div class="card-body skillbar"></div>
      <div class=" form-group row rowmap signup">
        <div class="row">

          <label for="myskills" class="col-sm-5 col-md-5 col-form-label"><h4>Pick
            Your Top 5 Languages</h4></label>

          <div class="col-sm-7 col-md-7 skillblock">
            <c:forEach items="${dev.myskills}" var="s">
              <button
                      style="background-image:url(images${s.name}.png);
                              background-position: center; background-repeat: no-repeat; background-size: cover;
                              height: 100%; width: 23%; margin: 0 auto;"
                      path="posSkills" value="${s.id}" label="${s.name}"
                      class="col-sm-3 text-center"></button>
            </c:forEach>
          </div>
        </div>



        <form:form action="/devtools/${dev.id}" method="Post"
                   modelAttribute="developer">

          <div class=" form-group row">
            <div class="row">
              <form:hidden path="fname" value="${dev.fname}" />
              <form:hidden path="lname" value="${dev.lname}" />
              <form:hidden path="address" value="${dev.address}" />
              <form:hidden path="state" value="${dev.state}" />
              <form:hidden path="city" value="${dev.city}" />
              <form:hidden path="passConfirm" value="${dev.password}" />
              <form:hidden path="password" value="${dev.password}" />
              <form:hidden path="email" value="${dev.email}" />

              <form:select class="col-sm-12 col-md-4 selectdiv"
                           path="myskills" name="skillz" SIZE="5" multiple="true">

                <c:forEach items="${skills}" var="s">

                  <form:option
                          style="background-image:url(images/${s.name}.png);
							 background-position: right center; background-repeat: no-repeat; background-size: 40%; width: 100%; height: 70px;
							  "
                          path="myskills" value="${s.id}" label="${s.name}"
                          class="col-sm-4 col-sm-3 text-right" />
                </c:forEach>

              </form:select>

              <div class="col-sm-12 col-md-6">
                <div class="form-group row">
                  <label for="biography" class="col-sm-12 col-form-label">Short
                    Biography:</label>

                  <form:textarea type="textarea" class="form-control"
                                 path="biography" name="biography"
                                 placeholder="${dev.biography}" style="height: 300px;" />

                </div>
              </div>
            </div>
          </div>
          <a href="/devdashboard"><button type="button"
                                          class="btn btn-secondary text-center middle col-sm-4">Skip
            this step</button></a>
          <button type="submit"
                  class="btn btn-success text-center middle col-sm-6">Go to Dashboard</button>
        </form:form>

      </div>
    </div>
  </div>
</div>
<script type="text/javascript" src="js/basic.js"></script>
</body>
</html>