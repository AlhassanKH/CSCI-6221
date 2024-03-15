import java.util.InputMismatchException;
import java.util.Scanner;

/*
Write a program/function in any Object-Oriented programming language that will perform the following functions, when the program is executed, to demonstrate the features of an OOP language—ADT, inheritance, and polymorphism:

1. Prompt a list of options—the main menu, below to compute the area of selected shape with input parameters: 

        triangle
        rectangle
        square
        circle
        parallelogram
        Exit

2. Per the selected option above, prompt grader to enter the corresponding required parameters as described below:

        base and height for triangle
        length and width for rectangle
        side for square
        radius for circle
        base and height for parallelogram

 

3. Your program should validate the number of input parameter(s) and the value of each parameter. 

        If the number of parameter(s) is incorrect OR the parameter is invalid (e.g., 0 or -3 or w), display the message—input parameter(s) is/are incorrect, and allow grader to re-enter the correct parameter(s)
        If the input parameter(s) is/are valid, display the computed area based on the input parameter(s), and then display the main menu to allow grader to select any one of options from the main menu.
        Assuming the unit is ft for all input parameters.

Please DO NOT hard-code any input values, output values in your code.
*/

public class CSCI6221HW6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Select a shape to calculate its area: ");
            System.out.println("1. Triangle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Circle");
            System.out.println("5. Parallelogram");
            System.out.println("6. Exit");
            int option = sc.nextInt();
            Shape shape;
            switch (option) {
                case 1:
                    shape = new Triangle();
                    break;
                case 2:
                    shape = new Rectangle();
                    break;
                case 3:
                    shape = new Square();
                    break;
                case 4:
                    shape = new Circle();
                    break;
                case 5:
                    shape = new Parallelogram();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    continue;
            }
            double[] parameters = shape.readParameters(sc);
            if (parameters == null) {
                System.out.println("Input parameter(s) is/are incorrect. Please try again.");
                sc.nextLine(); // consume the remaining newline character
                continue;
            }
            double area = shape.calculateArea(parameters);
            System.out.printf("The area of the %s is %.2f sq ft.\n", shape.getName(), area);
        }
    }
}

abstract class Shape {
    abstract double[] readParameters(Scanner sc);
    abstract double calculateArea(double[] parameters);
    abstract String getName();
}

class Triangle extends Shape {
    @Override
    double[] readParameters(Scanner sc) {
        double[] parameters;
        while (true) {
            System.out.print("Enter the base and height of the triangle separated by a space: ");
            try {
            double base = sc.nextDouble();
            double height = sc.nextDouble();
            if (base <= 0 || height <= 0) {
                System.out.println("Invalid input. Base and height must be positive.");
                continue;
            }
            parameters = new double[] {base, height};
            break;
            } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a positive value for the side length.");
             sc.next();
        }
        }
        return parameters;
    }

    @Override
    double calculateArea(double[] parameters) {
        double base = parameters[0];
        double height = parameters[1];
        return 0.5 * base * height;
    }

    @Override
    String getName() {
        return "triangle";
    }
}

class Rectangle extends Shape {
    @Override
    double[] readParameters(Scanner sc) {
        double[] parameters = null;
        while (parameters == null) {
            System.out.print("Enter the length and width of the rectangle separated by a space: ");
            try {
            double length = sc.nextDouble();
            double width = sc.nextDouble();
            if (length <= 0 || width <= 0) {
                System.out.println("Invalid input. Please enter positive values for both length and width.");
            } else {
                parameters = new double[]{length, width};
            }
            } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a positive value for the side length.");
             sc.next();
            }
        }
        return parameters;
    }

    @Override
    double calculateArea(double[] parameters) {
        double length = parameters[0];
        double width = parameters[1];
        return length * width;
    }

    @Override
    String getName() {
        return "rectangle";
    }
}

class Square extends Shape {
    @Override
    double[] readParameters(Scanner sc) {
        double[] parameters = null;
        while (parameters == null) {
            System.out.print("Enter the side length of the square: ");
            try {
            double side = sc.nextDouble();
            if (side <= 0) {
                System.out.println("Invalid input. Please enter a positive value for the side length.");
            } else {
                parameters = new double[]{side};
            }
            } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a positive value for the side length.");
             sc.next();
        }
        }
        return parameters;
    }

    @Override
    double calculateArea(double[] parameters) {
        double side = parameters[0];
        return side * side;
    }

    @Override
    String getName() {
        return "square";
    }
}

class Circle extends Shape {
    @Override
    double[] readParameters(Scanner sc) {
        double radius;
        while (true) {
            System.out.print("Enter the radius of the circle: ");
            try {
            radius = sc.nextDouble();
            if (radius > 0) {
                break;
            }
            System.out.println("Invalid input. Please enter a positive number.");
            } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a positive value for the side length.");
             sc.next();
            }
        }
        return new double[] {radius};
    }

    @Override
    double calculateArea(double[] parameters) {
        double radius = parameters[0];
        return Math.PI * radius * radius;
    }

    @Override
    String getName() {
        return "circle";
    }
}

class Parallelogram extends Shape {
    @Override
    double[] readParameters(Scanner sc) {
        double base, height;
        while (true) {
            System.out.print("Enter the base and height of the parallelogram separated by a space: ");
            try {
            base = sc.nextDouble();
            height = sc.nextDouble();
            if (base > 0 && height > 0) {
                break;
            }
            System.out.println("Invalid input. Please enter two positive numbers.");
            } catch (InputMismatchException e) {
             System.out.println("Invalid input. Please enter a positive value for the side length.");
             sc.next();
            }
        }
        return new double[] {base, height};
    }

    @Override
    double calculateArea(double[] parameters) {
        double base = parameters[0];
        double height = parameters[1];
        return base * height;
    }

    @Override
    String getName() {
        return "parallelogram";
    }
}