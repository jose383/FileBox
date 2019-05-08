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

  <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css?9963">
  <link rel="stylesheet" type="text/css" href="style.css?433">
  <link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">


  <script src="./js/jquery-3.3.1.min.js?6506"></script>
  <script src="./js/bootstrap.bundle.min.js?4643"></script>
  <script src="./js/blocs.min.js?9761"></script>
  <script src="./js/jqBootstrapValidation.js"></script>
  <script src="./js/formHandler.js?8758"></script>
  <script src="./js/lazysizes.min.js" defer></script>
  <title>Login</title>



  <!-- Analytics -->

  <!-- Analytics END -->

</head>
<body>
<!-- Main container -->
<div class="page-container">

  <!-- bloc-0 -->
  <div class="bloc l-bloc" id="bloc-0">
    <div class="container bloc-lg">
      <div class="row">
        <div class="col">
          <h1 class="mg-md text-lg-center text-md-center text-sm-center text-center">
            Welcome<br>
          </h1>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-6 offset-lg-3 offset-md-2 col-md-8">
          <form id="form" data-form-type="blocs-form" novalidate action="Login" method="POST">
            <div class="form-group">
              <label>
                Email
              </label>
              <input id="email" class="form-control" required data-validation-required-message="Enter an email" name="email" />
            </div>
            <div class="form-group">
              <label>
                Password
              </label>
              <input class="form-control" type="password" required data-validation-required-message="Enter a password" name="password" id="password" />
            </div>
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="optin" name="optin" />
              <label class="form-check-label">
                Remember me
              </label>
            </div>
            <button class="bloc-button btn btn-lg btn-block btn-azure" type="submit">
              Submit
            </button>
            <p class="text-lg-center text-md-center text-sm-center text-center btn-resize-mode p-style">
              Not a member?&nbsp;<a class="ltc-azure" href="SignUp">Sign Up</a>
            </p>
          </form>
        </div>
      </div>
    </div>
  </div>
  <!-- bloc-0 END -->

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
