package com.card.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.card.domain.entity.UserCard;
import com.card.domain.entity.UserInfo;
import com.card.domain.req.CreateOrUpdateUserReq;
import com.card.domain.req.QueryUserInfoReq;
import com.card.domain.service.UserCardService;
import com.card.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qinghong.zhu on 2021/4/20. 用户管理
 *
 * @author qinghong.zhu
 */
@Controller
public class UserManageController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserCardService userCardService;

    @RequestMapping("/admin_user_list.html")
    public ModelAndView adminUserList(QueryUserInfoReq queryUserInfoReq) {
        if (queryUserInfoReq == null) {
            queryUserInfoReq = new QueryUserInfoReq();
        }
        List<UserInfo> userInfos = userService.queryUserInfoByCondition(queryUserInfoReq);
        ModelAndView modelAndView = new ModelAndView("admin_user_list");
        modelAndView.addObject("userInfos", userInfos);
        return modelAndView;
    }

    @RequestMapping("/admin_user_create.html")
    public ModelAndView adminUserCreate() {
        return new ModelAndView("admin_user_create");
    }

    @RequestMapping("/admin_user_create_do.html")
    public String adminUserCreateDo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        UserCard userCard = userCardService.createUserInfoAndCard(createOrUpdateUserReq);
        return "redirect:/admin_user_list.html";
    }

    @RequestMapping("/admin_user_edit.html")
    public ModelAndView adminUserEdit(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("userId"));
        UserCard userCard = userCardService.findUserCardByUserId(userId);
        ModelAndView modelAndView = new ModelAndView("admin_user_edit");
        modelAndView.addObject("userCard", userCard);
        return modelAndView;
    }

    @RequestMapping("/admin_user_edit_do.html")
    public String adminUserEditDo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        userService.updateUserInfo(createOrUpdateUserReq);
        return "redirect:/admin_user_list.html";
    }

    @RequestMapping("/admin_user_delete.html")
    public String adminUserDelete(@RequestParam("userId") Integer userId, HttpServletRequest request) {
        UserInfo currentUserInfo = (UserInfo)request.getSession().getAttribute("userInfo");
        userCardService.deleteUserCard(userId, currentUserInfo.getId());
        return "redirect:/admin_user_list.html";
    }
}
