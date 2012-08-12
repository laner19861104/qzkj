<%@ page language="java" contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@page import="com.bip.sys.user.po.SysUsers;"%>
<%
	pageContext.setAttribute("path", request.getContextPath());
	response.setHeader("Pragma","No-cache"); 
	response.setHeader("Cache-Control","no-cache"); 
	response.setDateHeader("Expires", 0);
	
	
if(session.getAttribute("sysuser")!=null){
    SysUsers sysuser=(SysUsers)session.getAttribute("sysuser");
	if(!sysuser.getSsqy().equals("370700")){
		response.sendRedirect(request.getContextPath()+"/companySearchEnyRpt");
	}
}else{
    response.sendRedirect("/"+request.getContextPath());
}
	
%>
<html>
<head>

<link href="${path}/templates/css/main.css" rel="stylesheet" type="text/css" />
<script src="${path}/templates/js/tdcolor.js" type="text/javascript"></script>
<script src="${path}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${path}/templates/js/util.js"></script>
<title>  </title>

<script type="text/javascript">
var tableidArray = new Array('table1');
onloadEvent(showtable);

</script>

<style>
.search td {padding:0px 2px 0px 0px}
fieldset{
	font-size: 12px;
	margin: 5px 10px 0px 5px;
	padding: 5px;
}
fieldset legend {
	margin-left: 10px;
	color: #003366;
	font-weight: bold;
	padding: 0px 10px;
	margin-bottom: 10px;
}
fieldset table td{
	padding:0px 2px 0px 0px;
	font-size:12px
}
fieldset table th{
	font-weight:normal;
	white-space:nowrap;
	font-size:12px
}
fieldset table select{
	font-size:12px;
}
.list {
	
	border-width: 0px 0px 0px 0px;
	width: 100%;
}

.list td {
	
	border-width: 0px 0px 0px 0px;
	height: 20px;
	padding: 1px 1px 0px;
}

