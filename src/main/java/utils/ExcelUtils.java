package main.java.utils;

/**
 * Utility method to set (or update) the value of a cell in an Excel file.
 * <p>
 * This method uses Apache POI library. It first opens the file in read mode
 * to load the workbook and sheet structure, then updates/creates the specified
 * cell with the given data, and finally writes the changes back to the file.
 * </p>
 *
 * @param filePath  Path of the Excel file
 * @param sheetName Name of the sheet where data needs to be written
 * @param rowNum    Row number (0-based index)
 * @param colNum    Column number (0-based index)
 * @param data      Data to be written into the cell
 * @throws Exception If the file is not found or there’s an I/O error
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.FillPatternType;

public class ExcelUtils {
    // Utility methods for Excel operations would go here

    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle style;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        int rowCount = 0;
        rowCount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowCount;
    }

    public static int getCellCount(String xlFile, String xlSheet, int rowNum)  throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);
        int cellCount = 0;
        cellCount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);
        String data;
        try {
            data =cell.toString();
            // DataFormatter formatter = new DataFormatter();
            // data = formatter.formatCellValue(cell);
        } catch (Exception e) {
            data = "";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String xlFile, String xlSheet, int rowNum, int colNum, String data) throws IOException {
    // Step 1: Open the Excel file in read mode.
    // We use FileInputStream because we need to *load* the existing file structure (workbook, sheets, rows).
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

    // Step 2: Locate the required row.
    // If the row doesn’t exist yet, create a new one.
        row = ws.getRow(rowNum);
        if (row == null) {
            row = ws.createRow(rowNum);
        }

    // Step 3: Locate the required cell.
    // If the cell doesn’t exist, create a new one.   
        cell = row.createCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }

    // Step 4: Update the cell with the new value.
        cell.setCellValue(data);

     // Step 5: Close the input stream since we are done reading.
        fi.close();

    
    // Step 6: Open the file in write mode and save the updated workbook.
        fo = new FileOutputStream(xlFile);
        wb.write(fo);

    // Step 7: Close output stream and workbook to free resources.
        wb.close();
        fo.close();
    }

    public static void fillGreenColor(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        fi.close();

        fo = new FileOutputStream(xlFile);
        wb.write(fo);
        wb.close();
        fo.close();
    }

    public static void fillRedColor(String xlFile, String xlSheet, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);
        row = ws.getRow(rowNum);
        cell = row.getCell(colNum);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);
        fi.close();

        fo = new FileOutputStream(xlFile);
        wb.write(fo);
        wb.close();
        fo.close();
    }
}


