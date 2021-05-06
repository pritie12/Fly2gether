


function get_form_data_newFlight(){
	var d = new Date($("#date").val());
	/*var data='{ "name": "R", "surname": "Gosling","dateOfBirth": 60282914400000,"email": "rayan@mai;.fr","phoneNumber": "07XXX","flyingHours": 200, "pilotId": "" }';*/
	

	

	// ---get user ID

	var usrId = 2/*getCookie("usrId")*/;
	//document.getElementById("aircraftID").value = ; // pour testeter qddFlight

	
	
	 var flight='{'+
        '"id": 0,'+
       ' "appointmentDescription": "'+ $("#apointement").val()+ '",'+
        '"departureDate":"'+ $("#dateDeparture").val() +'",'+
        '"departureTime":null,'+
        '"departureAirport":"' +$("#airportDeparture").val()  +'",'+
        '"arrivalDate":"'+$("#dateArrival").val() +'",'+
        '"arrivalTime": null ,'+
        '"arrivalAirport":"'+  $("#airportArrival").val()  +'",'+
        '"flightDuration": null,'+
        '"price":' + $("#newFlightPrice").val() +','+
        '"passengersList":null,'+
        '"availableSeats":'+ $("#newFligthSeats").val() + 
    	'}' ;
	//$("#res").append(flight);
	console.log(JSON.stringify(flight));
	 putServerData("/ws/Flight/addFlight",flight,function(){
		 console.log("flight added!!");
		 addAircraft();
		 
	 })



	 

	 
	
	//return $("#newFlightId").val();
}


function addAircraft(){
	// ---- Aircraft------
	var aircraft='{' +
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
	});
	getServerData("ws/Flight/getLastFlightId",	addNewFlight) ;
}

function addNewFlight(fId){
	var usrId=getCookie("usrId");// teste
//	var fId=$("#newFlightId").val();

	 var url1= "/ws/Flight/"+fId+"/setdepartureTime?time=" + $("#datetimeDeparture").val();
	 console.log("departurTime "+url1 );
	 postServerData(url1,function(){
		console.log("departurTime set");
	 });
	 var url2= "/ws/Flight/"+fId+"/setarrivalTime?time=" + $("#datetimeArrival").val();
	 console.log("arrTime set"+url2 );
	 postServerData(url2,function(){
		console.log("arrivalTime set");
	 });

	 var url3= "/ws/Flight/"+fId+"/setPilot?Pilot=" + usrId;
	 console.log("usrId set"+url3 );
	 postServerData(url3,function(){
		console.log("usrId set"  );
	 });

	 var url4= "/ws/Flight/"+fId+"/setAircraft?Aircraft=" + $("#aircraftID").val();
	 console.log("avion set"+url4 );
	 postServerData(url4,function(){
		console.log("aircraft set" + $("#aircraftID").val());
	 });



	 
	
	console.log("tout ok");
	console.log("Departurtime: " +$("#datetimeArrival").val());
	
}




$(function(){
	
	$("#submitNewFlight").click(function(){
		
		//putServerData("ws/Pilote/addPilot",data,test2);
		

		var usrId=getCookie("usrId");
		console.log(usrId);
		if(usrId=="" || usrId==undefined ||getCookie("usrType")!="pilot" ){
			$("#res").css("display", "block");
		}
		else{
			get_form_data_newFlight();

		}



	
		
		
	});
});