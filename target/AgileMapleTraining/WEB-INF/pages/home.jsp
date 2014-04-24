<html>
<jsp:include page="header.jsp"/>
<body>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p>
<a href="${mainUrl}/myaccount?id=20">My Account</a>
</p>
<a href="${mainUrl}/myacc?id=20">My Account</a>




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