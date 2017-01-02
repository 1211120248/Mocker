package com.mocker.core.log.dao;/**
 * Created by sunwukong on 16/12/10.
 */

import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.log.domain.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @author Mocker
 * @Date 2016-12-10 下午5:01
 * @Version 1.0
 */
public interface LogRepository extends BaseRepository<Log>{

}
