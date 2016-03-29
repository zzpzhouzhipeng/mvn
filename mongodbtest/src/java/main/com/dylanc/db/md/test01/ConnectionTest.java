package com.dylanc.db.md.test01;

import java.util.Set;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class ConnectionTest {
	public static void main(String[] args) throws Exception {
//		MongoClient mc = MongoClient.MongoClient("192.168.87.35", 27017);
//        		Mongo("192.168.87.35", 27017);
//        DB db = m.getDB("test ");
//        if(db.authenticate("test", "123".toCharArray())){
//            System.out.println("success");;
//        }
//        else System.out.println("false");
		
//		MongoClient mongoClient = new MongoClient();
//		MongoClient mongoClient = new MongoClient( "localhost" );
		MongoClient mongoClient = new MongoClient( "192.168.87.35" , 27017 );
//		MongoClient mongoClient = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017),
//		                                      new ServerAddress("localhost", 27018),
//		                                      new ServerAddress("localhost", 27019)));

//		DB db = mongoClient.getDB("test");
//		
//		Set<String> colls = db.getCollectionNames();
//		for (String s : colls) {
//		    System.out.println(s);
//		}
		
		MongoDatabase db = mongoClient.getDatabase("test");
		
		MongoIterable<String> colls = db.listCollectionNames();
		for (String s : colls) {
		    System.out.println(s);
		}
		
    }
}
