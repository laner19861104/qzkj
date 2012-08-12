 var xmldoc; 

function createxmldoc(){ 
if(window.XMLHttpRequest){ 
xmldoc = new XMLHttpRequest(); 
if(xmldoc.overrideMimeType){ 
xmldoc.overrideMimeType("text/xml"); 
} 
}else if(window.ActiveXObject){ 
try{ 
xmldoc = new ActiveXObject("Msxml4.XMLHTTP"); 
}catch(e){ 
try{ 
xmldoc = new ActiveXObject("Msxml3.XMLHTTP"); 
}catch(e){ 
try{ 
xmldoc = new ActiveXObject("Msxml2.XMLHTTP"); 
}catch(e){ 
try{ 
xmldoc = new ActiveXObject("Microsoft.XMLHTTP"); 
}catch(e){} 
} 
} 
} 
} 
if(!xmldoc){ 
return false; 
} 
}
