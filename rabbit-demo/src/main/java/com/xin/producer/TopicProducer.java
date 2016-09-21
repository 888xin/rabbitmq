package com.xin.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lhx on 2016/9/5 9:56
 *
 * @Description
 */
@Service
public class TopicProducer {

    private Logger logger = LoggerFactory.getLogger(TopicProducer.class);

    @Resource
    private AmqpTemplate topicTemplate;

    public void sendMessage(Object message){
        logger.info("to send message:{}",message);
        topicTemplate.convertAndSend("info.debug",message);
    }
}
