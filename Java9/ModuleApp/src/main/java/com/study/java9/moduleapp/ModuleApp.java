package com.study.java9.moduleapp;

//import com.study.java9.privatemodule.InnerHello;

import com.google.common.collect.ImmutableList;
import com.study.java9.legacymodule.AncientHello;
import com.study.java9.testmodule.ModernHello;

import java.util.List;

/**
 * If module-info.java exists, App can be run as new module feature, otherwise it is still run as classpath app.
 * Any dependency build before java 9 will be treated as Automatic modules, such as Guava and LegacyModule in this example.
 * Also there is a concept of "unnamed module", which are those modules that do not have module-info but build in java 9
 * (different from Automatic Module above)
 *
 * One note:
 * It looks like Intellij does not handle automatic module properly if the module itself is part of the project (rather
 * than as an external dependency)
 */
public class ModuleApp {

    public static void main(String[] args) {
        ModernHello.say();
        //InnerHello.say();    //InnerModule is not exported in TestModule, check module-info.java in TestModule.
        List<String> list = ImmutableList.of();
        AncientHello.say();     //AncientHello is from Automatic module
        //AnonymousHello.say();  //Named module can not use unnamed module.
    }
}
