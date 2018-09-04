package com.skxd.controller;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.io.PrintUtil;
import com.zxs.utils.io.PropCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by shang-pc on 2015/11/7.
 */
@Controller
public class FileController {

    @RequestMapping("/uploadFile")
    @ResponseBody
    public ReturnResult upload(HttpServletRequest request,HttpServletResponse response) throws IOException {
        PrintUtil printUtil=new PrintUtil(response);
        String name_old=request.getParameter("name");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        String pathDir = PropCache.getValue("prop/version", "save_path");
        /**得到图片保存目录的真实路径**/
        /**根据真实路径创建目录**/
        File logoSaveFile = new File(pathDir);
        if (!logoSaveFile.exists())
            logoSaveFile.mkdirs();
        /**页面控件的文件流**/
        final MultipartFile multipartFile = multipartRequest.getFile(name_old);
        /**获取文件的后缀**/
        System.out.println(multipartFile.getOriginalFilename());
        String suffix = multipartFile.getOriginalFilename().substring
                (multipartFile.getOriginalFilename().lastIndexOf("."));

        /**拼成完整的文件保存路径加文件**/
        String name = +System.currentTimeMillis() + suffix;
        String fileName = pathDir + File.separator + name;
        final File file = new File(fileName);
        multipartFile.transferTo(file);
        //线程处理
        ReturnResult returnResult = ReturnResultUtil.returnSuccess();
        returnResult.setData(name);
        return returnResult;
    }

    @RequestMapping(value="/down/{fileName}/a11.jpg")
    public void down(@PathVariable String fileName,HttpServletResponse response){
        String pathDir = PropCache.getValue("prop/version", "save_path");
        String absoulteFile= pathDir + File.separator + fileName;
        File file=new File(absoulteFile);
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fips = new FileInputStream(file);
            byte[] btImg = readStream(fips);
            os.write(btImg);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public byte[] readStream(InputStream inStream){
        ByteArrayOutputStream bops = new ByteArrayOutputStream();
        int data = -1;
        try {
            while((data = inStream.read()) != -1){
                bops.write(data);
            }
            return bops.toByteArray();
        }catch(Exception e){
            return null;
        }
    }

}

