/*Animations  */

const inputs = document.querySelectorAll(".input");


function addcl(){
	let parent = this.parentNode.parentNode;
	parent.classList.add("focus");
}

function remcl(){
	let parent = this.parentNode.parentNode;
	if(this.value == ""){
		parent.classList.remove("focus");
	}
}


inputs.forEach(input => {
	input.addEventListener("focus", addcl);
	input.addEventListener("blur", remcl);
});


/*Formulaires */ 

function test(){
    var html =$("#name").val()+" hello";
    $("#result").append(html);
}


function test2(){
  //  var html =$("#name").val()+" hello "+ $("#fly").val();
    //$("#result").append(html);
	console.log("OK");
}
function get_form_data_pilot(){
	var d = new Date($("#date").val());
	/*var data='{ "name": "R", "surname": "Gosling","dateOfBirth": 60282914400000,"email": "rayan@mai;.fr","phoneNumber": "07XXX","flyingHours": 200, "pilotId": "" }';*/
	
	var data= '{ "name":"' + $("#name").val()+
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

function get_form_data_passenger(){
	var d = new Date($("#date").val());
	/*var data='{ "name": "R", "surname": "Gosling","dateOfBirth": 60282914400000,"email": "rayan@mai;.fr","phoneNumber": "07XXX","flyingHours": 200, "pilotId": "" }';*/
	
	var data= '{ "name":"' + $("#name").val()+
	'","surname":"' +	$("#surname").val()+
	 '","dateOfBirth":"'+$("#date").val()+
	 '","email":"'+ $("#mail").val()+
	 ' ","phoneNumber":"'+ $("#phone").val() +
	  '	} ';

	
	console.log(JSON.stringify(data))
	$("#result").append(data);
	return data;
}

function hide_div(){
	var x = document.getElementById("div_pilot");
	x.style.display = "none";
}

function show_div(){
	var x = document.getElementById("div_pilot");
	x.style.display = "block";
}


$(function(){
	$("#testform").click(function(){
		test();
	});
	$("#submit").click(function(){
		if(document.getElementById("is_pil").checked==true){
			var data = get_form_data_pilot();
			putServerData("ws/Pilote/addPilot",data,test2);
		}
		else{
			var data = get_form_data_passenger();
			putServerData("ws/Passenger/addPassenger",data,test2);
		}

		
	});
});