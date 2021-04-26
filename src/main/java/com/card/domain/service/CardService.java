package com.card.domain.service;

import java.util.List;

import com.card.dao.dto.CardOperateRecordDTO;
import com.card.dao.generatedMapper.CardOperateRecordDTOMapper;
import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import com.card.domain.repository.CardInfoRepository;
import com.card.domain.req.CreateOrUpdateCardReq;
import com.card.domain.req.CreateOrUpdateUserReq;
import com.card.domain.req.QueryCardInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qinghong.zhu on 2021/4/25.
 *
 * @author qinghong.zhu
 */
@Service
public class CardService {
    @Autowired
    private CardInfoRepository cardInfoRepository;
    @Autowired
    private CardOperateRecordDTOMapper cardOperateRecordDTOMapper;

    /**
     * 创建用户卡片
     */
    public CardInfo createCardInfo(CreateOrUpdateUserReq createOrUpdateUserReq, UserInfo userInfo) {
        return cardInfoRepository.createCardInfo(createOrUpdateUserReq, userInfo);
    }

    /**
     * 根据卡号查询 CardInfo
     */
    public CardInfo findCardByNumber(Integer cardNumber) {
        return cardInfoRepository.findCardByNumber(cardNumber);
    }

    /**
     * 根据条件查询 CardInfo
     */
    public List<CardInfo> queryCardInfoByCondition(QueryCardInfoReq queryCardInfoReq) {
        return cardInfoRepository.queryCardInfoByCondition(queryCardInfoReq);
    }

    /**
     * 修改卡片信息
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateCardInfo(CreateOrUpdateCardReq createOrUpdateCardReq, int operateId) {
        CardInfo cardInfo = cardInfoRepository.findCardByNumber(createOrUpdateCardReq.cardNumber);
        CardOperateRecordDTO cardOperateRecordDTO = cardInfo.updateCardInfo(createOrUpdateCardReq, operateId);
        // 修改卡片信息
        cardInfoRepository.saveCardInfo(cardInfo);
        // 保存卡片操作日志
        cardOperateRecordDTOMapper.insertSelective(cardOperateRecordDTO);
    }

    /**
     * 保存卡片信息
     */
    public void saveCardInfo(CardInfo cardInfo) {
        cardInfoRepository.saveCardInfo(cardInfo);
    }

    /**
     * 卡片激活
     */
    @Transactional(rollbackFor = Exception.class)
    public void activeCard(Integer cardNumber, int operateId) {
        CardInfo cardInfo = cardInfoRepository.findCardByNumber(cardNumber);
        CardOperateRecordDTO cardOperateRecordDTO = cardInfo.activeCard(operateId);
        // 修改卡片信息
        cardInfoRepository.saveCardInfo(cardInfo);
        // 保存卡片操作日志
        cardOperateRecordDTOMapper.insertSelective(cardOperateRecordDTO);
    }

    /**
     * 卡片挂失
     */
    @Transactional(rollbackFor = Exception.class)
    public void missCard(Integer cardNumber, int operateId) {
        CardInfo cardInfo = cardInfoRepository.findCardByNumber(cardNumber);
        CardOperateRecordDTO cardOperateRecordDTO = cardInfo.missCard(operateId);
        // 修改卡片信息
        cardInfoRepository.saveCardInfo(cardInfo);
        // 保存卡片操作日志
        cardOperateRecordDTOMapper.insertSelective(cardOperateRecordDTO);
    }

    /**
     * 卡片锁定
     */
    @Transactional(rollbackFor = Exception.class)
    public void suspendCard(Integer cardNumber, int operateId) {
        CardInfo cardInfo = cardInfoRepository.findCardByNumber(cardNumber);
        CardOperateRecordDTO cardOperateRecordDTO = cardInfo.suspendCard(operateId);
        // 修改卡片信息
        cardInfoRepository.saveCardInfo(cardInfo);
        // 保存卡片操作日志
        cardOperateRecordDTOMapper.insertSelective(cardOperateRecordDTO);
    }

    /**
     * 卡片删除
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteCardInfoByUserId(Integer userId, int operateId) {
        CardInfo cardInfo = cardInfoRepository.findCardByUserId(userId);
        cardInfoRepository.deleteCardInfoByUserId(userId);
        // 删除卡片
        CardOperateRecordDTO cardOperateRecordDTO = cardInfo.deleteCard(operateId);
        // 保存卡片操作日志
        cardOperateRecordDTOMapper.insertSelective(cardOperateRecordDTO);
    }
}
