package com.dylanc.thrift.test.server;  
   
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import com.dylanc.thrift.test.handler.AdditionServiceHandler;
import com.dylanc.thrift.test.service.AdditionService;
   
public class MyServer {  
   
 public static void StartsimpleServer(AdditionService.Processor<AdditionServiceHandler> processor) {  
  try {  
   TServerTransport serverTransport = new TServerSocket(9090);  
//   TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));  
   
   // Use this for a multithreaded server  
    TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));  
   
   System.out.println("Starting the simple server...");  
   server.serve();  
  } catch (Exception e) {  
   e.printStackTrace();  
  }  
 }  
    
 public static void main(String[] args) {  
  StartsimpleServer(new AdditionService.Processor<AdditionServiceHandler>(new AdditionServiceHandler()));  
 }  
   
}