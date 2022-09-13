<%@page import="selfstudy.cafe.guestbook.vo.GuestbookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	function goPage(type,frm){
		if(type==0){
			frm.action = ".do";
		} else if(type==1){
			frm.action = ".do";
		} else if(type==2){
			frm.action = ".do";
		} else if(type==3){
			frm.action = ".do";
		}
		frm.submit();
	}
</script>
<title>Main</title>
</head>
<body>
<h1>MainPage</h1>
<form action="#" method="get" name="frm">
<table width="100%" height="30px" onclick="">
	<tr>
		<td colspan="3">
			<input type="text" placeholder="searching">
			<input type="button" value="search" onclick="">
		</td>
		<td width="20px">
			<input type="button" value="post" onclick="post.do">
		</td>
	</tr>
</table>

<table border="1" width="100%" height="30px" onclick="">
	<tr>
		<td colspan="2">
			title
		</td>
		<td width="30%">
			read count
		</td>
		<td>
			date
		</td>
	</tr>
</table>
<%
	ArrayList<GuestbookVO> list = (ArrayList<GuestbookVO>)session.getAttribute("list");
	for(GuestbookVO guest : list){
%>
<table border="1" width="100%" height="30px" onclick="">
	<tr>
		<td colspan="2">
			<a href="index.do?seq=<%= guest.getSeq() %>"><%= guest.getTitle() /* 테두리 삭제 */ %></a>
		</td>
		<td rowspan="2">
			<%= guest.getReadCount() /* 위아래 테두리 삭제 옆 테두리 길이 조절 가운데정렬 */ %>
		</td>
		<td rowspan="2" width="30%">
			<%= guest.getRegDate()  /* 테두리 삭제 가운데정렬 */ %>
		</td>
	</tr>
	<tr>
		<td width="60%">
			<a href="index.do?seq=<%= guest.getSeq() %>"><%= guest.getUserId() %></a>
		</td>
		<td hidden="hidden">
			<%= guest.getSeq() %>
		</td>
	</tr>
</table>
<%
	}
%>
</form>
</body>
</html>