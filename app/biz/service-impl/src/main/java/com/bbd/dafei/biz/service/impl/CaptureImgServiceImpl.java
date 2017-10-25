package com.bbd.dafei.biz.service.impl;

import com.bbd.dafei.biz.shared.CaptureImgService;
import com.bbd.dafei.biz.shared.ScreenCaptureService;
import com.bbd.higgs.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;

/**
 * Created by tuanhong on 2017-05-22.
 */
@Service
public class CaptureImgServiceImpl implements CaptureImgService {

    @Value("${temp.path}")
    private String pdfPath;

    @Value("${page.url}")
    private String basePath;

    @Autowired
    private ScreenCaptureService phantomSer;

    @Override
    /**
     * 截屏
     **/
    public String captureImg(HttpServletRequest re, String url, String size) {
        String img = "";

        //"./phantomjs rasterize.js https://www.baidu.com c.png A4"
        String plugin = getImgPath(re, "/sysplugins/./phantomjs");
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("windows")) {
            plugin = getImgPath(re, "/sysplugins/phantomjs.exe");
        }
        String js = getImgPath(re, "/sysplugins/rasterize.js");

        File file = new File(this.pdfPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        img = this.pdfPath + DateUtils.format(new Date(), "yyyyMMddHHmmss") + System.nanoTime() + ".png";

        String basePath = this.basePath;

        File pluginFile = new File(plugin);
        if (!pluginFile.canExecute()) {
            pluginFile.setExecutable(true);
        }

        url = basePath + url;

        if (!phantomSer.exec(plugin, js, url, img, size)) {
            return null;
        }

        return img;
    }

    /**
     * 获取路径
     */
    private String getImgPath(HttpServletRequest re, String path) {
        return re.getSession().getServletContext().getRealPath(path);
    }
}
