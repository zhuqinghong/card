package com.card.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import com.card.domain.req.CreateOrUpdateCardReq;
import com.card.domain.req.QueryCardInfoReq;
import com.card.domain.service.CardService;
import com.card.domain.service.UserCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qinghong.zhu on 2021/4/20. 卡片管理
 *
 * @author qinghong.zhu
 */
@Controller
public class CardManageController {
    @Autowired
    private CardService cardService;
    @Autowired
    private UserCardService userCardService;

    @RequestMapping("/admin_card_list.html")
    public ModelAndView adminCardList(QueryCardInfoReq queryCardInfoReq) {
        List<CardInfo> cardInfoList = cardService.queryCardInfoByCondition(queryCardInfoReq);
        ModelAndView modelAndView = new ModelAndView("admin_card_list");
        modelAndView.addObject("cardInfoList", cardInfoList);
        return modelAndView;
    }

    @RequestMapping("/admin_card_edit.html")
    public ModelAndView adminCardEdit(HttpServletRequest request) {
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        CardInfo cardInfo = cardService.findCardByNumber(cardNumber);
        ModelAndView modelAndView = new ModelAndView("admin_card_edit");
        modelAndView.addObject("cardInfo", cardInfo);
        return modelAndView;
    }

    /**
     * 修改卡片
     */
    @RequestMapping("/admin_card_edit_do.html")
    public String adminUserEditDo(CreateOrUpdateCardReq createOrUpdateCardReq, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.updateCardInfo(createOrUpdateCardReq, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 删除卡片
     */
    @RequestMapping("/admin_card_delete.html")
    public String adminCardDelete(@RequestParam("userId") Integer userId, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        userCardService.deleteUserCard(userId, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片挂失
     */
    @RequestMapping("/card_missing.html")
    public String setCardMissing(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.missCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片激活
     */
    @RequestMapping("/card_active.html")
    public String setCardActive(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.activeCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片锁定
     */
    @RequestMapping("/card_suspend.html")
    public String setCardSuspend(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.suspendCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }
}
