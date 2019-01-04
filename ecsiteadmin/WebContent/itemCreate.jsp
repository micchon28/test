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
	<title>商品新規登録画面</title>

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

		#text-center{
			display:inline-block;
			text-align:center;
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
		<p>商品新規登録</p>
	</div>

	<div>
		<s:if test="newItemCreateErrorMessage != '' "> <!-- 入力エラーがありこのページに戻った場合にエラーメッセージを表示する。 -->
			<s:property value="newItemCreateErrorMessage" escape="false" /> <!-- escape="false"は、newItemCreateErrorMessage内の文字列にエスケープシーケンスが含まれていた場合、エスケープせずにそのまま表示するという意味（<>タグなどもそのまま読み込む） -->
		</s:if>

		<table>
			<s:form action="ItemCreateConfirmAction">
			<tr>
				<td>
					<label>新規商品名:</label>
				</td>
				<td>
					<input type="text" name="newItemName" />
				</td>
			</tr>
			<tr>
				<td>
					<label>新規商品単価:</label>
				</td>
				<td>
					<input type="number" name="newItemPrice" />
				</td>
			</tr>
			<tr>
				<td>
					<label>新規商品在庫数:</label>
				</td>
				<td>
					<input type="number" name="newItemStock" />
				<td>
					<s:submit value="登録" />

			</s:form>

		</table>
	</div>


</div>

<div id="footer">
	<div id="pr">
	</div>
</div>

</body>
</html>