package com.xin.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lhx on 2016/9/5 9:56
 *
 * @Description
 */
@Service
public class FanoutProducer {

    private Logger logger = LoggerFactory.getLogger(FanoutProducer.class);

    @Resource
    private AmqpTemplate fanoutTemplate;

    public void sendMessage(Object message){
        logger.info("to send message:{}",message);
        fanoutTemplate.convertAndSend(message);
    }
}
