package com.dylanc.mock.test003;

import org.easymock.EasyMock;
import org.junit.Test;

public class UserServiceImplTest3 {
	
	@Test
    public void testRuntimeReturn() {
        Business business = new Business();
        IService service = EasyMock.createMock(IService.class);
        business.setService(service);
//        EasyMock.expect(service.execute(EasyMock.anyInt())).andAnswer(new IAnswer<Integer>() {
//            public Integer answer() throws Throwable {
//                Integer count = (Integer) EasyMock.getCurrentArguments()[0];
//                System.out.println("param:" + count);
//                return count * 2;
//            }
//        });	
        EasyMock.expect(service.execute(EasyMock.anyInt())).andDelegateTo(new ServiceImpl());
        
        EasyMock.replay(service);
        business.execute();
        EasyMock.verify(service);
    }
}
