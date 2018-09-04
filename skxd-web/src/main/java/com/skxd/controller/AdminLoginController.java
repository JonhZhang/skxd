package com.skxd.controller;

import com.skxd.model.SkxdAdminRole;
import com.skxd.model.SkxdAdminUser;
import com.skxd.service.ISkxdAdminInputService;
import com.skxd.service.ISkxdAdminRoleService;
import com.skxd.service.ISkxdAdminUserService;
import com.zxs.resp.ReturnResult;
import com.zxs.util.ReturnResultUtil;
import com.zxs.utils.lang.EmptyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * <p></p>
 * <p>
 * Created by zzshang on 2015/11/19.
 */
@Controller
@RequestMapping("/login")
public class AdminLoginController {

    @Autowired
    private ISkxdAdminUserService skxdAdminUserService;

    @Autowired
    private ISkxdAdminRoleService skxdAdminRoleService;

//    private SkxdAdminUs
    //设置字母的大小,大小

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/login";
    }

    @RequestMapping("/execute")
    @ResponseBody
    public ReturnResult validateUserInfo(String userName, String password, HttpServletRequest request) throws Exception {
        Subject user = SecurityUtils.getSubject();
        SkxdAdminUser skxdAdminUser = skxdAdminUserService.validateUser(userName, password);
        if (EmptyUtils.isNotEmpty(skxdAdminUser)) {
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);
            user.login(token);
            request.getSession().setAttribute("adminUser",skxdAdminUser);
            return ReturnResultUtil.returnSuccess();
        } else {
            return ReturnResultUtil.returnFail("用户名密码错误");
        }
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                subject.logout(); //session 会销毁，在SessionListener监听session销毁，清理权限缓存
                request.getSession().invalidate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return "/login";
        }
    }

    /**
     * 生成验证码的方法
     *
     * @param response
     * @param request
     * @throws IOException
     */
    @RequestMapping("/createValidateCode")
    @ResponseBody
    public void createValidateCode(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //表明生成的响应是图片
        response.setContentType("image/jpeg");
        int width = 70, height = 55;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Font mFont = new Font("Times New Roman", Font.PLAIN, 24);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, width - 1, height - 1);
        g.setColor(new Color(102, 102, 102));
        g.drawRect(0, 0, width - 1, height - 1);
        g.setFont(mFont);
        g.setColor(getRandColor(160, 200));
        //画随机线
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x, y, x + xl, y + yl);
        }
        //从另一方向画随机线
        for (int i = 0; i < 70; i++) {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(12) + 1;
            int yl = random.nextInt(6) + 1;
            g.drawLine(x, y, x - xl, y - yl);
        }
        //生成随机数,并将随机数字转换为字母
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            int itmp = random.nextInt(26) + 65;
            char ctmp = (char) itmp;
            sRand += String.valueOf(ctmp);
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(String.valueOf(ctmp), 0 + (i * 17), 30 + (random.nextInt(15)));
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("validateCode", sRand);
        g.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
        Random random = new Random();
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
