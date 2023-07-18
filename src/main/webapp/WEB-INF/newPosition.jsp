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
<div class="container">
  <div class="row rowmap signup">
    <div class="col-sm-12">
      <div class="row topbar">

        <h2 class="col-sm-4">
          <c:out value="${org.orgName}"/>
        </h2>
        <h2 class="col-sm-4">DevsOnDeck</h2>
        <h3 class="col-sm-3 text-right">
          <a href="/orglogin" class="text-right" class="col-sm-12">Logout</a>
        </h3>

      </div>
    </div>
    <h2 class="text-center col-sm-12 skillbar">Add A Position</h2>
    <p>
      <form:errors path="position.*" />
    </p>
    <form:form action="/newPosition" method="POST"
               modelAttribute="position">

      <div class=" form-group row ">
        <form:label for="title" path="title"
                    class="col-sm-2 col-form-label">Title:</form:label>
        <div class="col-sm-10 col-md-7" >
          <form:input type="text" class="form-control appwhite" path="title"
                      name="title" placeholder="Enter Title" />
        </div>
      </div>



      <div class="form-group row">
        <label for="description" class="col-sm-2 col-form-label">Description:</label>
        <div class="col-sm-10 col-md-7">
          <form:input type="textarea" class="form-control appwhite"
                      path="description" name="description"
                      placeholder="Enter Details, task and requirements for the position" />
        </div>
      </div>
      <div class="form-group row ">
        <label for="posSkills" class="col-sm-2 col-form-label">Skills:</label>
        <div class="col-sm-7 col-md-7">

          <form:select class="col-sm-7 selectdiv appwhite" path="posSkills"
                       name="skillz" SIZE="5" multiple="true">
            <c:forEach items="${skills}" var="s">
              <div class="selectdiv">
                <form:option
                        style="background-image:(images/${s.name}.png);
							 background-position: center; background-repeat: no-repeat; background-size:90% 90%;
							  height: 70px; width: 70%; margin: 0 auto;"
                        path="posSkills" value="${s.id}" label="${s.name}"
                        class="col-sm-3 text-center" />
              </div>
            </c:forEach>

          </form:select>
        </div>

      </div>


      <button type="submit" class="btn btn-success text-center middle">Add
        Position</button>
    </form:form>
  </div>
</div>

</body>
</html>