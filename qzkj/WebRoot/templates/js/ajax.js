var http_request = false;
function send_request(url) {
  http_request = false;
  
    if(window.XMLHttpRequest) { 
		http_request = new XMLHttpRequest();
		if (http_request.overrideMimeType) {
	       http_request.overrideMimeType("text/xml");
		}
    }
    else if (window.ActiveXObject) {
		try {
			http_request = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				http_request = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}

	if (!http_request) { 
		window.alert("Cannot creat XMLHttpRequest.");
		return false;
	}
	http_request.onreadystatechange = processRequest;
	http_request.open("GET", url, true);
	http_request.send(null);
}

/*
function processRequest() {
	if (http_request.readyState == 4) {
		if (http_request.status == 200) { 
    	  document.getElementById("showCompanyDiv").innerHTML=http_request.responseText;

		} 
	}
}*/