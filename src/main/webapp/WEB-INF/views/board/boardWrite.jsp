<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BootStrap.jsp"></c:import>

<
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script type="text/javascript">
$(function() {
     $('#summernote').summernote({
       height: 300,
       lang: 'ko-KR' // 언어 세팅
     });
   });
</script>




</head>
<body>
	<c:import url="../template/header.jsp"></c:import>


	<div class="container">
		<h3>boardWrite</h3>
		<p>This example adds a dropdown menu for the "Page 1" button in
			the navigation bar.</p>

		<form action="./${board}Write" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="title">Title : </label> <input type="title"
					class="form-control" id="title" placeholder="Enter Title"
					name="title">
			</div>

			<div class="form-group">
				<label for="writer">Writer : </label> <input type="writer"
					class="form-control" id="writer" placeholder="Enter Writer"
					name="writer">
			</div>


			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="summernote" rows="5" id="summernote"
					name="contents"></textarea>
			</div>
			
			<div class="form-group">
				<label for="files">file : </label>
				<input type="file" class="form-control" name="files">
				<input type="file" class="form-control" name="files">
			</div>

			<button type="submit" class="btn btn-default">WRITE</button>
		</form>
	</div>

</body>
</html>