<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
  <link rel="shortcut icon" type="image/png" href="favicon.png">

  <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css?8345">
  <link rel="stylesheet" type="text/css" href="style.css?5777">
  <link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">


  <script src="./js/jquery-3.3.1.min.js?1489"></script>
  <script src="./js/bootstrap.bundle.min.js?4886"></script>
  <script src="./js/blocs.min.js?3569"></script>
  <script src="./js/jqBootstrapValidation.js"></script>
  <script src="./js/formHandler.js?9442"></script>
  <script src="./js/lazysizes.min.js" defer></script>
  <title>Sign Up</title>



  <!-- Analytics -->

  <!-- Analytics END -->

</head>
<body>
<!-- Main container -->
<div class="page-container">

  <!-- bloc-1 -->
  <div class="bloc l-bloc" id="bloc-1">
    <div class="container bloc-lg">
      <div class="row">
        <div class="col">
          <h1 class="mg-md text-lg-center text-md-center text-sm-center text-center ">
            Sign Up<br>
          </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-6 offset-lg-3 offset-md-2 col-md-8">
          <form id="form_44167" data-form-type="blocs-form" novalidate action="SignUp" method="POST">
            <div class="form-group">
              <label>
                Name
              </label>
              <input id="name_44167" class="form-control" required name="name" data-validation-required-message="Please enter your name" />
            </div>
            <div class="form-group">
              <label>
                Email<br>
              </label>
              <input id="email_44167" class="form-control" required name="user" data-validation-required-message="Please enter an email" />
            </div>
            <div class="form-group">
              <label>
                Password
              </label>
              <input class="form-control" type="password" name="password" id="input_2307" required data-validation-required-message="Please enter a password" />
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="optin_44167" name="optin" checked="checked" />
              <label class="form-check-label">
                We can send you product updates and offers via email. It is possible to opt-out at any time.
              </label>
            </div>
            <button class="bloc-button btn btn-lg btn-block btn-azure" type="submit">
              Submit
            </button>
            <p class="btn-resize-mode p-2-style text-lg-center text-md-center text-sm-center text-center">
              Already a member?&nbsp;<a class="ltc-azure" href="Login">Sign in</a>
            </p>
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- bloc-1 END -->

  <!-- ScrollToTop Button -->
  <a class="bloc-button btn btn-d scrollToTop" onclick="scrollToTarget('1',this)"><span class="fa fa-chevron-up"></span></a>
  <!-- ScrollToTop Button END-->


</div>
<!-- Main container END -->




<!-- Preloader -->
<div id="page-loading-blocs-notifaction" class="page-preloader"></div>
<!-- Preloader END -->

</body>
</html>
