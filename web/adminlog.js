$("document").ready(function(){

	$("#sinButton").click(function()
	{
		var username = $("#username").val();
        var password = $("#pass").val();
		$.ajax(
		{
			type: "POST",
			url:'http://localhost:8084/jdr/users/create',
			dataType:'json',
			contentType: 'application/json',
			async:true,
			data:'{"username": "' + username + '", "password": "' + password + '", "admin": true}',
			statusCode:{
				201:function(){
					$("#alertUser").text('Vous êtes bien inscrit');
				},
				409:function(){
					$("#alertUser").text('Le nom est deja pris');
				}
			}
		})
	});
	
	document.getElementById("pass").addEventListener("keyup", function(event)
	{
		if(event.keyCode === 13)
		{
			document.getElementById("sinButton").click();
		}
			
	});
	
	
});












//sessionStorage.setItem('username', value)
//sessionStorage.getItem('username')
//type : GET
//statusCode()
/*
$("#test1").click(function()
    {
        $.ajax(
        {
            type: "GET",
            url:'http://localhost:8080/jdr/users/authentification',
            dataType: 'json',
            contentType: 'application/json',
            async:true,
            data:'{"username": "harcker14", "password": "test12", "admin": true}',
            statusCode: {
                201 : function(){
                    alert("Vous êtes bien inscrit");
                },
                409 : function(){
                    alert("Le nom d'utilisateur est deja utilisé");
                }
            }
        });

NOTFOUND
ACCEPTED
AUTHORISED
    });
*/