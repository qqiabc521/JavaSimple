package com.ljj.javasimple.cache;

import java.util.Random;

public class ApiModelImpl implements ApiModel {

    private Random random;

    public ApiModelImpl() {
        random = new Random();
    }

    @Override
    public String getResult(String id) {
        return "result " + random.nextInt(1000);
    }
}
