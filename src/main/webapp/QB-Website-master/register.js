
function register(){
	
	populateStorage();
	var username = sessionStorage.getItem('username', document.getElementById('username').value);
	var password = sessionStorage.getItem('password', document.getElementById('password').value);
	var firstname = sessionStorage.getItem('firstname', document.getElementById('firstname').value);
	var lastname = sessionStorage.getItem('lastname', document.getElementById('lastname').value);
	var email = sessionStorage.getItem('email', document.getElementById('email').value);
	var repeat = sessionStorage.getItem('repeatpassword', document.getElementById('repeatpassword').value);
	
	checkUsername();
	checkEmail();
	checkPassword();

	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/register/' + username +'/' 
	+ password+'/'+ firstname +'/' + lastname +'/'+ email;
	var xhr = new XMLHttpRequest();
	xhr.open("POST", requestURL, true);
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send();
	
	
	

}

function checkUsername(){
	populateStorage();
	var username = sessionStorage.getItem('username', document.getElementById('username').value);

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
		else {
			sessionStorage.setItem('page', "success");
			
		}


	}

}

function checkEmail(){
	populateStorage();
	var email = sessionStorage.getItem('email', document.getElementById('email').value);

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
		
	

	}

}

function checkPassword() {
	
	populateStorage();
	var pass = sessionStorage.setItem('password');
	var repeatPass = sessionStorage.setItem('repeatpassword');
	
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
	case "pass fail":
		document.getElementById("outcome").innerHTML = "Passwords do not match!";
		document.getElementById("message").innerHTML = "Please enter matching passwords.";
	}
	
	if (sessionStorage.getItem('name') != null) {

		sessionStorage.removeItem('page');
	}
	else {
		sessionStorage.clear();
	}

}






function populateStorage() {

	sessionStorage.setItem('username', document.getElementById('username').value);
	sessionStorage.setItem('password', document.getElementById('password').value);
	sessionStorage.setItem('firstname', document.getElementById('firstname').value);
	sessionStorage.setItem('lastname', document.getElementById('lastname').value);
	sessionStorage.setItem('email', document.getElementById('email').value);
	sessionStorage.setItem('repeatpassword', document.getElementById('repeatpassword').value);


}
	