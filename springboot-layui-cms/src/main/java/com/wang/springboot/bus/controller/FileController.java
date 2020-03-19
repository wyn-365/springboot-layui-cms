package com.wang.springboot.bus.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.wang.springboot.sys.common.AppFileUtils;
import com.wang.springboot.sys.common.DataGridView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王一宁
 * @date 2020/3/18 17:01
 */
@RestController
@RequestMapping("file")
public class FileController {

    /**
     * 文件上传
     */
    @RequestMapping("uploadFile")
    public Map<String,Object> uploadFile(MultipartFile mf) throws IOException {
        //不能上传到tomcat ,需要到项目里
        //1.得到文件名
        String oldName = mf.getOriginalFilename();
        //2.根据文件名 生成新的文件名
        String newFileName = AppFileUtils.createNewFileName(oldName);
        //3.获取日期
        String dirName = DateUtil.format(new Date(),"yyyy-MM-dd");
        //4.构造文件夹
        File dirFile = new File(AppFileUtils.UPLOAD_PATH);
        //5.判断文件夹是否存在
        if(!dirFile.exists()){
            dirFile.mkdirs();
        }
        //6.构造文件对象
        File file = new File(dirFile,newFileName);
        //7.存放图像
        mf.transferTo(file);
        Map<String,Object> map = new HashMap<>();
        map.put("path",dirName+"/"+newFileName);
        return  map;
    }

    /**
     * 文件下载
     */
    @RequestMapping("showImageByPath")
    public ResponseEntity<Object> showImageByPath(String path){

        return AppFileUtils.createResponseEntity(path);
    }
}
