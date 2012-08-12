var XMLHttpReq;
    var currentSort;
     //创建XMLHttpRequest对象       
    function createXMLHttpRequest() {
        if(window.XMLHttpRequest) { //Mozilla 浏览器
            XMLHttpReq = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) { // IE浏览器
            try {
                XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }
        }
    }
    //发送请求函数
    function sendRequest(url) {
         createXMLHttpRequest();
        
        var araea_value = document.getElementsByName("search_area")[0].value;
        var class_value = document.getElementsByName("search_class")[0].value;        
        
        XMLHttpReq.open("post", url, true);   
		XMLHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");   
        XMLHttpReq.onreadystatechange = processResponse;//指定响应函数
        XMLHttpReq.send('search_area='+araea_value+'&search_class='+class_value);  // 发送请求
    }
    // 处理返回信息函数
    function processResponse() {
        if (XMLHttpReq.readyState == 4) { // 判断对象状态
            if (XMLHttpReq.status == 200) { // 信息已经成功返回，开始处理信息
                updateMenu();
            } else { //页面不正常
                  alert("您所请求的页面有异常。");
            }
        }
    }
    //更新菜单函数
    function updateMenu() {
        var resbh=XMLHttpReq.responseXML.getElementsByTagName("resbh");
        var resmc=XMLHttpReq.responseXML.getElementsByTagName("resmc");
        /**下面是用innerHTML输出控件内容的一般用法**/
        
        var list = document.all.search_enterprise;
        list.options.length=0;
        //list.add(new Option("---请选择---",""));
        for(var i=0;i<resbh.length;i++){
            list.add(new Option(resmc[i].firstChild.data,resbh[i].firstChild.data));
        }
    }
    // 创建级联菜单函数
    function showSubMenu(obj) {
        //currentSort =document.getElementById(obj); 
        //currentSort.parentNode.style.display = "";
//    	alert("obj:  "+obj);
        sendRequest("searchEnterprise.action");
        /**下面这一句的作用是：每次选择后回到第一个选项**/
        //document.all.mli.options[0].selected=true;
    }
