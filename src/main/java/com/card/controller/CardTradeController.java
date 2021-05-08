package com.card.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.card.dao.dto.CardBillRecordDTO;
import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import com.card.domain.repository.CardBillRecordRepository;
import com.card.domain.req.CardTradeReq;
import com.card.domain.req.QueryCardBillLogReq;
import com.card.domain.service.CardService;
import com.card.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qinghong.zhu on 2021/4/20.
 * <p>卡片交易管理<p/>
 *
 * @author qinghong.zhu
 */
@Controller
public class CardTradeController {
    @Autowired
    private CardBillRecordRepository cardBillRecordRepository;
    @Autowired
    private CardService cardService;
    @Autowired
    private UserService userService;
    /**
     * 消费
     */
    @RequestMapping("/card_consume.html")
    public ModelAndView cardConsume(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        modelAndView.setViewName("card_consume");
        modelAndView.addObject("cardNumber", cardInfo.getCardNumber());
        return modelAndView;
    }

    @RequestMapping(value = "/card_consume_do", method = RequestMethod.POST)
    @ResponseBody
    public Object cardConsumeDo(CardTradeReq cardTradeReq, HttpServletRequest request) {
        CardInfo cardInfo = cardService.findCardByNumber(cardTradeReq.cardNumber);
        HashMap<String, String> res = new HashMap<>();
        try {
            if (!cardInfo.checkOutPassword(cardTradeReq.cardPassword)) {
                throw new RuntimeException("密码错误");
            }
            cardService.cardTrade(cardTradeReq, cardInfo.getCardNumber());
            res.put("msg", "消费成功");
        } catch (RuntimeException e) {
            res.put("msg", e.getMessage());
        }
        return res;
    }

    /**
     * 充值
     */
    @RequestMapping("/card_charge.html")
    public ModelAndView cardCharge(CardTradeReq cardTradeReq, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        modelAndView.setViewName("card_charge");
        modelAndView.addObject("cardNumber", cardInfo.getCardNumber());
        return modelAndView;
    }

    @RequestMapping(value = "/card_charge_do", method = RequestMethod.POST)
    @ResponseBody
    public Object cardChargeDo(CardTradeReq cardTradeReq, HttpServletRequest request) {
        CardInfo cardInfo = cardService.findCardByNumber(cardTradeReq.cardNumber);
        UserInfo userInfo = userService.getUserInfoById(cardInfo.getUserId());
        HashMap<String, String> res = new HashMap<>();
        try {
            if (!cardInfo.checkOutPassword(cardTradeReq.cardPassword)) {
                throw new RuntimeException("密码错误");
            }
            if (StringUtils.isEmpty(userInfo.getPayAccountNumber())) {
                throw new RuntimeException("请先绑定银行卡");
            }
            cardService.cardTrade(cardTradeReq, cardInfo.getCardNumber());
            res.put("msg", "充值成功");
        } catch (RuntimeException e) {
            res.put("msg", e.getMessage());
        }
        return res;
    }

    /**
     * 卡片交易流水
     */
    @RequestMapping("/card_bill_log.html")
    public ModelAndView cardBillLog(QueryCardBillLogReq queryCardBillLogReq, HttpServletRequest request) {
        List<CardBillRecordDTO> cardOperateRecordDTOList = new ArrayList<>();
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        if (!cardInfo.isAdmin()) {
            // 普通用户只能查询自己的账单
            queryCardBillLogReq.cardNumber = cardInfo.getCardNumber();
        }
        cardOperateRecordDTOList = cardBillRecordRepository.queryByCondition(queryCardBillLogReq);
        ModelAndView modelAndView = new ModelAndView("card_bill_log");
        modelAndView.addObject("cardOperateRecordDTOList", cardOperateRecordDTOList);
        return modelAndView;
    }

    /**
     * 卡片交易流水删除
     */
    @RequestMapping("/card_bill_log_delete.html")
    public String cardBillLogDelete(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        cardBillRecordRepository.delCardBillRecord(id);
        return "redirect:card_bill_log.html";
    }
}
