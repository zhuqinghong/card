package com.card.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.card.domain.entity.CardInfo;
import com.card.domain.repository.CardInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by qinghong.zhu on 2021/4/18.
 *
 * @author qinghong.zhu
 */
@Controller
public class LoginController {
    @Autowired
    private CardInfoRepository cardInfoRepository;

    @RequestMapping(value = {"/", "/login.html"})
    public String toLogin(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }

    //负责处理loginCheck.html请求
    //请求参数会根据参数名称默认契约自动绑定到相应方法的入参中
    @RequestMapping(value = "/api/loginCheck", method = RequestMethod.POST)
    public @ResponseBody
    Object loginCheck(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String passwd = request.getParameter("passwd");
        CardInfo cardInfo = cardInfoRepository.findCardByNumber(id);
        HashMap<String, String> res = new HashMap<>();
        if (cardInfo == null || !cardInfo.checkOutPassword(passwd)) {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
        } else if (cardInfo.isAdmin()) {
            request.getSession().setAttribute("cardInfo", cardInfo);
            res.put("stateCode", "1");
            res.put("msg", "管理员登陆成功！");
        } else {
            request.getSession().setAttribute("cardInfo", cardInfo);
            res.put("stateCode", "2");
            res.put("msg", "普通用户登陆成功！");
        }
        return res;
    }

    //
    //@RequestMapping("/admin_main.html")
    //public ModelAndView toAdminMain(HttpServletResponse response) {
    //    return new ModelAndView("admin_main");
    //}
    //
    //@RequestMapping("/reader_main.html")
    //public ModelAndView toReaderMain(HttpServletResponse response) {
    //    return new ModelAndView("reader_main");
    //}
    //
    //@RequestMapping("/admin_repasswd.html")
    //public ModelAndView reAdminPasswd() {
    //    return new ModelAndView("admin_repasswd");
    //}
    //
    //@RequestMapping("/admin_repasswd_do")
    //public String reAdminPasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, String reNewPasswd, RedirectAttributes redirectAttributes) {
    //   return null;
    //}
    //
    //@RequestMapping("/reader_repasswd.html")
    //public ModelAndView reReaderPasswd() {
    //    return new ModelAndView("reader_repasswd");
    //}
    //
    //@RequestMapping("/reader_repasswd_do")
    //public String reReaderPasswdDo(HttpServletRequest request, String oldPasswd, String newPasswd, String reNewPasswd, RedirectAttributes redirectAttributes) {
    // return null;
    //}

    //配置404页面
    @RequestMapping("*")
    public String notFind() {
        return "404";
    }
}
