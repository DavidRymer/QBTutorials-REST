function register(){
	
	
	var username = document.getElementById('username').value;
	var password = document.getElementById('password').value;
	var firstname = document.getElementById('firstname').value;
	var lastname = document.getElementById('lastname').value;
	var email = document.getElementById('email').value;
	var repeat = document.getElementById('repeatpassword').value;
	var res = sessionStorage.getItem('page');
	
	checkPassword();
	
	if (res != "dupe user" && res != "dupe email") {
		sessionStorage.setItem('page', 'success');
		
	}
	console.log(sessionStorage.getItem('page')+"3");

	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/register/' + username +'/' 
	+ password+'/'+ firstname +'/' + lastname +'/'+ email;
	var xhr = new XMLHttpRequest();
	xhr.open("POST", requestURL, false);
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send();
	
	
	

}

function checkUsername(){

	var username = document.getElementById('username').value;

	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/login/' + username;
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		var reply = request.response;
		
		if (reply != null) {
			
			sessionStorage.setItem('page', "dupe user");
				
		}
		
		console.log(sessionStorage.getItem('page')+"1");


	}

}

function checkEmail(){
	
	var email = document.getElementById('email').value;

	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/getEmail/' + email;
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		var reply = request.response;
		
		if (reply != null) {

			sessionStorage.setItem('page', "dupe email");

		}
		
	console.log(sessionStorage.getItem('page')+"2");

	}

}

function checkPassword() {
	
	
	var pass = document.getElementById('password').value;
	var repeatPass = document.getElementById('repeatpassword').value;
	
	if (pass != repeatPass) {
		
		sessionStorage.setItem('page', "pass fail");
	}
	
	
}

function setPage() {
	var result = sessionStorage.getItem('page');
	
	switch (result) {
	case "dupe email":
		document.getElementById("outcome").innerHTML = "Email is already in use.";
		document.getElementById("message").innerHTML = "Please select a different email.";
		break;
	case "dupe user":
		document.getElementById("outcome").innerHTML = "Username is already in use.";
		document.getElementById("message").innerHTML = "Please select a different username.";
		break;
	case "success":
		document.getElementById("outcome").innerHTML = "Account creation successful!";
		document.getElementById("message").innerHTML = "Enjoy our site.";
		break;
	case "pass fail":
		document.getElementById("outcome").innerHTML = "Passwords do not match!";
		document.getElementById("message").innerHTML = "Please enter matching passwords.";
		break;
	}
	sessionStorage.clear();
	
	
		
	

}






function populateStorage() {

	sessionStorage.setItem('username', document.getElementById('username').value);
	sessionStorage.setItem('password', document.getElementById('password').value);
	sessionStorage.setItem('firstname', document.getElementById('firstname').value);
	sessionStorage.setItem('lastname', document.getElementById('lastname').value);
	sessionStorage.setItem('email', document.getElementById('email').value);
	sessionStorage.setItem('repeatpassword', document.getElementById('repeatpassword').value);


}