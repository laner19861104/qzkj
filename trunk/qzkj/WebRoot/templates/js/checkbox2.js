function Toggle2(e) {
	if (e.checked) {
		document.listForm.toggleAll2.checked = AllChecked();
	} else {
		document.listForm.toggleAll2.checked = false;
	}
}

function ToggleAll2(e) {
	if (e.checked) {
		CheckAll2();
	} else {
		ClearAll2();
	}
}

function AllChecked2() {
	ll = document.listForm;
	len = ll.elements.length;
	for ( var i = 0; i < len; i++) {
		if (ll.elements[i].name == "checkid2" && !ll.elements[i].checked) {
			return false;
		}
	}
	return true;
}
function CheckAll2() {
	var ll = document.listForm;
	var len = ll.elements.length;
	for ( var i = 0; i < len; i++) {
		var e = ll.elements[i];
		if (e.name == "checkid2") {
			Check2(e);
		}
	}
	ll.toggleAll2.checked = true;
}

function ClearAll2() {
	var ll = document.listForm;
	var len = ll.elements.length;
	for ( var i = 0; i < len; i++) {
		var e = ll.elements[i];
		if (e.name == "checkid2") {
			Clear2(e);
		}
	}
	ll.toggleAll2.checked = false;
}

function Check2(e) {
	e.checked = true;
}

function Clear2(e) {
	e.checked = false;
}
function selectOption2(selobject,objectvalue)
{
for(var i=0;i<selobject.options.length;i++)
{
 if(selobject.options[i].value==objectvalue)
 {
 selobject.options[i].selected=true;
 }
}
};
