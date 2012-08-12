function CellLogin()
{
  if(cell.Login("Beelink software", "","13040483", "7140-0421-0057-6004")==0)
    {
      alert("�ؼ�ע��ʧ�ܣ�");
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
//��Ҫ����ϼƵ�sum��
var doubleColSet ={};
function sumListSet(queryFlag)
{
    if(typeof(notSumFlag)!="undefined")
       return;
    var p=0;
    for (key1 in doubleColSet)
    {
        p++;
        cell.SetCellNumType(key1,rows.length + 2, 0, 1);                //��������
        cell.SetCellDigital(key1,rows.length + 2, 0, 2);                //����С��λ��
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
        cell.S(2,rows.length + 2,0,"�ϼ�");
      else
        cell.S(4,rows.length + 2,0,"�ϼ�");
    }
}

//Ĭ������ʽ
var sort_col=0;
//ֻ����
var readOnlyRowSet="";
//��������
var total_sum=0;
function sort_col_asc()
{
    cell.SortCol(1,sort_col,1,1,cell.GetCols(0),cell.GetRows(0));
    for (i = 0; i < fields.length; i ++)
    {
        if(i+3==sort_col)
          cell.S((i + 3), 1, 0, dic[fields[i]][1]+"��"); //��
        else
          cell.S((i + 3), 1, 0, dic[fields[i]][1])
    }	
}
//��������
function sort_col_desc()
{
    cell.SortCol(0,sort_col,1,1,cell.GetCols(0),cell.GetRows(0));
    for (i = 0; i < fields.length; i ++)
    {
        if(i+3==sort_col)
          cell.S((i + 3), 1, 0, dic[fields[i]][1]+"��"); //
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
/* Cell �¼�������                                             */
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
//����ѡ�������Ľ������
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
    //�ж��Ƿ����һ�����һ��
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
//�۵�Cell���
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
//�۵�Cell���
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

//��ѯcell���
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
                    cell.SetCellNumType(col, row, 0, 1);  //��������
                    if (dic[fields[j][0]]==0.00)
                        cell.DetCellDigital(col, row, 0, 0);  //����С��λ��
                    else
                        cell.SetCellDigital(col, row, 0, 2);
                    cell.SetCellHideZero(col,row, 0, 1);
                    cell.SetCellSeparator(col, row, 0, 2);
                    if (cell.GetCellDouble(col, row, 0)<0) { //������¼,��ʾ��ɫ
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
        alert("ע��ʧ��");
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
//��ѯcell���,������
function showQueryCellOrder(){
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("ע��ʧ��");
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
                        cell.SetCellNumType(col, row, 0, 1);                //��������
                        if (dic[fields[j][0]]==0.00)
                            cell.SetCellDigital(col, row, 0, 0);                //����С��λ��
                        else
                            cell.SetCellDigital(col, row, 0, 2);                //����С��λ��
                        cell.SetCellHideZero(col,row, 0, 1);
                        cell.SetCellSeparator(col, row, 0, 2);
                        
                        if(cell.GetCellDouble(col, row, 0)<0)  //������¼,��ʾ��ɫ
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
    /*�����������ֵ
     *add by shiyong
     *2005-07-19
     2005��10��30�� jinxz �޸�
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
//��ͨCell���
function fillCell()
{
    var rowend = currow + rownum;
    for (i = currow; (i < rowend) && (i < rowsize); i ++)
    {
        var row = i + 2;
        if(readOnlyRowSet.indexOf("_"+rows[i][keyindex]+"_")<0)  //�۵����У�����ֻ����
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
                    cell.SetCellNumType(col, row, 0, 1);  //��������
                    cell.SetCellDigital(col, row, 0, 2);  //����С��λ��
                    cell.SetCellSeparator(col, row, 0, 2);
                    if(cell.GetCellDouble(col, row, 0)<0) { //������¼,��ʾ��ɫ
                        cell.SetCellTextColor(-1,row,0,cell.FindColorIndex(0x0000FF,1));
                    }
                    break;
                default:
                    if (rows[i][k] != 'null')
                     {
                        cell.S(col, row, 0, rows[i][k]);
                        if(fields[j]=="OpType")
                        {
                            if(rows[i][k]!="����")	//������¼����ʾ��ɫ
                                cell.SetCellTextColor(-1,row,0,cell.FindColorIndex(0xFF0000,1));
                        }
                     }
                    else 
                    {
                        cell.S(col, row, 0, " ");
                        if(fields[j]=="CurRole")  //�˻ص�¼���˵ļ�¼��ʾ��ɫ 0x30C7FF,��ʱ��Ϊ��ɫ
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
        alert("ע��ʧ��");
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
        alert("ע��ʧ��");
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
        if (confirm("ȷʵҪɾ����Щ��¼��?")) {
            location = className + "Action.jsp?cmd=deletelist&listcell=1&idlist=" + chkeds.join(',') + ((url_para.length == 0) ? "" : "&" + url_para);
        }
    } else {
        alert("δѡ���¼��");
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
        return "-1";  //û��ѡ����
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
    cell.PrintSetOrient(1); //2006-10-30 add by dfz,���ô�ӡʱ��ֽ����Ϊ����
    cell.PrintPreview(1,0);
}

function showCombineCell(){
    if (cell.Login("Beelink software", "", "13040483", "7140-0421-0057-6004") == 0) {
        alert("ע��ʧ��");
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
    cell.S(1,1,0,"Ԥ��ִ�����");
    cell.SetCellAlign(1,1,0,32+4); 

    cell.MergeCells(1,3,2,3);
    cell.S(1,3,0,"��λ");
    cell.SetCellAlign(1,3,0,32+4); 

    cell.MergeCells(1,4,1,5);
    cell.S(1,4,0,"��λ����");
    cell.SetCellAlign(1,4,0,32+4); 
    cell.MergeCells(2,4,2,5);
    cell.S(2,4,0,"��λ����");
    cell.SetCellAlign(2,4,0,32+4); 
    
    cell.MergeCells(3,3,5,3);    
    cell.S(3,3,0,"��Ŀ����");
    cell.SetCellAlign(3,3,0,32+4); 
    
    cell.MergeCells(3,4,3,5);
    cell.S(3,4,0,"��");
    cell.SetCellAlign(3,4,0,32+4); 
    cell.SetColWidth(1,30,3,0);
    cell.MergeCells(4,4,4,5);
    cell.S(4,4,0,"��");
    cell.SetCellAlign(4,4,0,32+4); 
    cell.SetColWidth(1,30,4,0);
    cell.MergeCells(5,4,5,5);
    cell.S(5,4,0,"��");
    cell.SetCellAlign(5,4,0,32+4); 
    cell.SetColWidth(1,30,5,0);

    cell.MergeCells(6,3,6,5);
    cell.S(6,3,0,"��Ŀ����");
    cell.SetCellAlign(6,3,0,32+4); 
    cell.MergeCells(7,3,7,5);
    cell.S(7,3,0,"��Ŀ����");
    cell.SetCellAlign(7,3,0,32+4);     
    cell.MergeCells(8,3,8,5);
    cell.S(8,3,0,"��Ŀ����");
    cell.SetCellAlign(8,3,0,32+4);   
    cell.MergeCells(9,3,9,5);
    cell.S(9,3,0,"��;");
    cell.SetCellAlign(9,3,0,32+4); 

    cell.MergeCells(10,3,14,3);    
    cell.S(10,3,0,"Ԥ��ָ��");
    cell.SetCellAlign(10,3,0,32+4); 

    cell.MergeCells(10,4,10,5);
    cell.S(10,4,0,"��ָ��");
    cell.SetCellAlign(10,4,0,32+4); 
    cell.MergeCells(11,4,11,5);
    cell.S(11,4,0,"�������");
    cell.SetCellAlign(11,4,0,32+4);     
    cell.MergeCells(12,4,12,5);
    cell.S(12,4,0,"����ָ��");
    cell.SetCellAlign(12,4,0,32+4);   
    cell.MergeCells(13,4,13,5);
    cell.S(13,4,0,"���´�ָ��");
    cell.SetCellAlign(13,4,0,32+4);    
    cell.MergeCells(14,4,14,5);
    cell.S(14,4,0,"ʣ��ָ��");
    cell.SetCellAlign(14,4,0,32+4);   

    cell.MergeCells(15,3,23,3);    
    cell.S(15,3,0,"�ÿ�ƻ�");
    cell.SetCellAlign(15,3,0,32+4);    

    cell.MergeCells(15,4,17,4);    
    cell.S(15,4,0,"���´�ƻ�");
    cell.SetCellAlign(15,4,0,32+4); 
       
    cell.S(15,5,0,"�ϼ�");
    cell.SetCellAlign(15,5,0,32+4); 
    cell.S(16,5,0,"ֱ��֧��");
    cell.SetCellAlign(16,5,0,32+4); 
    cell.S(17,5,0,"��Ȩ֧��");
    cell.SetCellAlign(17,5,0,32+4); 

    cell.MergeCells(18,4,20,4);    
    cell.S(18,4,0,"��֧�üƻ�");
    cell.SetCellAlign(18,4,0,32+4); 
       
    cell.S(18,5,0,"�ϼ�");
    cell.SetCellAlign(18,5,0,32+4); 
    cell.S(19,5,0,"ֱ��֧��");
    cell.SetCellAlign(19,5,0,32+4); 
    cell.S(20,5,0,"��Ȩ֧��");
    cell.SetCellAlign(20,5,0,32+4); 
    
    cell.MergeCells(21,4,23,4);    
    cell.S(21,4,0,"ʣ��ƻ�");
    cell.SetCellAlign(21,4,0,32+4); 
       
    cell.S(21,5,0,"�ϼ�");
    cell.SetCellAlign(21,5,0,32+4); 
    cell.S(22,5,0,"ֱ��֧��");
    cell.SetCellAlign(22,5,0,32+4); 
    cell.S(23,5,0,"��Ȩ֧��");
    cell.SetCellAlign(23,5,0,32+4); 

    cell.MergeCells(24,3,26,3);    
    cell.S(24,3,0,"֧��");
    cell.SetCellAlign(24,3,0,32+4);  
    
    cell.MergeCells(24,4,24,5);  
    cell.S(24,4,0,"�ϼ�");
    cell.SetCellAlign(24,4,0,32+4); 
    cell.MergeCells(25,4,25,5);  
    cell.S(25,4,0,"ֱ��֧��");
    cell.SetCellAlign(25,4,0,32+4); 
    cell.MergeCells(26,4,26,5);     
    cell.S(26,4,0,"��Ȩ֧��");
    cell.SetCellAlign(26,4,0,32+4); 
}
//���cell�ؼ���XP���������ļ�������
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