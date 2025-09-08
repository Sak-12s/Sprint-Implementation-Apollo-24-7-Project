package com.parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static String[][] readData() {
        String[][] data = null;
        String filename = "src\\test\\resources\\Exceldata\\Apollo User Inputs.xlsx";
        try {
            FileInputStream fis = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            System.out.println("Row Count " + rowCount);

            DataFormatter df = new DataFormatter();
            XSSFCell cell;
            data = new String[rowCount][colCount];

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // force 4-digit year

            for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
                int cellCount = sheet.getRow(rowNo).getLastCellNum();

                for (int cellNo = 0; cellNo < cellCount; cellNo++) {
                    cell = sheet.getRow(rowNo).getCell(cellNo);

                    if (cell != null && cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
                        // If it's a date cell, format with 4-digit year
                        data[rowNo - 1][cellNo] = sdf.format(cell.getDateCellValue());
                    } else {
                        // Otherwise, use normal formatter
                        data[rowNo - 1][cellNo] = df.formatCellValue(cell);
                    }
                }
            }

            workbook.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
