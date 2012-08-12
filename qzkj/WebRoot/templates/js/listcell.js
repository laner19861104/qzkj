function CellLogin()
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("控件注册失败！");
    }	
}
function getColPos(FdName)  
{
  var p=-1;
  for(key1 in dic)
     {
       p++;
       if(key1==FdName)
         break;
     }
  return p;
}
//需要计算合计的sum列
var doubleColSet ={};
function sumListSet(queryFlag)
{
    if(typeof(notSumFlag)!="undefined")
       return;
    var p=0;
    for (key1 in doubleColSet)
    {
        p++;
        cell.SetCellNumType(key1,rows.length + 2, 0, 1);                //设置类型
        cell.SetCellDigital(key1,rows.length + 2, 0, 2);                //设置小数位数
        cell.SetCellSeparator(key1,rows.length + 2, 0, 2);	
        startLable=cell.CellToLabel(key1,2);
        endLable=cell.CellToLabel(key1,rows.length + 1);
        if(queryFlag=="1")
          formulaText="Sum2d("+startLable+":"+endLable+",A=\"1\")";
        else
          formulaText="Sum2d("+startLable+":"+endLable+",C=\"1\")";
        cell.SetFormula(key1,rows.length + 2,0,formulaText);
    }
    if(p>0)
    {
      if(queryFlag=="1")
        cell.S(2,rows.length + 2,0,"合计");
      else
        cell.S(4,rows.length + 2,0,"合计");
    }
}

//默认排序方式
var sort_col=0;
//只读行
var readOnlyRowSet="";
//升序排列
var total_sum=0;
function sort_col_asc()
{
    cell.SortCol(1,sort_col,1,1,cell.GetCols(0),cell.GetRows(0));
    for (i = 0; i < fields.length; i ++)
    {
        if(i+3==sort_col)
          cell.S((i + 3), 1, 0, dic[fields[i]][1]+"↑"); //↓
        else
          cell.S((i + 3), 1, 0, dic[fields[i]][1])
    }	
}
//降序排列
function sort_col_desc()
{
    cell.SortCol(0,sort_col,1,1,cell.GetCols(0),cell.GetRows(0));
    for (i = 0; i < fields.length; i ++)
    {
        if(i+3==sort_col)
          cell.S((i + 3), 1, 0, dic[fields[i]][1]+"↓"); //
        else
          cell.S((i + 3), 1, 0, dic[fields[i]][1])
    }

}
function addNew(className, url_para)
{
    if (!url_para)
        url_para = "";
    location = className + "Action.jsp?cmd=create" + ((url_para.length == 0) ? "" : "&" + url_para);
}
function cmd_change_page(url_para, currpage, lastpage)
{
    var page = document.getElementById('changepageinput');
    if (page.value > 0 && page.value <= lastpage ) {
        document.change_page_form.action = url_para + page.value;
        document.change_page_form.submit();
    } else {
        page.value = currpage;
    }
}
/*---------------------------------------------------------------*/
/* Cell 事件处理函数                                             */
function appendLine(){
    cell.InsertRow(cell.GetCurrentRow() + 1, 1, cell.GetCurSheet());
}
function cell_CheckCellChanged(col, row){
    if(col == 1 && row == 1) {
        for(var i = 2; i < cell.GetRows(0); i ++) {
            if(cell.GetCellType(1, i, 0) == 4) {
                cell.D(1, i, 0, cell.GetCellDouble(1, 1, 0));
                if(cell.GetCellDouble(1, 1, 0)==1)
                    cell.SetCellBackColor(-1,i,0,cell.FindColorIndex(0xFFFF00,1));
                else
                    cell.SetCellBackColor(-1,i,0,16777215);
            }
        }
    } else if(col == 1 && row > 1) {
        if(cell.GetCellType(1, row, 0) == 4) {
            if(cell.GetCellDouble(1, row, 0)==1) {
                cell.SetCellBackColor(-1,row,0,cell.FindColorIndex(0xFFFF00,1));
                //cell.SetCellBackColor(-1,row,0,2);
                
            } else {
                cell.SetCellBackColor(-1,row,0,16777215);
            }
        }
        
    }
}
//计算选中行数的金额总数
//2005-9-15 dfz add
function getTotalSum(getcol,row)
{
   
    if(cell.GetCellDouble(1, row, 0) == 1) {
            total_sum =total_sum+cell.getCellDouble(getcol,row,0);
        }
        else
            total_sum =total_sum-cell.getCellDouble(getcol,row,0);
    
    return total_sum;
   
}

