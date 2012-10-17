function changeMenu(arg){
	var obj =$("#"+arg);
	obj.addClass("slt");
	obj.html(obj.children().children());
}	