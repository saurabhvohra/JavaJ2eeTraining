<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  
<title> Locations </title>
</head>
<body>
<jsp:include page="header.jsp"/>
<H1>Register Today and Get Free Oil Change</H1>	
<form name="input" action="welcome/register" method="post">
First Name      :<input type="text" name="firstName"><br>
Last Name       :<input type="text" name="lastName"><br>
<!-- Gender :<input type="radio" name="sex" value="male">Male 
       :<input type="radio" name="sex" value="female">Female<br> -->
Address         :<input type="text" name="address"><br>
Province        :<input type="text" name="province"><br>
Country         :<input type="text" name="country"><br>
Postal Code     :<input type="text" name="postalCode"><br>
Phone No.       :<input type="text" name="phoneNumber"><br>
Email Address   :<input type="text" name="email">
 <input type="submit" value="Submit">
</form>
</body>
</html>