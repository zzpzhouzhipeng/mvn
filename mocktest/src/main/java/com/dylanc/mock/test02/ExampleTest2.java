package com.dylanc.mock.test02;

import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

public class ExampleTest2 {

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @Mock
    private Collaborator mockCollaborator; 				// 1

    @TestSubject
    private final ClassUnderTest classUnderTest = new ClassUnderTest(); // 2

    @Test
    public void addDocument() {
    	mockCollaborator.documentAdded("New Document"); // 3
        EasyMock.replay(mockCollaborator);				// 4
        classUnderTest.addDocument("New Document", "content"); // 5
        EasyMock.verify(mockCollaborator);
    }
}