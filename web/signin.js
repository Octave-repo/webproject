$("document").ready(function(){

	$("#sinButton").click(function()
	{
		var username = $("#username").val();
        var password = $("#pass").val();
		var conf = $("#conf").val();
		

		if(conf === password && password)
		{
			$.ajax(
			{
			type: "POST",
			url:'http://localhost:8084/jdr/users/create',
			dataType:'json',
			contentType: 'application/json',
			async:true,
			data:'{"username": "' + username + '", "password": "' + password + '", "admin": false}',
			statusCode:{
				201:function(){
					$("#alertUser").text('Vous êtes bien inscrit');
					sessionStorage.setItem('username', username);
					window.location.replace("myaccount.html");
				},
				409:function(){
					$("#alertUser").text('Le nom est deja pris');
				}
			}
			})
		}else
		{
			console.log(password);
			if(!password){
				$("#alertUser").text("Veuillez entrez un mot de passe");
			}
			else {
				$("#alertUser").text("Les mot de passe ne sont pas identiques");
			}
		}

	});
	
	document.getElementById("pass").addEventListener("keyup", function(event)
	{
		if(event.keyCode === 13)
		{
			document.getElementById("sinButton").click();
		}
			
	});
	
	document.getElementById("username").addEventListener("keyup", function(event)
	{
		if(event.keyCode === 13)
		{
			document.getElementById("sinButton").click();
		}
	});
	
});


