package com.bbd.dafei.common.util;

import com.google.common.io.Closeables;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by tuanhong on 2017-04-23.
 */
public final class DownloadAndUploadUtil {
    /**
     * user stream type save files
     *
     * @param request       HttpServletRequest
     * @param multipartFile MultipartFile  support CommonsMultipartFile file
     * @param filePath      filePath example "/files/Upload"
     * @return
     */
    public static String FilesUpload(HttpServletRequest request, MultipartFile multipartFile, String filePath) {
        if (multipartFile != null) {
            InputStream inputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                inputStream = multipartFile.getInputStream();
                fileOutputStream = new FileOutputStream(filePath);
                byte buffer[] = new byte[4096]; //create a buffer
                long fileSize = multipartFile.getSize();
                if (fileSize <= buffer.length) {//if fileSize < buffer
                    buffer = new byte[(int) fileSize];
                }
                int line = 0;
                while ((line = inputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, line);
                }

            } catch (Exception e) {
            } finally {
                Closeables.closeQuietly(inputStream);
                try {
                    Closeables.close(fileOutputStream, true);
                } catch (Exception e) {
                } finally {
                    fileOutputStream = null;
                }
            }
        } else {
            return "fail";
        }
        return "success";
    }

    /**
     * 文件下载
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param filePath
     * @return
     */
    public static void FilesDownload(HttpServletRequest request, HttpServletResponse response, String filePath) {
        //获得文件完整路径
//        String realPath = request.getSession().getServletContext().getRealPath(filePath);
        File file = new File(filePath);
        String filenames = file.getName();
        InputStream inputStream = null;
        OutputStream os = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[inputStream.available()];

            response.reset();
            // 先去掉文件名称中的空格,然后转换编码格式为utf-8,保证不出现乱码,这个文件名称用于浏览器的下载框中自动显示的文件名
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filenames.replaceAll(" ", "").getBytes("gb2312"), "iso8859-1"));
            response.addHeader("Content-Length", "" + file.length());
             os = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");

            int line = 0;
            while((line = inputStream.read(buffer)) > 0){
                os.write(buffer,0,line);// 输出文件
            }
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }finally {
            try {
                if(null != inputStream){
                    inputStream.close();
                }
            } catch (Exception e) {
                throw  new RuntimeException(e);
            }
            try {
                if(null != os){
                    os.flush();
                    os.close();
                }
            }catch (Exception e){
                throw  new RuntimeException(e);
            }
        }
    }
}
