<!-- 1. The <iframe> (and video player) will replace this <div> tag. -->



// 2. This code loads the IFrame Player API code asynchronously.
var tag = document.createElement('script');

tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 3. This function creates an <iframe> (and YouTube player)
//    after the API code downloads.
var player;
function onYouTubeIframeAPIReady(vidId) {
	player = new YT.Player('player', {
		height: '390',
		width: '640',
		videoId: "iTt3TVjsjuY",
		events: {
			'onReady': onPlayerReady,
		}
	});
}

// 4. The API will call this function when the video player is ready.
function onPlayerReady(event) {
	event.target.playVideo();
}

// 5. The API calls this function when the player's state changes.
//    The function indicates that when playing a video (state=1),
//    the player should play for six seconds and then stop.
var done = false;
function onPlayerStateChange(event) {
	if (event.data == YT.PlayerState.PLAYING && !done) {
		setTimeout(stopVideo, 6000);
		done = true;
	}
}
function stopVideo() {
	player.stopVideo();
}

// After the API loads, call a function to enable the search box.
function handleAPILoaded() {
	$('#search-button').attr('disabled', false);
}

// Search for a specified string.
function search() {
	var q = $('#query').val();
	var request = gapi.client.youtube.search.list({
		q: q,
		part: 'snippet'
	});

	request.execute(function(response) {
		var str = JSON.stringify(response.result);
		$('#search-container').html('<pre>' + str + '</pre>');
	});
}


function youtube(){
	sessionStorage.setItem('topic', document.getElementById('town').value);
	console.log(sessionStorage.getItem('topic') + "fdf");
	var requestURL = "https://www.googleapis.com/youtube/v3/search?" +
	"part=snippet&maxResults=1&q="+ sessionStorage.getItem('topic') + " gcse maths" +"&key=AIzaSyBgTllnRFlB0K1oOxuWdXzoVt1uEu_E8rM"
	console.log(requestURL);
	var request = new XMLHttpRequest();
	request.open('GET', requestURL);
	request.responseType = 'json';
	request.send();
	request.onload = function () {
		var reply = request.response;
		var vidId = reply.items[0].id.videoId;
		console.log(vidId);
		sessionStorage.setItem('videoId', vidId);
		setPage();

	}

}
function setPage() {

	

		document.getElementById('vid').src = 'https://www.youtube.com/embed/' + sessionStorage.getItem('videoId');
		document.getElementById('vid').width = "560";
		document.getElementById('vid').height = "315";
	
	if (document.getElementById('town').value == "" || document.getElementById('prov').value == "") {
		
		document.getElementById("outcome").innerHTML = "Search failed";
		document.getElementById("message").innerHTML = "Please fill in all of the boxes.";
		document.getElementById('vid').src = '';
	}
		
	sessionStorage.removeItem('topic');
	sessionStorage.removeItem('vid');

}

