package com.lhx.run;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lhx on 2016/9/19 10:49
 *
 * @Description
 */
public class RunMain {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
    }
}
