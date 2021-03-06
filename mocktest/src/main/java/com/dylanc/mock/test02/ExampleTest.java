package com.dylanc.mock.test02;

import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class ExampleTest extends EasyMockSupport {

//    @Rule
//    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator collaborator; // 1

    @TestSubject
    private final ClassUnderTest classUnderTest = new ClassUnderTest(); // 2

    @Test
    public void addDocument() {
        collaborator.documentAdded("New Document"); // 3
        replayAll(); // 4
        classUnderTest.addDocument("New Document", "content"); // 5
        verifyAll(); // 6
    }
}