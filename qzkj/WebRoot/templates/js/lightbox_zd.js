// JavaScript Document
var isIE = (document.all) ? true : false;
var isIE6 = isIE && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);
function Each(list, fun){
for (var i = 0, len = list.length; i < len; i++) { fun(list[i], i); }
};
var $ = function (id) {
    return "string" == typeof id ? document.getElementById(id) : id;
};
var Class = {
  create: function() {
    return function() {
      this.initialize.apply(this, arguments);
    }
  }
}
Object.extend = function(destination, source) {
  for (var property in source) {
    destination[property] = source[property];
  }
  return destination;
}
Function.prototype.bind = function(object) {
  var __method = this, args = Array.apply(null, arguments); args.shift();
  return function() {
    return __method.apply(object, args);
  }
}
var OverLay = Class.create();
OverLay.prototype = {
  initialize: function(overlay, options) {
this.Lay = $(overlay);//���ǲ�
//ie6���ø��ǲ��С����
this._size =  function(){};
this.SetOptions(options);
this.Color = this.options.Color;
this.Opacity = parseInt(this.options.Opacity);
this.zIndex = parseInt(this.options.zIndex);
this.Set();
  },
  //����Ĭ������
  SetOptions: function(options) {
    this.options = {//Ĭ��ֵ
Color:"#999",//����ɫ
Opacity:50,//͸����(0-100)
zIndex:1000//���˳��
    };
    Object.extend(this.options, options || {});
  },
  //����
  Set: function() {
this.Lay.style.display = "none";
this.Lay.style.zIndex = this.zIndex;
this.Lay.style.left = this.Lay.style.top = 0;
if(isIE6){
this.Lay.style.position = "absolute";
this._size = function(){
this.Lay.style.width = Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth) + "px";
this.Lay.style.height = Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) + "px";
}.bind(this);
//�ڸ�select
this.Lay.innerHTML = '<iframe style="position:absolute;top:0;left:0;width:100%;height:100%;filter:alpha(opacity=0);"></iframe>'
} else {
this.Lay.style.position = "fixed";
this.Lay.style.width = this.Lay.style.height = "100%";
}
  },
  //��ʾ
  Show: function() {
  

//  	  parent.parent.leftFrame.document.all.ly.style.display="block";         
//	  parent.parent.leftFrame.document.all.ly.style.width=205;         
//	  parent.parent.leftFrame.document.all.ly.style.height=1000; 
	  
	 // alert("��ʼִ�У�"+parent.parent.leftFrame.document.all.ly.style+"===");
	  
	//  alert(parent.parent.midFrame.document.all.zdlb.style);
	  
	// this.parent.Lay.style.display="block";         
	// this.parent.Lay.style.width=205;         
	// this.parent.Lay.style.height=1000; 
	    
	  
	  
  
//������ʽ
this.Lay.style.backgroundColor = this.Color;
//����͸����
if(isIE){
this.Lay.style.filter = "alpha(opacity:" + this.Opacity + ")";
} else {
this.Lay.style.opacity = this.Opacity / 100;
}
//����ie6
if(isIE6){ this._size(); window.attachEvent("onresize", this._size); }
this.Lay.style.display = "block";
  },
  //�ر�
  Close: function() {
this.Lay.style.display = "none";
if(isIE6){ window.detachEvent("onresize", this._size); }
  }
};
var LightBox = Class.create();
LightBox.prototype = {
  initialize: function(box, overlay, options) {
this.Box = $(box);//��ʾ��
this.OverLay = new OverLay(overlay, options);//���ǲ�
this.SetOptions(options);
this.Fixed = !!this.options.Fixed;
this.Over = !!this.options.Over;
this.Center = !!this.options.Center;
this.onShow = this.options.onShow;
this.Box.style.zIndex = this.OverLay.zIndex + 1;
this.Box.style.display = "none";
//����ie6�õ�����
if(isIE6){ this._top = this._left = 0; this._select = []; }
  },
  //����Ĭ������
  SetOptions: function(options) {
    this.options = {//Ĭ��ֵ
Fixed:false,//�Ƿ�̶���λ
Over:true,//�Ƿ���ʾ���ǲ�
Center:true,//�Ƿ����
onShow:function(){}//��ʾʱִ��
};
    Object.extend(this.options, options || {});
  },
  //����ie6�Ĺ̶���λ����
  _fixed: function(){
var iTop = this.Box.offsetTop + document.documentElement.scrollTop - this._top, iLeft = this.Box.offsetLeft + document.documentElement.scrollLeft - this._left;
//����ʱ��Ҫ����
if(this.Center){ iTop += this.Box.offsetHeight / 2; iLeft += this.Box.offsetWidth / 2; }
this.Box.style.top = iTop + "px"; this.Box.style.left = iLeft + "px";
this._top = document.documentElement.scrollTop; this._left = document.documentElement.scrollLeft;
  },
  //��ʾ
  Show: function(options) {
//�̶���λ
if(this.Fixed){
if(isIE6){
//����ie6
this.Box.style.position = "absolute";
this._top = document.documentElement.scrollTop; this._left = document.documentElement.scrollLeft;
window.attachEvent("onscroll", this._fixed.bind(this));
} else {
this.Box.style.position = "fixed";
}
} else {
this.Box.style.position = "absolute";
}
//���ǲ�
if(this.Over){
//��ʾ���ǲ㣬���ǲ��Դ�select����
this.OverLay.Show();
} else {
//ie6��Ҫ�Ѳ���Box�ϵ�select����
if(isIE6){
this._select = [];
var oThis = this;
Each(document.getElementsByTagName("select"), function(o){
if(oThis.Box.contains ? !oThis.Box.contains(o) : !(oThis.Box.compareDocumentPosition(o) & 16)){
o.style.visibility = "hidden"; oThis._select.push(o);
}
})
}
}
this.Box.style.display = "block";
//����
if(this.Center){
this.Box.style.top = this.Box.style.left = "50%";
//��ʾ����ܻ�ȡ
var iTop = - this.Box.offsetHeight / 2, iLeft = - this.Box.offsetWidth / 2;
//����fixed��ie6Ҫ����
if(!this.Fixed || isIE6){ iTop += document.documentElement.scrollTop; iLeft += document.documentElement.scrollLeft; }
this.Box.style.marginTop =  iTop + "px"; this.Box.style.marginLeft = iLeft + "px";
}
this.onShow();
  },
  //�ر�
  Close: function() {
this.Box.style.display = "none";
this.OverLay.Close();
if(isIE6){ window.detachEvent("onscroll", this._fixed); Each(this._select, function(o){ o.style.visibility = "visible"; }); }
  }
};
function addEventHandler(oTarget, sEventType, fnHandler) {
if (oTarget.addEventListener) {
oTarget.addEventListener(sEventType, fnHandler, false);
} else if (oTarget.attachEvent) {
oTarget.attachEvent("on" + sEventType, fnHandler);
} else {
oTarget["on" + sEventType] = fnHandler;
}
};
function removeEventHandler(oTarget, sEventType, fnHandler) {
    if (oTarget.removeEventListener) {
        oTarget.removeEventListener(sEventType, fnHandler, false);
    } else if (oTarget.detachEvent) {
        oTarget.detachEvent("on" + sEventType, fnHandler);
    } else { 
        oTarget["on" + sEventType] = null;
    }
};
if(!isIE){
HTMLElement.prototype.__defineGetter__("currentStyle", function () {
return this.ownerDocument.defaultView.getComputedStyle(this, null);
});
}
//�Ϸų���
var Drag = Class.create();
Drag.prototype = {
  //�ϷŶ���,��������
  initialize: function(obj, drag, options) {
    var oThis = this;
this._obj = $(obj);//�ϷŶ���
this.Drag = $(drag);//��������
this._x = this._y = 0;//��¼�������ϷŶ����λ��
//�¼�����(�����Ƴ��¼�)
this._fM = function(e){ oThis.Move(window.event || e); }
this._fS = function(){ oThis.Stop(); }
this.SetOptions(options);
this.Limit = !!this.options.Limit;
this.mxLeft = parseInt(this.options.mxLeft);
this.mxRight = parseInt(this.options.mxRight);
this.mxTop = parseInt(this.options.mxTop);
this.mxBottom = parseInt(this.options.mxBottom);
this.mxContainer = this.options.mxContainer;
this.onMove = this.options.onMove;
this.Lock = !!this.options.Lock;
this._obj.style.position = "absolute";
addEventHandler(this.Drag, "mousedown", function(e){ oThis.Start(window.event || e); });
  },
  //����Ĭ������
  SetOptions: function(options) {
    this.options = {//Ĭ��ֵ
Limit:true,//�Ƿ���������(Ϊtrueʱ�����������,�����Ǹ���)
mxLeft:0,//�������
mxRight:0,//�ұ�����
mxTop:0,//�ϱ�����
mxBottom:0,//�±�����
mxContainer:null,//ָ��������������
onMove:function(){},//�ƶ�ʱִ��
Lock:false//�Ƿ�����
    };
    Object.extend(this.options, options || {});
  },
  //׼���϶�
  Start: function(oEvent) {
if(this.Lock){ return; }
//��¼�������ϷŶ����λ��
this._x = oEvent.clientX - this._obj.offsetLeft;
this._y = oEvent.clientY - this._obj.offsetTop;
//mousemoveʱ�ƶ� mouseupʱֹͣ
addEventHandler(document, "mousemove", this._fM);
addEventHandler(document, "mouseup", this._fS);
//ʹ����Ƶ�������Ҳ���ͷ�
if(isIE){
addEventHandler(this.Drag, "losecapture", this._fS);
this.Drag.setCapture();
}else{
addEventHandler(window, "blur", this._fS);
}
  },
  //�϶�
  Move: function(oEvent) {
window.getSelection && window.getSelection().removeAllRanges();
//��ǰ���λ�ü�ȥ����ϷŶ����λ�õõ�offsetλ��
var iLeft = oEvent.clientX - this._x, iTop = oEvent.clientY - this._y;
//���÷�Χ����
if(this.Limit){
//�������������,��Ϊ������С���ܻ�仯����ÿ�ζ�Ҫ��
if(!!this.mxContainer){
this.mxLeft = this.mxTop = 0;
this.mxRight = this.mxContainer.clientWidth;
this.mxBottom = this.mxContainer.clientHeight;
}
//��ȡ��������
var iRight = iLeft + this._obj.offsetWidth - this.mxRight, iBottom = iTop + this._obj.offsetHeight - this.mxBottom;
//�������������ұ��±�����������ϱ�,���ܻ᲻׼ȷ
if(iRight > 0) iLeft -= iRight;
if(iBottom > 0) iTop -= iBottom;
if(this.mxLeft > iLeft) iLeft = this.mxLeft;
if(this.mxTop > iTop) iTop = this.mxTop;
}
//����λ��
//����offset�ǰ�marginҲ���ȥ������Ҫ��ȥ
this._obj.style.left = iLeft - (parseInt(this._obj.currentStyle.marginLeft) || 0) + "px";
this._obj.style.top = iTop - (parseInt(this._obj.currentStyle.marginTop) || 0) + "px";
//���ӳ���
this.onMove();
  },
  //ֹͣ�϶�
  Stop: function() {
//�Ƴ��¼�
removeEventHandler(document, "mousemove", this._fM);
removeEventHandler(document, "mouseup", this._fS);
if(isIE){
removeEventHandler(this.Drag, "losecapture", this._fS);
this.Drag.releaseCapture();
}else{
removeEventHandler(window, "blur", this._fS);
}
  }
};
