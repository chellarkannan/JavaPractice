package Utils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class ExcelUtils {
    
    // method to read data from an Excel sheet and return it as a 2D Object array
    public static Object[][] readExcelSheet(String workbookPath, String sheetName) throws IOException {
       
        try (FileInputStream fis = new FileInputStream(workbookPath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the workbook.");
            }

            int rowCount = sheet.getPhysicalNumberOfRows();
            if (rowCount < 1) {
            return new Object[0][0];
            }

            Row headerRow = sheet.getRow(0);
            int columnCount = headerRow.getPhysicalNumberOfCells();

            List<Map<Object, Object>> rowsData = new ArrayList<>();

            for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            Map<Object, Object> rowData = new HashMap<>();
            for (int j = 0; j < columnCount; j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell dataCell = row.getCell(j);

                Object headerValue = headerCell != null ? getCellValueAsString(headerCell) : null;
                Object dataValue = dataCell != null ? getCellValueAsString(dataCell) : null;

                rowData.put(headerValue, dataValue);
            }
            rowsData.add(rowData);
            }

            Object[][] result = new Object[rowsData.size()][1];
            for (int i = 0; i < rowsData.size(); i++) {
            result[i][0] = rowsData.get(i);
            }

            return result;
        }
    }

    private static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
            case FORMULA:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());            
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}
