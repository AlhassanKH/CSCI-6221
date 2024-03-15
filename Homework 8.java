/*

    write code in an Object-Oriented programing language, e.g., Java, Python, or C++, for the following:
        choose one of design patterns from Creational catalog and implement the pattern.
        choose one of design patterns from Structural catalog and implement the pattern.
        implement a function that will use both 2 design patterns from in 1.a) and 1.b).
        implement a main/test function to run/test the code from 1.c).
    in your instructions, define input argument(s) and the expected result for the function from 1.c) and 1.d).
    include the following 4 items in your HW submission:
        your source codes (2 design patterns from 1.a), 1.b); the function from 1.c), and the testing function from 1.d) in txt format.  please indicate the names of design patterns in your source code.
        a screenshot of code got compiled, executed, and generated the expected result.
        instructions showing how your code can be compiled/executed/tested by grader.

 

Please note that any built-in deign patterns, such as singleton (object) from Spring (boot) framework, CANNOT be used in your answer.  You need to write your own code to implement each design pattern.

 

Please DO NOT hard code any input values, output values in your code.
*/

/*
* Alhassan Halawani
* HW9 - Design
* Language - Java
*/


interface Product {
    void print();
}

class ConcreteProduct implements Product {
    @Override
    public void print() {
        System.out.println("ConcreteProduct");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();
}

class ConcreteCreator extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}

abstract class Decorator implements Product {
    private Product product;

    public Decorator(Product product) {
        this.product = product;
    }

    public void print() {
        product.print();
    }
}

class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Product product) {
        super(product);
    }

    public void print() {
        super.print();
        System.out.println("ConcreteDecorator1");
    }
}

class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Product product) {
        super(product);
    }

    public void print() {
        super.print();
        System.out.println("ConcreteDecorator2");
    }
}

public class DesignPatternExample {
    public static void main(String[] args) {
        System.out.println("Testing Factory Method and Decorator patterns:");

        Creator creator = new ConcreteCreator();
        Product product = creator.factoryMethod();
        Product decorator1 = new ConcreteDecorator1(product);
        Product decorator2 = new ConcreteDecorator2(decorator1);

        decorator2.print();
    }
}