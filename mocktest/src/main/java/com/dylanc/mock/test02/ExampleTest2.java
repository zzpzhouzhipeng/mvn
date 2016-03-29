package com.dylanc.mock.test02;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ExampleTest2 {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock(type = MockType.NICE, name = "mock", fieldName = "listener")
    private Collaborator mock; 				// 1

//    @Mock(type = MockType.NICE, name = "mock", fieldName = "d")
//    private Collaborator mockCollaborator; 			
    
    @TestSubject
    private final ClassUnderTest classUnderTest = new ClassUnderTest(); // 2

    @Test
    public void addDocument() {
    	mock.documentAdded("New Document"); // 3
        EasyMock.replay(mock);				// 4
        classUnderTest.addDocument("New Document", "content"); // 5
        EasyMock.verify(mock);
    }
}