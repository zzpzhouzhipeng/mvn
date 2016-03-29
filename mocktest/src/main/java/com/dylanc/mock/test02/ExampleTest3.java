package com.dylanc.mock.test02;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class ExampleTest3 {

//    @Rule
//    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator collaborator; // 1

    @TestSubject
    private final ClassUnderTest classUnderTest = new ClassUnderTest(); // 2

    @Test
    public void addDocument() {
    	EasyMock.expect(collaborator.addDocument("chenliang")).andReturn(42).times(1);
//        collaborator.documentAdded("New Document"); // 3
        EasyMock.replay(collaborator);
        classUnderTest.addDocument2("chenliang", "content"); // 5
        EasyMock.verify(collaborator);
    }
}