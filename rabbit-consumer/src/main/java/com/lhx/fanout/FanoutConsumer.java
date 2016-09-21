package com.lhx.fanout;

import com.lhx.bean.Bet;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by lhx on 2016/9/5 17:52
 *
 * @Description
 */
public class FanoutConsumer {

    public void getInfo(String foo) throws IOException {
        System.out.println("处理端1已经收到信息：" + foo);
        System.out.println("============处理端1开始处理===========");
        ObjectMapper mapper = new ObjectMapper();
        Bet bet = mapper.readValue(foo, Bet.class);
        System.out.println("============处理端1统计开始===========");
        System.out.println("下注人数+1，userId为：" + bet.getUserId());

    }


}
