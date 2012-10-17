document.write("<meta http-equiv='X-UA-Compatible' content='IE=EmulateIE7' />");
/*—°œÓø®*/
function setTab(name,cursel,n){setTimeout(function(){for(i=1;i<=n;i++){var menu=document.getElementById(name+i);var con=document.getElementById("con_"+name+"_"+i);menu.className=i==cursel?"hover":"";con.style.display=i==cursel?"block":"none";}},200)}
//<a href="javascript:AddToShoppingCart(70726112002)">π∫¬Ú</a>
function AddToShoppingCart(ProdID)
{url = "http://member.chinaacc.com/shop/putbook.shtm?cpbm="+ProdID+"&t=1";popup = window.open(url,"","height=400,width=778,left=10,top=10,resizable=yes,scrollbars=yes,status=yes,toolbar=yes,menubar=yes,location=yes");}
//<a href="javascript:preview(70726112002)"><font color="#003399">œÍœ∏ΩÈ…‹</font ></a>
function preview(productID) { window.open("http://member.chinaacc.com/shop/preview.shtm?productID="+productID,"","height=500,width=630,left=190,top=0,resizable=yes,scrollbars=yes,status=no,toolbar=no,menubar=no,location=no");}
/* ◊“≥¿œ ¶*/
function scrollggpic(bigbox,smallbox,sd,location){var speeda = 5; var oMarqueea = document.getElementById(bigbox);var omqdemoa = document.getElementById(smallbox);var ha = oMarqueea.offsetHeight;var odla = omqdemoa.offsetHeight;var xa = parseInt(ha/odla)+1;for(var m=0;m<xa;m++){var oa = omqdemoa.cloneNode(true);oMarqueea.appendChild(oa);}var myMara;function scrolla(){oMarqueea.scrollTop += iScrollAmount[location];var ola = oMarqueea.scrollTop;if(odla-ola<=0){window.clearTimeout(myMara);oMarqueea.scrollTop = 0;}else{if(ola%ha!=0){myMara = window.setTimeout(scrolla,speeda);}else{window.clearTimeout(myMara);}}}var ta = sd;function clipShowa(){scrolla();window.setTimeout(clipShowa,ta);}window.setTimeout(clipShowa,ta);}var iScrollAmount = new Array(1,1);
/*πˆ∂Ø¥˙¬Î*/
function scrollgg(bigbox,onebox,twobox,sd){var speed=sd;document.getElementById(twobox).innerHTML=document.getElementById(onebox).innerHTML;function Marquee2(){if(document.getElementById(twobox).offsetTop-document.getElementById(bigbox).scrollTop<=0)document.getElementById(bigbox).scrollTop-=document.getElementById(onebox).offsetHeight;else{document.getElementById(bigbox).scrollTop++;}}var MyMar2=setInterval(Marquee2,speed);document.getElementById(bigbox).onmouseover=function() {clearInterval(MyMar2)};document.getElementById(bigbox).onmouseout=function() {MyMar2=setInterval(Marquee2,speed)};}
/*◊Û”“πˆ∂Ø*/
function picleft(demo,demo1,demo2,sd){var speed=sd;var tab=document.getElementById(demo);var tab1=document.getElementById(demo1);var tab2=document.getElementById(demo2);tab2.innerHTML=tab1.innerHTML;function Marquee(){if(tab2.offsetWidth-tab.scrollLeft<=0){tab.scrollLeft-=tab1.offsetWidth}else{tab.scrollLeft++;}}var MyMar=setInterval(Marquee,speed);tab.onmouseover=function() {clearInterval(MyMar)};tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};}

/*<a href="javascript:AddToShoppingCart(70726112002)">π∫¬Ú</a>
function AddToShoppingCart(ProdID)
{
	url = "http://member.chinaacc.com/shop/put.shtm?cpbm="+ProdID+"&t=1";	
	popup = window.open(url,"","height=400,width=778,left=10,top=10,resizable=yes,scrollbars=yes,status=yes,toolbar=yes,menubar=yes,location=yes");
}
*/
/*<a href="javascript:preview(70726112002)"><font color="#003399">œÍœ∏ΩÈ…‹</font ></a>*/
function preview(productID) { window.open("http://member.chinaacc.com/shop/preview.shtm?productID="+productID,"","height=500,width=630,left=190,top=0,resizable=yes,scrollbars=yes,status=no,toolbar=no,menubar=no,location=no");}

/*ª¨∂Ø√≈*/
function showsub_a(id)
	{
		for (i = 0;i<3;i++)
		{
			document.getElementById("tab_a"+i).className = "";
			document.getElementById("sub_a"+i).style.display = "none";
		}
			document.getElementById("tab_a"+id).className = "dqtit";
			document.getElementById("sub_a"+id).style.display = "";
	}