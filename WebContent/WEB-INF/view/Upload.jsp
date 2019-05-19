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

	<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css?5219">
	<link rel="stylesheet" type="text/css" href="style.css?3468">
	<link rel="stylesheet" type="text/css" href="./css/font-awesome.min.css">


	<script src="./js/jquery-3.3.1.min.js?8647"></script>
	<script src="./js/bootstrap.bundle.min.js?7430"></script>
	<script src="./js/blocs.min.js?2783"></script>
	<script src="./js/jqBootstrapValidation.js"></script>
	<script src="./js/formHandler.js?4694"></script>
	<script src="./js/lazysizes.min.js" defer></script>
	<title>Upload File</title>



	<!-- Analytics -->

	<!-- Analytics END -->

</head>
<body>
<!-- Main container -->
<div class="page-container">

	<!-- bloc-4 -->
	<div class="bloc l-bloc " id="bloc-4">
		<div class="container bloc-lg">
			<div class="row">
				<div class="col">
					<h1 class="mg-md text-center">
						Upload File
					</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 offset-lg-3 offset-md-2 col-md-8">
					<form action="Upload" id="form" data-form-type="blocs-form" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<p>
								You can upload a file of any size and type.
							</p>
							<input id="file" class="form-control" required type="file" name="file1"/>
						</div>
						<div class="divider-h">
							<span class="divider"></span>
						</div>
						<button class="bloc-button btn btn-lg btn-block btn-rd btn-azure" type="submit" name="upload">
							Upload
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- bloc-4 END -->

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
