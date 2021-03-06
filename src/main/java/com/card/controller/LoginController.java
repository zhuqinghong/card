package com.card.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import com.card.domain.service.CardService;
import com.card.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by qinghong.zhu on 2021/4/18.
 *
 * @author qinghong.zhu
 */
@Controller
public class LoginController {
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index"})
    public String toLogin(HttpServletRequest request) {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object loginCheck(HttpServletRequest request, @RequestParam("id") Integer id, @RequestParam("passwd") String passwd) {
        CardInfo cardInfo = cardService.findCardByNumber(id);
        HashMap<String, String> res = new HashMap<>();
        if (cardInfo == null || !cardInfo.checkOutPassword(passwd)) {
            res.put("stateCode", "0");
            res.put("msg", "账号或密码错误！");
        } else {
            if (cardInfo.isAdmin()) {
                res.put("stateCode", "1");
                res.put("msg", "管理员登陆成功！");
            } else {
                res.put("stateCode", "2");
                res.put("msg", "普通用户登陆成功！");
            }
            UserInfo userInfo = userService.getUserInfoById(cardInfo.getUserId());
            request.getSession().setAttribute("cardInfo", cardInfo);
            request.getSession().setAttribute("userInfo", userInfo);
        }
        return res;
    }

    @RequestMapping("/admin_main.html")
    public String toAdminMain(HttpServletResponse response) {
        return "redirect:/admin_user_list.html";
    }

    @RequestMapping("/user_main.html")
    public ModelAndView toReaderMain(HttpServletResponse response) {
        return new ModelAndView("user_main");
    }

    @RequestMapping("/repasswd.html")
    public ModelAndView rePasswd() {
        return new ModelAndView("repasswd");
    }

    @RequestMapping("/repasswd_do")
    public String rePasswordDo(HttpServletRequest request, String cardPassword, String newCardPassword, RedirectAttributes redirectAttributes) {
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
        if (cardInfo.checkOutPassword(cardPassword)) {
            cardService.rePassword(cardInfo.getCardNumber(), newCardPassword, userInfo.getId());
            redirectAttributes.addFlashAttribute("succ", "密码修改成功！");
            return "redirect:/repasswd.html";
        } else {
            redirectAttributes.addFlashAttribute("error", "密码修改失败！");
            return "redirect:/repasswd.html";
        }
    }

    //配置404页面
    @RequestMapping("*")
    public String notFind() {
        return "404";
    }
}
