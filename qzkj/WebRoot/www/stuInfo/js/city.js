var AreaMap = function(provinceid,cityid){
    
    var cityid = cityid;
    var provinceid = provinceid;
    var cityname;
    var provincename;
    
    var map = new Array(35);
        map[0]= new comefrom("��ѡ��ʡ����","��ѡ�������");
        map[1] = new comefrom("����","����|����|����|����|����|��̨|ʯ��ɽ|��ͷ��|��ɽ|ͨ��|˳��|��ƽ|����|ƽ��|����|����|����"); 
        map[2] = new comefrom("�Ϻ�","����|¬��|���|����|����|����|բ��|���|����|����|��ɽ|�ζ�|�ֶ�|��ɽ|�ɽ�|����|�ϻ�|����|����"); 
        map[3] = new comefrom("���","��ƽ|����|�Ӷ�|����|����|����|�Ͽ�|����|�ӱ�|����|����|����|����|���|����|����|����|����"); 
        map[4] = new comefrom("����","����|����|����|��ɿ�|����|ɳƺ��|������|�ϰ�|����|��ʢ|˫��|�山|����|ǭ��|����|�뽭|����|ͭ��|����|�ٲ�|��ɽ|��ƽ|�ǿ�|�ᶼ|�潭|��¡|����|����|����|���|��ɽ|��Ϫ|ʯ��|��ɽ|����|��ˮ|����|�ϴ�|����|�ϴ�"); 
        map[5] = new comefrom("�ӱ�","ʯ��ׯ|����|��̨|����|�żҿ�|�е�|�ȷ�|��ɽ|�ػʵ�|����|��ˮ"); 
        map[6] = new comefrom("ɽ��","̫ԭ|��ͬ|��Ȫ|����|����|˷��|����|����|����|�ٷ�|�˳�"); 
        map[7] = new comefrom("���ɹ�","���ͺ���|��ͷ|�ں�|���|���ױ�����|��������|����ľ��|�˰���|�����첼��|���ֹ�����|�����׶���|��������"); 
        map[8] = new comefrom("����","����|����|��ɽ|��˳|��Ϫ|����|����|Ӫ��|����|����|�̽�|����|����|��«��"); 
        map[9] = new comefrom("����","����|����|��ƽ|��Դ|ͨ��|��ɽ|��ԭ|�׳�|�ӱ�"); 
        map[10] = new comefrom("������","������|�������|ĵ����|��ľ˹|����|�绯|�׸�|����|�ں�|˫Ѽɽ|����|��̨��|���˰���"); 
        map[11] = new comefrom("����","�Ͼ�|��|����|��ͨ|����|�γ�|����|���Ƹ�|����|����|��Ǩ|̩��|����"); 
        map[12] = new comefrom("�㽭","����|����|����|����|����|����|��|����|��ɽ|̨��|��ˮ"); 
        map[13] = new comefrom("����","�Ϸ�|�ߺ�|����|����ɽ|����|ͭ��|����|��ɽ|����|����|����|����|����|����|����|����|����"); 
        map[14] = new comefrom("����","����|����|����|����|Ȫ��|����|��ƽ|����|����"); 
        map[15] = new comefrom("����","�ϲ���|������|�Ž�|ӥ̶|Ƽ��|����|����|����|�˴�|����|����"); 
        map[16] = new comefrom("ɽ��","����|�ൺ|�Ͳ�|��ׯ|��Ӫ|��̨|Ϋ��|����|̩��|����|����|����|����|����|�ĳ�|����|����"); 
        map[17] = new comefrom("����","֣��|����|����|ƽ��ɽ|����|�ױ�|����|����|���|����|���|����Ͽ|����|����|����|�ܿ�|פ����|��Դ"); 
        map[18] = new comefrom("����","�人|�˲�|����|�差|��ʯ|����|�Ƹ�|ʮ��|��ʩ|Ǳ��|����|����|����|����|Т��|����");
        map[19] = new comefrom("����","��ɳ|����|����|��̶|����|����|����|����|¦��|����|����|����|����|�żҽ�"); 
        map[20] = new comefrom("�㶫","����|����|�麣|��ͷ|��ݸ|��ɽ|��ɽ|�ع�|����|տ��|ï��|����|����|÷��|��β|��Դ|����|��Զ|����|����|�Ƹ�"); 
        map[21] = new comefrom("����","����|����|����|����|����|���Ǹ�|����|���|����|��������|���ݵ���|����|��ɫ|�ӳ�"); 
        map[22] = new comefrom("����","����|����"); 
        map[23] = new comefrom("�Ĵ�","�ɶ�|����|����|�Թ�|��֦��|��Ԫ|�ڽ�|��ɽ|�ϳ�|�˱�|�㰲|�ﴨ|�Ű�|üɽ|����|��ɽ|����"); 
        map[24] = new comefrom("����","����|����ˮ|����|��˳|ͭ��|ǭ����|�Ͻ�|ǭ����|ǭ��"); 
        map[25] = new comefrom("����","����|����|����|��Ϫ|��ͨ|����|���|��ɽ|˼é|��˫����|��ɽ|�º�|����|ŭ��|����|�ٲ�");
        map[26] = new comefrom("����","����|�տ���|ɽ��|��֥|����|����|����"); 
        map[27] = new comefrom("����","����|����|����|ͭ��|μ��|�Ӱ�|����|����|����|����"); 
        map[28] = new comefrom("����","����|������|���|����|��ˮ|��Ȫ|��Ҵ|����|����|¤��|ƽ��|����|����|����"); 
        map[29] = new comefrom("����","����|ʯ��ɽ|����|��ԭ"); 
        map[30] = new comefrom("�ຣ","����|����|����|����|����|����|����|����"); 
        map[31] = new comefrom("�½�","��³ľ��|ʯ����|��������|����|��������|����|�������տ¶�����|��������|��³��|����|��ʲ|����|������"); 
        map[32] = new comefrom("���","���"); 
        map[33] = new comefrom("����","����"); 
        map[34] = new comefrom("̨��","̨��|����|̨��|̨��|����|��Ͷ|����|����|�û�|����|����|����|��԰|����|��¡|̨��|����|����|���"); 
        map[35] = new comefrom("����","������|������|����|����|ŷ��|������");
    
    function $(id){return document.getElementById(id);}
    function comefrom(provinces,citys){this.provinces=provinces;this.citys=citys;}
    
    return{
        province:function(provincename,cityname){
           provincename = provincename;
           cityname = cityname;
           $(provinceid).options.length = 0;
           for(i=0;i<map.length;i++){
                $(provinceid).options.add(new Option(map[i].provinces, map[i].provinces)); 
           }
           if(provincename!='' && cityname!=''){
                 $(provinceid).value = provincename;
              this.city(provincename);
              $(cityid).value = cityname;  
           }
        },
        city:function(provincename){
            $(cityid).options.length = 0;
            for(i=0;i<map.length;i++){
                if(map[i].provinces==provincename){
                    var citys = (map[i].citys).split("|");
                    for(x=0;x<citys.length;x++){
                        $(cityid).options.add(new Option(citys[x],citys[x])); 
                    }
                }
            }
        }
    }
}
function checkdata()
{
	return true;
}
function checkPasswordData()
{
	return true;
}
function changeVerifyCode(obj) {

	//1�������<iframe>ʵ�֣������¼���<iframe>������
	//verifyCodeFrame.location.reload();

	//2�������<img>ʵ�֣����޸�<img src=url>��url
	//������һ��С���ɣ������url����ͬ��ֵ��������������·������������js����һ����ʱ��������url�еĲ���
	t = new Date().getTime();
	obj.src = "VerifyCodeServlet.action?t=" + t;
}