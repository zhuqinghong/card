package com.card.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.card.dao.dto.CardBillRecordDTO;
import com.card.domain.entity.CardInfo;
import com.card.domain.repository.CardBillRecordRepository;
import com.card.domain.req.CardTradeReq;
import com.card.domain.req.QueryCardBillLogReq;
import com.card.domain.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    /**
     * 消费
     */
    @RequestMapping("/card_bill_log.html")
    public ModelAndView cardConsume(CardTradeReq cardTradeReq, HttpServletRequest request) {
        CardInfo cardInfo = (CardInfo)request.getSession().getAttribute("cardInfo");
        cardService.cardTrade(cardTradeReq, cardInfo.getCardNumber());
        cardInfo = cardService.findCardByNumber(cardInfo.getCardNumber());
        return null;
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
        cardBillRecordRepository.queryByCondition(queryCardBillLogReq);
        ModelAndView modelAndView = new ModelAndView("card_bill_log");
        modelAndView.addObject("cardOperateRecordDTOList", cardOperateRecordDTOList);
        return modelAndView;
    }
}
