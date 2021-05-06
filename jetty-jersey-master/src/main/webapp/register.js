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
	
	var data= '{' +
	'"username": "' +  $("#username").val() +
	'","pwd": "' +$("#pwd").val()+
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
	
	var data= '{'+
	'"passengerBookingList": null,'+
	'"username": "' +  $("#username").val() +
	'","pwd": "' +$("#pwd").val()+
	'","name":"' + $("#name").val()+
	'","surname":"' +	$("#surname").val()+
	'","dateOfBirth":"'+$("#date").val()+
	'","email":"'+ $("#mail").val()+
	'","phoneNumber":"'+ $("#phone").val() +
	'", "passengerId": 0'+
	'} ';
	console.log(JSON.stringify(data));
	console.log(JSON.stringify(data))
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

	var c1 = "usrId="+ id;
	document.cookie = c1 ;
}


$(function(){
	$("#testform").click(function(){
		test();
	});
	/*submit register */
	$("#submit").click(function(){
		var usr_type=null;
		var url="";
		try{
			if(document.getElementById("is_pil").checked==true){
				var data = get_form_data_pilot();
				putServerData("ws/Pilote/addPilot",data,function(){

					
					url = "/ws/Pilote/PilotLogin?username=" + $("#username").val() +"&pwd="+$("#pwd").val();
					
			
					console.log(url);
					getServerData(url,function(id){
						if(id==-1){
							console.log("bad");
						}else{
							var c1 = "usrId="+ id;
						document.cookie = c1 ;
						usr_type="pilot";
						var c = "usrType="+ usr_type;
						document.cookie = c ;
						window.history.go(-1);
						}
						
					});

				});
				

			}
			else{
				var data = get_form_data_passenger();
				putServerData("ws/Passenger/addPassenger",data,function(){
					usr_type = "passenger";
					url = "ws/Passenger/PassengerLogin/?username="+$("#username").val()+"&password="+$("#pwd").val();
					
			
					console.log(url);
					getServerData(url,function(id){
						if(id==-1){
							console.log("bad");
						}else{
						var c1 = "usrId="+ id;
						document.cookie = c1 ;
						var c = "usrType="+ usr_type;
						document.cookie = c ;
						window.history.go(-1);
						}
					});

				});
				
			}
			var c = "usrType="+ usr_type;
			
				
			//set_usrId_cookie(2); // pour tester
			
		}catch (error) {
			console.log(error);
		}
		

		
		
	});

	$("#btnLogin").click(function(){
		var pwd = $("#login_pwd").val();
		var username = $("#login_usr").val();
		var id =null;
		var usr_type=null;
		if(document.getElementById("is_pil").checked==true){
			
			var url = "ws/Pilote/PilotLogin?username="+username + "&pwd="+pwd;
			
			getServerData(url,function(data){
				if(data==-1){
					console.log("username or passwor incorrect")
				}
				else{
				set_usrId_cookie(data);
				usr_type="pilot";
				var c = "usrType="+ usr_type;
				document.cookie = c ;
				
				
				//set_usrId_cookie(data); // pour tester
				window.history.go(-1);
				}
			}); 
			
		}
		else{
			var url = "ws/Passenger/PassengerLogin/?username="+username+"&password="+pwd;
			console.log(url);
			getServerData(url,function(data){
				if(data==-1){
					console.log("username or passwor incorrect")
				}
				else{
				set_usrId_cookie(data);
				usr_type = "passenger";
				var c = "usrType="+ usr_type;
				document.cookie = c ;
				
				
				//set_usrId_cookie(data); // pour tester
				window.history.go(-1);
				}
			});
			
		}

		/* dans le cas ou ca marche pas? */

	

	});
});