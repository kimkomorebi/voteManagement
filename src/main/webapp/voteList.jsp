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
		ArrayList<String> list2 = (ArrayList<String>)request.getAttribute("LIST2");
		ArrayList<String> man = (ArrayList<String>)request.getAttribute("MANLIST");
	%>
	<%@include file="header.jsp" %>
	<section>
		<div align="center">
			<h3>투표 검수 리스트</h3>
			<table border="1">
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				<%
					for(VoteMember l : list){
				%>
					<tr>
						<td><%= l.getV_name() %></td>
						<td>
							<%= l.getYear() %>
							<%= l.getMonth() %>
							<%= l.getDay() %>
						</td>
						<td><%= l.getV_jumin() %></td>
						<td><%= l.getGender() %></td>
						<td><%= l.getM_no() %></td>
						<td><%= l.getV_time() %></td>
						<td><%= l.getV_confirm() %></td>
					</tr>
				<%	
					}
				%>
			<%
				for(String j : list2){
			%>
				<tr>
					<td><%= j %></td>
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