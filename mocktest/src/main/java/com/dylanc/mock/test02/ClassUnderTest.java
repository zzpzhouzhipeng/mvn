package com.dylanc.mock.test02;

public class ClassUnderTest {
	
	private Collaborator listener;
	
    public void setListener(Collaborator listener) {
        this.listener = listener;
    }
    
    public void addDocument(String title, String document) { 
    	listener.documentAdded(title);
    }
    
    public boolean addDocument2(String title, String document) { 
    	int result = listener.addDocument(title);
    	System.out.println("result:" + result);
    	return result > 0;
    }
    
    public void addDocument3(String title, String document) { 
    	System.out.println("title:" + title + ", document:" + document);
    }
}
