/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulpro.vista.componentes.excel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import simulpro.modelo.logica.ControlModel;
import simulpro.modelo.logica.Persona;

/**
 *
 * @author sala de software
 */
public class CreateSheetExcel {

    public static boolean createExcel(File file) throws IOException {
        FileOutputStream out;

        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
            createSheetHours(workbook, ControlModel.getControlModel().getAnimation().getPersonasProcesadas());
            out = new FileOutputStream(file);
            workbook.write(out);
        }
        out.close();
        return true;
    }

    private static void createSheetHours(HSSFWorkbook workbook, List<Persona> personas) {

        HSSFSheet sheetHours = workbook.createSheet("PersonasProcesadas");
        String cabecera[] = {"N°", "Genero", "Tipo", "Tiempo entre llegadas", "Tiempo en caja", "Tiempo de atención", "Productos comprados"};

        createTitle(workbook, sheetHours, cabecera);
        CellStyle cellStyle = createCellStyle(workbook, 3);
        Row row;

        for (int i = 1; i < personas.size() + 1; i++) {
            row = sheetHours.createRow(i);
            for (int j = 0; j < cabecera.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(cellStyle);
                switch (j) {
                    case 0: {
                        cell.setCellValue((i));
                        break;
                    }
                    case 1: {
                        cell.setCellValue(personas.get(i - 1).getGenero());
                        break;
                    }
                    case 2: {
                        cell.setCellValue(personas.get(i - 1).getTipo());
                        break;
                    }
                    case 3: {
                        cell.setCellValue(personas.get(i - 1).getTimeEntreLlegada()/1000);
                        break;
                    }
                    case 4: {
                        cell.setCellValue(personas.get(i - 1).getTimeCaja()/1000);
                        break;
                    }
                    case 5: {
                        cell.setCellValue(personas.get(i - 1).getTimeAtencion()/1000);
                        break;
                    }
                    case 6: {
                        if(personas.get(i - 1).getProductosComprados() == null){
                            cell.setCellValue("No compró nada");
                        }else{
                            cell.setCellValue(personas.get(i - 1).getProductosComprados().toString());
                        }
                        break;
                    }
                }
                sheetHours.autoSizeColumn(j);
            }
        }
    }

    private static void createTitle(HSSFWorkbook workbook, HSSFSheet sheet, String[] titles) {
        Row row = sheet.createRow(0);
        CellStyle cellStyle = createCellStyle(workbook, 0);
        int lastRow = 0;
        for (int i = 0; i < titles.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(titles[i]);
            sheet.autoSizeColumn(i);
        }
    }

    private static CellStyle createCellStyle(HSSFWorkbook workbook, int type) {
        CellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        switch (type) {
            case 0: {
                style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                style.setFillForegroundColor(new HSSFColor.SKY_BLUE().getIndex());

                break;
            }
            case 1: {

                break;
            }
            case 2: {

                break;
            }
        }
        return style;
    }
}
