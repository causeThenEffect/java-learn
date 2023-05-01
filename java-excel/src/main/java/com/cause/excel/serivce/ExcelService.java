package com.cause.excel.serivce;

import com.alibaba.excel.EasyExcel;
import com.cause.excel.entity.UserEntity;
import com.google.common.collect.Lists;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExcelService {

    public void test1(String filePath) {
        List<UserEntity> list = EasyExcel.read(filePath).head(UserEntity.class).sheet().doReadSync();
        System.out.println(list);
    }

    public String getSavePath() {
        // 这里需要注意的是ApplicationHome是属于SpringBoot的类
        // 获取项目下resources/static/img路径
        ApplicationHome applicationHome = new ApplicationHome(this.getClass());

        // 保存目录位置根据项目需求可随意更改
        return applicationHome.getDir().getParentFile()
                .getParentFile().getAbsolutePath() + "/src/main/resources/static/";
    }

    public void test2() {
        //表头
        List<List<String>> headList = new ArrayList<>();
        headList.add(Lists.newArrayList("姓名"));
        headList.add(Lists.newArrayList("年龄"));
        headList.add(Lists.newArrayList("操作时间"));

        //数据体
        List<List<Object>> dataList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Object> data = new ArrayList<>();
            data.add("张三" + i);
            data.add(20 + i);
            data.add(new Date(System.currentTimeMillis() + i));
            dataList.add(data);
        }
        EasyExcel.write(getSavePath() + "/easyexcel-user2.xls").head(headList).sheet("用户信息").doWrite(dataList);
    }

    public static void main(String[] args) {
        ExcelService service = new ExcelService();
        String savePath = service.getSavePath() + "/easyexcel-user2.xls";
//        String savePath = service.getSavePath() + "/excel1.xlsx";
        System.out.println(savePath);
        service.test1(savePath);

        service.test2();
    }

}
