
var section = document.querySelector("section");
var reply = null;
var score = 0;
var ana = "ff";

var topic = "trigonometry";
var difficulty = "medium";
var level = "gcse";


function getQuestionLineId() {

	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/getQuestionLine/' + topic + "/" + difficulty + "/" + level;
	var request = new XMLHttpRequest();
    request.open('GET', requestURL);
    request.responseType = 'json';
    request.send();
    request.onload = function anatest() {
    	var reply1 = request.response;
    	console.log(reply1.question_line_id);
        var myH1 = document.createElement('h1');
        myH1.textContent = reply1.question_line_id;
        document.getElementsByTagName('section')[0].appendChild(myH1);
        ana = reply1.question_line_id;
        
    }

   
}

function getQuestions(){
    getQuestionLineId();
	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/getQuestion/' + ana;
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		reply = request.response;

		for (var i = 0; i < reply.length; i++ ) {
			var myH1 = document.createElement('h3');
			var myTextbox = document.createElement('input');
			var myButton = document.createElement('button');
			myButton.innerHTML = "Check";
				myTextbox.type = 'text';
			myTextbox.setAttribute("id", "textbox" + i);
			myButton.setAttribute("onclick", "check("+i+")");
			myButton.setAttribute("id", "button" + i)
			myButton.setAttribute("class", "registerbtn1")

			myH1.textContent = reply[i].question;
			section.appendChild(myH1);
			section.appendChild(myTextbox);
			section.appendChild(myButton);
		}

		var myScore = document.createElement('p');
		myScore.setAttribute("id", "score");
		var submitButton = document.createElement('button');
		submitButton.innerHTML = "Submit test"
		submitButton.setAttribute("onclick", "calculateScore()");
		submitButton.setAttribute("class", "registerbtn2")
		section.appendChild(submitButton);
		section.appendChild(myScore);

	}
}

function check(p1) {
	if (document.getElementById("textbox"+p1).value == reply[p1].answer) {

		document.getElementById("button"+p1).innerHTML = "Correct!";
		document.getElementById("textbox"+p1).disabled = true;
		document.getElementById("button"+p1).disabled = true;
		document.getElementById("button" + p1).setAttribute("class", "correctbtn");
		score++;

	}
	else {

		document.getElementById("button"+p1).innerHTML = "Incorrect!";
		document.getElementById("textbox"+p1).disabled = true;
		document.getElementById("button"+p1).disabled = true;
		document.getElementById("button" + p1).setAttribute("class", "incorrectbtn");

	}
}
function calculateScore() {

	document.getElementById('score').innerHTML = "Your scored "+ ((score/reply.length) * 100).toFixed(2) + "%";

}
        