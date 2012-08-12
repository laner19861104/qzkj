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

	// �޸�ģ����ʽ
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

	// ���ģ����ʽ����ģ����ʽ�ĵĻ����ϣ������ݵ���excel����

	private HSSFWorkbook printExcel(String templatePath, int startRow,
			List dataList, List excelStyleList) throws FileNotFoundException,
			IOException {

		POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(
				templatePath));
		// ����ģ�幤����
		HSSFWorkbook workbook = null;
		try {
			// ����������ʵ��
			workbook = new HSSFWorkbook(fs);
			// ��ù�����ʵ��
			HSSFSheet sheet = workbook.getSheetAt(0);
			HSSFRow templateRow = sheet.getRow(0);
			int columns = sheet.getRow((short) 0).getPhysicalNumberOfCells();
			// ������ʽ����
			HSSFCellStyle styleArray[] = new HSSFCellStyle[columns];
			// һ���Դ��������е���ʽ����������
			for (int s = 0; s < columns; s++) {
				styleArray[s] = workbook.createCellStyle();
			}
			// ����ģ����ʽ����
			for (int i = 0; i < excelStyleList.size(); i++) {
				ExcelStyle style = (ExcelStyle) excelStyleList.get(i);
				HSSFRow preStyleRow = sheet.getRow(style.getRows());
				// HSSFCellStyle cellStyle =createTitleStyle(workbook);

				createCell(preStyleRow, style.getColumn(), styleArray[style
						.getColumn()], HSSFCell.CELL_TYPE_STRING, style
						.getStyle_content());
			}

			// ѭ����ÿһ����Ԫ����и�ֵ,��λ��,�ӵ�rowId��ʼ��excel������������
			for (int rowId = startRow; rowId < dataList.size() + startRow; rowId++) {
				Object po = (Object) dataList.get(rowId - startRow);
				List valueList = objectToList(po, templateRow, (rowId
						- startRow + 1));
				for (int columnId = 0; columnId < columns; columnId++) {
					String dataValue = valueList.get(columnId) == null ? ""
							: ((Object) valueList.get(columnId)).toString();
					// ȡ��colunmId�еĵ�style,ģ��ÿһ�е���ʽ
					HSSFCellStyle style = styleArray[columnId];
					// ȡģ���colunmId�еĵ�Ԫ����� ,ģ�嵥Ԫ�����
					HSSFCell templateCell = templateRow
							.getCell((short) columnId);
					// ����һ���µ�rowId�� �ж���
					HSSFRow hssfRow = sheet.createRow(rowId);
					// �����µ�rowId�� columnId�� ��Ԫ�����
					HSSFCell cell = hssfRow.createCell((short) columnId);
					// �����Ӧ��ģ�嵥Ԫ�� ��ʽΪ������
					if (templateCell.getCellStyle().getLocked() == false) {
						// ���ô���styleΪ������
						style.setLocked(false);
						// ���õ��µĵ�Ԫ����
						cell.setCellStyle(style);
					}
					// ������ʽΪ����
					else {
						// ���ô���styleΪ����
						style.setLocked(true);
						// ���õ��µ�Ԫ����
						cell.setCellStyle(style);
					}
					// ���ñ���
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					// ����ֵ ͳһΪString
					cell.setCellValue(dataValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workbook;
	}

	// д����������

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

	// �����Object�Ķ��󻻳�list����
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
	 * ����excel���е�һ�е������ֶΣ� �ӵ�2�п�ʼ
	 */

	public List getSheet(HSSFRow templateRow) {
		List listSheet = new ArrayList();
		int rows = templateRow.getPhysicalNumberOfCells();
		for (int k = 1; k < rows; k++) {
			listSheet.add(templateRow.getCell((short) k));
		}
		return listSheet;

	}

	// ����Excel��Ԫ��
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

	// ���õ�Ԫ���ʽ����ʱû��
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
