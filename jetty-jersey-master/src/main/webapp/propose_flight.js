


function get_form_data(){
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

	
	console.log(JSON.stringify(data))
	$("#result").append(data);
	return data;
}


$(function(){
	
	$("#submit").click(function(){
		var data = get_form_data_pilot();
		putServerData("ws/Pilote/addPilot",data,test2);
		
	});
});