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
	
	@Mock 			// 1. ����mock����
	private IUserDao mockUserDao;
	
	@TestSubject	// 2. ��mock����ע�뵽��������
	private UserServiceImpl  userServiceImpl = new UserServiceImpl();
	
	@Test  
    public void testVoidMethodByEditUser() throws Exception {  
		
		// 3. record�׶�
        User targetUser = new User();  
        targetUser.setId("1003");  
        targetUser.setName("chenfliang");
        
//        EasyMock.expect(mockUserDao.editUser(targetUser)).times(1);  //¼��Mock����Ԥ����Ϊ  
        
        // 4. replay�׶�
        EasyMock.replay(mockUserDao);  //�ط�Mock���󣬲���ʱ��¼�ƵĶ���Ԥ����Ϊ������ʵ�������Ϊ  
        userServiceImpl.editUser(targetUser);
//        User user = service.query("1002");  //���ò��Է���  
        
//        System.out.println("Expe-id:" + expectedUser.getId() + ",name:" + expectedUser.getName());
//        System.out.println("Real-id:" + user.getId() + ",name:" + user.getName());
        
//        Assert.assertNotNull(user);
//        Assert.assertEquals(expectedUser.getId(), user.getId());   //���Բ��Խ��   
//        Assert.assertEquals(expectedUser.getName(), user.getName());   //���Բ��Խ��   
        
        // 5. verify�׶�
//        EasyMock.verify(mockUserDao);  		//��֤Mock���󱻵���  
    }  
}
