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

function set_usrId_cookie(id){
	var c = "usrId="+ id;
	document.cookie = c ;
}


$(function(){
	$("#testform").click(function(){
		test();
	});
	/*submit register */
	$("#submit").click(function(){
		var usr_type=null;
		if(document.getElementById("is_pil").checked==true){
			var data = get_form_data_pilot();
			putServerData("ws/Pilote/addPilot",data,test2);
			usr_type="pilot";
		}
		else{
			var data = get_form_data_passenger();
			putServerData("ws/Passenger/addPassenger",data,test2);
			usr_type = "passenger";
		}

		var c = "usrType="+ usr_type;
		document.cookie = c ;
		set_usrId_cookie(1); // pour tester
		window.history.go(-1);
		
	});

	$("#btnLogin").click(function(){
		var pwd = $("login_pwd").val();
		var username = $("login_usr").val();
		var id =null;
		var usr_type=null;
		if(document.getElementById("is_pil").checked==true){
			
			var url = "ws/Pilote/username/PilotLogin?username="+username + "&pwd="+pwd;
			/*	getServerData(url,set_usrId_cookie); */
			usr_type="pilot";
		}
		else{
			var url = "ws/Passenger/username/PassengerLogin?username="+username + "&pwd="+pwd;
			/*getServerData(url,set_usrId_cookie);*/
			
			usr_type = "passenger";
		}

		/* dans le cas ou ca marche pas? */

		var c = "usrType="+ usr_type;
		document.cookie = c ;
		set_usrId_cookie(1); // pour tester
		window.history.go(-1);

	});
});