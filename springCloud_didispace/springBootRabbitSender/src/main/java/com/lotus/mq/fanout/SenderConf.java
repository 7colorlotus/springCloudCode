package com.lotus.mq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhusheng on 2017/8/10 0010.
 */
//@Configuration
public class SenderConf {
    @Bean("Amessage")
    public Queue Amessage() {
        return new Queue("fanout.A");
    }

    @Bean("Bmessage")
    public Queue Bmessage() {
        return new Queue("fanout.B");
    }

    @Bean("Cmessage")
    public Queue Cmessage() {
        return new Queue("fanout.C");
    }

    @Bean("fanoutExchange")
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");// 配置广播路由器
    }

    @Bean
    Binding buildingExchangeA(@Qualifier("Amessage") Queue aMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(aMessage).to(fanoutExchange);
    }

    @Bean
    Binding buildingExchangeB(@Qualifier("Bmessage") Queue bMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(bMessage).to(fanoutExchange);
    }

    @Bean
    Binding buildingExchangeC(@Qualifier("Cmessage") Queue cMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(cMessage).to(fanoutExchange);
    }
}
