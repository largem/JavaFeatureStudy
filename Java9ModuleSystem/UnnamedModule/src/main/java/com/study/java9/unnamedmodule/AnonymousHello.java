package com.study.java9.unnamedmodule;

import com.study.java9.testmodule.ModernHello;

/**
 * Unnamed module does not have module-info.java
 * It requires all tbe other modules and exports all its packages
 * Means it can use all the modules including other unnamed modules
 *
 * Named module can not access unnamed module
 */
public class AnonymousHello {

    public static void say() {
        System.out.println("Hello from " + AnonymousHello.class.getName());
    }

    public static void main(String[] args) {
        Module module = AnonymousHello.class.getModule();
        System.out.println("Module name: " + module.getName());
        System.out.println("Module isnamed: " + module.isNamed());

        ModernHello.say();
    }
}
