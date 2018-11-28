<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
<title>TEST</title>
</head>
<body>

<p>こんにちは</p>
<% out.println(new java.util.Date()); %>

<br>

<p>演習1</p>

<%!
	static int add(int a, int b){
	return a + b;
}
%>

<p>1+2=<%=add(1,2) %></p>
<p>3+4=<%=add(3,4) %></p>

<br>

<p>演習2</p>

<%! static int countA = 0; %>
<%	int countB = 0; //←宣言文内で書かないと ++ 反映されない？？

countA++;
countB++;
%>

<p>宣言による変数countA=<%=countA %></p>
<p>スクリプトレットによる変数countB=<%=countB %></p>

<br>

<p>演習3</p>

<p><% out.println(Math.random()); %></p>
<p><%= Math.random() %></p>

<br>

<p>演習4</p>

<p>お名前を入力してください。</p>
<form method="post" action="greeting-out.jsp">
	<input type="text" name="user">
	<input type="submit" value="確定">
</form>

<br>

<p>演習5</p>

<form method="post" action="total-out.jsp">
	<input type="text" name="price">
	円×
	<input type ="text" name="count">
	個+送料
	<input type="text" name="delivery">
	円=
	<input type="submit"  value="計算">
</form>

</body>
</html>