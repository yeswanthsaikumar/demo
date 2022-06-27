<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nagarro.javaassignment4.model.Tshirt"%>
<%@page import="com.nagarro.javaassignment4.service.HomeService"%>
<%@page import="java.util.List"%>

<%
List<Tshirt> tshirtList = (List<Tshirt>) session.getAttribute("tshirts");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; ">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Hind+Siliguri:wght@600&display=swap"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Roboto&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="/homestyle.css" />
<title>Home page</title>
</head>
<body>
	<nav class="navbar navbar-light">
		<div class="container-fluid">
			<span class="navbar-text">Query for Tshirts </span> <span
				id="user-show"> Hello <%=session.getAttribute("username")%></span>
			<form class="d-flex" action="logout" method="post">
				<button class="logout-btn btn btn-primary" type="submit">
					logout</button>
			</form>
		</div>
	</nav>
	<div class="row mb-4 input-details">
		<span id="input-detail-text"> Please enter preferred Tshirt
			Model details </span>

		<form action="" method="post"
			enctype="multipart/form-data">
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">Colour</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						name="colour" placeholder="color" />
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">Gender</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						name="gender" placeholder="gender" />
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">Size</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						name="size" placeholder="size" />
				</div>
			</div>
			<div class="row mb-3">
				<label class="col-sm-2 col-form-label">Order</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						name="outputpref" placeholder="1 or 2 or 3" />
				</div>
			</div>

			<div class="d-grid gap-2 d-md-block">
				<button class="browse-btn btn btn-primary" type="submit">
					Enter</button>
			</div>
		</form>
	</div>
	<div class="container-fluid">
		<table class="table table-striped">

			<thead>
				<th class="table-heading" style="text-align: center;">SNo</th>
				<th class="table-heading" style="text-align: center;">Unique Id</th>
				<th class="table-heading" style="text-align: center;">Color</th>
				<th class="table-heading" style="text-align: center;">Size</th>
				<th class="table-heading" style="text-align: center;">Recommended Gender</th>
				<th class="table-heading" style="text-align: center;">Price</th>
				<th class="table-heading" style="text-align: center;">Rating</th>
				<th class="table-heading" style="text-align: center;">Availability</th>
			</thead>

			<tbody>
				<%
				int i = 0, totalSize = 0;
				for (Tshirt iter : tshirtList) {
					i++;
				%>
				<tr>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=i%></td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getunum()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getColour()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getSize()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getGenderRecommendation()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getPrice()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getRating()%>
					</td>
					<td class="table-data"
						style="text-align: center; vertical-align: middle;"><%=iter.getAvailability()%>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>