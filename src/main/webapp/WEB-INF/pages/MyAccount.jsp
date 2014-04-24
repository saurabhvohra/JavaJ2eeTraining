<html>
<jsp:include page="header.jsp"/>
<body>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<table>
<tr>
<td> My Account</td>
<tr>
<c:forEach items="${myAccountDetails}" var="item">

<tr>
<td>
${item.key} 
<c:out value="${item}"/>  in JSP-HTML
</td>
<td>
${item.value}
</td>
<tr>
</c:forEach>
<c:if test="${not empty userDetailObj}">
<tr><td>First Name:</td><td><c:out value="${userDetailObj.firstName}" /> </td></tr>
<tr><td>Last Name:</td><td><c:out value="${userDetailObj.lastName}" /> </td></tr>
<tr><td>Address:</td><td><c:out value="${userDetailObj.address}" /> </td></tr>
<tr><td>Province:</td><td><c:out value="${userDetailObj.province}" /> </td></tr>
<tr><td>Country:</td><td><c:out value="${userDetailObj.country}" /> </td></tr>
<tr><td>Postal Code:</td><td><c:out value="${userDetailObj.postalCode}" /> </td></tr>
<tr><td>Email:</td><td><c:out value="${userDetailObj.email}" /> </td></tr>
 </c:if>

</table> 
</body>
























