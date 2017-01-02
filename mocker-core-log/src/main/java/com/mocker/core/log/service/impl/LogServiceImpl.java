package com.mocker.core.log.service.impl;

import com.mocker.core.base.dao.BaseRepository;
import com.mocker.core.base.service.IBaseService;
import com.mocker.core.base.service.impl.BaseServiceImpl;
import com.mocker.core.log.domain.Log;
import com.mocker.core.log.service.ILogService;
import org.springframework.stereotype.Service;

/**
 * @author Mocker
 * @Date 2017-01-02 下午11:53
 * @Version 1.0
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements ILogService {

    public LogServiceImpl(BaseRepository<Log> repository) {
        super(repository);
    }

}
