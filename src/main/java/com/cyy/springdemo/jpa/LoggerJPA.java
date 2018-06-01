package com.cyy.springdemo.jpa;

import com.cyy.springdemo.model.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ========================
 * Created with IntelliJ IDEA.
 *
 * @Author： Cyy
 * @Date: 2018/6/1
 * @Time: 下午5:14
 * ========================
 */
public interface LoggerJPA
        extends JpaRepository<LoggerEntity, Long> {

}
