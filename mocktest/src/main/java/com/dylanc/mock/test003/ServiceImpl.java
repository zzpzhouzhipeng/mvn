package com.dylanc.mock.test003;

public class ServiceImpl implements IService{

	public int execute(int count) {
		int result = count * 2;
		System.out.println("count:" + count);
		System.out.println("result:" + result);
		return result;
	}

}