function isLastRowCol(cell){
    //判断是否最后一行最后一列
    return cell.GetCurrentRow()==cell.GetRows(cell.GetCurSheet())-1 && cell.GetCurrentCol()==cell.GetCols(cell.GetCurSheet())-1
}
function cell_KeyDown(KeyCode,Shift) {
    return;
    if(KeyCode == 13 && isLastRowCol(cell)){
        appendLine();
    }
}
function getFieldIndex(fstr) {
    for (var i = 0; i < allfields.length; i ++) {
        if (fstr == allfields[i]) {
            return i;
        }
    }
    return 0;
}
//折叠Cell输出
var isShowCompCell = false;
function showCompCell()
{
    isShowCompCell = true;
    showCell();
}
function postShowCompCell()
{
    var str=Array();
    for(p=0;p<compagesRow.length;p++)
    {
        str=compagesRow[p].split(":");
        cell.AddRowCompages(str[0],parseInt(str[1])-1);
        cell.SetRowHidden(str[0],parseInt(str[1])-1);
    }
}
//折叠Cell输出
function showQueryCompCell()
{
    showQueryCell();
    var str=Array();
    for(p=0;p<compagesRow.length;p++)
    {
        str=compagesRow[p].split(":");
        cell.AddRowCompages(str[0],parseInt(str[1])-1);
        cell.SetRowHidden(str[0],parseInt(str[1])-1);
    }
}
var showfields = new Array();
var rowsize;
var currow = 0;
var rownum = 50;
var colsize

//查询cell输出
function fillQueryCell() {
    var rowend = currow + rownum;
    for (i = currow; (i < rowend) && (i < rowsize); i ++) {
        var row = i + 2;
        if(inSumList(row))
          cell.S(1, row, 0, "1");
        else
          cell.S(1, row, 0, "0");
        for (j = 0; j < colsize; j ++) {
            var col = j + 2;
            var k = showfields[j];
            switch(dic[fields[j]][0]){
                case "double":
                    if(currow==0)
                    {
                       doubleColSet[col+""]="0";
                    }
                    cell.SetCellInput(col, row, 0, 2);
                    cell.D(col, row, 0, parseFloat(rows[i][k]));
                    cell.SetCellNumType(col, row, 0, 1);  //设置类型
                    if (dic[fields[j][0]]==0.00)
                        cell.DetCellDigital(col, row, 0, 0);  //设置小数位数
                    else
                        cell.SetCellDigital(col, row, 0, 2);
                    cell.SetCellHideZero(col,row, 0, 1);
                    cell.SetCellSeparator(col, row, 0, 2);
                    if (cell.GetCellDouble(col, row, 0)<0) { //负数记录,显示红色
                        cell.SetCellTextColor(col,row,0,cell.FindColorIndex(0x0000FF,1));
                    }
                    break;
                default:
                    if (rows[i][k] != 'null') {
                        cell.S(col, row, 0, rows[i][k]);
                    }
                    break;
            }
        }
    }
    if (rowend < rowsize) {
        timer = window.setTimeout("fillQueryCell()", 50);
    } else {
        window.clearTimeout(timer);
        sumListSet("1");
        timer = null;
    }
    currow += rownum;
}

