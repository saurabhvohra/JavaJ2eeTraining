<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="header.jsp"/>
<html>
<head>
<title> Users From DataBase </title>

<script>
$(document).ready(function(){
  $("button").click(function(){
    $("p").hide();
  });
});
</script>
</head>
<body>
<h2>This is a heading</h2>
<p>This is a paragraph.</p>
<p>This is another paragraph.</p>
<button>Click me</button>
<c:if test="${not empty usernameerror}">
<div style="color: red"><c:out value="${errors.usernameerror}"></c:out></div>
</c:if>
<form class="cmxform" id="commentForm" method="get" action="">
  <fieldset>
    <legend>Please provide your name, email address (won't be published) and a comment</legend>
    <p>
      <label for="cname">Name (required, at least 2 characters)</label>
      <input id="cname" name="name" minlength="2" type="text" required/>
    </p>
    <p>
      <label for="cemail">E-Mail (required)</label>
      <input id="cemail" type="email" name="email" required/>
    </p>
    <p>
      <label for="curl">URL (optional)</label>
      <input id="curl" type="url" name="url"/>
    </p>
    <p>
      <label for="ccomment">Your comment (required)</label>
      <textarea id="ccomment" name="comment" required></textarea>
    </p>
    <p>
      <input class="submit" type="submit" value="Submit"/>
    </p>
  </fieldset>
</form>


<form id ="loginform" action="${mainUrl}/userInformation" method="POST">
	<fieldset>
	<p>
      <label for="cusername">User name: (required, at least 30 characters)</label>
      <input id="cusername" name="username" minlength="30" type="text" required/>
    </p>
    <p>
      <label for="cpassword">Password: (required)</label>
      <input id="cpassword" name="password" type="password" required/>
    </p> 
    <p>
<input type="submit" value="Submit">
</p>
</fieldset>
</form>
<form action="${mainUrl}/userSignup">
<input type="submit" value="SignUp">
</form>
<%-- 

<form:form action="submitForm" commandName="portfolio" method="post">

        Name : <form:input path="name" /><br />

        Nick Name : <form:input path="nickName" /><br />

        Age : <form:input path="age" /><br />

        Mobile : <form:input path="mobNum" /><br />

        <input type="submit" />

    </form:form>

<script>
$("#loginform").validate();
</script> --%>
</body>
</html>