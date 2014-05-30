<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<%-- <%@page session="true"%> --%>
<html>
<head>
<title>Login Page</title>
<style type="text/css">
</style>
</head>
<body > 

	<h1>Spring Security Login Using Capcha</h1>

	<div id="login-box">

		<h3>Login with Username and Password</h3>
		
<form name="loginForm" action="${mainUrl}/returnPage" method="GET">
           <table>
  <tr>
      <td>Username:</td> 
      <td><input type="text" ></td> 
  </tr>
  <tr>
      <td>Password:</td>
      <td><input type="text" ></td>
 </tr>
 
           </table>
 <img src="http://localhost:8080/AgilemapleTraining/tutor/open/account/capcha"><br>
 
     Please put above code :<input type="text" name="capcha">
          <input type="submit" value="Submit">
   
           
           
</form>

</div>
</body>
</html>