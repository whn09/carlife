// IService.aidl
 package com.baidu.che.codriver;

 // Declare any non-default types here with import statements

 interface ICoDriverListener {
     /**
      * Demonstrates some basic types that you can use as parameters
      * and return values in AIDL.
      */
     String onCommand(in String pkg, in String cmd, in String param, in String data);
 }