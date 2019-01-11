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
	<title>商品リスト</title>

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
			display:block;
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
		<p>商品リスト</p>
	</div>


	<div>

		<table border="1">
			<tr>
				<th>ID</th>
				<th>商品名</th>
				<th>単価</th>
				<th>在庫数</th>
				<th>登録日時</th>
				<th>更新日時</th>
			</tr>


			<s:iterator value="#session.iiDTOListJSP">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="itemName" /></td>
				<td><s:property value="itemPrice" /></td>
				<td><s:property value="itemStock" /></td>
				<td><s:property value="insertDate" /></td>
				<td><s:property value="updateDate" /></td>
			</tr>
			</s:iterator>


		</table>
	</div>

	<div id="button-position">
		<s:action name="ItemListDeleteConfirmAction">
			<s:submit value="削除" id="delete-button"/>
		</s:action>
	</div>


</div>

<div id="footer">
	<div id="pr">
	</div>
</div>

</body>
</html>