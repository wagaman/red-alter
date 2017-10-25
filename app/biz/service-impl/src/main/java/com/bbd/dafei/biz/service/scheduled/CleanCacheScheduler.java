package com.bbd.dafei.biz.service.scheduled;

import com.bbd.dafei.common.dal.mapper.RaCacheMapper;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 清除缓存
 * @author Ian.Su
 * @version $Id: CleanCache.java, v 0.1 2017/4/28 9:35 Ian.Su Exp $
 */
@Component
public class CleanCacheScheduler {


    Logger LOGGER = LoggerFactory.getLogger(CleanCacheScheduler.class);

    @Autowired
    private RaCacheMapper cacheMapper;

    /**
     * 每分钟清除一次过期缓存
     * */
    @Scheduled(cron = "1 0/30 * * * ?")
    public void cleanExceedTimeCache(){

        LOGGER.info("定期清理缓存开始");
        cacheMapper.clean(new Date());
        LOGGER.info("定期清理缓存结束");

    }



    /**
     * 清除所有缓存
     * */
    public void cleanAllCache(){

        LOGGER.info("清理所有缓存开始");
        cacheMapper.clean(null);
        LOGGER.info("清理所有缓存结束");

    }


}
