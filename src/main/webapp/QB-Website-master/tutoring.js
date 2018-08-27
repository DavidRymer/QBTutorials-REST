var section = document.querySelector("select");

function checkAvailability() {

	var date = document.getElementById('date').value;
	console.log(date);
	
	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/getTimes/' + date;
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		var reply = request.response;
		var options = "";
		
		var array = [9,10,11,12,13,14,15,16,17];
		
		for (var i = 0; i<reply.length; i++) {
		console.log(reply[i].hour);	
		array.splice(reply[i].hour - 9, 1);
		}
		
		for (var i = 0; i < array.length; i++) {

		    var option = document.createElement("option");
		    option.value = array[i];
		    option.text = array[i] + ":00";
		    options +=  "<option>" + array[i] + ":00</option>";
		}
		
		document.getElementById('hours').innerHTML = options;
	}

}

//function addSession() {
//	
//	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/getTimes/' + date;
//	var request = new XMLHttpRequest();
//	request.open('GET', requestURL);
//	request.responseType = 'json';
//	request.send();
//	request.onload = function () {
//		var reply = request.response;
//	
//}

