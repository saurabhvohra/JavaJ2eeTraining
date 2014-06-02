<html>
<jsp:include page="header.jsp"/>
<head>
<script>

function doAjaxPost() {
	// get the form values
	var firstName = $('#firstName').val();
	var lastname = $('#lastname').val();
	var telephone = $('#telephone').val();
	var email = $('#email').val();
	var pattern=/^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
	if(pattern.test(email)){         
		$.ajax({
			type: "POST",
			url: "${mainUrl}/ajaxFormResponseType2Method",
			data: "firstName=" + firstName + "&lastName=" + lastname + "&telephone=" + telephone + "&email=" + email,
			success: function(response){
			//alert(response);
				
				// we have the response
			$('#info').html(response);
			$('#firstName').val('');
			$('#lastname').val('');
	     	$('#telephone').val('');
			$('#email').val('');
			},
			error: function(e){
			alert('Error: ' + e);
			}
			});
	}else{   
		alert("Please enter the correct email."); 
	}

	}
</script>
</head>
<body>
<div class="quickinquiry">
                <div class="left">
                 <div id="info" style="color: green;"></div>
First Name: <input type="text" required id="firstName" name="firstName">
Last Name: <input type="text" required id="lastname" name="lastName">
Telephone: <input type="text" required id="telephone" name="telephone">
email: <input type="text" required id="email" name="email">
<%-- <c:out value="${contactList.firstname}"/> 
<c:out value="${contactList.lastname}"/> --%>
<input type="submit" value="Submit" class="btn_submit" onclick="doAjaxPost()" />

</div>

</body>
</html>
























