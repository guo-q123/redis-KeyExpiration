package com.lixiang.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author guoqiang3@lixiang.com
 * @version 1.0
 * @Date 2022/3/8 5:36 PM
 */
@Slf4j
public class RedisExpiredListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        System.out.print("onMessage >> " );
        System.out.printf("channel: %s, body: %s, bytes: %s%n",new String(channel), new String(body), new String(bytes));
        log.error("过期key："+new String(body));
    }

}
