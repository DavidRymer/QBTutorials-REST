


function login(){
	populateStorage();
	var username = sessionStorage.getItem('username');
    var password = sessionStorage.getItem('password');
	console.log(username);
	console.log(password);

	var hashword = hashCode(password);
	console.log(hashword);
	            var requestURL = 'http://localhost:8080/QBTutorials/qb/web/login/' + username +'/' + hashword;
	            var request = new XMLHttpRequest();
	            request.open('GET', requestURL);
	            request.responseType = 'json';
	            request.send();
	            request.onload = function () {
		            var reply = request.response;
		            console.log(reply.hashword);
		            if (reply.hashword == hashword) {
		            	document.getElementById("logincontainer").innerHTML = "Login Successful!"

		            }
		            else {
		            	alert("login failed, Please try again")

		            }
		            
	            }
	            sessionStorage.clear();
}

function hashCode(str) {
	  return str.split('').reduce((prevHash, currVal) =>
	    (((prevHash << 5) - prevHash) + currVal.charCodeAt(0))|0, 0);
	}

function populateStorage() {
	
	sessionStorage.setItem('username', document.getElementById('username').value);
	sessionStorage.setItem('password', document.getElementById('password').value);

	
}
        