.mapdiv {
	width: 850px;
}
.map {
	
	margin-top: 4%;
	
	margin-bottom: 0;
	margin-left: 25%;
}
.map img {
	width: 499px;
	height: 553px;
	float: left;
}
.map .xmap img {
	height: 158px;
	width: 150px;
	border: 1px solid #CCCCCC;
	margin-top: 350px;
	margin-left: 10px;
}
</style>
</head>
<body >
	<div class="position">当前位置：能源消耗数据库系统 &gt;&gt; <a href="#">能源消耗数据查询</a></div>
    
    <table width="850" border="0" cellpadding="0" cellspacing="0" class="tableout" >
      <tr>
        <td><fieldset >
           <legend>地图</legend>
          <table border="0" cellspacing="0" cellpadding="0" class="list" id="table1" height="550">
           <tr>
             <td align="center">
				<div class="map"><img src="../../image/map-1.gif" alt="地图" border="0" usemap="#Map" />
				  <map name="Map" id="Map">
				    <area shape="poly" coords="97,127,107,144,113,160,114,168,121,178,132,195,140,206,153,216,153,228,154,217,154,228,147,246,143,251,135,250,133,243,126,238,121,237,116,235,102,235,114,235,100,237,93,242,89,251,87,253,88,255,80,260,63,268,78,261,54,273,47,279,40,285,33,290,22,292,18,287,15,283,16,277,20,268,19,260,14,250,14,244,17,239,10,233,11,220,13,211,14,199,19,186,32,181,38,178,38,176,45,177,52,174,60,170,68,164,69,158,74,153,80,149,80,143,82,134,85,127,81,120,94,122,96,126,97,126" href="${path}/companySearchEnyRpt?ssqy=370781" alt="青州市" />
				    <area shape="poly" coords="145,246,152,256,152,256,154,273,154,284,166,286,162,294,156,302,151,315,156,330,153,339,159,348,150,376,144,381,144,397,131,398,121,387,108,389,99,395,91,405,85,416,79,415,78,408,81,403,74,398,69,399,63,405,58,395,50,383,53,372,50,365,48,361,38,364,36,345,24,337,20,335,16,329,11,325,12,310,18,295,21,293,37,288,51,275,68,265,83,259,88,250,96,238,105,234,115,234,126,238,131,244,133,247,138,250,142,250,146,248,151,255,153,255,152,256,152,257,153,255" href="${path}/companySearchEnyRpt?ssqy=370724" alt="临朐县" />
				    <area shape="poly" coords="352,383,366,374,373,376,378,384,380,391,379,401,379,408,385,413,398,420,397,428,393,439,392,448,398,459,407,476,407,484,397,485,393,488,385,490,378,500,376,509,370,518,367,520,365,526,371,532,356,533,350,528,343,521,336,518,329,509,328,504,318,505,308,509,303,506,305,494,303,482,298,472,286,470,272,470,262,473,253,473,247,474,241,472,250,461,252,455,249,449,246,447,241,447,232,450,215,449,204,445,202,439,206,426,211,415,214,407,214,400,222,404,223,405,244,381,255,369,274,369,294,363,306,351,316,350,321,359,328,369,330,370,336,372,342,371,347,376" href="${path}/companySearchEnyRpt?ssqy=370782" alt="诸城市"  />
				 <!--    <area shape="poly" coords="96,125" href="#" /> -->  
				    <area shape="poly" coords="97,124,99,110,95,99,101,91,115,87,124,82,128,72,122,54,126,47,136,36,148,28,163,19,179,17,185,14,189,13,188,26,193,29,199,29,207,26,220,31,219,38,219,40,224,41,230,42,237,48,239,50,228,58,224,65,228,73,230,80,237,80,241,81,245,84,239,92,225,124,215,130,213,157,212,168,201,168,196,172,193,184,181,184,170,183,163,182,156,185,151,196,151,201,142,207,136,200,129,188,118,174,113,162,109,151,102,136" href="${path}/companySearchEnyRpt?ssqy=370783" alt="寿光市" />
				    <area shape="poly" coords="244,49,251,53,255,58,259,64,262,68,259,74,255,75,251,81,248,84,245,84,241,81,236,80,231,80,229,76,227,71,225,67,225,63,229,57,236,53,242,50" href="${path}/companySearchEnyRpt?ssqy=370792" alt="滨海区" />
				    <area shape="poly" coords="266,67,274,67,279,69,273,94,270,132,271,152,268,159,270,169,273,177,291,175,295,183,304,191,311,192,316,182,318,183,322,185,324,196,324,203,317,197,312,196,303,195,291,196,274,199,272,195,272,192,267,188,258,185,238,179,245,170,241,162,233,154,223,151,216,151,213,152,213,151,214,138,215,130,223,126,228,118,234,104,243,87,247,84,254,78,256,75,265,67" href="${path}/companySearchEnyRpt?ssqy=370703" alt="寒亭区" />
				    <area shape="poly" coords="218,181,228,181,227,182,238,180,244,174,244,164,236,156,223,151,212,153,213,161,214,175" href="${path}/companySearchEnyRpt?ssqy=370791" alt="高新区" />
				    <area shape="poly" coords="223,204,225,212,227,219,243,219,246,207,243,197,243,191,240,184,235,181,235,180,223,182,221,188,221,203" href="${path}/companySearchEnyRpt?ssqy=370705" alt="奎文区" />
				    <area shape="poly" coords="194,236,189,218,189,200,194,183,196,171,200,167,213,167,213,174,218,180,222,182,222,188,223,201,226,214,227,219,225,227,218,230,211,231,204,232" href="${path}/companySearchEnyRpt?ssqy=370702" alt="潍城区" />
				<!--   <area shape="poly" coords="315,216" href="#" alt="坊子区" /> -->  
				    <area shape="poly" coords="314,217,311,225,311,238,297,239,292,239,285,233,276,236,266,246,263,265,250,274,235,251,207,247,196,241,195,237,209,232,223,229,227,219,243,219,254,212,271,199,284,198,309,194,320,198,323,202,319,206" href="${path}/companySearchEnyRpt?ssqy=370704" alt="坊子区" />
				    <area shape="poly" coords="448,333,440,346,431,366,431,377,434,387,409,391,409,391,383,396,381,384,373,375,365,378,354,385,348,374,342,372,331,370,326,364,334,357,334,334,323,315,323,309,335,309,345,301,351,297,365,302,377,297,378,268,372,252,357,227,369,215,378,235,396,243,412,255,446,265,478,276,481,284,480,287,467,294,461,306,462,312,453,318" href="${path}/companySearchEnyRpt?ssqy=370785" alt="高密市" />
				    <area shape="poly" coords="217,312,212,294,218,289,228,288,238,287,249,274,262,265,266,247,276,236,285,233,291,239,307,238,311,238,313,259,314,281,333,294,338,300,338,306,330,309,323,309,323,310,325,317,333,333,334,357,327,364,319,354,309,352,292,366,257,368,243,382,231,398,227,404,217,400,216,404,199,404,194,402,188,406,180,409,173,409,174,391,169,379,166,376,151,377,158,349,154,340,157,330,156,321,156,317,165,319,178,319,188,325,197,324,210,318" href="${path}/companySearchEnyRpt?ssqy=370784" alt="安丘市" />
				    <area shape="poly" coords="318,68,333,66,333,65,349,67,357,70,357,81,362,89,369,92,369,105,369,146,364,164,353,177,351,196,362,207,369,213,362,222,357,227,361,235,366,243,373,254,379,273,377,296,366,301,361,301,353,299,348,297,343,303,338,305,336,300,333,295,332,292,333,286,335,275,337,255,334,243,334,230,329,214,323,212,317,210,320,203,324,200,321,189,318,182,314,187,310,195,303,191,295,184,290,174,275,177,270,173,267,159,271,152,269,142,270,118,276,78,278,69,285,65,290,68,294,78,295,80,297,68" href="${path}/companySearchEnyRpt?ssqy=370786" alt="昌邑市 " />
				    <area shape="poly" coords="311,228,310,241,313,257,314,271,314,281,327,290,333,293,336,275,338,256,335,247,334,230,333,218,327,212,319,210,314,216" href="${path}/companySearchEnyRpt?ssqy=370793" alt="峡山区" />
				    <area shape="poly" coords="153,231,147,244,153,256,152,273,155,284,167,286,161,297,153,309,150,315,156,328,157,318,177,319,189,325,198,324,216,312,214,299,213,294,222,288,237,287,249,274,236,252,223,250,209,248,196,240,189,222,190,197,193,184,163,182,154,187,150,202,142,206,149,213,153,219" href="${path}/companySearchEnyRpt?ssqy=370725" alt="昌乐县" />
				    <area shape="poly" coords="255,183,265,188,273,193,269,201,246,217,246,205,244,194,239,183,239,179" href="${path}/companySearchEnyRpt?ssqy=370790" alt="高新区" />
				  </map>
				  <div class="xmap">
				    <a href="${path}/companySearchEnyRpt"><img src="../../image/xmap.gif" alt="潍坊市全图" /></a>
				  </div>
				</div>
				
			<br><br><br></td>
           </tr>
          </table>
          
        </fieldset></td>
      </tr>
    </table>
</body>
</html>
