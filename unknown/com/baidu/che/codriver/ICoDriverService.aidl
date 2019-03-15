// IService.aidl
 package com.baidu.che.codriver;

import com.baidu.che.codriver.ICoDriverListener;
 // Declare any non-default types here with import statements

 interface ICoDriverService {
     /**
      * Demonstrates some basic types that you can use as parameters
      * and return values in AIDL.
      */
     String sendCommand(in String pkg, in String cmd, in String param, in String data);
     void registerListener(in String pkg, in ICoDriverListener listener);
     void unRegisterListener(in ICoDriverListener listener);
 }