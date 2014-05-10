<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="header.jsp" />
<html>
<head>
<title>Portfolio</title>

</head>
<body>


	<form:form action="submitForm" commandName="portfolio" method="post">

        Name : <form:input path="name" />
		<br />

        Nick Name : <form:input path="nickName" />
		<br />

        Age : <form:input path="age" />
		<br />

        Mobile : <form:input path="mobNum" />
		<br />

		<input type="submit" />

	</form:form>

</body>
</html>