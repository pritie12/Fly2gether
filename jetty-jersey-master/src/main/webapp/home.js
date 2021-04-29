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
	$("#result2").html("");
	list.forEach(f => {
		html=html+ t(f);

		
	});

	$("#result2").append(html);
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
		getServerData("ws/Flight/getFlightsBySeats",callDone);

	});

	$("#getFlightList").click(function(){
		$("#result").append($("#inputArr").val() + " " + $("#inputDep").val() + " "+$("#inputDate").val() + " "+$("#inputNum").val() + " ");
		
		getServerData("ws/Flight/getFlightsBySeats",fligth_list_display);
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
	
});