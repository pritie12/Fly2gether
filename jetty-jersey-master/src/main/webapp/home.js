/*
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}
function putServerData(url,success){
	$.ajax({
		url: url,
		type: 'PUT',
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
}*/

function pilotedata(pilote){

	var templateExample = _.template($('#templateExample').html());
	var nameHtml = templateExample( {"attribute":pilote.name	} );

	$("#result").append(nameHtml);
	$("#surname").append( templateExample( {"attribute":pilote.surname	} ) );

}


function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
		

	});
	
	$("#result").append(html);
}


function fligth_list_display(list){
	var t = _.template($('#templateShortFlightView').html());
	var html="";
	var count=0;
	$("#result2").html("");
	list.forEach(f => {
		html= t({
			"departureAirport":f.departureAirport,
			"arrivalAirport":f.arrivalAirport,
			"aircraftModel":f.flightAircraft.model,
			"pilotName": f.flightPilot.name,
			"pilotSurname": f.flightPilot.surname,
			"price":f.price,
			"availableSeats":f.availableSeats,
			"id":'<input type="hidden" value=' + f.id + ' id=flightId  > ',
			"buttonC":' <button id=\"choose\" onClick="chooseFly('+f.id +' )\"  > choose this flight</button>'
		});
		$("#result2").append(html);
		count++;
		
	});

	
}

function fligth_list_display2(list){
	var t = _.template($('#templateShortFlightView').html());
	var html="";
	$("#result3").html("");
	list.forEach(f => {
		html=html+ t(f);		
	});

	$("#result3").append(html);
}

function processSearchInput(s){
	/*$("#result").append($("#inputArr").val() + " " + $("#inputDep").val() + " "+$("#inputDate").val() + " "+$("#inputNum").val() + " ");*/

	if (s==""){
		return "xxx";
	}
	return s;

}

function chooseFly(id) {
	console.log("hello "+ id);
	var c = "flightId="+ id;
	document.cookie = c ;
	location.replace("flight_res.html");
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



function fligth_view_display(){
	console.log("hello ");
	var html="let's start";
	var cook = getCookie("flightId");
	console.log(cook);
	if(cook==""){
		console.log("no flight selected");
		location.replace("find_flight.html");
	}
	var url= "ws/Flight/getFlightPrice?id="+ cook

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#app_detail").append(res);
	});

	getServerData(url,function(res){
		$("#departure_loc").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#departure_date").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#departure_time").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#arrival_loc").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#arrival_date").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#arrival_time").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#flightL_price").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#flightL_seats").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#flightL_aircrafModel").append(res);
	});

	url= "ws/Flight/{id}/getFlightPrice?id="+ cook
	getServerData(url,function(res){
		$("#flightL_aircrafCons").append(res);
	});




	$("#flight_long_view").append(html);
}





$(function(){
	$("#buttonHome").click(function(){
		window.location.href='find_flight.html';
		$("#result").append("hello from home");
		getServerData("ws/Flight/getFlightsByDeparture",fligth_list_display);

	});

	$("#button").click(function(){
		getServerData("ws/example/aircraft",callDone);
	});
	$("#buttonA").click(function(){
		getServerData("ws/Pilote",callDone);
	});

	$("#buttonB").click(function(){
		getServerData("ws/Pilote/PI1",pilotedata);
	});
	$("#buttonC").click(function(){
		pilotedata("hello");
	});

	$("#buttonD").click(function(){
		getServerData("ws/Flight/getFlights",callDone);

	});

	$("#getFlightList").click(function(){
		$("#result").append($("#inputArr").val() + " " + $("#inputDep").val() + " "+$("#inputDate").val() + " "+$("#inputNum").val() + " ");
		
		getServerData("ws/Flight/getFlights",fligth_list_display2);
	});
	

	$("#searchButton").click(function(){
		processSearchInput();
		var arrival =processSearchInput( $("#inputArr").val());
		var departur =processSearchInput( $("#inputDep").val() );
		var date =processSearchInput( $("#inputDate").val() );
		var seats =processSearchInput( $("#inputNum").val() );
		var url = "ws/Flight/getFlights/" + departur+"/" + arrival+"/"+date;
		console.log(url);
		getServerData("/ws/Flight/getFlights",fligth_list_display);
		/*getServerData("ws/Flight/getFlights%departureAirport%arrivalAirport%date" ,fligth_list_display);*/
	});

	$("#choose").click(function(){
		$("#result").append("hello from home");
		var c =this.parentNode.firstChild;
		console.log("hello "+c.val());
		
	});

	$("#flight_long_view").onload(function (){
		console.log("hello ");
	});

});