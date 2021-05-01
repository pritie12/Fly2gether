
function getServerData(url, success){
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
	var account='			<li class="nav_li"><a href="profil.html"><i class="far fa-user-circle fa-3x"></i></a></li>';
	var lists ="";
	
	if(c=="pilot"){
		lists= '			<li class="nav_li"><a href="flight_list_pilot.html">My Flights</a></li>'

	}else if( c=="passenger"){
		lists ='			<li class="nav_li"><a href="login.html">My Reservations</a></li>'

	}else{
		account = '			<li class="nav_li"><a href="login.html">Log in / Register</a></li>'
	}
	
	
	
	html = ""+
	 '<div class="nav_title">'+
	'			<a href="home.html"><h1>Fly2gether<h1></a>'+
	'		</div>'+
	'		<div class="nav_links">'+
	'			<ul class="nav_ul" >'+
				account +
	'			<li class="nav_li"><a href="propose_flight.html">Propose a flight</a></li>'+
	'			<li class="nav_li"><a href="find_flight.html">Find a flight</a></li>'+
				lists+		
				
	'			</ul>'+
	'		</div> '
	 
	 
	$("#navBarre").append(html);
	
}
