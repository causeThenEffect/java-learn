package com.cause.excel.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

@RestController
@Slf4j
public class PoiController {

    @GetMapping("/excelWrite")
    public void excelWrite(HttpServletResponse response) {
        {
            try {
                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet();
                sheet.setDefaultColumnWidth(12);

                HSSFRow rowHead1 = sheet.createRow(0);
                HSSFRow rowHead2 = sheet.createRow(1);
                rowHead1.setHeight((short) 600);

                HSSFCellStyle cellStyleHead0 = workbook.createCellStyle();
                cellStyleHead0.setAlignment(HorizontalAlignment.CENTER);
                cellStyleHead0.setVerticalAlignment(VerticalAlignment.CENTER);

                HSSFCellStyle cellStyleHead1 = workbook.createCellStyle();
                cellStyleHead1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
                cellStyleHead1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                cellStyleHead1.setLeftBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
                cellStyleHead1.setRightBorderColor(IndexedColors.GREY_40_PERCENT.getIndex());
                cellStyleHead1.setBorderLeft(BorderStyle.THIN);
                cellStyleHead1.setBorderRight(BorderStyle.THIN);
                cellStyleHead1.setWrapText(true);

                for (int i = 0; i < 10; i++) {
                    HSSFCell cell = rowHead1.createCell(i);
                    cell.setCellStyle(cellStyleHead0);
                    cell.setCellValue("column" + i);
                }

                for (int i = 0; i < 10; i++) {
                    HSSFCell cell = rowHead2.createCell(i);
                    cell.setCellStyle(cellStyleHead1);
                    cell.setCellValue("column" + i + "\n放大沙发上阿萨德发生阿萨德发弟");
                }

                for (int i = 2; i <= 20; i++) {
                    HSSFRow row = sheet.createRow(i);
                    row.setHeight((short) 500);
                    for (int j = 0; j < 10; j++) {
                        HSSFCellStyle cellStyle = workbook.createCellStyle();
                        cellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
                        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                        HSSFCell cell = row.createCell(j);
                        cell.setCellValue(i * j);
                        if (i * j == 5) {
                            cell.setCellStyle(cellStyle);
                        }
                    }
                }

                CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);
                sheet.addMergedRegion(cellRangeAddress);

                CellRangeAddress cellRangeAddress2 = new CellRangeAddress(0, 0, 5, 9);
                sheet.addMergedRegion(cellRangeAddress2);

                String fileName = URLEncoder.encode("数据验证模版", "UTF-8").replaceAll("\\+", "%20");
                response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
                workbook.write(response.getOutputStream());
            } catch (Exception e) {
                log.error("excelTemplate error: ", e);
            }
        }
    }

}
