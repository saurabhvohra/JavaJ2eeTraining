<html>
<jsp:include page="header.jsp"/>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<style type="text/css">
body{
	background-color: #333;
	
}
nav{
	padding: 20px;
}
.nav li{
margin: 0px 5px 10px 0;
display: inline-block;/* to make it verticcle use "block"*/
}
.nav a{
	padding: 10px 10px;
	text-decoration: :none;
	color: #999;
}
.nav .current a{
	background: #999;
	color: #fff;
	border-radius: 5px;
	-moz-box-shadow: 5px 1px 1px #666; /*for older browsers*/
	-webkit-box-shadow: 5px 1px 1px #666; /*for older browsers*/
	box-shadow: 5px 1px 1px #666;
}
</style>
</head>
<body>
<nav class="nav ">
<ul>
<li class="current"><a href="${mainUrl}/myaccount?id=20">My Account</a></li>
<li><a href="${mainUrl}/myacc?id=20">My Account</a></li>
<li><a href="${mainUrl}/myacc?id=20">My Account</a></li>
<li><a href="${mainUrl}/contactform">Create new Contact</a></li>
<li><a href="${mainUrl}/listContacts" target="_blank">Contacts</a></li>
<li><a href="${mainUrl}/userdata?page=0" target="_blank">Users From DataBase</a></li>
<li><a href="${mainUrl}/userlogin">Login(Database)</a></li>
</ul>
</nav>
<%-- <table>
<tr>
<c:forEach items="${userDetails}" var="item">
<td> 
<c:out value="${item}"/>
</td>

</c:forEach>
</tr>
</table> --%>











<%-- <table border="1" style="width:300px">
<tr>
<%
List<String> userDetailsList = (ArrayList)request.getAttribute("userDetails");
for(int i=0; i <userDetailsList.size(); i++){
	
	%>
	 <td>
	<%out.println(userDetailsList.get(i)); %>
	</td>
<%}
%>


 

  </tr>


</table>
 --%>
</body>
</html>