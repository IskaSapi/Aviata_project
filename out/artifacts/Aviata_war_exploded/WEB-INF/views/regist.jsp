<%--
  Created by IntelliJ IDEA.
  User: iskandersapiyev
  Date: 2019-03-04
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/sign-in/">

<!-- Bootstrap core CSS -->
<link href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css" rel="stylesheet">

<form class="form-signin" action="/register" method="post">
    <%--<img class="mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">--%>
    <h1 class="h3 mb-3 font-weight-normal" style="alignment: center">Please sign up</h1>
    <label for="inputEmail" class="sr-only">Email address</label>
    <input type="email" id="inputEmail" class="form-control" name="login" placeholder="Login" required autofocus>
        <br>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <label for="inputEmail" class="sr-only">Full Name</label>
    <input type="text" id="inputEmail" class="form-control" name="full_name" placeholder="Full Name" required autofocus>

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <br>
    <button class="btn btn-lg btn-primary btn-block" style="background-color: forestgreen;border-color: forestgreen"
            type="submit">Sign in
    </button>
    <br>
    <center><a href="/">Back</a>
        <p class="mt-5 mb-3 text-muted">&copy; 2017-2019</p>
    </center>
</form>

</body>
</html>
