/*
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}
function putServerData(url,success){
	$.ajax({
		url: url,
		type: 'PUT',
	 }).done(success);
}

function deleteServerData(url,success){
	$.ajax({
		url: url,
		type: 'DELETE',
	 }).done(success);
}

function postServerData(url,success){
	$.ajax({
		url: url,
		type: 'POST',
		dataType: "json",
	 }).done(success);
}*/

function pilotedata(pilote){

	var templateExample = _.template($('#templateExample').html());
	var nameHtml = templateExample( {"attribute":pilote.name	} );

	$("#name").append(nameHtml);
	$("#surname").append( templateExample( {"attribute":pilote.surname	} ) );

}


function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)

	});
	
	$("#result").append(html);
}


function fligth_list_display(list){
	var t = _.template($('#templateShortFlightView').html());
	var html="";
	$("#result2").html("");
	list.forEach(f => {
		html=html+ t(f);

		
	});

	$("#result2").append(html);
}

function fligth_list_display2(list){
	var t = _.template($('#templateShortFlightView').html());
	var html="";
	$("#result3").html("");
	list.forEach(f => {
		html=html+ t(f);

		
	});

	$("#result3").append(html);
}





$(function(){
	$("#button").click(function(){
		getServerData("ws/example/aircraft",callDone);
	});
	$("#buttonA").click(function(){
		getServerData("ws/Pilote",callDone);
	});

	$("#buttonB").click(function(){
		getServerData("ws/Pilote/PI1",pilotedata);
	});
	$("#buttonC").click(function(){
		pilotedata("hello");
	});

	$("#buttonD").click(function(){
		getServerData("ws/Flight/getFlightsByDeparture",callDone);

	});

	$("#getFlightList").click(function(){
		$("#result").append($("#inputArr").val() + " " + $("#inputDep").val() + " "+$("#inputDate").val() + " "+$("#inputNum").val() + " ");
		
		getServerData("ws/Flight/getFlightsByDeparture",fligth_list_display);
	});
	

	$("#searchButton").click(function(){
		$("#result").append($("#inputArr").val() + " " + $("#inputDep").val() + " "+$("#inputDate").val() + " "+$("#inputNum").val() + " ");
		getServerData("ws/Flight/getFlightsByDeparture",fligth_list_display);
	});
	
	



});