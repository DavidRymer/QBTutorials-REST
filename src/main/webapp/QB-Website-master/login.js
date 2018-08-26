


function login(){
	populateStorage();
	var username = sessionStorage.getItem('username1');
    var password = sessionStorage.getItem('password1');
	console.log(username);
	console.log(password);

	var hashword = hashCode(password);
	console.log(hashword);
	            var requestURL = 'http://localhost:8080/QBTutorials/qb/web/login/' + username;
	            var request = new XMLHttpRequest();
	            request.open('GET', requestURL);
	            request.responseType = 'json';
	            request.send();
	            request.onload = function () {
		            var reply = request.response;
	                   
		            if (reply == null) {
		            	
		            	sessionStorage.clear();
		            	sessionStorage.setItem('login result', "failed username");
		            	
		            }
		            else if (reply.hashword != hashword && reply !=null) {
		            	
		            	sessionStorage.clear();
		            	sessionStorage.setItem('login result', "failed pass");
		            	
		            }
		            
		            else if (reply.hashword == hashword && reply !=null) {

		            	sessionStorage.clear();
		            	sessionStorage.setItem('name', reply.first_name)
		            	sessionStorage.setItem('username1', reply.username);
		            	sessionStorage.setItem('userId', reply.user_id);;
		            	sessionStorage.setItem('login result', "success");
		            	

		            }
		            
		           
		         
		            
	            }
	            
}

function setPage() {
	var result = sessionStorage.getItem('login result');
	
	switch (result) {
	case "failed username":
		document.getElementById("login").innerHTML = "Login Failed!"
		document.getElementById("message").innerHTML = "User does not exist.";
		break;
	case "failed pass":
    	document.getElementById("login").innerHTML = "Login Failed!"
	    document.getElementById("message").innerHTML = "Incorrect password.";
		break;
	case "success":
    	document.getElementById("login").innerHTML = "Login Successful!"
        document.getElementById("message").innerHTML = "Welcome back " +reply.first_name +".";

	}
	
	
	


}

function hashCode(str) {
	  return str.split('').reduce((prevHash, currVal) =>
	    (((prevHash << 5) - prevHash) + currVal.charCodeAt(0))|0, 0);
	}

function populateStorage() {
	
	sessionStorage.setItem('username1', document.getElementById('username').value);
	sessionStorage.setItem('password1', document.getElementById('password').value);

	
}
        