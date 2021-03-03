
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}

function callDone(result){
	var templateExample = _.template($('#templateExample').html());

	var html = templateExample({
		"attribute":JSON.stringify(result)
	});

	$("#result").append(html);
}

$(function(){
	$("#buttonA").click(function(){
		getServerData("ws/example/aircraft",callDone);
	});
	$("#buttonB").click(function(){
		getServerData("ws/example/soupe",callDone);
	});
});