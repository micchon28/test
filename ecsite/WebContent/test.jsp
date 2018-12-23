<!DOCTYPE html>
<%@page import="com.internousdev.ecsite.dto.LoginDTO"%>
<html>
<head>

<title>Insert title here</title>
</head>
<body>

<%

LoginDTO loginDTO=new LoginDTO();
out.println(loginDTO.getLoginFlg());


%>


</body>
</html>