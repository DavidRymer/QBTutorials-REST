function setPage() {
	console.log(sessionStorage.getItem('name'));
	var ifSignedIn = "signOut()";
	var ifNotSignedIn = "location.href='/QBTutorials/QB-Website-master/login.html'; " +
			"sessionStorage.removeItem('login result');"

		if (sessionStorage.getItem('name') != null) {

			document.getElementById('welcome').innerHTML = "Logged in as  " + sessionStorage.getItem('name') + "";
			document.getElementById('loginout').setAttribute('value', 'Sign out');
			document.getElementById('loginout').setAttribute('onclick', ifSignedIn);

		}
	
	
	
		else  {
			
			document.getElementById('welcome').innerHTML = 'QB Tutorials';
			document.getElementById('loginout').setAttribute('value', 'Sign in');
			document.getElementById('loginout').setAttribute('onclick', ifNotSignedIn);
		}


}

function signOut() {
	sessionStorage.removeItem('name');
	sessionStorage.removeItem('login result');
	sessionStorage.removeItem('username1');
	sessionStorage.removeItem('userId');
	setPage();
	
}