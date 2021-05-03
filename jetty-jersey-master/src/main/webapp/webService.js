

function display_getServerData(url, div_id){
    $.ajax({
        dataType: "json",
        url: url
    }).done(function(div_id,data){
		$(div_id).append(data);
	} );
}
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function returnServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}
function putServerData(url, data, success) {
    
    $.ajax({
        type: 'PUT',
        contentType: "application/json",
        dataType: "json",
        data: data,
        url: url
    }).done(success);
}

function deleteServerData(url,success){
	$.ajax({
		url: url,
		type: 'DELETE',
	 }).done(success);
}

function postServerData(url,success){
	$.ajax({
		url: url,
		type: 'POST',
		dataType: "json",
	 }).done(success);
}



function getCookie(cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for(var i = 0; i <ca.length; i++) {
	  var c = ca[i];
	  while (c.charAt(0) == ' ') {
		c = c.substring(1);
	  }
	  if (c.indexOf(name) == 0) {
		return c.substring(name.length, c.length);
	  }
	}
	return "";
  }


  
function nav_load(){
	var c = getCookie("usrType");
	var account='			<div class="nav_li" id ="dropdown" ><a href="profil.html" id="account">Account</a>'+
				' <div class="dropdown-content" id="dropdown-content" >'+
				'<a href="profil.html" class ="nav_drop">Profil</a>'+
				'<a  class ="nav_drop" onclick="logout_fun()">Logout</a>'+
 	' </div> </div>';
	var lists ="";
	
	if(c=="pilot"){
		lists= '			<div class="nav_li"><a href="flight_list_pilot.html">My Flights</a></div>'

	}else if( c=="passenger"){
		lists ='			<div class="nav_li"><a href="login.html">My Reservations</a></div>'

	}else{
		account = '			<div class="nav_li" id=""><a href="login.html">Log in / Register</a></div>'
	}
	
	
	
	html = ""+
	 '<div class="nav_title">'+
	'			<a href="home.html"><h1>Fly2gether<h1></a>'+
	'		</div>'+
	'		<div class="nav_links">'+
	'			<ul class="nav_ul" >'+
				account +
				lists+	
	'			<div class="nav_li"><a href="propose_flight.html">Propose a flight</a></div>'+
	'			<div class="nav_li"><a href="find_flight.html">Find a flight</a></div>'+
					
				
	'			</ul>'+
	'		</div> '
	 
	 
	$("#navBarre").append(html);
	
}

function logout_fun(){
	document.cookie = "usrId=; expires=Thu, 01 Jan 1970 00:00:00 UTC; ";
	document.cookie = "usrType=; expires=Thu, 01 Jan 1970 00:00:00 UTC; ";
	location.replace("home.html");

}




