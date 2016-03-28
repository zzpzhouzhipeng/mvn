package com.dylanc.mock.test01;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dylanc.mock.bean.User;
import com.dylanc.mock.dao.IUserDao;
import com.dylanc.mock.service.UserServiceImpl;

@RunWith(EasyMockRunner.class)
public class UserServiceImplTest3 {
	
	@Mock 			// 1. 创建mock对象
	private IUserDao mockUserDao;
	
	@TestSubject	// 2. 将mock对象注入到测试类中
	private UserServiceImpl  userServiceImpl = new UserServiceImpl();
	
	@Test  
    public void testVoidMethodByEditUser() throws Exception {  
		
		// 3. record阶段
        User targetUser = new User();  
        targetUser.setId("1003");  
        targetUser.setName("chenfliang");
        
//        EasyMock.expect(mockUserDao.editUser(targetUser)).times(1);  //录制Mock对象预期行为  
        
        // 4. replay阶段
        EasyMock.replay(mockUserDao);  //重放Mock对象，测试时以录制的对象预期行为代替真实对象的行为  
        userServiceImpl.editUser(targetUser);
//        User user = service.query("1002");  //调用测试方法  
        
//        System.out.println("Expe-id:" + expectedUser.getId() + ",name:" + expectedUser.getName());
//        System.out.println("Real-id:" + user.getId() + ",name:" + user.getName());
        
//        Assert.assertNotNull(user);
//        Assert.assertEquals(expectedUser.getId(), user.getId());   //断言测试结果   
//        Assert.assertEquals(expectedUser.getName(), user.getName());   //断言测试结果   
        
        // 5. verify阶段
//        EasyMock.verify(mockUserDao);  		//验证Mock对象被调用  
    }  
}
