



function register(){
	populateStorage();
	var username = sessionStorage.getItem('username', document.getElementById('username').value);
	var password = sessionStorage.getItem('password', document.getElementById('password').value);
	var firstname = sessionStorage.getItem('firstname', document.getElementById('firstname').value);
	var lastname = sessionStorage.getItem('lastname', document.getElementById('lastname').value);
	var email = sessionStorage.getItem('email', document.getElementById('email').value);
	var repeat = sessionStorage.getItem('repeatpassword', document.getElementById('repeatpassword').value);


	
	var requestURL = 'http://localhost:8080/QBTutorials/qb/web/register/' + username +'/' 
	+ password+'/'+ firstname +'/' + lastname +'/'+ email;
	var xhr = new XMLHttpRequest();
	xhr.open("POST", requestURL, true);
	xhr.setRequestHeader('Content-Type', 'application/json');
	xhr.send();
	
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

	