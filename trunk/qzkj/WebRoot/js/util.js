/**
 * ����ַ����ĺϷ���
 * inputΪ��Ҫ�����ַ�����checkStringΪ�Ϸ��ַ���
 * Ted Fan 2003-04-06
 * @return
 */
  function check(input,checkString)
  {
    var ok = true;
    if(input==null||input.length==0) return ok;
    for (var i = 0; i < input.length; i++)
    {
      var chr = input.charAt(i);
      var found = false;
      for (var j = 0; j < checkString.length; j++)
      {
        if (chr == checkString.charAt(j)) found = true;
      }
      if (!found) ok = false;
    }
    return ok;
  }

  /**
   * ���Ƿ��ַ�
   * inputΪ������ַ�����checkStringΪ�Ƿ����ַ���
 * Ted Fan 2003-04-06
   * @return
   */
  function errCheck(input,checkString)
  {
    var ok = true;
    for (var i = 0; i < input.length; i++)
    {
      var chr = input.charAt(i);
      var found = true;
      for (var j = 0; j < checkString.length; j++)
      {
        if (chr == checkString.charAt(j)) found = false;
      }
      if (!found) ok = false;
    }
    return ok;
  }

  /**
   * ����������������ж�Ӧ����ʾ������
   * x,y,z�ֱ����ꡢ�¡��յĶ���
   * Ted Fan 2003-04-06
   * @return
   */
  function generateDate(x,y,z)
  {
    if(!check(x.value,"1234567890"))
    {
      alert("���������������������!");
      x.value="";
      x.focus();
      bcontrol=false;
      return false;
    }

    //�ж�����
    var dayfor2=28;
    if((x.value % 100 != 0 && x.value % 4==0)||( x.value % 100 == 0 && x.value % 400==0)) dayfor2=29;
    //alert(dayfor2);
    temp=y.length-12;

    //����2��
    if(y.value==2) dayOfMonth=dayfor2;
    //��2��
    if(y.value!=2)
    {
      dayOfMonth=30
    }
    //����
    if((y.value<8&&y.value % 2==1) || (y.value > 7 &&y.value % 2 ==0)) dayOfMonth=31;
    //alert(temp+" "+z.length+" "+dayOfMonth);
    for(var i=z.length;i>dayOfMonth+temp;i--)
    {
      //alert("del "+z.options[i-1].value);
      z.options[i-1]=null;
    }

    for(var i=z.length;i<dayOfMonth+temp;i++)
    {
      z.options[i]=new Option(i+1-temp,i+1-temp);
      //alert("add "+z.options[i].value);
    }

  }

  /**
   * ���绰����
   * Ted Fan 2003-04-06
   * @return
   */
  function telCheck(input)
  {
    return check(input,"0123456789-()+");
  }

  /**
   * �����ּ��
   * Ted Fan 2003-04-06
   * @return
   */
  function digCheck(input)
  {
    return check(input,"0123456789");
  }

  /**
   * ����½����ֻ��a-z,A-Z,_,0-9��ĸ��ͷ
   * Ted Fan 2003-04-06
   * @return
   */
  function loginCheck(input)
  {
    result=true;
    result=check(input,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_");
    if(!check(input.charAt[0],"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")) result=false;
    return result;
  }
  /**
   * �����ҵ�û���½����ֻ��a-z,A-Z,_,0-9��ĸ��ͷ
   * Ted Fan 2003-04-06
   * @return
   */
  function entloginCheck(input)
  {
    result=true;
    result=check(input,"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_-");
    if(!check(input.charAt[0],"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ")) result=false;
    return result;
  }
  /**
   * ���������ּ��Ƿ��ַ�&%$'
   * Ted Fan 2003-04-06
   * @return
   */
  function descCheck(input)
  {
    return errCheck(input,"&%$'");
  }

  /**
   * С���ж�
   * Ted Fan 2003-04-06
   * @return
   */
  function floatCheck(input)
  {
    return check(input,"0123456789.");
  }

  /*�����ʻ� wenhui 2003-04-23*/
  function accountCheck(input)
  {
    return check(input,"0123456789-");
  }

  /*check ip address wenhui 2003-05-01*/
  function ipCheck(input)
  {
	if (!check(input,"0123456789."))
		return false;
	
	var temp=0;
	var npos=0;
	for (var i=0;i<input.length;i++)
	{
		var chr = input.charAt(i);
		if ((i==0)&&(chr=="."))
		   return false;
		if (chr=="."){
		  if ((npos==0)&&(temp==0)) return false;
		  npos++;
                  temp=0;
                  if ((i==input.length-1)&&(npos!=3)) return false;
                  if (i==input.length-1) return false;
		  continue;
		}
		temp +=chr;
		if ((i==input.length-1)&&(temp==0)) return false;
                if ((i==input.length-1)&&(npos!=3)) return false;
		if (temp>255)
		   return false;
	}
	return true;
  }

  /*Email wenhui 2003-04-23*/
  function emailCheck(item) {
    var etext
    var elen
    var i
    var aa
    etext=item
    elen=etext.length
    if (elen<5)
      return 0;
    i= etext.indexOf("@",0)
    if (i==0 || i==-1 || i==elen-1)
       return 0;
    else {
      if (etext.indexOf("@",i+1)!=-1)
	return 0;
    }
    if (etext.indexOf("..",i+1)!=-1)
	return 0;
    i=etext.indexOf(".",0)
    if (i==0 || i==-1 || etext.charAt(elen-1)=='.')
	return 0;
    if ( etext.charAt(0)=='-' ||  etext.charAt(elen-1)=='-')
	return 0;
    if ( etext.charAt(0)=='_' ||  etext.charAt(elen-1)=='_')
	return 0;
    for (i=0;i<=elen-1;i++) {
      aa=etext.charAt(i)
      if (!((aa=='.') || (aa=='@') || (aa=='-') ||(aa=='_') || (aa>='0' && aa<='9') || (aa>='a' && aa<='z') || (aa>='A' && aa<='Z')))
	return 0;
    }
    return 1;
}

  
  function zipcodeCheck(input)
  {
  	if (!digCheck(input))
		return false
  	
  	if (input > 999999)
  		return false;
  	
  	return true
  }
//==============begin by zhaosy============
  
  function IsNumber(string,sign)
  {
    var number;
    if (string==null) return false;
    if ((sign!=null) && (sign!='-') && (sign!='+'))
    {
      alert('IsNumber(string,sign)�Ĳ�������\nsignΪnull��"-"��"+"');
      return false;
    }
    number = new Number(string);
    if (isNaN(number))
    {
      return false;
    }
    else if ((sign==null) || (sign=='-' && number<0) || (sign=='+' && number>=0))
    {
      return true;
    }
    else
      return false;
  }
  
  //===========end by zhaosy===========
 
/**
  * ȡ���ַ���str�ĳ��� 
  * @param str : ������ִ�
  * @return �ִ�����
  */
function strLength(str)
{
	y=0;
	for(i=0;i<str.length;i++)
	{
	if(str.charCodeAt(i)> 0 && str.charCodeAt(i) <255)        //�����ASCII��
		y++;
	else
		y+=2;
	}
	return y;
}

/**
  * �ж��ַ����Ƿ񳬳�ָ���ĳ���
  * @param : str - �������ַ���
  * @param : maxlen - ָ������󳤶�
  * return : ����-true��û�г���-false 
  */
function isUpLength(str,maxlen)
{
	if(strLength(str)>maxlen)
		return true;
	else
		return false;
}

//-----------------------------------------------------------------------------------
//���������ڶ�sString�ַ�������ǰ�ո�س�
//-----------------------------------------------------------------------------------
function JHshLTrim(sString)
{ 
	var sStr,i,iStart,sResult = ""; 
	sStr = sString.split("");
	iStart = -1 ;
	for (i = 0 ; i < sStr.length ; i++)
	{
		if (sStr[i] != " ") 
		{
			iStart = i;
			break;
		}
	}
	if (iStart == -1) 
		return "" ;    //��ʾsString�е������ַ����ǿո�,�򷵻ؿմ�
	else 
		return sString.substring(iStart) ;
}

//-----------------------------------------------------------------------------------
//���������ڶ�sString�ַ������к�ո�س�
// -----------------------------------------------------------------------------------
function JHshRTrim(sString)
{ 
	var sStr,i,sResult = "",sTemp = "" ; 
	// if (sString.length == 0) { return "" ;} // ����sString�ǿմ�
	sStr = sString.split("");
	for (i = sStr.length - 1 ; i >= 0 ; i-- )  // ���ַ������е���
	{ 
 		sResult = sResult + sStr[i]; 
	}
	sTemp = JHshLTrim(sResult) ; // �����ַ���ǰ�ո�س�
	if (sTemp == "") 
		return "" ;
	sStr = sTemp.split("");
	sResult = "" ;
	for (i = sStr.length - 1 ; i >= 0 ; i--) // �����������ַ����ٽ��е���
		sResult = sResult + sStr[i];
	return sResult ;
} 

// �س��ַ���ǰ��ո�
function JHshTrim(sString)
{
	var strTmp ; 
	strTmp = JHshRTrim(JHshLTrim(sString)) ;
	return strTmp ;
} 



function IsDate(DateString , Dilimeter)
{
if (DateString==null) return true;
if (Dilimeter=='' || Dilimeter==null)
Dilimeter = '-';
var tempy='';
var tempm='';
var tempd='';
var tempArray;
if (DateString.length<8 && DateString.length>10)
return false; 
tempArray = DateString.split(Dilimeter);
if (tempArray.length!=3)
return false;
if (tempArray[0].length==4)
{
tempy = tempArray[0];
tempd = tempArray[2];
}
else
{
tempy = tempArray[2];
tempd = tempArray[1];
}
tempm = tempArray[1];
var tDateString = tempy + '/'+tempm + '/'+tempd+' 8:0:0';//�Ӱ�Сʱ����Ϊ���Ǵ��ڶ�����
var tempDate = new Date(tDateString);
if (isNaN(tempDate))
return false;
if (((tempDate.getUTCFullYear()).toString()==tempy) && (tempDate.getMonth()==parseInt(tempm)-1) && (tempDate.getDate()==parseInt(tempd)))
{
return true;
}
else
{
return false;
}
}

/*****************************************
��ȡѡ����ֶ��б�ѡ�е�ֵ����Ӧ���ı�˵��
Add by Shuming Tang 2003-12-04
*/
function getSelectedText(field)
{
	tmpTxt = "";
	for(i=0;i<field.length;i++)
	{
		if(field.options[i].selected)
			tmpTxt = field.options[i].text;
	}
	return tmpTxt;
}


/*****************************************
�ı���ֻ������������
Add by yanrubin 2010-10-26
*/
function onlyNum(value)
{
	if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39))
	if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
	event.returnValue=false;
	
}
function chekvalue(obj,meren){
   if(obj.value<=0 || obj.value>12){
		alert("ֻ������1-12֮������");
		obj.value=meren;
		return false;
   }
}
