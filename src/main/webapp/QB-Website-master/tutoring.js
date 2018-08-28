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
		delete array[reply[i].hour - 9];
		}

		for (var i = 0; i < array.length; i++) {

			if (array[i] != undefined) {
				var option = document.createElement("option");
				option.value = array[i];
				option.text = array[i] + ":00";
				options +=  "<option>" + array[i] + ":00</option>";
			}
		}

		document.getElementById('hours').innerHTML = options;
		console.log(array.toString());
	}

}


function addSession() {
	var userId = sessionStorage.getItem('userId');
	var hour = document.getElementById('hours').value;
	var date = document.getElementById('date').value +"T"+hour +":00";
	var d = new Date(date);
	var tutorId = null;
	hour = hour.replace(':00','');
	console.log(userId);
	console.log(hour);
	console.log(d);
	console.log(date);
	
	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/addSession/'+tutorId+'/' + userId +'/' 
	+ date +'/'+ hour;
	var xhr = new XMLHttpRequest();
	xhr.open("POST", requestURL, true);
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send();
	
	if (userId == null) {
		
		document.getElementById('message').innerHTML = "Please log in before you book a session.";
	}
	else {
		
		document.getElementById('message').innerHTML = "Session booked for " + d;
	}
	
	
}

