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
        
        
        EasyMock.expect(mockUserDao.getById("1002")).andReturn(expectedUser).times(1);  //¼��Mock����Ԥ����Ϊ  
        EasyMock.replay(mockUserDao);  //�ط�Mock���󣬲���ʱ��¼�ƵĶ���Ԥ����Ϊ������ʵ�������Ϊ  
        
        User user = service.query("1002");  //���ò��Է���  
        
        System.out.println("Expe-id:" + expectedUser.getId() + ",name:" + expectedUser.getName());
        System.out.println("Real-id:" + user.getId() + ",name:" + user.getName());
        
        Assert.assertNotNull(user);
        Assert.assertEquals(expectedUser.getId(), user.getId());   //���Բ��Խ��   
        Assert.assertEquals(expectedUser.getName(), user.getName());   //���Բ��Խ��   
        
        EasyMock.verify(mockUserDao);  		//��֤Mock���󱻵���  
    }  
}
