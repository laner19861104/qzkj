// JavaScript Document
function onloadEvent(func){
	var one=window.onload;
	if(typeof window.onload!='function'){
		window.onload=func;
	}
	else{
		window.onload=function(){
			one();
			func();
		}
	}
}
function showtable(){
	var overcolor='#FCF9D8'; 
	var color1='#F8F8F8';  
	var color2='#FFFFFF'; 
		
	for(var j=0;j<=tableidArray.length-1;j++){		
		var tablename=document.getElementById(tableidArray[j]);
		if(tablename!=null){
			var tr=tablename.getElementsByTagName("tr");
			if(tr!=null){
				for(var i=1 ;i<tr.length;i++){
						if(i%2==0){
							tr[i].className="color1";
				}else{
					tr[i].className="color2";
				}
				tr[i].onmouseover=function(){
					this.style.backgroundColor=overcolor;
				}
				tr[i].onmouseout=function(){
					if(this.rowIndex%2==0){
						this.style.backgroundColor=color1;
					}else{
						this.style.backgroundColor=color2;
					}
				}
			}
		}
	}
	}	
}

