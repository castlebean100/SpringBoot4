<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/BootStrap.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="container">
	<h3>Title : ${vo.title}</h3>
	<h3>Contents : ${vo.contents}</h3>
	<h3>Files</h3>

	<c:forEach items="${vo.files}" var="file">
	<p><a href="noticeFileDown?fnum=${file.fnum}">${file.oriName}</a></p>
	
	</c:forEach>

</div>
</body>
</html>