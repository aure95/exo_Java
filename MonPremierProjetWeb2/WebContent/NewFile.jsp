<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%= request.getAttribute("maclef")%>	
<%= request.getAttribute("message")%>

<% 

for(int i=0;i<10;i++){
	
%>
	<%=i %> bonjour tous le monde<br>
	
	
<%
	}
%>

</body>
</html>