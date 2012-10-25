function init(date) {
	var str;
	if(date!=undefined&&date!="")
		{
		str=date.split('-');
		}
	for ( var i = new Date().getYear(); i > 1920; i--) {
		var newitem = new Option(i, i);
		if(i==str[0])
			newitem.selected='selected';
		var obj = document.getElementById("year1")
		obj.options.add(newitem)
	}
	for ( var i = 1; i < 13; i++) {
		var newitem = new Option(i < 10 ? "0" + i : i, i < 10 ? "0" + i : i);
		var obj = document.getElementById("month1")
		if(i==str[1])
			newitem.selected='selected';
		obj.options.add(newitem)
	}
	for ( var i = 1; i < 32; i++) {
		var newitem = new Option(i < 10 ? "0" + i : i,i < 10 ? "0" + i : i);
		var obj = document.getElementById("date1")
		if(i==str[2])
			newitem.selected='selected';
		obj.options.add(newitem)
	}
}
function selectedMonth(month,year) {
	var obj = document.getElementById("date1")
	obj.options.length=0;
	var days=0;
	if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
		days=29
		else
			days=28
	if (month == 2) {
		for ( var i = 1; i < 30; i++) {
			var newitem = new Option(i < 10 ? "0" + i : i, i);
			obj.options.add(newitem)
		}
	} else if (month == 4 || month == 6 || month == 9 || month == 11) {
		for ( var i = 1; i < 31; i++) {
			var newitem = new Option(i < 10 ? "0" + i : i, i);
			obj.options.add(newitem)
		}
	} else {
		for ( var i = 1; i < 32; i++) {
			var newitem = new Option(i < 10 ? "0" + i : i, i);
			obj.options.add(newitem)
		}
	}
}