package com.cyy.springdemo.controller;

import com.cyy.springdemo.dao.IUserDao;
import com.cyy.springdemo.jpa.UserJPA;
import com.cyy.springdemo.model.Person;
import com.cyy.springdemo.model.User;
import com.cyy.springdemo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;


    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value ="/login")
    public String login(UserEntity user, HttpServletRequest request){
        String result = "success";
        Optional<UserEntity> userEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.where(criteriaBuilder.equal(root.get("name"),user.getName()));
                return null;
            }
        });
        if(!userEntity.isPresent()){
            result = "user is not present";
        } else if(!user.getPwd().equals(userEntity.get().getPwd())){
            result = "user pwd wrong";
        }
        //登录成功
        if(result.equals("success")){
            //将用户写入session
            request.getSession().setAttribute("_session_user",userEntity);
        }
        return result;
    }

    /**
     * 查询用户列表方法
     * @return
     */
    @RequestMapping(value ="/list" ,method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userJPA.findAll();
    }

    /**
     * 添加、更新用户方法
     * @param entity
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity)
    {
        return userJPA.save(entity);
    }

    /**
     * 删除用户方法
     * @param id 用户编号
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id)
    {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

}
