<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"/>
<html>
<head>
</head>
<body>
<table>
<tr>
<td><c:out value="FIRST NAME"></c:out></td> <td><c:out value="LAST NAME"></c:out></td>
<td><c:out value="EMAIL"></c:out></td> <td><c:out value="COUNTRY"></c:out></td>
<td><c:out value="POSTAL-CODE"></c:out></td> <td><c:out value="BIRTHDAY"></c:out></td>
<td><c:out value="GENDER"></c:out></td>
</tr>
<tr>
<td><c:out value="${user.firstname}"></c:out></td>
<td><c:out value="${user.lastname}"></c:out></td>
<td><c:out value="${user.email}"></c:out></td>
<td><c:out value="${user.country}"></c:out></td>
<td><c:out value="${user.postalcode}"></c:out></td>
<td><c:out value="${user.birthday}"></c:out></td>
<td><c:out value="${user.gender}"></c:out></td>
</table>
</body>
</html>