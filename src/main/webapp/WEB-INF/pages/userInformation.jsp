<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="header.jsp"/>
<html>
<head>
<title> Users From DataBase </title>
<style type="text/css">
body{
	background-color: #333;
	color:#E0D0FB;
}
li{
margin: 5px 5px 20x 5px;
display: inline-block;/* to make it verticcle use "block"*/
}
</style>
</head>
<body>
<table border="1" style="width:300px" >
<tr> <td>User ID</td><td>First Name</td><td>Last Name</td><td>Phone Number</td> </tr>
<c:forEach items="${userInform.userInformation}" var="item">
<tr><td> <c:out value="${item.id}"/></td><td> <c:out value="${item.firstname}"/></td>
<td> <c:out value="${item.lastname}"/></td><td> <c:out value="${item.number}"/></td>
</tr>
</c:forEach>
</table>
<ul><c:set var="listsize" scope="request" value="${fn:length(userInform.userInformation)*(nextPageid)}"/>
<c:out value="${listsize}"/>
<li><a href="${mainUrl}/userdata?page=${nextPageid-3}">Back</a></li>
<c:if test="${userInform.totalUsers/listsize!=1}" >
<li><a href="${mainUrl}/userdata?page=${nextPageid-1}">Next</a></li>
</c:if>
</ul>
<c:out value=" Page No. ${nextPageid-1}"></c:out>
<c:out value=" Page No. ${userInform.totalUsers}"></c:out>
</body>
</html>