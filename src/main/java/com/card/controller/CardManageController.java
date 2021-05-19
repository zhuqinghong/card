package com.card.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.card.dao.dto.CardOperateRecordDTO;
import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import com.card.domain.repository.CardOperateRecordRepository;
import com.card.domain.req.CreateOrUpdateCardReq;
import com.card.domain.req.QueryCardInfoReq;
import com.card.domain.req.QueryCardOperateLogReq;
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
    @Autowired
    private CardOperateRecordRepository cardOperateRecordRepository;

    @RequestMapping("/admin_card_list.html")
    public ModelAndView adminCardList(QueryCardInfoReq queryCardInfoReq, HttpServletRequest request) {
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        if (!cardInfo.isAdmin()) {
            // 普通用户只能看自己的信息
            queryCardInfoReq.cardNumber = cardInfo.getCardNumber();
        }
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
    public String adminCardEditDo(CreateOrUpdateCardReq createOrUpdateCardReq, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.updateCardInfo(createOrUpdateCardReq, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 删除卡片，目前卡片信息和用户信息做一个强依赖，删除卡片= 删除用户+删除卡片
     */
    @RequestMapping("/admin_card_delete.html")
    public ModelAndView adminCardDelete(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_card_delete");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        CardInfo cardInfo = cardService.findCardByNumber(cardNumber);
        modelAndView.addObject("cardInfo", cardInfo);
        return modelAndView;
    }

    /**
     * 删除卡片，目前卡片信息和用户信息做一个强依赖，删除卡片= 删除用户+删除卡片
     */
    @RequestMapping("/admin_card_delete_do.html")
    public String adminCardDeleteDo(@RequestParam("userId") Integer userId, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        userCardService.deleteUserCard(userId, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片挂失
     */
    @RequestMapping("/card_missing.html")
    public ModelAndView setCardMissing(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_card_missing");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        CardInfo cardInfo = cardService.findCardByNumber(cardNumber);
        modelAndView.addObject("cardInfo", cardInfo);
        return modelAndView;
    }

    /**
     * 卡片挂失
     */
    @RequestMapping("/card_missing_do.html")
    public String setCardMissingDo(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.missCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片激活
     */
    @RequestMapping("/card_active.html")
    public ModelAndView setCardActive(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_card_active");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        CardInfo cardInfo = cardService.findCardByNumber(cardNumber);
        modelAndView.addObject("cardInfo", cardInfo);
        return modelAndView;
    }

    /**
     * 卡片激活
     */
    @RequestMapping("/card_active_do.html")
    public String setCardActiveDo(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.activeCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片锁定
     */
    @RequestMapping("/card_suspend.html")
    public ModelAndView setCardSuspend(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_card_suspend");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        CardInfo cardInfo = cardService.findCardByNumber(cardNumber);
        modelAndView.addObject("cardInfo", cardInfo);
        return modelAndView;
    }

    /**
     * 卡片锁定
     */
    @RequestMapping("/card_suspend_do.html")
    public String setCardSuspendDo(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.suspendCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }

    /**
     * 卡片日志
     */
    @RequestMapping("/admin_card_log.html")
    public ModelAndView adminCardLog(QueryCardOperateLogReq queryCardOperateLogReq, HttpServletRequest request) {
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        if (!cardInfo.isAdmin()) {
            // 普通用户只能看自己的信息
            queryCardOperateLogReq.cardNumber = cardInfo.getCardNumber();
        }
        List<CardOperateRecordDTO> cardOperateRecordDTOList = cardOperateRecordRepository.queryByCondition(queryCardOperateLogReq);
        ModelAndView modelAndView = new ModelAndView("admin_card_log");
        modelAndView.addObject("cardOperateRecordDTOList", cardOperateRecordDTOList);
        return modelAndView;
    }

    /**
     * 卡片日志
     */
    @RequestMapping("/admin_card_log_delete.html")
    public String adminCardLog(HttpServletRequest request) {
        cardOperateRecordRepository.deleteRecord(Integer.parseInt(request.getParameter("id")));
        return "redirect:/admin_card_log.html";
    }

    /**
     * 卡片补办
     */
    @RequestMapping("/card_readd.html")
    public ModelAndView setCardReAdd(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin_card_readd");
        int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        CardInfo cardInfo = cardService.findCardByNumber(cardNumber);
        modelAndView.addObject("cardInfo", cardInfo);
        return modelAndView;
    }

    /**
     * 卡片激活
     */
    @RequestMapping("/card_card_readd_do.html")
    public String setCardReAddDo(@RequestParam("cardNumber") Integer cardNumber, HttpServletRequest request) {
        UserInfo currentUser = (UserInfo)request.getSession().getAttribute("userInfo");
        cardService.activeCard(cardNumber, currentUser.getId());
        return "redirect:/admin_card_list.html";
    }
}
