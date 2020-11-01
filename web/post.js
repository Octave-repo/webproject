$("document").ready(function()
{
	$("ul").append("<li>" + sessionStorage.getItem('username')+"</li>");
});