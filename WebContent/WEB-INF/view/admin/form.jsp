<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Article Creation Form</title>
</head>
<body>
<p>Article Creation Form</p>
<form action="/morning-readup/admin/submit" method="GET">
	URL: <input type="url" name="url" placeholder="URL for article"/>
	<br><br>
	Paywall: <input type="radio" name="paywall"/>
	<br><br>
	Domain: <input type="text" name="domain" placeholder="*.org , *.com"/>
	<br><br>
	Notes: <input type="text" name="notes" placeholder="reader notes"/>
	<br><br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>