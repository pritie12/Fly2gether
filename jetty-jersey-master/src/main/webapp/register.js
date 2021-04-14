function test(){
    var html =$("#name").val()+" hello";
    $("#result").append(html);
}


function test2(){
  //  var html =$("#name").val()+" hello "+ $("#fly").val();
    //$("#result").append(html);
	console.log("OK");
}
function get_form_data(){
	var data={ "name":$("#name").val()
	,"surname":$("#surname").val()
	,"dateOfBirth":$("#date").val()
	,"email":$("#email").val()
	,"phoneNumber":$("#phone").val()
	,"pilot_id":""
	,"flyingHours":$("#fly").val()
	} ;
	console.log(JSON.stringify(data))
	$("#result").append(JSON.stringify(data));
	return data;
}


$(function(){
	$("#testform").click(function(){
		test();
	});
	$("#submit").click(function(){
		var data = get_form_data();
		putServerData("ws/Pilote/addPilot1",data,test2);
	});
});