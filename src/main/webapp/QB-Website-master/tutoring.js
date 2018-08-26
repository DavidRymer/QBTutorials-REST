
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
		
		var myDiv = document.getElementById("myDiv");
		var myLabel = document.createElement("label");
		myLabel.textContent = "Time";

		var selectList = document.createElement("select");
		selectList.id = "mySelect";
		
		myDiv.appendChild(myLabel);
		myDiv.appendChild(selectList);
		

		//Create and append the options
		for (var i = 0; i < reply.length; i++) {
		    var option = document.createElement("option");
		    option.value = reply[i].hour;
		    option.text = reply[i].hour + ":00";
		    selectList.appendChild(option);
		}


	}

}