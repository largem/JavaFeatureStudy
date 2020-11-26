package com.study.java9.moduleapp;

import com.study.java9.legacymodule.AncientHello;
//import com.study.java9.privatemodule.InnerHello;
import com.study.java9.testmodule.ModernHellp;

public class ModuleApp {

    public static void main(String[] args) {
        ModernHellp.say();
        //InnerHello.say();    //InnerModule is not exported in TestModule, check module-info.java in TestModule.

        AncientHello.say();
    }
}
