<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="style.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<String> m_list = (ArrayList<String>)request.getAttribute("MCODELIST");
	%>
	<%@include file="header.jsp" %>
	<section>
		<div align="center">
			<h3>투표하기</h3>
			<form action="putVote.do" method="post" onSubmit="return check(this)" name="frm">
				<table border="1">
					<tr>
						<th>주민번호</th>
						<td><input type="text" name="V_JUMIN" autofocus="autofocus"/><span class="exJumin"> 예 : 8906153154726 </span></td>
					</tr>
					<tr>
						<th>성명</th>
						<td><input type="text" name="V_NAME"/></td>
					</tr>
					<tr>
						<th>투표번호</th>
						<td>
							<select name="M_NO">
								<option>--선택해주세요--</option>
								<%
									for(String m : m_list){
								%>
									<option><%= m %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
					<tr>
						<th>투표시간</th>
						<td><input type="text" name="V_TIME"/></td>
					</tr>
					<tr>
						<th>투표장소</th>
						<td><input type="text" name="V_AREA"/></td>
					</tr>
					<tr>
						<th>유권자 확인</th>
						<td>
							<input type="radio" name="V_CONFIRM" value="Y" id="YES"/><label for="YES">확인</label>
							<input type="radio" name="V_CONFIRM" value="N" id="NO"/><label for="NO">미확인</label>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="투표하기"/>
							<input type="reset" value="다시하기" onClick="resetInput()"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<%@include file="footer.jsp" %>
	<script type="text/javascript">
		function check(f){
			if(f.V_JUMIN.value == ''){
				alert("주민번호가 입력되지 않았습니다!");
				return false;
			}
			if(f.V_NAME.value == ''){
				alert("성명이 입력되지 않았습니다!");
				return false;
			}
			if(f.M_NO.selectedIndex < 1){
				alert("후보 번호가 선택되지 않았습니다!");
				return false;
			}
			if(f.V_TIME.value == ''){
				alert("투표 시간이 입력되지 않았습니다!");
				return false;
			}
			if(f.V_AREA.value == ''){
				alert("투표 장소가 입력되지 않았습니다!");
				return false;
			}
			if(f.V_CONFIRM.value == ''){
				alert("유권자확인이 선택되지 않았습니다!");
				return false;
			}
			if(! confirm("정말로 입력하시겠습니까?")){
				return false;
			}else {
				return true;
			}
		}
		function resetInput(){
			alert("정보를 지우고 처음부터 다시 입력합니다!");
			frm.V_JUMIN.focus(); 
		}
	</script>
</body>
</html>