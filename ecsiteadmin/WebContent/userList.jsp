<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<title>ユーザーリスト</title>

	<style type="text/css">
		body{
			margin:0;
			padding:0;
			line-height:1.6;
			letter-spacing:1px;
			font-family:Verdana, Helcetica, sans-serif;
			font-size:12px;
			color:#333;
			background:#fff;
		}

		table{
			text-align:center;
			margin:0 auto;
		}


		/* ecsite LAYOUT */
		#top{
			width:780px;
			margin:30px auto;
			border:1px solid #333;
		}

		#header{
			width:100%;
			height:80px;
			background-color:black;
		}

		#main{
			width:100%;
			height:500px;
			text-align:center;
		}

		#footer{
			width:100%;
			height:80px;
			background-color:black;
			clear:both;
		}

		#box{
			display:inline-block;
			width:100px;
			text-align:center;
			margin:0 auto;
			border:solid 1px black;
		}

		#button-position{
			margin:10px;
		}

		#delete-button{
			display:block;
			margin:0 auto;

		}

	</style>
</head>
<body>

<div id="header">
	<div id="pr">
	</div>
</div>

<div id="main">
	<div id="top">
		<p>ユーザーリスト</p>
	</div>


	<div>

		<table border="1">
			<tr>
				<th>登録番号</th>
				<th>ログインID</th>
				<th>ログインPASS</th>
				<th>ユーザー名</th>
				<th>管理者フラグ</th>
				<th>登録日時</th>
				<th>更新日時</th>
			</tr>


			<s:iterator value="#session.uiDTOListJSP">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="loginId" /></td>
				<td><s:property value="loginPass" /></td>
				<td><s:property value="userName" /></td>
				<td><s:property value="adminFlg" /></td>
				<td><s:property value="insertDate" /></td>
				<td><s:property value="updateDate" /></td>
			</tr>
			</s:iterator>


		</table>


	</div>

	<div id="button-position">
		<s:form action="UserListGeneralDeleteConfirmAction">
			<s:submit value="削除（一般ユーザーのみ）" id="delete-button" />
		</s:form>
		<s:form action="UserListDeleteConfirmAction">
			<s:submit value="削除（全件）" id="delete-button" />
		</s:form>
	</div>


	<a href="<s:url action='AdminAction' />">管理者TOPへ</a>


</div>

<div id="footer">
	<div id="pr">
	</div>
</div>

</body>
</html>