function showQueryCell(){
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("注册失败");
        return;
    }
    cell.ShowSheetLabel(0, 0);
    cell.CurCellMoveDir = 2;
    cell.SetDefaultColWidth(0, 1, 100);
    cell.SetDefaultRowHeight(0, 1, 30);
    cell.ShowSideLabel(0, 0);
    cell.ShowTopLabel(0, 0);
    cell.WndBkColor=16777215;
    cell.AllowSizeRowInGrid=true;
    cell.AllowSizeColInGrid=true;
    
    if(rows.length==0)
      cell.SetRows(rows.length + 2, 0);
    else
      cell.SetRows(rows.length + 3, 0);
    cell.SetCols(fields.length + 2, 0);
    cell.SetSheetGridLineColor(0,0xFF0000);
    keyindex = getFieldIndex(keyfield);
    rowsize = rows.length;
    colsize = fields.length
    cell.S(1, 1, 0, "flag");
    for (i = 0; i < fields.length; i ++) {
        cell.S((i + 2), 1, 0, dic[fields[i]][1]);
        showfields[i] = getFieldIndex(fields[i]);
    }
    cell.SetFixedRow(1, 1);
    cell.SetFixedCol(1, 5);
    cell.SetSelectMode(0,2);
    cell.SetColHidden(1, 1);
    timer = window.setTimeout("fillQueryCell()", 0);
}
//查询cell输出,并排序
function showQueryCellOrder(){
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("注册失败");
        return;
    }
    cell.ShowSheetLabel(0, 0);
    cell.CurCellMoveDir = 2;
    cell.SetDefaultColWidth(0, 1, 100);
    cell.SetDefaultRowHeight(0, 1, 30);
    cell.ShowSideLabel(0, 0);
    cell.ShowTopLabel(0, 0);
    cell.WndBkColor=16777215;
    cell.AllowSizeRowInGrid=true;
    cell.AllowSizeColInGrid=true;
    cell.SetRows(rows.length + 2, 0);
    cell.SetCols(fields.length + 1, 0);
    cell.SetSheetGridLineColor(0,0xFF0000);
    var showfields = new Array();
    var keyindex = getFieldIndex(keyfield);
    for (i = 0; i < fields.length; i ++) {
        cell.S((i + 1), 1, 0, dic[fields[i]][1]);
        showfields[i] = getFieldIndex(fields[i]);
    }
    for (i = 0; i < rows.length; i ++) {
        var row = i + 2
            for (j = 0; j < fields.length; j ++) {
                var col = j + 1;
                var k = showfields[j]
                    switch(dic[fields[j]][0]){
                        case "double":
                            cell.SetCellInput(col, row, 0, 2);
                        cell.D(col, row, 0, parseFloat(rows[i][k]));
                        cell.SetCellNumType(col, row, 0, 1);                //设置类型
                        if (dic[fields[j][0]]==0.00)
                            cell.SetCellDigital(col, row, 0, 0);                //设置小数位数
                        else
                            cell.SetCellDigital(col, row, 0, 2);                //设置小数位数
                        cell.SetCellHideZero(col,row, 0, 1);
                        cell.SetCellSeparator(col, row, 0, 2);
                        
                        if(cell.GetCellDouble(col, row, 0)<0)  //负数记录,显示红色
                            cell.SetCellTextColor(col,row,0,cell.FindColorIndex(0x0000FF,1));
                        break;
                        default:

                        if (rows[i][k] != 'null') {
                            cell.S(col, row, 0, rows[i][k]);
                        }
                        break;
                    }
            }
    }
    cell.SetFixedRow(1, 1);
    cell.SetFixedCol(1, 5);
    cell.SetSelectMode(0,2);
    cell.SortCol(1,1,1,1,cell.getCols(0),cell.getRows(0));
    /*设置余额列数值
     *add by shiyong
     *2005-07-19
     2005年10月30日 jinxz 修改
    */
    
    if (fields[3] =="ItemId"){
        if(cell.GetCellString(2,2,0) == "")
            cell.D(9,2,0,cell.GetCellDouble(8,2,0));
        else
            cell.D(9,2,0,(0-cell.GetCellDouble(8,2,0)));
        
        for (i =3; i <= rows.length+1; i ++){
            if(cell.GetCellString(2,i,0) =="")
                cell.D(9,i,0,(cell.GetCellDouble(9,i-1,0)+cell.GetCellDouble(8,i,0)));
            else
                cell.D(9,i,0,(cell.GetCellDouble(9,i-1,0)-cell.GetCellDouble(8,i,0)));
        }
    }
    else{
        if(cell.GetCellString(2,2,0) == "")
            cell.D(6,2,0,cell.GetCellDouble(4,2,0));
        else
            cell.D(6,2,0,(0-cell.GetCellDouble(5,2,0)));
        for (i =3; i <= rows.length+1; i ++){
            
            if(cell.GetCellString(2,i,0) =="")
                cell.D(6,i,0,(cell.GetCellDouble(6,i-1,0)+cell.GetCellDouble(4,i,0)));
            else
                cell.D(6,i,0,(cell.GetCellDouble(6,i-1,0)-cell.GetCellDouble(5,i,0)));
        }
    }
        
    for (i = 0; i < fields.length; i ++) {
        cell.S((i + 1), 1, 0, dic[fields[i]][1]);
    }
    for (i = 3; i <= rows.length+1; i ++)
    {
       
        if (fields[3] =="ItemId")
        {
          if(cell.GetCellDouble(9,i,0) < 0.001 && cell.GetCellDouble(9,i,0) > -0.001 )
            cell.D(9,i,0,(0));
        }
        else
        {
          if(cell.GetCellDouble(6,i,0) < 0.001 && cell.GetCellDouble(6,i,0) > -0.001)
            cell.D(6,i,0,(0));
        }   
       
    }
}
function inSumList(rowId)
{
    
    if(typeof(vouherNotRows)!="undefined")  
    {
      for(key1 in vouherNotRows)
         {
           
           if(key1==rowId)
             return false;	
         }
      return true;	
    }
    
    
    if(typeof(otherNotRows)!="undefined")  
    {
      for(key1 in otherNotRows)
         {
           if(key1==rowId)
             return false;	
         }	
    }
    if(typeof(compagesRow)=="undefined")  
      return true; 
    if(compagesRow.length==0)
      return true; 
    var str=Array();
    for(p=0;p<compagesRow.length;p++)
    {
        str=compagesRow[p].split(":");
        var start=parseInt(str[0])-1;
        var end=parseInt(str[1]);
        if(parseInt(rowId)>start&&parseInt(rowId)<end)
        {
          return false;	
        }
    }
    return true;
}
//普通Cell输出
function fillCell()
{
    var rowend = currow + rownum;
    for (i = currow; (i < rowend) && (i < rowsize); i ++)
    {
        var row = i + 2;
        if(readOnlyRowSet.indexOf("_"+rows[i][keyindex]+"_")<0)  //折叠行中，设置只读行
          cell.SetCheckCell(1, row, 0, '', 2);
        cell.S(2, row, 0, rows[i][keyindex]);
        if(inSumList(row))
          cell.S(3, row, 0, "1");
        else
          cell.S(3, row, 0, "0");
        for (j = 0; j < colsize; j ++)
        {
            var col = j + 4;
            var k = showfields[j];
            switch(dic[fields[j]][0])
            {
                case "double":
                    if(currow==0)
                    {
                       doubleColSet[col+""]="0";
                    }
                    cell.SetCellInput(col, row, 0, 2);
                    cell.D(col, row, 0, parseFloat(rows[i][k]));
                    cell.SetCellNumType(col, row, 0, 1);  //设置类型
                    cell.SetCellDigital(col, row, 0, 2);  //设置小数位数
                    cell.SetCellSeparator(col, row, 0, 2);
                    if(cell.GetCellDouble(col, row, 0)<0) { //负数记录,显示红色
                        cell.SetCellTextColor(-1,row,0,cell.FindColorIndex(0x0000FF,1));
                    }
                    break;
                default:
                    if (rows[i][k] != 'null')
                     {
                        cell.S(col, row, 0, rows[i][k]);
                        if(fields[j]=="OpType")
                        {
                            if(rows[i][k]!="正常")	//调整记录，显示蓝色
                                cell.SetCellTextColor(-1,row,0,cell.FindColorIndex(0xFF0000,1));
                        }
                     }
                    else 
                    {
                        cell.S(col, row, 0, " ");
                        if(fields[j]=="CurRole")  //退回到录入人的记录显示黄色 0x30C7FF,暂时调为红色
                        {
                            //cell.SetCellTextColor(-1,row,0,cell.FindColorIndex(0x00FF00,1));
                            cell.SetCellTextColor(-1,row,0,cell.FindColorIndex(0xFF00FF,1));
                        }
                    }
                    break;
            }
        }
    }
    if (rowend < rowsize)
    {
        timer = window.setTimeout("fillCell()", 50);
    } 
    else
    {
        window.clearTimeout(timer);
        sumListSet("0");
        timer = null;
        if (isShowCompCell)
        {
            postShowCompCell();
        }
    }
    currow += rownum;
}
function showQueryCell_1(){
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("注册失败");
        return;
    }
    cell.ShowSheetLabel(0, 0);
    cell.CurCellMoveDir = 2;
    cell.SetDefaultColWidth(0, 1, 100);
    cell.SetDefaultRowHeight(0, 1, 30);
    cell.ShowSideLabel(0, 0);
    cell.ShowTopLabel(0, 0);
    cell.WndBkColor=16777215;
    cell.AllowSizeRowInGrid=true;
    cell.AllowSizeColInGrid=true;
    
    if(rows.length==0)
      cell.SetRows(rows.length + 2, 0);
    else
      cell.SetRows(rows.length + 3, 0);
    cell.SetCols(fields.length + 2, 0);
    cell.SetSheetGridLineColor(0,0xFF0000);
    keyindex = getFieldIndex(keyfield);
    rowsize = rows.length;
    colsize = fields.length
    cell.S(1, 1, 0, "flag");
    for (i = 0; i < fields.length; i ++) {
        cell.S((i + 2), 1, 0, dic[fields[i]][1]);
        showfields[i] = getFieldIndex(fields[i]);
    }
    //cell.SetFixedRow(1, 1);
    //cell.SetFixedCol(1, 5);
    cell.SetSelectMode(0,2);
    cell.SetColHidden(1, 1);
    timer = window.setTimeout("fillQueryCell()", 0);
}
function showCell() {
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("注册失败");
        return;
    }
    cell.ShowSheetLabel(0, 0);
    cell.CurCellMoveDir = 2;
    cell.SetDefaultColWidth(0, 1, 100);
    cell.SetDefaultRowHeight(0, 1, 30);
    cell.SetColWidth(1, 20, 1, 0);
    if(typeof(changeCol)!="undefined")
    {
        cell.SetColWidth(1, 50, changeCol, 0);
    }
    
    cell.ShowSideLabel(0, 0);
    cell.ShowTopLabel(0, 0);
    cell.Border=1;
    cell.WndBkColor=16777215;
    cell.AllowSizeRowInGrid=true;
    cell.AllowSizeColInGrid=true;
    
    if(rows.length==0)
      cell.SetRows(rows.length + 2, 0);
    else
      cell.SetRows(rows.length + 3, 0);
    cell.SetCols(fields.length + 4, 0);
    cell.SetCheckCell(1, 1, 0, '', 2);
    cell.S(2, 1, 0, keyfield);
    cell.S(3, 1, 0, "flag");
    keyindex = getFieldIndex(keyfield);
    rowsize = rows.length;
    colsize = fields.length;
    cell.SetSheetGridLineColor(0,0xFF0000);
    for (i = 0; i < fields.length; i ++) {
        cell.SetCellInput((i + 4), 1, 0, 5);
        if(typeof(widthSet)!="undefined")
        {
           var curWidth=widthSet[fields[i]];
           if(typeof(curWidth)!="undefined")
           {
             cell.SetColWidth(1, curWidth, i+4, 0);
           }  	
        }
        cell.S((i + 4), 1, 0, dic[fields[i]][1]);
        showfields[i] = getFieldIndex(fields[i]);
    }
    cell.SetFixedRow(1, 1);
    cell.SetFixedCol(1, 6);
    
    cell.SetColHidden(2, 3);
    
    timer = window.setTimeout("fillCell()", 0);
}

