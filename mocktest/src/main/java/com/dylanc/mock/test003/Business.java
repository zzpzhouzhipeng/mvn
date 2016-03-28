package com.dylanc.mock.test003;

import java.util.Random;

public class Business {
	private IService service;

    public void execute() {
        int count = ramdonInt();
        int result = service.execute(count);
        System.out.println("resoult:" + result);
    }

    public void setService(IService service) {
        this.service = service;
    }

    private int ramdonInt() {
        Random random = new Random();
        return random.nextInt() / 10000;
    }
}
