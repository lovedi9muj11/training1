<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org" xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorator="layout">
<head>
<title>Insert title here</title>
</head>
<body>

	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Add Student</h3>
		</div>
		<div class="panel-body">
			<form th:object="${employee}" th:action="@{/employee/save}" action="#" method="post">
				<input type="text" th:field="*{studentID}" class="form-control"/>
				<div style="clear:both; display:block;height:10px;"></div>
				<input type="text" th:field="*{firstName}" class="form-control"/>
				<div style="clear:both; display:block;height:10px;"></div>
				<input type="text" th:field="*{lastName}" class="form-control"/>
				<div style="clear:both; display:block;height:10px;"></div>
				<input type="submit" class="btn btn-danger pull-right" value="Save">
			</form>
		</div>
	</div>

</body>
</html>