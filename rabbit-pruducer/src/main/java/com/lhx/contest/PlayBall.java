package com.lhx.contest;

import com.lhx.bean.Bet;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by lhx on 2016/9/18 16:36
 *
 * @Description
 */
@Service
public class PlayBall {

    private Logger logger = LoggerFactory.getLogger(PlayBall.class);

    @Resource
    private AmqpTemplate fanoutTemplate;

    public void bet(long userId, long contestId, double money, int support) throws IOException {

        System.out.println(String.format("下注比赛了，用户为%d，赛事为%d，下注金额为%f，支持方为%d",userId, contestId, money, support));
        System.out.println("下注写入数据库");
        System.out.println("=============================");
        System.out.println("现在开始统计信息，发rabbitMq");
        Bet bet = new Bet();
        bet.setUserId(userId);
        bet.setContestId(contestId);
        bet.setMoney(money);
        bet.setSupport(support);
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(bet);
        fanoutTemplate.convertAndSend(jsonStr);
        System.out.println("+++++++++发送出去++++++");
    }

}
