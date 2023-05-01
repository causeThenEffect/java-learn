package com.cause.excel.controller;

import com.alibaba.excel.EasyExcel;
import com.cause.excel.entity.UserEntity;
import com.cause.excel.serivce.ExcelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

/**
 * https://easyexcel.opensource.alibaba.com/docs/current/
 */
@RestController
public class FileHandleController {

    @Resource
    private ExcelService service;

    @RequestMapping("/excelHandle")
//    public String excelHandle(@RequestParam("files") MultipartFile files[], HttpServletResponse response) {
    public String excelHandle(HttpServletResponse response) {
        try {
//            MultipartFile file = files[0];
//            InputStream inputStream = file.getInputStream();
//            List<UserEntity> list = EasyExcel.read(inputStream).head(UserEntity.class).sheet().doReadSync();

            String savePath = service.getSavePath() + "/easyexcel-user2.xls";
            List<UserEntity> list = EasyExcel.read(savePath).head(UserEntity.class).sheet().doReadSync();

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), UserEntity.class).sheet("模板").doWrite(list);
            return list.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
