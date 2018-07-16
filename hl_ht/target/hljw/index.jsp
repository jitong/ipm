<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>这个是测试</title>
<script type="text/javascript" src="/demo/js/jquery-1.7.2.min.js"></script>
</head>
<body>
<h2>Hello World!<div id = "message"></div>
</h2>
</body>

<script type="text/javascript">

$(document).ready(function() {
	

	
	$.ajax({
			url : "/demo/user/getJsonTest.do",
			type :"post",
			success : function(result) {
				
				$("#message").html(result["message"]);
			}
		})

	});
</script>
</html>