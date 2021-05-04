


function get_form_data_newFlight(){
	var d = new Date($("#date").val());
	/*var data='{ "name": "R", "surname": "Gosling","dateOfBirth": 60282914400000,"email": "rayan@mai;.fr","phoneNumber": "07XXX","flyingHours": 200, "pilotId": "" }';*/
	
	var data= '{ "username": "' +  $("#username").val() +
	' ","pwd": "' +$("#pwd").val()+
	'",	"name":"' + $("#name").val()+
	'","surname":"' +	$("#surname").val()+
	 '","dateOfBirth":"'+$("#date").val()+
	 '","email":"'+ $("#mail").val()+
	 ' ","phoneNumber":"'+ $("#phone").val() +
	  '","flyingHours":'+$("#fly").val()+
	  '	} ';

	  /*
	     {
        "id": 0,
        "appointmentDescription": "",
        "departureDate": 61576668000000,
        "departureTime": ,
        "departureAirport": "Aerodrome 1",
        "arrivalDate": 61576668000000,
        "arrivalTime": ,
        "arrivalAirport": "",
        "flightDuration": ,
        "price": 37,
        "passengersList":null,
        "availableSeats": 140,
        "flightAircraft": 1520,
        "flightPilotId": 1
    } 
	 
	 
	  */

	
	console.log(JSON.stringify(data))
	$("#result").append(data);
	return data;
}


$(function(){
	
	$("#submitNewFlight").click(function(){
		var data = get_form_data_newFlight();
		putServerData("ws/Pilote/addPilot",data,test2);
		
	});
});