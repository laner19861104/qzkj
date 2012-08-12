package com.bip.common.excel.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.lang.reflect.Method;

public class ExportExcel extends ActionSupport {

	String fileNames;
	InputStream downloadFile;

	// 修改模板样式
	public String outExcel(List dataList, String templateName,
			String excelStart, List excelStyleList) {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		String templatePath = request.getRealPath("/") + "templates//excel//"
				+ templateName;
		HSSFWorkbook workbook;
		int startRow = Integer.parseInt(excelStart);

		// System.out.println("    startRow   "+startRow);
		try {
			workbook = printExcel(templatePath, startRow, dataList,
					excelStyleList);

			System.out.println(" workbook    " + workbook);
			if (workbook != null) {
				Calendar c = Calendar.getInstance();
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1;
				String month_ = new String("" + month);
				if (month < 10) {
					month_ = "0" + month;
				}
				int day = c.get(Calendar.DAY_OF_MONTH);
				String day_ = new String("" + day);
				if (day < 10) {
					day_ = "0" + day;
				}
				// this.exportExcel(workbook,year+month_+""+day_+"_bake.xls");
				this.exportExcel(workbook, year + month_ + "_"
						+ templateName.substring(9));
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return "success";
	}

	public String outExcel(List dataList, String templateName, String excelStart) {
		return this.outExcel(dataList, templateName, excelStart,
				new ArrayList());
	}

	// 获得模板样式，在模板样式的的基础上，将数据导入excel表中

	private HSSFWorkbook printExcel(String templatePath, int startRow,
			List dataList, List excelStyleList) throws FileNotFoundException,
			IOException {

		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
				templatePath));
		// 创建模板工作表
		HSSFWorkbook workbook = null;
		try {
			// 创建工作簿实例
			workbook = new HSSFWorkbook(fs);
			// 获得工作表实例
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow templateRow = sheet.getRow(0);
			int columns = sheet.getRow((short) 0).getPhysicalNumberOfCells();
			// 创建样式数组
			HSSFCellStyle styleArray[] = new HSSFCellStyle[columns];
			// 一次性创建所有列的样式放在数组里
			for (int s = 0; s < columns; s++) {
				styleArray[s] = workbook.createCellStyle();
			}
			// 更改模板样式内容
			for (int i = 0; i < excelStyleList.size(); i++) {
				ExcelStyle style = (ExcelStyle) excelStyleList.get(i);
				HSSFRow preStyleRow = sheet.getRow(style.getRows());
				// HSSFCellStyle cellStyle =createTitleStyle(workbook);

				createCell(preStyleRow, style.getColumn(), styleArray[style
						.getColumn()], HSSFCell.CELL_TYPE_STRING, style
						.getStyle_content());
			}

			// 循环对每一个单元格进行赋值,定位行,从第rowId开始向excel表格中添加数据
			for (int rowId = startRow; rowId < dataList.size() + startRow; rowId++) {
				Object po = (Object) dataList.get(rowId - startRow);
				List valueList = objectToList(po, templateRow, (rowId
						- startRow + 1));
				for (int columnId = 0; columnId < columns; columnId++) {
					String dataValue = valueList.get(columnId) == null ? ""
							: ((Object) valueList.get(columnId)).toString();
					// 取出colunmId列的的style,模板每一列的样式
					HSSFCellStyle style = styleArray[columnId];
					// 取模板第colunmId列的单元格对象 ,模板单元格对象
					HSSFCell templateCell = templateRow
							.getCell((short) columnId);
					// 创建一个新的rowId行 行对象
					HSSFRow hssfRow = sheet.createRow(rowId);
					// 创建新的rowId行 columnId列 单元格对象
					HSSFCell cell = hssfRow.createCell((short) columnId);
					// 如果对应的模板单元格 样式为非锁定
					if (templateCell.getCellStyle().getLocked() == false) {
						// 设置此列style为非锁定
						style.setLocked(false);
						// 设置到新的单元格上
						cell.setCellStyle(style);
					}
					// 否则样式为锁定
					else {
						// 设置此列style为锁定
						style.setLocked(true);
						// 设置到新单元格上
						cell.setCellStyle(style);
					}
					// 设置编码
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					// 设置值 统一为String
					cell.setCellValue(dataValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	// 写入输入流中

	public void exportExcel(HSSFWorkbook workbook, String fileName)
			throws IOException {
		fileNames = fileName;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		baos.flush();
		byte[] aa = baos.toByteArray();
		downloadFile = new ByteArrayInputStream(aa, 0, aa.length);
		baos.close();
	}

	// 将获得Object的对象换成list对象
	private List objectToList(Object po, HSSFRow templateRow, int id) {

		if (!po.getClass().getName().equals("java.util.HashMap")) {

			return poToList(po, templateRow, id);
		} else {
			return mapToList(po, templateRow, id);
		}
	}

	private List mapToList(Object po, HSSFRow templateRow, int id) {
		List listData = new ArrayList();
		List listSheet = getSheet(templateRow);
		Map map = (HashMap) po;
		listData.add(id);
		// int coutt = 0;
		// int ss = 1;
		for (Object sheet : listSheet) {
			for (Object key : map.keySet()) {
				if (sheet.toString().trim().equalsIgnoreCase(key.toString())) {
					listData.add(map.get(key));
				}
			}
		}
		return listData;

	}

	private List poToList(Object po, HSSFRow templateRow, int id) {
		List listData = new ArrayList();
		List listSheet = getSheet(templateRow);

		Class<?> clazz = po.getClass();
		Method[] methods = clazz.getMethods();
		listData.add(id);
		int coutt = 0;
		int ss = 1;
		for (Object sheet : listSheet) {

			for (Method method : methods) {
				String mname = method.getName();
				Class<?> type = method.getReturnType();
				if (mname.substring(0, 3).equals("get")) {
					try {
						Object returnO = method.invoke(po, new Object[] {});
						mname = mname.replaceFirst("get", "");
						if (sheet.toString().trim().equalsIgnoreCase(
								mname.toLowerCase())) {
							listData.add(returnO);
							coutt++;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			ss++;
		}
		return listData;

	}

	/*
	 * 返回excel表中第一行的隐藏字段， 从第2列开始
	 */

	public List getSheet(HSSFRow templateRow) {
		List listSheet = new ArrayList();
		int rows = templateRow.getPhysicalNumberOfCells();
		for (int k = 1; k < rows; k++) {
			listSheet.add(templateRow.getCell((short) k));
		}
		return listSheet;

	}

	// 创建Excel单元格
	private void createCell(HSSFRow row, int column, HSSFCellStyle style,
			int cellType, Object value) {
		HSSFCell cell = row.createCell((short) column);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		if (style != null) {
			cell.setCellStyle(style);
		}
		switch (cellType) {
		case HSSFCell.CELL_TYPE_BLANK: {
		}
			break;
		case HSSFCell.CELL_TYPE_STRING: {
			cell.setCellValue(value.toString() + "");
		}
			break;
		case HSSFCell.CELL_TYPE_NUMERIC: {
			cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
			cell.setCellValue(Double.parseDouble(value.toString()));
		}
			break;
		default:
			break;
		}

	}

	// 设置单元格格式，暂时没用
	private HSSFCellStyle createTitleStyle(HSSFWorkbook wb) {
		HSSFFont boldFont = wb.createFont();
		boldFont.setFontHeight((short) 200);
		HSSFCellStyle style = wb.createCellStyle();
		style.setFont(boldFont);
		style.setDataFormat(HSSFDataFormat.getBuiltinFormat("###,##0.00"));
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillBackgroundColor(HSSFColor.LIGHT_ORANGE.index);
		boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		return style;
	}

	public InputStream getDownloadFile() {
		return downloadFile;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

}
