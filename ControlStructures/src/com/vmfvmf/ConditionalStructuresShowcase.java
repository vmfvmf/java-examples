package com.vmfvmf;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ConditionalStructuresShowcase {

    // Using Enum with Strategy Pattern
    enum Operation {
        ADD {
            @Override
            int apply(int a, int b) {
                return a + b;
            }
        },
        SUBTRACT {
            @Override
            int apply(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY {
            @Override
            int apply(int a, int b) {
                return a * b;
            }
        },
        DIVIDE {
            @Override
            int apply(int a, int b) {
                return b != 0 ? a / b : 0;
            }
        };

        abstract int apply(int a, int b);
    }

    // Using Map of commands
    private final Map<String, Runnable> commandMap = new HashMap<>();

    public void ConditionalStructuresShowcase() {
        commandMap.put("hello", () -> System.out.println("Hello there!"));
        commandMap.put("goodbye", () -> System.out.println("Goodbye, friend!"));
        commandMap.put("surprise", () -> System.out.println("🎉 Surprise! 🎉"));
    }

    public void executeCommand(String command) {
        commandMap.getOrDefault(command, () -> System.out.println("Unknown command")).run();
    }

    // Using Polymorphism to avoid if-else
    interface Animal {
        void speak();
    }

    static class Dog implements Animal {
        public void speak() {
            System.out.println("Woof!");
        }
    }

    static class Cat implements Animal {
        public void speak() {
            System.out.println("Meow!");
        }
    }

    static class NinjaTurtle implements Animal {
        public void speak() {
            System.out.println("Cowabunga!");
        }
    }

    public static void main(String[] args) {
        ConditionalStructuresShowcase showcase = new ConditionalStructuresShowcase();

        // Example: enum with strategy
        System.out.println("Enum ADD: " + Operation.ADD.apply(5, 3));
        System.out.println("Enum DIVIDE: " + Operation.DIVIDE.apply(10, 2));

        // Example: map of commands
        showcase.executeCommand("hello");
        showcase.executeCommand("surprise");
        showcase.executeCommand("not-a-command");

        // Example: polymorphism
        Animal dog = new Dog();
        Animal cat = new Cat();
        Animal turtle = new NinjaTurtle();

        dog.speak();
        cat.speak();
        turtle.speak();
    }
}