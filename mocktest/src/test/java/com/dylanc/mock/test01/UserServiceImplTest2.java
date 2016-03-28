/**  
 * Copyright © 2016 SYNNEX. All rights reserved.
 * @Title SalesAction.java
 * @Prject mocktest
 * @Package com.dylanc.mock
 * @ClassName UserServiceImplTest2 
 * @author dylanc  
 * @date 2016-2-2
 * @version: v1.0 
 * @Description 注解方式进行mock测试
*/

package com.dylanc.mock.test01;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dylanc.mock.bean.User;
import com.dylanc.mock.dao.IUserDao;
import com.dylanc.mock.service.UserServiceImpl;

@RunWith(EasyMockRunner.class)
public class UserServiceImplTest2 {
	
	@Mock 			// 1. 创建mock对象
	private IUserDao mockUserDao;
	
	@TestSubject	// 2. 将mock对象注入到测试类中
	private UserServiceImpl  service = new UserServiceImpl();
	
	@Before
	public void setUp(){
		System.out.println("before");
	}
	
	@Test  
    public void testQuery() throws Exception {  
		
		// 3. record阶段
        User expectedUser = new User();  
        expectedUser.setId("1003");  
        expectedUser.setName("chenfliang");
        
        EasyMock.expect(mockUserDao.getById("1002")).andReturn(expectedUser).times(1);  //录制Mock对象预期行为  
        
        // 4. replay阶段
        EasyMock.replay(mockUserDao);  //重放Mock对象，测试时以录制的对象预期行为代替真实对象的行为  
        
        User user = service.query("1002");  //调用测试方法  
        
        System.out.println("Expe-id:" + expectedUser.getId() + ",name:" + expectedUser.getName());
        System.out.println("Real-id:" + user.getId() + ",name:" + user.getName());
        
        Assert.assertNotNull(user);
        Assert.assertEquals(expectedUser.getId(), user.getId());   //断言测试结果   
        Assert.assertEquals(expectedUser.getName(), user.getName());   //断言测试结果   
    } 
	
	
	@After
	public void setDown(){
		// 5. verify阶段
		EasyMock.verify(mockUserDao);  		//验证Mock对象被调用  
		System.out.println("after");
	}
}