function deleteList(className, url_para)
{
    var chkeds = new Array();
    for(var i = 2; i < cell.GetRows(0); i ++) {
        if(cell.GetCellDouble(1, i, 0) == 1) {
            chkeds.push(cell.GetCellString(2, i, 0));
        }
    }
    if (chkeds.length > 0) {
        if (confirm("确实要删除这些记录吗?")) {
            location = className + "Action.jsp?cmd=deletelist&listcell=1&idlist=" + chkeds.join(',') + ((url_para.length == 0) ? "" : "&" + url_para);
        }
    } else {
        alert("未选择记录！");
    }
}
function writeEvent() {
    document.write('<script language="javascript" for="cell" event="CheckCellChanged(col, row)">\n' +
            'cell_CheckCellChanged(col, row);\n' +
            '</script>\n' +
            '<script language="javascript" for="cell" event="KeyDown(KeyCode, Shift)">\n' +
            'cell_KeyDown(KeyCode, Shift);\n' +
            '</script>\n');
}
function getIdList(type1)
{
    var chkeds = new Array();
    var flag=0;
    for(var i = 2; i < cell.GetRows(0); i ++) {
        if(cell.GetCellDouble(1, i, 0) == 1) {
            flag = 1;
            chkeds.push(cell.GetCellString(2, i, 0));
        }
    }
    if (flag == 0) {
        return "-1";  //没有选择行
    } else {
        if (type1 == 0 )  {
            return chkeds[0];
        } else {
            return chkeds.join(',');
        }
    }
}
function exportFile()
{
    cell.ExportExcelDlg()
}
function print()
{
    cell.PrintSetOrient(1); //2006-10-30 add by dfz,设置打印时进纸方向为横向
    cell.PrintPreview(1,0);
}

