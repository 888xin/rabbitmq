package com.lhx.fanout;

import com.lhx.bean.Bet;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by lhx on 2016/9/5 17:52
 *
 * @Description
 */
public class FanoutConsumer2{

    public void getInfo(String str) throws IOException {
        System.out.println("处理端2已经收到信息：" + str);
        System.out.println("============处理端2开始处理===========");
        ObjectMapper mapper = new ObjectMapper();
        Bet bet = mapper.readValue(str, Bet.class);
        System.out.println("============处理端2统计开始===========");
        System.out.println("下注金额累加，金额为：" + bet.getMoney());
    }

}
