package com.cyy.springdemo.controller;

import com.cyy.springdemo.jpa.UserJPA;
import com.cyy.springdemo.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController  extends IController{
    @Autowired
    private UserJPA userJPA;
    /**
     * 查询用户列表方法
     *
     * @return
     */
    @RequestMapping(value = "/login")
//    @ResponseBody
    public String login(UserEntity user, HttpServletRequest request) {
        String result = "success";
        Optional<UserEntity> userEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        if (!userEntity.isPresent()) {
            result = "user is not present";
        } else if (!user.getPwd().equals(userEntity.get().getPwd())) {
            result = "user pwd wrong";
        }
        //登录成功
        if (result.equals("success")) {
            //将用户写入session
            request.getSession().setAttribute("_session_user", userEntity);
        }
        logger.info(result);
        return "upload_index";
    }

    /**
     * 查询用户列表方法
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> list() {
        return userJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     *
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity save(UserEntity entity) {
        return userJPA.save(entity);
    }

    /**
     * 删除用户方法
     *
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> delete(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

    /**
     * 初始化登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login_view", method = RequestMethod.GET)
    public String login_view() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


}
