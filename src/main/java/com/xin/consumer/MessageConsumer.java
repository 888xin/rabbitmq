package com.xin.consumer;

import com.xin.producer.MessageProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lhx on 2016/9/5 9:57
 *
 * @Description 消费接收
 */
public class MessageConsumer implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Override
    public void onMessage(Message message) {
        logger.info("receive message:{}",message);
        System.out.println(new String(message.getBody()));
    }

    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        MessageProducer messageProducer = (MessageProducer) ctx.getBean("messageProducer");
        messageProducer.sendMessage("-------------hello,xin3453465465467456456456^^^^^^66666!");
        Thread.sleep(1000);
        ctx.destroy();
    }

}
