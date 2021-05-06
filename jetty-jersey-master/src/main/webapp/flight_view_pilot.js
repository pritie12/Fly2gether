


function pilot_flight_list_load(){
    nav_load();
    userId=getCookie("usrId");
    console.log("hello"+userId);
    url ="/ws/Pilote/"+ userId+"/getScheduledFlights";
   // url="/ws/Flight/getFlights" //test
    getServerData(url,fligth_list_display);
    
}


function pilot_flight_list_load(){
    nav_load();
    userId=getCookie("usrId");
    console.log("hello"+userId);
    url ="/ws/Pilote/"+ userId+"/getScheduledFlights";
   // url="/ws/Flight/getFlights" //test
    getServerData(url,fligth_list_display);
    

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
	var t = _.template($('#templateShortFlightViewPi').html());
	var html="";
	console.log(JSON.stringify(list));
	$("#result2").html("");
	list.forEach(f => {
        console.log(JSON.stringify(f));
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
            "pendingResa":"hello",
            "approuvedResa"="ppp",
			"id":'<input type="hidden" value=' + f.id + ' id=flightId  > ',
			"viewButton":' <button id=\"choose\" onClick="chooseFly('+f.id +' )\"  > choose this flight</button>'
		});
		$("#result2").append(html);
	
		
	});
    console.log("fin");
	
}




$(function(){
    $("#choose").click(function(){
		pilotedata("hello");
	});

});