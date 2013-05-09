package com.toxind.benchmark.thrid.poi;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


public class CopyOfSXXFSTest {
    public static void main(String[] args) throws Throwable {
        Workbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        for(int rownum = 0; rownum < 1000; rownum++){
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < 10; cellnum++){
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }

        }
//        HSSFCellStyle.BORDER_THIN
        Sheet s2 = wb.createSheet("基本信息");
        
        

        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
        style.setFillPattern(HSSFCellStyle.BORDER_THIN);        
        
//        style.setBorderBottom(CellStyle.BORDER_THIN);
//        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
//        style.setBorderLeft(CellStyle.BORDER_THIN);
//        style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
//        style.setBorderRight(CellStyle.BORDER_THIN);
//        style.setRightBorderColor(IndexedColors.BLUE.getIndex());
//        style.setBorderTop(CellStyle.BORDER_THIN);
//        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        
        
//        CellStyle style2 = wb.createCellStyle();
//        style2.setFillForegroundColor(HSSFColor.DARK_GREEN.index);
//        style2.setFillPattern(HSSFCellStyle.BORDER_THIN);
        
//        CellStyle style3 = wb.createCellStyle();
//        style3.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
//        style3.setFillPattern(HSSFCellStyle.BORDER_THIN);
        
        List<String> columns = new ArrayList<String>();
        Row title = s2.createRow(1);
        for(int i = 0 ; i < columns.size() ; i++){
        	Cell cell = title.createCell(i);
        	cell.setCellValue(columns.get(i));
        	cell.setCellStyle(style);
        }
        
        
        Cell c1 = title.createCell(1);
        c1.setCellValue("返回数量");
        Cell c2 = title.createCell(2);
        c2.setCellValue("花费时间");
        Cell c3 = title.createCell(3);
        c3.setCellValue("执行SQL");

        c1.setCellStyle(style);
        c2.setCellStyle(style);
        c3.setCellStyle(style);
        

        CellStyle style2 = wb.createCellStyle();
//        style2.setFillForegroundColor(HSSFColor.LIGHT_CORNFLOWER_BLUE.index);
//        style2.setFillPattern(HSSFCellStyle.BORDER_THIN);
        
        
        
        style2.setBorderTop(CellStyle.BORDER_THIN);
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style2.setBorderLeft(CellStyle.BORDER_THIN);
        style2.setLeftBorderColor(IndexedColors.BLUE.getIndex());
        style2.setBorderRight(CellStyle.BORDER_THIN);
        style2.setRightBorderColor(IndexedColors.BLUE.getIndex());
        style2.setBorderBottom(CellStyle.BORDER_THIN);
        style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        
        
        
        Row content = s2.createRow(2);
        Cell cc1 = content.createCell(1);
        cc1.setCellValue(1250);
        Cell cc2 = content.createCell(2);
        cc2.setCellValue(111+"ms");
        Cell cc3 = content.createCell(3);
        cc3.setCellValue("sdfsdfsdlkfjdskljfklsdjflksajflksadjflka;sjfksadjflkasjflksajflkasdjflksadjfas");
        cc1.setCellStyle(style2);
        cc2.setCellStyle(style2);
        cc3.setCellStyle(style2);
        
        
        FileOutputStream out = new FileOutputStream("d:/sxssf.xlsx");
        wb.write(out);
        out.close();
    }
}
