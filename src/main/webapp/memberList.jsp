<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<VoteMember> list = (ArrayList<VoteMember>)request.getAttribute("LIST");
	%>
		<%@include file="header.jsp" %>
	<section>
		<div align="center">
			<h3>후보조회</h3>
			<table border="1">
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
				<%
					for(VoteMember l : list){
				%>
					<tr>
						<td><%= l.getM_no() %></td>
						<td><%= l.getM_name() %></td>
						<td><%= l.getP_code() %></td>
						<td><%= l.getP_school() %></td>
						<td><%= l.getM_jumin() %></td>
						<td><%= l.getM_city() %></td>
						<td><%= l.getTell() %></td>
					</tr>
				<%
					}
				%>
			</table>
		</div>
	</section>
	<%@include file="footer.jsp" %>
</body>
</html>