package com.lhx.run;

import com.lhx.contest.PlayBall;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lhx on 2016/9/19 10:45
 *
 * @Description
 */
public class RunMain {

    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
        PlayBall  playBall = (PlayBall) ctx.getBean("playBall");
        playBall.bet(8L, 101L, 100.00D, 1);
        Thread.sleep(1000);
        ctx.destroy();
    }
}
