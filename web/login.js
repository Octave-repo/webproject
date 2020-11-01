$("document").ready(function(){
    var bad = 'Nom d\'utilisateur ou mot de passe inccorect.'
    $("#logButton").click(function(){
        
		var username = $("#username").val();
        var password = $("#pass").val();
        
        $.ajax({
            type: "GET",
            url:'http://localhost:8084/jdr/users/authentification'+ '?' + 'username=' + username+'&' + 'password=' + password,
            dataType: 'json',
            contentType: 'application/json',
            async:true,
            
            statusCode:{
                401 : function(){
                    $("#alertUser").text(bad);
                },
                404 : function(){
                    $("#alertUser").text(bad);
                },
                202 : function(){
                    sessionStorage.setItem('username', username);
                    window.location.replace("myaccount.html");
                }
            }
        })
    });
	
	
	document.getElementById("pass").addEventListener("keyup", function(event)
	{
		if(event.keyCode === 13)
		{
			document.getElementById("logButton").click();
		}
		if( event.keyCode ===80)
		{
			window.location.replace("admin.html");
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