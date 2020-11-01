$("document").ready(function(){
	var objectFiche = {
		campagne : {
			id:0
		},
		createur : {
			username: sessionStorage.getItem('username')
		},
		nom : "",
		gold:0,
		force:0,intelligence:0,dexterite:0,charisme:0,constitution:0,
		niveau:0,exp:0,maxHp:0,hp:0,
		classe : "",race: "",
		description : "",competences: undefined
		
	}
	
	var objectType = {
		nom : "",
		template : undefined
	}
	
	var objectCampagne = {
		
		limite : 0,
		type : {
			idType : 0 },
		mj : {
			username:sessionStorage.getItem('username')}
	}
	
	
    var username = sessionStorage.getItem('username');
    //Redirige l'utilisateur si il n'est pas connecté
    var uri = 'http://localhost:8084/jdr' 
	var perso = undefined;
	var campagne = undefined;
	var type = undefined;

	if (username == undefined){
        alert("Vous allez être redirigé vers la page principale.");
        window.location.replace("index.html");
    }
	$("#listFichePerso").append($("<option>").attr('value', "default").text("----"));
	$("#listCampagne").append($("<option>").attr('value', "default").text("----"));
	$("#listType").append($("<option>").attr('value', "default").text("----"));

   $.get(uri + "/character/users/" + username, function(data) {
	   perso = data;
	   
       data.forEach(function(element, index) {
          $("#listFichePerso").append($("<option>").attr('value', index).text(element.nom));
       });
    });
    $.get(uri + "/campaign/users/" + username, function(data) {
		campagne = data;
		
        data.forEach(function(element, index){
           $("#listCampagne").append($("<option>").attr('value', index).text(element.type.nom));
        });
     });
	$.get(uri + "/type", function(data) {
		type = data;
		
        data.forEach(function(element, index){
           $("#listType").append($("<option>").attr('value', index).text(element.nom));
        });
     });
     $("#listFichePerso").on('input', function(e){
        var index = $(this).val();
		var map = Object.entries(perso[index]);
		$("#vrac").empty();
		map.forEach(([cle, valeur]) => {
			switch(cle)
			{
				case 'campagne':
					$("#vrac").append($("<p>").text(cle +  " : " + valeur.type.nom));
					break;
				case 'createur':
					break;
				default:
					$("#vrac").append($("<p>").text(cle +  " : " + valeur));
					if(cle === 'classe' || cle === 'race' || cle === 'description' || cle === 'nom')
					{
						$("#vrac").append($("<input>").attr('id', cle).attr('name', cle).attr('type', 'text'));
					}
					else if(!(cle === 'createur') && !(cle === 'competences'))
					{
						$("#vrac").append($("<input>").attr('id', cle).attr('name', cle).attr('type', 'number'));
					}
					else if(cle === 'competences'){}
			}
			
			
		});
		
		
		$("#vrac").append($("<input>").attr({
			type : "button",
			id : "modif",
			class : "button",
			value : "Modifier"
			
		}
		));
		$("#modif").click(function()
		{
			for(let key in objectFiche)
			{
				if(key === 'campagne')
				{
				objectFiche[key].id=perso[index].campagne.id;
					
				}
				else if(!(key === 'createur'))
				{
					objectFiche[key] = $("#" +key).val();
				}
			}
			console.log(objectFiche);
		});

    });
	
	$("#listCampagne").on('input', function(e){
        var index = $(this).val();
		var map = Object.entries(campagne[index]);
		$("#vrac").empty();
		map.forEach(([cle, valeur]) => {
			switch(cle)
			{
				case 'type':
					$("#vrac").append($("<p>").text(cle +  " : " + valeur.nom));
					break;
				case 'mj':
					break;
				default:
					$("#vrac").append($("<p>").text(cle +  " : " + valeur));

			}
			
			
		});
	});
	
	$("#listType").on('input', function(e){
        var index = $(this).val();
		var map = Object.entries(type[index]);
		$("#vrac").empty();
		map.forEach(([cle, valeur]) => {
			switch(cle)
			{
				case 'template':
					$("#vrac").append($("<p>").text(cle +  " : " + valeur));
					break;
				default:
					$("#vrac").append($("<p>").text(cle +  " : " + valeur));

			}
			
			
		});
	});
	
	$("#postPerso").click(function()
	{
		$("#vrac").empty();
		var map=Object.entries(objectFiche);
		map.forEach(([cle, valeur]) => {
			if(cle === 'classe' || cle === 'race' || cle === 'description' || cle === 'nom')
			{
				$("#vrac").append($("<label>").attr('for', cle).text(cle + ' : '));
				$("#vrac").append($("<input>").attr('id', cle).attr('name', cle).attr('type', 'text'));
				
				
			}
			else if(!(cle === 'createur') && !(cle === 'competences'))
			{
				$("#vrac").append($("<label>").attr('for', cle).text(cle + ' : '));
				$("#vrac").append($("<input>").attr('id', cle).attr('name', cle).attr('type', 'number'));
			}
			else if(cle === 'competences')
			{
				
			}
			
			$("#vrac").append("<br>");
			
		});

		$("#vrac").append($("<input>").attr({
			type : "button",
			id : "create",
			class : "button",
			value : "Confirmer"
			
		}
		));

		$("#create").click(function()
		{
			for(let key in objectFiche)
			{
				if(key === 'campagne')
				{
					objectFiche[key].id=$("#" +key).val();
					
				}
				else if(!(key === 'createur'))
				{
					objectFiche[key] = $("#" +key).val();
				}
			}
		
			$.ajax({
				url:'http://localhost:8084/jdr/character/create',
				type : 'POST',
				contentType: 'application/json',
				dataType:'json',
				data: JSON.stringify(objectFiche),
				statusCode: {
					200: function()
					{
						alert("Votre perso a bien été crée");
						window.location.replace("myaccount.html");
					}
				}
			});
		});
		
		
	});
	$("#postType").click(function()
	{
		$("#vrac").empty();
		var map=Object.entries(objectType);
		map.forEach(([cle, valeur]) => {
			$("#vrac").append($("<label>").attr('for', cle).text(cle + ' : '));
			$("#vrac").append($("<input>").attr('id', cle).attr('name', cle).attr('type', 'text'));
			$("#vrac").append("<br>");
			
		});

		$("#vrac").append($("<input>").attr({
			type : "button",
			id : "create",
			class : "button",
			value : "Confirmer"
			
		}
		));

		$("#create").click(function()
		{
			for(let key in objectType)
			{
				if(key === 'template'){
					var temp = [ $("#"+key).val() ];
					objectType[template] = temp;
				}
				
				else {
					objectType[key] = $("#" +key).val();
				}
				

			}
		
			$.ajax({
				url:'http://localhost:8084/jdr/type/create',
				type : 'POST',
				contentType: 'application/json',
				dataType:'json',
				data: JSON.stringify(objectType),
				statusCode: {
					200: function()
					{
						alert("Votre type a bien été crée");
						window.location.replace("myaccount.html");
					}
				}
			});
		});
		
		
	});
	
	$("#postCampagne").click(function()
	{
		$("#vrac").empty();
		var map=Object.entries(objectCampagne);
		map.forEach(([cle, valeur]) => {
			if(!(cle === 'mj') && !(cle === 'id'))
			{
				$("#vrac").append($("<label>").attr('for', cle).text(cle + ' : '));
				$("#vrac").append($("<input>").attr('id', cle).attr('name', cle).attr('type', 'number'));
			}
			
			$("#vrac").append("<br>");
			
		});

		$("#vrac").append($("<input>").attr({
			type : "button",
			id : "create",
			class : "button",
			value : "Confirmer"
			
		}
		));

		$("#create").click(function()
		{
			for(let key in objectCampagne)
			{
				if(key === 'type')
				{
					objectCampagne[key].idType=$("#" +key).val();
					
				}
				else if(!(key === 'mj'))
				{
					objectCampagne[key] = $("#" +key).val();
				}
					
			}
			
			console.log(objectCampagne);
			$.ajax({
				url:'http://localhost:8084/jdr/campaign/create',
				type : 'POST',
				contentType: 'application/json',
				dataType:'json',
				data: JSON.stringify(objectCampagne),
				statusCode: {
					200: function()
					{
						alert("Votre campagne a bien été crée");
						window.location.replace("myaccount.html");
					}
				}
			});
		});
		
		
	});
	
	$("#logout").click(function()
	{
		sessionStorage.removeItem('username');
		alert("Vous allez être redirigé vers la page de connexion");
		window.location.replace("index.html")
		
	});
});