/*
 * @�ַ��滻����
 * @param {String} oldValue
 * @param {String} newValue
 * @return {String}
*/
String.prototype.replaceAll = function(oldValue,newValue){ 
   return this.replace(new RegExp(oldValue,"g"),newValue);
}

/*
 * @ȥ���ַ����˵Ŀհ��ַ�
 * @return {String}
*/
String.prototype.trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

/*
 * @ȥ���ַ���˵ĵĿհ��ַ�
 * @return {String}
*/
String.prototype.lTrim  = function(){
    return this.replace(/(^[\\s]*)/g, "");
}

/*
 * @ȥ���ַ��Ҷ˵Ŀհ��ַ�
 * @return {String}
*/
String.prototype.rTrim = function(){
    return this.replace(/([\\s]*$)/g, "");
}

/*
 * @�����ַ��ĳ��ȣ�һ��������2��
 * @return {int}
*/
String.prototype.cnLength=function(){
    return this.replace(/[^\x00-\xff]/g,"**").length;
}

 /*
 * @����߽�ȡn���ַ� ,�����������,���ְ������ַ�����
 * @param {int} n
 * @return {String}
*/
String.prototype.cnLeft=function(n){
		return this.slice(0,n-this.slice(0,n).replace(/[\x00-\xff]/g,"").length);
}
 
  /*
 * @���ұ߽�ȡn���ַ� ,�����������,���ְ������ַ�����
 * @param {int} n
 * @return {String}
*/
String.prototype.cnRight=function(n){
		return this.slice(this.slice(-n).replace(/[\x00-\xff]/g,"").length-n);
}
 
/*
 * @�ж��ַ����Ƿ���ָ�����ַ�����ʼ
 * @param {String} str
 * @return {Boolean}
*/
String.prototype.startsWith = function(str){
    return this.substr(0, str.length) == str;
}
 
/*
 * @�ж��ַ����Ƿ���ָ�����ַ�������
 * @param {String} str
 * @return {Boolean}
*/
String.prototype.endsWith = function(str){
    return this.substr(this.length - str.length) == str;
}

/*
 * @��������������ͱ����ļ��ʱ�䣨�ꡢ�¡��ա��ܣ�
 * @param {Date} cDate
 * @param {String} mode
 * @return {int}
 * alert((new Date()).DayDiff((new Date(2002,0,1)))) -> ��ʾ 329
*/
Date.prototype.DayDiff = function(cDate,mode){
     try{
         cDate.getYear();
     }catch(e){
         return(0);
     }
     var base =60*60*24*1000;
     var result = Math.abs(this - cDate);
     switch(mode){
         case "y":
             result/=base*365;
             break;
         case "m":
             result/=base*365/12;
             break;
         case "w":
             result/=base*7;
             break;
         default:
             result/=base;
             break;
     }
     return(Math.floor(result));
}

/*
 * @�ж��ַ����Ƿ�Ϊ��
 * @param {String} sText
 * @return {Boolean}
*/
function isEmpty(sText)
{
  return /^\s*$/g.test(sText);
}

/*
 * @�ж��ַ����Ƿ�Ϊ��ȷEmail 
 * @param {String} sText
 * @return {Boolean}
*/
function isEmail(sText)
{
   return  /^[a-z0-9][\w\-\.]+@[\w\-]+(\.[a-z]+){1,2}$/.test(sText);
}

/*
 * @�ж��ַ����Ƿ�Ϊ��ȷ�ʱ� 
 * @param {String} sText
 * @return {Boolean}
*/
function isZipCode(sText)
{
   return /^[0-9]{6}$/.test(sText);
}

/*
 * @�ж��ַ����Ƿ�Ϊ��ȷ�ֻ�����
 * @param {String} sText
 * @return {Boolean}
*/
function isMobilePhone(sText)
{
   return /^1[3|4|5|8][0-9]\d{8}$/.test(sText);
}