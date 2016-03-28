package com.dylanc.mock.test02;

public class ClassUnderTest {
	
	private Collaborator listener;
	
    public void setListener(Collaborator listener) {
        this.listener = listener;
    }
    
    public void addDocument(String title, String document) { 
    	listener.documentAdded(title);
    }
}
