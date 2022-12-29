package com.yzm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class HelloController {

    @RequestMapping("upload")
    public String upload(HttpServletRequest request, MultipartFile upload) throws Exception {
        // 获取要存放上传文件的目录
        String path = request.getSession().getServletContext().getRealPath("/uploads");
        // 创建File对象
        File file = new File(path);
        // 判断该路径是否存在，不存在则创建
        if (!file.exists()) file.mkdirs();

        // 获取文件名
        String filename = upload.getOriginalFilename();
        // 给文件设置唯一值(没有设置唯一，同样的照片就会被覆盖)
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        // 完成上传
        upload.transferTo(new File(path, filename));

        return "success";
    }

}
