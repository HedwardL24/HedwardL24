<%@page import="LearnSE.model.processtypedata"%>
<%@page import="java.util.ArrayList"%>
<%@page import="LearnSE.dao.daoService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	daoService pageContent = new daoService();
	ArrayList getpageContent = pageContent.getprocesstypedata();
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Software Engineering</title>
	<link rel ="stylesheet" type="text/css" href="stylesheet/frt_page.css">
	<link rel ="stylesheet" type="text/css" href="stylesheet/text_entry_area.css">
	<link rel ="stylesheet" type="text/css" href="stylesheet/sitemenu.css">
	<link rel ="stylesheet" type="text/css" href="stylesheet/home.css">
</head>
<body>	
	<h1>Department of Computer Science and Mathematics</h1>
	<h2>Software Engineering: Models, Methods, Process and Techniques with the Emphasis on cybersecurity</h2><hr><br><br>
	<%@ include file="/headmenu.jsp"%>
	<table class="tblmainpage">
	<%for(int j=0; j<1; j++){ %>
		<tr>				
		<%for(int i = 0; i<getpageContent.size(); i++){ %>
		<%processtypedata item = (processtypedata)getpageContent.get(i); %>
			<%if(i< 2){ %>				
				<td>
					<p id="txttitle"><%=item.getTitletypetext()%></p>
					<br>
					<p><%=item.getDetailtypetext()%>
				</td>
			<%} %>
				<!-- second row -->
			 <%if(i>=2){ %>
				<td><p id="txttitle"><%=item.getTitletypetext()%></p>
						<br>
						<p><%=item.getDetailtypetext()%></p>
					</td>
			<%} %>	
		 <%} %>
		 </tr>
		 <%} %>
	</table>
</body>
</html>