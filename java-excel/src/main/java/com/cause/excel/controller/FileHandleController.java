package com.cause.excel.controller;

import com.alibaba.excel.EasyExcel;
import com.cause.excel.entity.UserEntity;
import com.cause.excel.serivce.ExcelService;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/read")
    public String read(@RequestParam("files") MultipartFile files[]) {
        try {
            MultipartFile file = files[0];
            InputStream inputStream = file.getInputStream();
            List<Object> objects = EasyExcel.read(inputStream, new NoModelDataListener()).sheet().doReadSync();

            return objects.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("/write")
    public void write(HttpServletResponse response) {
//    public String excelHandle2(HttpServletResponse response) {
        try {
            List<List<String>> head = new ArrayList<>();
            head.add(Lists.newArrayList("姓名"));
            head.add(Lists.newArrayList("年龄"));
            head.add(Lists.newArrayList("操作时间"));

            List<List<String>> body = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                ArrayList<String> list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    list.add(i + "==>" + j);
                }
                body.add(list);
            }


            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream()).head(head).sheet("模板").doWrite(body);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
