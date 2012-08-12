function outliner() {
	var child = document.all[event.srcElement.getAttribute("child", false)];
	if (null != child) {
		if (child.className == "expanded") {
			child.className = "collapsed";
			document.getElementById("updown1").background = "templates/image/title_bg_up.jpg";
			return;
		}
		if (child.className == "collapsed") {
			child.className = "expanded";
			document.getElementById("updown1").background = "templates/image/title_bg_down.jpg";
			return;
		}
	}
}