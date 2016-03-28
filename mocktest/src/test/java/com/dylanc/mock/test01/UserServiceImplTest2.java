package com.dylanc.mock.test01;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dylanc.mock.bean.User;
import com.dylanc.mock.dao.IUserDao;
import com.dylanc.mock.dao.impl.UserDaoImpl;
import com.dylanc.mock.service.UserServiceImpl;

@RunWith(EasyMockRunner.class)
public class UserServiceImplTest2 {
	
	@Mock
	private IUserDao mockUserDao  = EasyMock.createMock(UserDaoImpl.class);	// 1
	
	@TestSubject
	private UserServiceImpl  service = new UserServiceImpl(); 				// 2
	
	@Test  
    public void testQuery() throws Exception {  
		
        User expectedUser = new User();  
        expectedUser.setId("1003");  
        expectedUser.setName("chenfliang");
        
        
        EasyMock.expect(mockUserDao.getById("1002")).andReturn(expectedUser).times(1);  //录制Mock对象预期行为  
        EasyMock.replay(mockUserDao);  //重放Mock对象，测试时以录制的对象预期行为代替真实对象的行为  
        
        User user = service.query("1002");  //调用测试方法  
        
        System.out.println("Expe-id:" + expectedUser.getId() + ",name:" + expectedUser.getName());
        System.out.println("Real-id:" + user.getId() + ",name:" + user.getName());
        
        Assert.assertNotNull(user);
        Assert.assertEquals(expectedUser.getId(), user.getId());   //断言测试结果   
        Assert.assertEquals(expectedUser.getName(), user.getName());   //断言测试结果   
        
        EasyMock.verify(mockUserDao);  		//验证Mock对象被调用  
    }  
}
