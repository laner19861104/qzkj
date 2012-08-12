var XMLHttpReq;
    var currentSort;
     //����XMLHttpRequest����       
    function createXMLHttpRequest() {
        if(window.XMLHttpRequest) { //Mozilla �����
            XMLHttpReq = new XMLHttpRequest();
        }
        else if (window.ActiveXObject) { // IE�����
            try {
                XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }
        }
    }
    //����������
    function sendRequest(url) {
         createXMLHttpRequest();
        
        var araea_value = document.getElementsByName("search_area")[0].value;
        var class_value = document.getElementsByName("search_class")[0].value;        
        
        XMLHttpReq.open("post", url, true);   
		XMLHttpReq.setRequestHeader("Content-Type","application/x-www-form-urlencoded");   
        XMLHttpReq.onreadystatechange = processResponse;//ָ����Ӧ����
        XMLHttpReq.send('search_area='+araea_value+'&search_class='+class_value);  // ��������
    }
    // ��������Ϣ����
    function processResponse() {
        if (XMLHttpReq.readyState == 4) { // �ж϶���״̬
            if (XMLHttpReq.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
                updateMenu();
            } else { //ҳ�治����
                  alert("���������ҳ�����쳣��");
            }
        }
    }
    //���²˵�����
    function updateMenu() {
        var resbh=XMLHttpReq.responseXML.getElementsByTagName("resbh");
        var resmc=XMLHttpReq.responseXML.getElementsByTagName("resmc");
        /**��������innerHTML����ؼ����ݵ�һ���÷�**/
        
        var list = document.all.search_enterprise;
        list.options.length=0;
        //list.add(new Option("---��ѡ��---",""));
        for(var i=0;i<resbh.length;i++){
            list.add(new Option(resmc[i].firstChild.data,resbh[i].firstChild.data));
        }
    }
    // ���������˵�����
    function showSubMenu(obj) {
        //currentSort =document.getElementById(obj); 
        //currentSort.parentNode.style.display = "";
//    	alert("obj:  "+obj);
        sendRequest("searchEnterprise.action");
        /**������һ��������ǣ�ÿ��ѡ���ص���һ��ѡ��**/
        //document.all.mli.options[0].selected=true;
    }