function showCombineCell(){
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("注册失败");
        return;
    }
    cell.ShowSheetLabel(0, 0);
    cell.CurCellMoveDir = 2;
    cell.SetDefaultColWidth(0, 1, 100);
    cell.SetDefaultRowHeight(0, 1, 20);
    cell.ShowSideLabel(0, 0);
    cell.ShowTopLabel(0, 0);
    cell.WndBkColor=16777215;
    cell.AllowSizeRowInGrid=true;
    cell.AllowSizeColInGrid=true;
    cell.SetCols(27, 0);
    cell.SetSheetGridLineColor(0,0xFF0000);
    
    cell.MergeCells(1,1,26,1);
    cell.MergeCells(1,2,26,2);
    cell.S(1,1,0,"预算执行情况");
    cell.SetCellAlign(1,1,0,32+4); 

    cell.MergeCells(1,3,2,3);
    cell.S(1,3,0,"单位");
    cell.SetCellAlign(1,3,0,32+4); 

    cell.MergeCells(1,4,1,5);
    cell.S(1,4,0,"单位编码");
    cell.SetCellAlign(1,4,0,32+4); 
    cell.MergeCells(2,4,2,5);
    cell.S(2,4,0,"单位名称");
    cell.SetCellAlign(2,4,0,32+4); 
    
    cell.MergeCells(3,3,5,3);    
    cell.S(3,3,0,"科目编码");
    cell.SetCellAlign(3,3,0,32+4); 
    
    cell.MergeCells(3,4,3,5);
    cell.S(3,4,0,"类");
    cell.SetCellAlign(3,4,0,32+4); 
    cell.SetColWidth(1,30,3,0);
    cell.MergeCells(4,4,4,5);
    cell.S(4,4,0,"款");
    cell.SetCellAlign(4,4,0,32+4); 
    cell.SetColWidth(1,30,4,0);
    cell.MergeCells(5,4,5,5);
    cell.S(5,4,0,"项");
    cell.SetCellAlign(5,4,0,32+4); 
    cell.SetColWidth(1,30,5,0);

    cell.MergeCells(6,3,6,5);
    cell.S(6,3,0,"科目名称");
    cell.SetCellAlign(6,3,0,32+4); 
    cell.MergeCells(7,3,7,5);
    cell.S(7,3,0,"项目编码");
    cell.SetCellAlign(7,3,0,32+4);     
    cell.MergeCells(8,3,8,5);
    cell.S(8,3,0,"项目名称");
    cell.SetCellAlign(8,3,0,32+4);   
    cell.MergeCells(9,3,9,5);
    cell.S(9,3,0,"用途");
    cell.SetCellAlign(9,3,0,32+4); 

    cell.MergeCells(10,3,14,3);    
    cell.S(10,3,0,"预算指标");
    cell.SetCellAlign(10,3,0,32+4); 

    cell.MergeCells(10,4,10,5);
    cell.S(10,4,0,"总指标");
    cell.SetCellAlign(10,4,0,32+4); 
    cell.MergeCells(11,4,11,5);
    cell.S(11,4,0,"年初已用");
    cell.SetCellAlign(11,4,0,32+4);     
    cell.MergeCells(12,4,12,5);
    cell.S(12,4,0,"可用指标");
    cell.SetCellAlign(12,4,0,32+4);   
    cell.MergeCells(13,4,13,5);
    cell.S(13,4,0,"已下达指标");
    cell.SetCellAlign(13,4,0,32+4);    
    cell.MergeCells(14,4,14,5);
    cell.S(14,4,0,"剩余指标");
    cell.SetCellAlign(14,4,0,32+4);   

    cell.MergeCells(15,3,23,3);    
    cell.S(15,3,0,"用款计划");
    cell.SetCellAlign(15,3,0,32+4);    

    cell.MergeCells(15,4,17,4);    
    cell.S(15,4,0,"已下达计划");
    cell.SetCellAlign(15,4,0,32+4); 
       
    cell.S(15,5,0,"合计");
    cell.SetCellAlign(15,5,0,32+4); 
    cell.S(16,5,0,"直接支付");
    cell.SetCellAlign(16,5,0,32+4); 
    cell.S(17,5,0,"授权支付");
    cell.SetCellAlign(17,5,0,32+4); 

    cell.MergeCells(18,4,20,4);    
    cell.S(18,4,0,"已支用计划");
    cell.SetCellAlign(18,4,0,32+4); 
       
    cell.S(18,5,0,"合计");
    cell.SetCellAlign(18,5,0,32+4); 
    cell.S(19,5,0,"直接支付");
    cell.SetCellAlign(19,5,0,32+4); 
    cell.S(20,5,0,"授权支付");
    cell.SetCellAlign(20,5,0,32+4); 
    
    cell.MergeCells(21,4,23,4);    
    cell.S(21,4,0,"剩余计划");
    cell.SetCellAlign(21,4,0,32+4); 
       
    cell.S(21,5,0,"合计");
    cell.SetCellAlign(21,5,0,32+4); 
    cell.S(22,5,0,"直接支付");
    cell.SetCellAlign(22,5,0,32+4); 
    cell.S(23,5,0,"授权支付");
    cell.SetCellAlign(23,5,0,32+4); 

    cell.MergeCells(24,3,26,3);    
    cell.S(24,3,0,"支付");
    cell.SetCellAlign(24,3,0,32+4);  
    
    cell.MergeCells(24,4,24,5);  
    cell.S(24,4,0,"合计");
    cell.SetCellAlign(24,4,0,32+4); 
    cell.MergeCells(25,4,25,5);  
    cell.S(25,4,0,"直接支付");
    cell.SetCellAlign(25,4,0,32+4); 
    cell.MergeCells(26,4,26,5);     
    cell.S(26,4,0,"授权支付");
    cell.SetCellAlign(26,4,0,32+4); 
}
//解决cell控件因XP升级产生的激活问题
function insertCell(elm,base, w, h)
{
 if (!document.getElementById(elm)) return;
 var str = '';
 str += '<object name=cell id=cell width="'+ w +'" height="'+ h +'" classid="CLSID:3F166327-8030-4881-8BD2-EA25350E574A" codebase="'+base+'">';
 str += '</object>';
 document.getElementById(elm).innerHTML = str;
}
function insertCell(elm,base, w, h,cellname)
{
 if (!document.getElementById(elm)) return;
 var str = '';
 str += '<object name='+cellname+' id='+cellname+' width="'+ w +'" height="'+ h +'" classid="CLSID:3F166327-8030-4881-8BD2-EA25350E574A" codebase="'+base+'">';
 str += '</object>';
 document.getElementById(elm).innerHTML = str;
}