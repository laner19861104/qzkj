/*
SQLyog Enterprise - MySQL GUI v6.03
Host - 5.0.18-nt : Database - pmdb
*********************************************************************
Server version : 5.0.18-nt
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `pmdb`;

USE `pmdb`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `job_customer` */

DROP TABLE IF EXISTS `job_customer`;

CREATE TABLE `job_customer` (
  `id` int(11) NOT NULL,
  `custno` varchar(50) character set gbk NOT NULL,
  `custname` varchar(50) character set gbk NOT NULL,
  `briefname` varchar(50) character set gbk default NULL,
  `enname` varchar(50) character set gbk default NULL,
  `custtype` varchar(20) character set gbk default NULL,
  `custlevel` varchar(20) character set gbk default NULL,
  `custvaluelevel` varchar(20) character set gbk default NULL,
  `custhyfl` varchar(20) character set gbk default NULL,
  `custqy` varchar(20) character set gbk default NULL,
  `states` varchar(20) character set gbk default NULL,
  `telno` varchar(50) character set gbk default NULL,
  `postcode` varchar(50) character set gbk default NULL,
  `address` varchar(50) character set gbk default NULL,
  `faxno` varchar(50) character set gbk default NULL,
  `remark` varchar(200) character set gbk default NULL,
  `mrelap` varchar(20) character set gbk default NULL,
  `mrelaptelno` varchar(50) character set gbk default NULL,
  `mchargep` varchar(20) character set gbk default NULL,
  `mchargeptelno` varchar(50) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  `searchp` varchar(50) character set gbk default NULL,
  `chargep` varchar(200) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_customer` */

/*Table structure for table `job_custrelap` */

DROP TABLE IF EXISTS `job_custrelap`;

CREATE TABLE `job_custrelap` (
  `id` int(11) NOT NULL,
  `custno` varchar(20) character set gbk NOT NULL,
  `custname` varchar(50) character set gbk NOT NULL,
  `relap` varchar(20) default NULL,
  `telno` varchar(20) default NULL,
  `faxno` varchar(20) default NULL,
  `birghdate` varchar(20) default NULL,
  `sex` varchar(20) default NULL,
  `duty` varchar(20) default NULL,
  `remark` varchar(200) default NULL,
  `res01` varchar(50) default NULL,
  `res02` varchar(50) default NULL,
  `res03` varchar(50) default NULL,
  `res04` varchar(50) default NULL,
  `res05` double(30,2) default NULL,
  `res06` double(30,2) default NULL,
  `chargep` varchar(200) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_custrelap` */

/*Table structure for table `job_custstates` */

DROP TABLE IF EXISTS `job_custstates`;

CREATE TABLE `job_custstates` (
  `id` int(11) NOT NULL,
  `custno` varchar(50) character set gbk NOT NULL,
  `custname` varchar(50) character set gbk NOT NULL,
  `pstates` varchar(20) character set gbk default NULL,
  `statesdate` varchar(20) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  `chargep` varchar(200) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_custstates` */

/*Table structure for table `job_custtrade` */

DROP TABLE IF EXISTS `job_custtrade`;

CREATE TABLE `job_custtrade` (
  `id` int(11) NOT NULL,
  `custno` varchar(20) character set gbk NOT NULL,
  `custname` varchar(50) character set gbk NOT NULL,
  `pno` varchar(20) character set gbk NOT NULL,
  `pname` varchar(50) character set gbk NOT NULL,
  `tradeamount` varchar(20) default NULL,
  `tradedate` varchar(20) default NULL,
  `remark` varchar(200) default NULL,
  `res01` varchar(50) default NULL,
  `res02` varchar(50) default NULL,
  `res03` varchar(50) default NULL,
  `res04` varchar(50) default NULL,
  `res05` double(30,2) default NULL,
  `res06` double(30,2) default NULL,
  `chargep` varchar(200) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_custtrade` */

/*Table structure for table `job_project` */

DROP TABLE IF EXISTS `job_project`;

CREATE TABLE `job_project` (
  `id` int(11) NOT NULL,
  `pno` varchar(50) character set gbk NOT NULL,
  `pname` varchar(50) character set gbk NOT NULL,
  `custno` varchar(50) character set gbk default NULL,
  `custname` varchar(50) character set gbk default NULL,
  `pamount` varchar(20) character set gbk default NULL,
  `ptype` varchar(20) character set gbk default NULL,
  `pvaluelevel` varchar(20) character set gbk default NULL,
  `pstates` varchar(20) character set gbk default NULL,
  `pprogress` varchar(20) character set gbk default NULL,
  `begindate` varchar(50) character set gbk default NULL,
  `enddate` varchar(50) character set gbk default NULL,
  `remark` varchar(50) character set gbk default NULL,
  `searchp` varchar(50) character set gbk default NULL,
  `chargep` varchar(200) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_project` */

/*Table structure for table `job_projectstates` */

DROP TABLE IF EXISTS `job_projectstates`;

CREATE TABLE `job_projectstates` (
  `id` int(11) NOT NULL,
  `pno` varchar(50) character set gbk NOT NULL,
  `pname` varchar(50) character set gbk NOT NULL,
  `pstates` varchar(20) character set gbk default NULL,
  `statesdate` varchar(20) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  `chargep` varchar(200) character set gbk default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_projectstates` */

/*Table structure for table `job_scheduleadjust` */

DROP TABLE IF EXISTS `job_scheduleadjust`;

CREATE TABLE `job_scheduleadjust` (
  `id` int(11) NOT NULL,
  `wsno` varchar(50) character set gbk NOT NULL,
  `wsname` varchar(50) character set gbk NOT NULL,
  `operp` varchar(20) character set gbk default NULL,
  `operdate` varchar(20) character set gbk default NULL,
  `content` varchar(200) character set gbk default NULL,
  `remark` varchar(50) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_scheduleadjust` */

/*Table structure for table `job_workplan` */

DROP TABLE IF EXISTS `job_workplan`;

CREATE TABLE `job_workplan` (
  `id` int(11) NOT NULL,
  `userno` varchar(50) character set gbk NOT NULL,
  `username` varchar(50) character set gbk NOT NULL,
  `wpclass` varchar(20) character set gbk default NULL,
  `wptype` varchar(20) character set gbk default NULL,
  `wpdate` varchar(20) character set gbk default NULL,
  `operdate` varchar(20) character set gbk default NULL,
  `content` varchar(200) character set gbk default NULL,
  `remark` varchar(50) character set gbk default NULL,
  `states` varchar(20) character set gbk default NULL,
  `selfscore` varchar(20) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_workplan` */

/*Table structure for table `job_workschedule` */

DROP TABLE IF EXISTS `job_workschedule`;

CREATE TABLE `job_workschedule` (
  `id` int(11) NOT NULL,
  `wsno` varchar(50) character set gbk NOT NULL,
  `wsname` varchar(50) character set gbk NOT NULL,
  `wsclass` varchar(20) character set gbk default NULL,
  `wstype` varchar(20) character set gbk default NULL,
  `operp` varchar(20) character set gbk default NULL,
  `operdate` varchar(20) character set gbk default NULL,
  `content` varchar(200) character set gbk default NULL,
  `remark` varchar(50) character set gbk default NULL,
  `states` varchar(20) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_workschedule` */

/*Table structure for table `job_worksummary` */

DROP TABLE IF EXISTS `job_worksummary`;

CREATE TABLE `job_worksummary` (
  `id` int(11) NOT NULL,
  `userno` varchar(50) character set gbk NOT NULL,
  `username` varchar(50) character set gbk NOT NULL,
  `wsclass` varchar(20) character set gbk default NULL,
  `wstype` varchar(20) character set gbk default NULL,
  `states` varchar(20) character set gbk default NULL,
  `selfscore` varchar(20) character set gbk default NULL,
  `pmscore` varchar(20) character set gbk default NULL,
  `vicegmscore` varchar(20) character set gbk default NULL,
  `gmscore` varchar(20) character set gbk default NULL,
  `totalscore` varchar(20) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_worksummary` */

/*Table structure for table `job_wsscorestates` */

DROP TABLE IF EXISTS `job_wsscorestates`;

CREATE TABLE `job_wsscorestates` (
  `id` int(11) NOT NULL,
  `wsid` int(11) NOT NULL,
  `operp` varchar(50) character set gbk NOT NULL,
  `operdate` varchar(20) character set gbk default NULL,
  `score` varchar(20) character set gbk default NULL,
  `RES01` varchar(50) character set gbk default NULL,
  `RES02` varchar(50) character set gbk default NULL,
  `RES03` varchar(50) character set gbk default NULL,
  `RES04` varchar(50) character set gbk default NULL,
  `RES05` double default NULL,
  `RES06` double default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `job_wsscorestates` */

/*Table structure for table `sys_department` */

DROP TABLE IF EXISTS `sys_department`;

CREATE TABLE `sys_department` (
  `deptid` int(30) NOT NULL,
  `deptname` varchar(50) NOT NULL,
  `deptno` varchar(50) NOT NULL,
  `depttype` varchar(10) default NULL,
  `deptlevel` varchar(10) default NULL,
  `telno` varchar(50) default NULL,
  `faxno` varchar(50) default NULL,
  `remark` varchar(200) default NULL,
  `relap` varchar(20) default NULL,
  `relaptelno` varchar(50) default NULL,
  `chargep` varchar(20) default NULL,
  `chargeptelno` varchar(50) default NULL,
  `res01` varchar(50) default NULL,
  `res02` varchar(50) default NULL,
  `res03` varchar(50) default NULL,
  `res04` varchar(50) default NULL,
  `res05` double(30,2) default NULL,
  `res06` double(30,2) default NULL,
  PRIMARY KEY  (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_department` */

insert  into `sys_department`(`deptid`,`deptname`,`deptno`,`depttype`,`deptlevel`,`telno`,`faxno`,`remark`,`relap`,`relaptelno`,`chargep`,`chargeptelno`,`res01`,`res02`,`res03`,`res04`,`res05`,`res06`) values (2,'车改办','000000000','02','01','1','11','','','','','',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `sys_dmlb` */

DROP TABLE IF EXISTS `sys_dmlb`;

CREATE TABLE `sys_dmlb` (
  `ID` int(30) NOT NULL auto_increment,
  `LBBH` varchar(50) default NULL,
  `LBMC` varchar(50) default NULL,
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_dmlb` */

insert  into `sys_dmlb`(`ID`,`LBBH`,`LBMC`) values (1,'enterpriseqy','区域字典'),(2,'deptlevel','部门类别'),(3,'depttype','部门类型'),(4,'resourcetype','资源类型'),(5,'actionid','权限动作'),(6,'state','用户状态'),(7,'roletype','角色类型'),(8,'unitlevel','单位类别'),(9,'unittype','单位类型'),(10,'postpriv','用户职务'),(11,'hidebirth','隐藏生日'),(12,'smson','短信启用'),(13,'hidemobile','隐藏手机'),(14,'sex','性别'),(15,'cartype','车辆类型'),(16,'classname','分类名称'),(17,'brandname','品牌名称'),(18,'states','车辆状态'),(19,'displacemini','排气量'),(20,'allowancemode','补助方式');

/*Table structure for table `sys_dmzd` */

DROP TABLE IF EXISTS `sys_dmzd`;

CREATE TABLE `sys_dmzd` (
  `ID` int(30) NOT NULL auto_increment,
  `BH` varchar(50) NOT NULL,
  `MC` varchar(50) default NULL,
  `LBBH` varchar(50) default NULL,
  `JSXS` double(30,2) default NULL,
  `SSCY` varchar(10) default '0',
  `ZDLX` varchar(10) default '0',
  `STARTMARK` varchar(10) default '0',
  `SJBH` varchar(50) default NULL,
  `REMARK` varchar(1000) default NULL,
  `SSXT` varchar(10) default '0',
  `QZGY` varchar(10) default '0',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_dmzd` */

insert  into `sys_dmzd`(`ID`,`BH`,`MC`,`LBBH`,`JSXS`,`SSCY`,`ZDLX`,`STARTMARK`,`SJBH`,`REMARK`,`SSXT`,`QZGY`) values (1,'01','车改办','depttype',0.00,'0','0','0',NULL,NULL,'0','0'),(2,'02','其他','depttype',0.00,'0','0','0',NULL,NULL,'0','0'),(3,'01','直属','deptlevel',0.00,'0','0','0',NULL,'1','0','0'),(4,'02','下属','deptlevel',0.00,'0','0','0',NULL,NULL,'0','0'),(5,'0','正常','state',0.00,'0','0','0',NULL,NULL,'0','0'),(6,'1','冻结','state',0.00,'0','0','0',NULL,NULL,'0','0'),(7,'2','注销','state',0.00,'0','0','0',NULL,NULL,'0','0'),(8,'view','浏览','actionid',0.00,'0','0','0',NULL,NULL,'0','0'),(9,'add','新增','actionid',0.00,'0','0','0',NULL,NULL,'0','0'),(10,'update','修改','actionid',0.00,'0','0','0',NULL,NULL,'0','0'),(11,'delete','删除','actionid',0.00,'0','0','0',NULL,NULL,'0','0'),(12,'permission','全部权限','actionid',0.00,'0','0','0',NULL,NULL,'0','0'),(13,'00','超级管理员角色','roletype',0.00,'0','-1','0','0',NULL,'0','0'),(14,'01','普通用户角色','roletype',NULL,NULL,NULL,'0','0','',NULL,NULL),(15,'01','菜单','resourcetype',0.00,'0','-1','0','0',NULL,'0','0'),(16,'02','其他','resourcetype',0.00,'0','-1','0','0',NULL,'0','0'),(17,'370702','潍城区','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(18,'370704','坊子区','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(19,'370724','临朐县','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(20,'370781','青州市','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(21,'370783','寿光市','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(22,'370785','高密市','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(23,'370701','市辖区','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(24,'370703','寒亭区','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(25,'370705','奎文区','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(26,'370725','昌乐县','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(27,'370782','诸城市','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(28,'370784','安丘市','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(29,'370786','昌邑市','enterpriseqy',0.00,'0','3','0','370700',NULL,'0','0'),(30,'370793','峡山区','enterpriseqy',0.00,'0','-1','0','370700',NULL,'0','0'),(31,'01','市直','unittype',NULL,'0','0','0',NULL,NULL,'0','0'),(32,'01','1级','unitlevel',NULL,'0','0','0',NULL,NULL,'0','0'),(40,'01','轿车','cartype',NULL,'0','0','0',NULL,NULL,'0','0'),(60,'01','基本公务用车','classname',NULL,'0','0','0',NULL,NULL,'0','0'),(61,'02','特殊公务用车','classname',NULL,'0','0','0',NULL,NULL,'0','0'),(62,'03','其他用车','classname',NULL,'0','0','0',NULL,NULL,'0','0'),(70,'01','奥迪','brandname',NULL,'0','0','0',NULL,NULL,'0','0'),(100,'01','0.8L','displacemini',NULL,'0','0','0',NULL,NULL,'0','0'),(101,'02','1.0L','displacemini',NULL,'0','0','0',NULL,NULL,'0','0'),(110,'01','在用','states',NULL,'0','0','0',NULL,NULL,'0','0'),(111,'02','未使用','states',NULL,'0','0','0',NULL,NULL,'0','0'),(120,'A','全部补助','allowancemode',NULL,'0','0','0',NULL,NULL,'0','0'),(121,'B','定项补助','allowancemode',NULL,'0','0','0',NULL,NULL,'0','0'),(122,'C','定额补助','allowancemode',NULL,'0','0','0',NULL,NULL,'0','0'),(123,'D','零补助','allowancemode',NULL,'0','0','0',NULL,NULL,'0','0'),(124,'02','小型客车','cartype',NULL,NULL,NULL,'0','','',NULL,NULL),(125,'03','中型客车','cartype',NULL,NULL,NULL,'0','','',NULL,NULL),(126,'04','商务车','cartype',NULL,NULL,NULL,'0','','',NULL,NULL),(127,'05','面包','cartype',NULL,NULL,NULL,'0','','',NULL,NULL),(128,'06','越野','cartype',NULL,NULL,NULL,'0','','',NULL,NULL),(129,'0101','基本公务用车－领导用车','classname',NULL,NULL,NULL,'0','01','',NULL,NULL),(130,'0102','基本公务用车－一般用车','classname',NULL,NULL,NULL,'0','01','',NULL,NULL),(131,'02','红旗','brandname',NULL,NULL,NULL,'0','','',NULL,NULL),(132,'03','帕萨特','brandname',NULL,NULL,NULL,'0','','',NULL,NULL),(133,'04','本田雅阁','brandname',NULL,NULL,NULL,'0','','',NULL,NULL),(134,'05','君越','brandname',NULL,NULL,NULL,'0','','',NULL,NULL),(135,'03','留用','states',NULL,NULL,NULL,'0','','',NULL,NULL),(136,'04','报废','states',NULL,NULL,NULL,'0','','',NULL,NULL);

/*Table structure for table `sys_idinfo` */

DROP TABLE IF EXISTS `sys_idinfo`;

CREATE TABLE `sys_idinfo` (
  `TABLENAME` varchar(50) NOT NULL,
  `FIELDNAME` varchar(50) NOT NULL,
  `CURRENTVALUE` int(11) default NULL,
  `LASTSTEP` int(11) default NULL,
  PRIMARY KEY  (`TABLENAME`,`FIELDNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `sys_idinfo` */

insert  into `sys_idinfo`(`TABLENAME`,`FIELDNAME`,`CURRENTVALUE`,`LASTSTEP`) values ('job_carinfo','id',73,1),('job_unitcarinfo','id',12,1),('sys_carinfo','id',100,1),('sys_department','deptid',8,1),('sys_dmlb','id',100,1),('sys_dmzd','id',200,1),('sys_log','logid',1,1),('sys_permission','permissionid',16,1),('sys_resource','resourceid',20,1),('sys_role','roleid',3,1),('sys_unit','unitid',1302,1),('sys_unitcarinfo','id',100,1),('sys_users','userid',2,1);

/*Table structure for table `sys_log` */

DROP TABLE IF EXISTS `sys_log`;

CREATE TABLE `sys_log` (
  `LOGID` int(30) NOT NULL,
  `USERID` varchar(50) NOT NULL,
  `IP` varchar(20) default NULL,
  `OPERATION` varchar(200) default NULL,
  `OPERTIME` varchar(20) default NULL,
  `RES01` varchar(50) default NULL,
  `RES02` varchar(50) default NULL,
  `RES03` varchar(50) default NULL,
  `RES04` varchar(50) default NULL,
  `RES05` double(30,2) default NULL,
  `RES06` double(30,2) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_log` */

/*Table structure for table `sys_permission` */

DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission` (
  `PERMISSIONID` int(30) NOT NULL,
  `PERMISSIONNAME` varchar(50) NOT NULL,
  `RESOURCEID` int(30) NOT NULL,
  `ACTIONID` varchar(100) NOT NULL,
  `PERMISSIONNO` varchar(50) default NULL,
  `PPERMISSIONNO` varchar(50) default NULL,
  PRIMARY KEY  (`PERMISSIONID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_permission` */

insert  into `sys_permission`(`PERMISSIONID`,`PERMISSIONNAME`,`RESOURCEID`,`ACTIONID`,`PERMISSIONNO`,`PPERMISSIONNO`) values (1,'系统管理',1,'permission','1','1'),(2,'部门管理',2,'permission','11','1'),(3,'单位管理',3,'permission','12','1'),(4,'资源管理',4,'permission','13','1'),(5,'权限管理',5,'permission','14','1'),(6,'角色管理',6,'permission','15','1'),(7,'用户管理',7,'permission','16','1'),(8,'密码设置',8,'permission','17','1'),(9,'数据字典',9,'permission','2','0'),(10,'代码字典',10,'permission','21','2'),(11,'车辆信息管理',11,'permission','3','0'),(12,'车辆信息登记',12,'permission','31','3'),(13,'单位车辆登记',13,'permission','32','3'),(14,'车辆信息查询',14,'permission','4','0'),(15,'信息综合查询',15,'permission','41','4');

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `RESOURCEID` int(30) NOT NULL,
  `RESOURCENO` varchar(10) NOT NULL,
  `PRESOURCENO` varchar(10) NOT NULL,
  `RESOURCENAME` varchar(50) NOT NULL,
  `LINK` varchar(50) default NULL,
  `REMARK` varchar(200) default NULL,
  `ISDELETE` varchar(10) default NULL,
  `TYPE` varchar(10) default NULL,
  `IMAGEURL` varchar(100) default NULL,
  `WINSIZE` varchar(100) default NULL,
  PRIMARY KEY  (`RESOURCEID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`RESOURCEID`,`RESOURCENO`,`PRESOURCENO`,`RESOURCENAME`,`LINK`,`REMARK`,`ISDELETE`,`TYPE`,`IMAGEURL`,`WINSIZE`) values (1,'1','0','系统管理','111',NULL,NULL,'01',NULL,NULL),(2,'11','1','部门管理',NULL,NULL,NULL,'01',NULL,NULL),(3,'12','1','单位管理',NULL,NULL,NULL,'01',NULL,NULL),(4,'13','1','资源管理',NULL,NULL,NULL,'01',NULL,NULL),(5,'14','1','权限管理',NULL,NULL,NULL,'01',NULL,NULL),(6,'15','1','角色管理',NULL,NULL,NULL,'01',NULL,NULL),(7,'16','1','用户管理',NULL,NULL,NULL,'01',NULL,NULL),(8,'17','1','密码设置','','','','01','',''),(9,'2','0','数据字典','','','','01','',''),(10,'21','2','代码字典','','','','01','',''),(11,'3','0','车辆信息管理','','','','01','',''),(12,'31','3','车辆信息登记','','','','01','',''),(13,'32','3','单位车辆登记','','','','01','',''),(14,'4','0','车辆信息查询','','','','01','',''),(15,'41','4','信息综合查询','','','','01','','');

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `ROLEID` int(30) NOT NULL,
  `ROLENAME` varchar(20) NOT NULL default '',
  `TITLE` varchar(100) NOT NULL default '',
  `DESCRIPTION` varchar(200) NOT NULL default '',
  `TYPE` varchar(10) NOT NULL default '',
  PRIMARY KEY  (`ROLEID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_role` */

insert  into `sys_role`(`ROLEID`,`ROLENAME`,`TITLE`,`DESCRIPTION`,`TYPE`) values (1,'超级管理员','超级管理员角色','系统支撑平台的管理','00'),(2,'普通用户','普通用户角色','其他用户角色','01');

/*Table structure for table `sys_rolepermission` */

DROP TABLE IF EXISTS `sys_rolepermission`;

CREATE TABLE `sys_rolepermission` (
  `ROLEID` int(30) NOT NULL,
  `PERMISSIONID` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_rolepermission` */

insert  into `sys_rolepermission`(`ROLEID`,`PERMISSIONID`) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(2,11),(2,12),(2,13),(2,14),(2,15);

/*Table structure for table `sys_userroles` */

DROP TABLE IF EXISTS `sys_userroles`;

CREATE TABLE `sys_userroles` (
  `USERID` int(30) NOT NULL,
  `ROLEID` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_userroles` */

insert  into `sys_userroles`(`USERID`,`ROLEID`) values (1,1),(2,2);

/*Table structure for table `sys_users` */

DROP TABLE IF EXISTS `sys_users`;

CREATE TABLE `sys_users` (
  `USERID` int(30) NOT NULL,
  `USERXM` varchar(50) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `POSTPRIV` varchar(50) default NULL,
  `DEPTID` int(30) default NULL,
  `SEX` varchar(10) default NULL,
  `BIRTHDAY` varchar(20) default NULL,
  `ISHIDEBIRTHDAY` varchar(10) default NULL,
  `ADDRESSHOME` varchar(100) default NULL,
  `ZIPHOME` varchar(10) default NULL,
  `TELHOME` varchar(50) default NULL,
  `MOBILE` varchar(50) default NULL,
  `ISHIDEMOBILE` varchar(10) default NULL,
  `EMAIL` varchar(100) default NULL,
  `OICQ` varchar(20) default NULL,
  `ICQ` varchar(20) default NULL,
  `MSN` varchar(50) default NULL,
  `SKYPE` varchar(50) default NULL,
  `NICKNAME` varchar(50) default NULL,
  `SMSON` varchar(10) default NULL,
  `DUTYTYPE` varchar(10) default NULL,
  `STATE` varchar(10) default NULL,
  `BINDIP` varchar(20) default NULL,
  `USINGKEY` varchar(10) default NULL,
  `UGUID` varchar(50) default NULL,
  `UKEY` varchar(50) default NULL,
  `USETYPE` varchar(10) default NULL,
  `REGIONCODE` varchar(50) default NULL,
  `RES01` varchar(50) default NULL,
  `RES02` varchar(50) default NULL,
  `RES03` varchar(50) default NULL,
  `RES04` varchar(50) default NULL,
  `RES05` double(30,2) default NULL,
  `RES06` double(30,2) default NULL,
  `SSQY` varchar(10) default NULL,
  PRIMARY KEY  (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

/*Data for the table `sys_users` */

insert  into `sys_users`(`USERID`,`USERXM`,`USERNAME`,`PASSWORD`,`POSTPRIV`,`DEPTID`,`SEX`,`BIRTHDAY`,`ISHIDEBIRTHDAY`,`ADDRESSHOME`,`ZIPHOME`,`TELHOME`,`MOBILE`,`ISHIDEMOBILE`,`EMAIL`,`OICQ`,`ICQ`,`MSN`,`SKYPE`,`NICKNAME`,`SMSON`,`DUTYTYPE`,`STATE`,`BINDIP`,`USINGKEY`,`UGUID`,`UKEY`,`USETYPE`,`REGIONCODE`,`RES01`,`RES02`,`RES03`,`RES04`,`RES05`,`RES06`,`SSQY`) values (1,'超级管理员','admin','90737BC7C7FFA0BC9D7ECFD7FBF5BA6E',NULL,2,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'370700'),(2,'车辆管理员','cm','90737BC7C7FFA0BC9D7ECFD7FBF5BA6E',NULL,2,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
