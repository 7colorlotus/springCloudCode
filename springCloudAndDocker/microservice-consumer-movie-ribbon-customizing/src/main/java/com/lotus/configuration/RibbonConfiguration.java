package com.lotus.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * Created by Administrator on 2017/6/25.
 */
public class RibbonConfiguration {
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
