


function get_form_data_newFlight(){
	var d = new Date($("#date").val());
	/*var data='{ "name": "R", "surname": "Gosling","dateOfBirth": 60282914400000,"email": "rayan@mai;.fr","phoneNumber": "07XXX","flyingHours": 200, "pilotId": "" }';*/
	

	// ---- Aircraft------
/*	var aircraft='{' +
	'"tailNumber":'+$("#tailNumber").val()+','+
	'"model": "' + $("#aircraftModel").val() +'",'+
	'"constructorCompany": "+' +$("#aircraftConstructor").val() +'",'+
	'"numberOfSeats": '+ $("#newFligthSeats").val()+
	'}'; 
	putServerData("/ws/Aircraft/addAircraft", aircraft, function(){
		console.log("aircraft added");
	});
	var url = "/ws/Aircraft/"+$("#tailNumber").val() +"/getAircraftId"
	getServerData(url, function (data){
		//$("#aircraftID").val(data);
		document.getElementById("aircraftID").value = data;
		console.log("aircraft id set" + data);
	});*/

	// ---get user ID

	var usrId = getCookie("usrId");
	document.getElementById("aircraftID").value = 0; // pour testeter qddFlight

	
	
	 var flight='{'+
        '"id": 0,'+
       ' "appointmentDescription": "'+ $("#apointement").val()+ '",'+
        '"departureDate":"'+ $("#dateDeparture").val() +'",'+
        '"departureTime":null,'+
        '"departureAirport":"' +$("#airportDeparture").val()  +'",'
        '"arrivalDate":"'+$("#dateArrival").val() +'",'+
        '"arrivalTime": null ,'+
        '"arrivalAirport":"'+  $("#airportArrival").val()  +'",'+
        '"flightDuration":' +  0 + ','+
        '"price":' + $("#newFlightPrice").val() +','+
        '"passengersList":null,'+
        '"availableSeats":'+ $("#newFligthSeats").val() + ","+
        '"flightAircraft":' + $("#aircraftID").val() +','+
        '"flightPilotId":'+usrId+
    	'}' 
		console.log(JSON.stringify(flight));
	 putServerData("/ws/Flight/addFlight",flight,function(){
		 console.log("flight added!!");
	 })
	var date = new Date($("#datetimeDeparture").val());
	 console.log("time: " +date.toISOString());
	
	console.log(JSON.stringify(flight));
	$("#result").append(flight);
	return flight;
}


$(function(){
	
	$("#submitNewFlight").click(function(){
		var data = get_form_data_newFlight();
		//putServerData("ws/Pilote/addPilot",data,test2);
		
		
	});
});