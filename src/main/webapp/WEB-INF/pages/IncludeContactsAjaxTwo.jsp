
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="header.jsp"/>

<body>
<table border="2">
<tr> <td>Contacts</td><td>Send Email</td> </tr>

<c:forEach items="${contactList}" var="item">
<tr>
<td> 
<a href="${mainUrl}/contact?firstname=${item.firstname}&lastname=${item.lastname}">
<c:out value="${item.firstname}"/> <c:out value="${item.lastname}"/></a>
</td>
<td> 
<c:out value="${item.email}"/>
</td>
</tr>
</c:forEach>
</table>
</body>
