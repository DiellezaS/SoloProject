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
  <div class="card col-md-6">

    <div class="text-center">
      <h1>Add Your Frameworks</h1>
      <div class="progress">
        <div class="progress-bar" role="progressbar" style="width: ${dev.myskills.size()*10}%;"
             aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">${dev.myskills.size()*10  }%</div>
      </div>
    </div>

    <div class=" form-group row">
      <div class="row">
        <label for="myskills" class="col-sm-5 col-md-6 col-form-label"><h4>Pick
          Your Top 5 Frameworks</h4></label>

        <div class="col-sm-5 col-md-5">
          <c:forEach items="${dev.myskills}" var="s">
            <button
                    style="background-image:url(images/${s.name}.png);
                            background-position: center; background-repeat: no-repeat; background-size: cover;
                            height: 60%; width: 20%; margin: 0 auto;"
                    path="posSkills" value="${s.id}" label="${s.name}"
                    class="col-sm-3 text-center"></button>
          </c:forEach>
        </div>
      </div>
    </div>



    <form:form action="/devtool/${dev.id}" method="post" modelAttribute="developer">

      <div class=" form-group row">
        <div class="row">


          <form:select class="col-sm-12 col-md-6 selectdiv" path="myskills"
                       name="skillz" SIZE="5" multiple="true">
            <c:forEach items="${frameworks}" var="f">
              <div class="selectdiv">
                <form:option
                        style="background-image:url(images/${f.name}.png);
							 background-position: center; background-repeat: no-repeat; background-size: cover;
							  height: 70px; width: 40%; margin: 0 auto;"
                        path="myskills" value="${f.id}" label="${f.name}"
                        class="col-sm-3 text-center" />
              </div>
            </c:forEach>

          </form:select>

        </div>
      </div>

      <a href="/devdashboard"><button  type="button" class="btn btn-secondary text-center middle col-sm-4">Skip this step</button></a>
      <button type="submit" class="btn btn-success text-center middle col-sm-6">Next Step Frameworks and DevTools</button>
    </form:form>

  </div>
</div>
<script type="text/javascript" src="js/basic.js"></script>
</body>
</html>