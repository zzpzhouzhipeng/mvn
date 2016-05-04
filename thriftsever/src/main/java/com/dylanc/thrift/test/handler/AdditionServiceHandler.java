package com.dylanc.thrift.test.handler;  
   
import org.apache.thrift.TException;

import com.dylanc.thrift.test.service.AdditionService;
   
public class AdditionServiceHandler implements AdditionService.Iface {  
   
 @Override 
 public int add(int n1, int n2) throws TException {  
  return (n1 + n2) * 2;  
 }  
   
}