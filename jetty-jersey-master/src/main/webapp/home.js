
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

function dateToString(date){
	var res="";
	var list = JSON.stringify(date).split(',');
	
	console.log(list);
	console.log(list[1].split(':')[1]);

	res = list[3].split(':')[1]+"/" + list[2].split(':')[1] +"/"+list[1].split(':')[1] + " " +list[4].split(':')[1]+":"+list[5].split(':')[1];
	return res;
}

function fligth_list_display(list){
	var t = _.template($('#templateShortFlightView').html());
	var html="";
	var count=0;
	$("#result2").html("");
	list.forEach(f => {
		var sur=getCookie("pSname");
		var name = getCookie("pName");
		var d1=f.departureTime;
		var d2=f.arrivalTime;


		html= t({
			"departureAirport":f.departureAirport,
			"departureDate":dateToString(d1),
			"arrivalDate":dateToString(d2),
			"arrivalAirport":f.arrivalAirport,
			"price":f.price,
			"availableSeats":f.availableSeats,
			"id":'<input type="hidden" value=' + f.id + ' id=flightId  > ',
			"buttonC":' <button id=\"choose\" onClick="chooseFly('+f.id +' )\"  > choose this flight</button>'
		});
		document.cookie = "pName=; expires=Thu, 01 Jan 1970 00:00:00 UTC; ";
		document.cookie = "pSname=; expires=Thu, 01 Jan 1970 00:00:00 UTC; ";
		$("#result2").append(html);
		count++;
		
	});

	
}

function display_div(div, data){
	$("#result").append(" div"+div + "data " + data);
}

function getPilotnName(d){
	var name =d ;
	$("#result").append("/ hello "+d);
}
function getPilotnSurname(d){
	var sur=d;

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

function flight_res_load(){
	var flightId= getCookie("flightId");
	var url1 = "ws/Flight/"+flightId+"/getFlight";
	getServerData(url1,function(f){
		console.log(JSON.stringify(f));
		var d1=f.departureTime;
		var d2=f.arrivalTime;
		$("#app_detail").append(f.appointmentDescription);
		$("#departure_loc").append(f.departureAirport);
		$("#arrival_loc").append(f.arrivalAirport);
		$("#arrival_date").append(dateToString(d2));
		$("#departure_date").append(dateToString(d1));
		$("#flightL_price").append(f.price);
		$("#availableSeats").append(f.availableSeats);
		url2 ="/ws/Aircraft/"+f.flightAircraftTailnumber+"/getAircraft";
		getServerData(url2,function(data){
			$("#aircrafModel").append(data.model);
			$("#aircrafCons").append(data.constructorCompany);
		});
		console.log(url2);
		url3="/ws/Pilote/"+ f.flightPilotId +"/getPilot";
		if(f.flightPilotId ==null){
			$("#pilot_name").append("unknown");
		}else{
			getServerData(url3,function(data){
				$("#pilot_name").append(data.name);
				$("#pilot_surname").append(data.surname);
				$("#flyingHours").append(data.flyingHours);
			});
		}
		
		
		console.log(url3);
	});
	

	/*
	var d1=f.departureTime;
		var d2=f.arrivalTime;
		dateToString(d1);

		html= t({
			"departureAirport":f.departureAirport,
			"departureDate":dateToString(d1),
			"arrivalDate":dateToString(d2),
			"arrivalAirport":f.arrivalAirport,
			"price":f.price,
			"availableSeats":f.availableSeats,
	 */

	fligth_view_display();
}


function fligth_view_display(){
	nav_load();
	console.log("hello ");
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




//	$("#flight_long_view").append("ok");
}


function pilot_flight_list_load(){

	fligth_view_display();
}

function addResa(){

	var resa = '{'+
		'"bookingUser":'+ getCookie("usrId")+ ','+
		'"flight": '+ getCookie("flightId")+','+
		'"desiredSeats":'+$("#newResaSeats").val() +
	"}";
	console.log(JSON.stringify(resa));

	putServerData("/ws/Reservation/addReservation",resa, function(){
		console.log("resa send");
	});

}

function pilot_flight_list_load(){
    nav_load();
    userId=getCookie("usrId");
    console.log("hello"+userId);
    url ="/ws/Pilote/"+ userId+"/getScheduledFlights";
   // url="/ws/Flight/getFlights" //test
    getServerData(url,fligth_list_display);
    

}






$(function(){
	$("#buttonHome").click(function(){
		window.location.href='find_flight.html';
		$("#result").append("hello from home");
		getServerData("ws/Flight/getFlightsByDeparture",fligth_list_display);

	});

	$("#button").click(function(){

		var url ="/ws/Passenger/PassengerLogin/?username=vincent&password=123";
		getServerData(url,callDone);
		getServerData(url,function(data){
			var s ="hello"+ data.passengerId;
			callDone(s);
		});

	});
	$("#buttonA").click(function(){
		$("#result").append("hhhh");
		//getServerData("ws/Pilote",callDone);
		var c = getCookie("usrId");
		$("#result").append("hello");
	});

	$("#buttonB").click(function(){
		getServerData("ws/Pilote/PI1",pilotedata);
	});
	$("#buttonC").click(function(){
		pilotedata("hello");
	});

	$("#buttonD").click(function(){
		getServerData("ws/Flight/getFlights",callDone);
		getServerData("ws/Flight/getFlightse",fligth_list_display);

	});

	// show all flights
	$("#getFlightList").click(function(){
		$("#result").append($("#inputDep").val() + " " + $("#inputDateFrom").val() + " "+$("#inputDateTo").val() + " "+$("#inputNum").val() + " ");
		processSearchInput();
		var arrival =processSearchInput( $("#inputArr").val());
		var departur =processSearchInput( $("#inputDep").val() );
		var date =processSearchInput( $("#inputDate").val() );
		var seats =processSearchInput( $("#inputNum").val() );
		var url = "ws/Flight/getFlights/" + departur+"/" + arrival+"/"+date;
		console.log(url);
		getServerData("/ws/Flight/getFlights",fligth_list_display);
	});
	

	$("#searchButton").click(function(){
		
		/*getServerData("ws/Flight/getFlights%departureAirport%arrivalAirport%date" ,fligth_list_display);*/
		var dateMin=$("#inputDateFrom").val().replace("T"," ");
		var dateMax=$("#inputDateTo").val().replace("T"," ");
		var url ="ws/Flight/getFlightsByDeparture?DepartureMin=" +dateMin +"&DepartureMax="+ dateMax+"&DepartureAirport="+$("#inputDep").val() ;
		console.log(url);
		getServerData(url,fligth_list_display);

	});

	$("#flight_short_view").hover(function(){
		$("#choose").css("display", "block");
    }, function(){
    $("#choose").css("display", "none");
	});

	$("#dropdown").hover(function(){
		$("#dropdown-content").css("display", "block");
	}, function(){
	$("#dropdown-content").css("display", "none");
	});

	$("#bookingBtn").click(function(){
		var usrId=getCookie("usrId");
		usrId=0 //test
		console.log(usrId);
		if(usrId==null || usrId==undefined ){
			$("#res").css("display", "block");
		}
		else{
			addResa();

		}

	});




});
//background-color: #ffffff;