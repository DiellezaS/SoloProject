<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
      <h2 class="col-sm-8">DevsOnDeck</h2>
      <div class="col-sm-3">
        <a href="/devlogin" class="text-right">Dev Login </a> <a href="/orglogin"> Org
        Login</a>
      </div>
    </div>

    <div class="card col-md-8 rowmap signup">
      <h1 class="text-center">Developer Sign Up</h1>
      <div class="card-body">
        <p>
          <form:errors path="developer.*" />
        </p>
        <form:form action="/newdev" method="POST"
                   modelAttribute="developer">
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
            <option value="DE">DE</option>
            <option value="FL">FL</option>
            <option value="GA">GA</option>
            <option value="HI">HI</option>
            <option value="IA">IA</option>
            <option value="ID">ID</option>
            <option value="IL">IL</option>
            <option value="IN">IN</option>
            <option value="KS">KS</option>
            <option value="KY">KY</option>
            <option value="LA">LA</option>
            <option value="MA">MA</option>
            <option value="MD">MD</option>
            <option value="ME">ME</option>
            <option value="MI">MI</option>
            <option value="MN">MN</option>
            <option value="MO">MO</option>
            <option value="MS">MS</option>
            <option value="MT">MT</option>
            <option value="NC">NC</option>
            <option value="ND">ND</option>
            <option value="NE">NE</option>
            <option value="NH">NH</option>
            <option value="NJ">NJ</option>
            <option value="NM">NM</option>
            <option value="NV">NV</option>
            <option value="NY">NY</option>
            <option value="OH">OH</option>
            <option value="OK">OK</option>
            <option value="OR">OR</option>
            <option value="PA">PA</option>
            <option value="RI">RI</option>
            <option value="SC">SC</option>
            <option value="SD">SD</option>
            <option value="TN">TN</option>
            <option value="TX">TX</option>
            <option value="UT">UT</option>
            <option value="VA">VA</option>
            <option value="VT">VT</option>
            <option value="WA">WA</option>
            <option value="WI">WI</option>
            <option value="WV">WV</option>
            <option value="WY">WY</option>
          </form:select>

          <form:label path="password" class="col-sm-2">Password:</form:label>
          <form:input path="password" class=" col-sm-9" />
          <form:label path="passConfirm" class="col-sm-2">Confirm:</form:label>
          <form:input path="passConfirm" class="col-sm-9" />


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