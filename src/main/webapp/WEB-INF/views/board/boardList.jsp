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
		<table class="table table-hober">

			<!-- <img alt="" src="../images/image.jpg">

			<!-- search -->
			<form action="./${board}List" id="frm">
				<input type="hidden" name="curPage" id="curPage" value=1>

				<div class="form-group">
					<label for="sel1">Select list:</label> <select class="form-control"
						id="kind" name="kind">
						<option>TITLE</option>
						<option>WRITER</option>
						<option>CONTENTS</option>
					</select>
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search"
							name="search" id="search">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>

				</div>
			</form>

			<tr>
				<td>NUM</td>
				<td>TITLE</td>
				<td>WRITER</td>
				<td>Date</td>
				<td>HIT</td>
			</tr>

			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="${board}Select?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>

		</table>

		<input type="button" id="btn" value="write">

		<!-- page -->
		<ul class="pagination">
			<c:if test="${pager.before}">
				<li><a href="#" class="list" title="${pager.startNum-1}">이전</a></li>
			</c:if>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				<li><a href="#" class="list" title="${i}">${i}</a></li>
			</c:forEach>

			<c:if test="${pager.after}">
				<li><a href="#" class="list" title="${pager.lastNum+1}">다음</a></li>
			</c:if>

		</ul>

		<script type="text/javascript">

		$("#search").val('${param.search}');

			// 이 코드엔 헛점이 있다는데 난 모르겄네..
			var kind = '${param.kind}';
			if(kind != '') {
			$("#kind").val(kind);
				}
			
				$(".list").click(function() {
				var curPage = $(this).attr("title");
				$("#curPage").val(curPage);
				$("#frm").submit();
				
			});


				
			$("#btn").click(function() {
				location.href = "./${board}Write";
			});

			
		</script>
	</div>
</body>
</html>