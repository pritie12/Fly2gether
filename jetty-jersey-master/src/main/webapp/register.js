function test(){
    var html =$("#name").val()+" hello";
    $("#result").append(html);
}


function test2(){
    var html =$("#name").val()+" hello "+ $("#fly").val();
    $("#result").append(html);
}
function get_form_data(){
	var data='{ "name":"'+$("#name").val()+
	'","surname":"'+$("#surname").val()+
	'","dateOfBirth":'+$("#date").val()+
	',"email":'+$("#email").val()+
	',"phoneNumber":'+$("#phone").val()+
	',"flyingHours":'+$("#fly").val()+
	' } ';
	$("#result").append(data);
	return data;
}


$(function(){
	$("#testform").click(function(){
		test();
	});
	$("#submit").click(function(){
		var data = JSON.parse(get_form_data());
		putServerData("/Pilote/addPilot1",data,test2);
	});
});