
function getServerData(url, success){
    $.ajax({
        dataType: "json",
        url: url
    }).done(success);
}
function putServerData(url, data, success) {
    $.ajax({
        type: 'PUT',
        contentType: "application/json",
        dataType: "json",
        data: data,
        url: url
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
}