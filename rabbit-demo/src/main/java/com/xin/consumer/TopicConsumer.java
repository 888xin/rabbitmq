package com.xin.consumer;

import com.xin.producer.TopicProducer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lhx on 2016/9/5 17:52
 *
 * @Description
 */
public class TopicConsumer implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println(message);
        System.out.println(new String(message.getBody()));
    }

    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        TopicProducer topicProducer = (TopicProducer) ctx.getBean("topicProducer");
        topicProducer.sendMessage("++++++++++++++++++hello,xin3453465465467456456456^^^^^^66666!hello,xin");
        Thread.sleep(1000);
        ctx.destroy();
    }
}
