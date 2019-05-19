<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, viewport-fit=cover">
  <link rel="shortcut icon" type="image/png" href="favicon.png">

  <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css?5947">
  <link rel="stylesheet" type="text/css" href="style.css?5032">
  <link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">


  <script src="./js/jquery-3.3.1.min.js?9090"></script>
  <script src="./js/bootstrap.bundle.min.js?4949"></script>
  <script src="./js/blocs.min.js?842"></script>
  <script src="./js/lazysizes.min.js" defer></script>
  <title>Home</title>



  <!-- Analytics -->

  <!-- Analytics END -->

</head>
<body>
<!-- Main container -->
<div class="page-container">

  <!-- bloc-0 -->
  <div class="bloc l-bloc" id="bloc-0">
    <div class="container bloc-sm">
      <div class="row">
        <div class="col">
          <nav class="navbar navbar-light row navbar-expand-md" role="navigation">
            <a class="navbar-brand" href="Home">CloudDrive</a>
            <button id="nav-toggle" type="button" class="ml-auto ui-navbar-toggler navbar-toggler border-0 p-0" data-toggle="collapse" data-target=".navbar-1" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse navbar-1">
              <ul class="site-navigation nav navbar-nav ml-auto ">
                <li class="nav-item">
                  <a href="Upload" class="nav-link a-btn">Upload File</a>
                </li>
                <li class="nav-item">
                  <a href="Logout" class="nav-link a-btn ltc-ou-crimson-red">Logout</a>
                </li>
              </ul>
            </div>
          </nav>
        </div>
      </div>
    </div>
  </div>
  <!-- bloc-0 END -->

  <!-- bloc-1 -->
  <div class="bloc l-bloc " id="bloc-1">
    <div class="container bloc-lg">
      <div class="row">
        <div class="col">
          <h1 class="mg-md text-center">
            Completed
          </h1>
          <h3 class="mg-md float-none text-center">
            ${count} file(s) uploaded to ${fileDir}.
          </h3>
          <div class="text-center">
            <a href="Home" class="btn btn-lg btn-wire btn-rd wire-btn-azure">Return to Files<br></a>
          </div>
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