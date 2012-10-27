/*
 * @字符替换函数
 * @param {String} oldValue
 * @param {String} newValue
 * @return {String}
*/
String.prototype.replaceAll = function(oldValue,newValue){ 
   return this.replace(new RegExp(oldValue,"g"),newValue);
}

/*
 * @去掉字符两端的空白字符
 * @return {String}
*/
String.prototype.trim = function(){
    return this.replace(/(^\s*)|(\s*$)/g, "");
}

/*
 * @去掉字符左端的的空白字符
 * @return {String}
*/
String.prototype.lTrim  = function(){
    return this.replace(/(^[\\s]*)/g, "");
}

/*
 * @去掉字符右端的空白字符
 * @return {String}
*/
String.prototype.rTrim = function(){
    return this.replace(/([\\s]*$)/g, "");
}

/*
 * @返回字符的长度，一个中文算2个
 * @return {int}
*/
String.prototype.cnLength=function(){
    return this.replace(/[^\x00-\xff]/g,"**").length;
}

 /*
 * @从左边截取n个字符 ,如果包含汉字,则汉字按两个字符计算
 * @param {int} n
 * @return {String}
*/
String.prototype.cnLeft=function(n){
		return this.slice(0,n-this.slice(0,n).replace(/[\x00-\xff]/g,"").length);
}
 
  /*
 * @从右边截取n个字符 ,如果包含汉字,则汉字按两个字符计算
 * @param {int} n
 * @return {String}
*/
String.prototype.cnRight=function(n){
		return this.slice(this.slice(-n).replace(/[\x00-\xff]/g,"").length-n);
}
 
/*
 * @判断字符串是否以指定的字符串开始
 * @param {String} str
 * @return {Boolean}
*/
String.prototype.startsWith = function(str){
    return this.substr(0, str.length) == str;
}
 
/*
 * @判断字符串是否以指定的字符串结束
 * @param {String} str
 * @return {Boolean}
*/
String.prototype.endsWith = function(str){
    return this.substr(this.length - str.length) == str;
}

/*
 * @计算出两个日期型变量的间隔时间（年、月、日、周）
 * @param {Date} cDate
 * @param {String} mode
 * @return {int}
 * alert((new Date()).DayDiff((new Date(2002,0,1)))) -> 显示 329
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
 * @判断字符串是否为空
 * @param {String} sText
 * @return {Boolean}
*/
function isEmpty(sText)
{
  return /^\s*$/g.test(sText);
}

/*
 * @判断字符串是否为正确Email 
 * @param {String} sText
 * @return {Boolean}
*/
function isEmail(sText)
{
   return  /^[a-z0-9][\w\-\.]+@[\w\-]+(\.[a-z]+){1,2}$/.test(sText);
}

/*
 * @判断字符串是否为正确邮编 
 * @param {String} sText
 * @return {Boolean}
*/
function isZipCode(sText)
{
   return /^[0-9]{6}$/.test(sText);
}

/*
 * @判断字符串是否为正确手机号码
 * @param {String} sText
 * @return {Boolean}
*/
function isMobilePhone(sText)
{
   return /^1[3|4|5|8][0-9]\d{8}$/.test(sText);
}