<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.*" %>
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
			<h3>후보자 등수</h3>
			<table border="1">
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>
				<%
					for(VoteMember l : list){
				%>
					<tr>
						<td><%= l.getM_no() %></td>
						<td><%= l.getM_name() %></td>
						<td><%= l.getCount_Mcode() %></td>
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