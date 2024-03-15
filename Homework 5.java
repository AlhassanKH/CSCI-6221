import java.util.InputMismatchException;
import java.util.Scanner;

/*

Write a program/function in any Object-Oriented programming language (e.g., Java, C++, Python) that will implement Queue Abstract Data Type with the following functions/methods.  Any build-in/pre-defined Queue function/library (e.g., java.util.Queue in Java) is NOT allowed to use in your code.

    push(Element):  insert the input Element (e.g., String or Integer in Java) to the end of the queue.
    pop(): remove/pop the head element of the queue and print the popped element  on screen.
    count():  return the total number of elements in the queue

 

Your program/function will perform the following:

    your program should display 2 options below for grader to select one of 2 options to initialize your object type in the queue. Only 1 data type is allowed in the Queue.
        Integer
        String
    after step #1, your program should display the following options (i.e., main screen) for grader to select any one of them to test out your program.
        push
        pop
        count
        end

When option (a) from the main screen is selected, your program should enable grader to enter an element (e.g., TEST1, if grader selects String option) that will be inserted into the queue and prompt the main screen to let grader to continue to select any one of options. If the input element has a wrong data (e.g., Queue is initialized for integer data type, but the input is a string “abc”), your program should display “wrong data type is entered”, skip the insertion, and go back to the main screen.

When option (b) from the main screen is selected, your program should do the following:

    print out the head element (e.g., TEST1) on screen
    remove the head element from the queue
    prompt the main screen to let grader to continue to select any one of options.  

If the queue is empty when option (b) is selected, your program should display “There is no element in the queue” on screen and prompt the main screen to let grader to continue to select any one of options.

When option (c) from the main screen is selected, your program should display the total number of elements in the queue and prompt the main screen to let grader to continue to select any one of options.

When option (d) from the main screen is selected, your program will be terminated.

Please DO NOT hard-code any input values, output values in your code.

*/

public class CSCI6221HW5 {
    private static final int MAX_SIZE = 100;
    private Object[] elements;
    private int front;
    private int rear;
    private int count;
    private boolean isIntegerQueue;
    //private boolean isStringQueue;
     
    public CSCI6221HW5(boolean isIntegerQueue) {
        elements = new Object[MAX_SIZE];
        front = 0;
        rear = -1;
        count = 0;
        this.isIntegerQueue = isIntegerQueue;
    }
    
    public void push(Object element) {
    if (((element instanceof Integer && !isIntegerQueue) || 
        (element instanceof String &&  isIntegerQueue)) ||
        (!(element instanceof Integer) && !(element instanceof String))) {
       // System.out.println("Wrong data type is entered");
        return;
    }
    if (count == MAX_SIZE) {
        System.out.println("Queue is full");
        return;
    }
    rear = (rear + 1) % MAX_SIZE;
    elements[rear] = element;
    count++;
}

    
    public Object pop() {
        if (count == 0) {
            System.out.println("There is no element in the queue");
            return null;
        }
        Object element = elements[front];
        front = (front + 1) % MAX_SIZE;
        count--;
        return element;
    }
    
    public int count() {
        return count;
    }
    
    public static void main(String[] args) {
    Scanner nscan = new Scanner(System.in);
    boolean isIntegerQueue = false;
    
    System.out.println("Select data type for queue:");
    System.out.println("1. Integer");
    System.out.println("2. String");
    
    int dataType = 0;
    while (dataType != 1 && dataType != 2) {
        try {
            dataType = nscan.nextInt();
            if (dataType == 1) {
                isIntegerQueue = true;
            } else if (dataType == 2) {
                isIntegerQueue = false;
            } else {
                System.out.println("Invalid input type. Please enter 1 or 2.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter 1 or 2.");
            nscan.nextLine();  
        }
    }
    
    CSCI6221HW5 queue = new CSCI6221HW5(isIntegerQueue);
    
    while (true) {
        System.out.println("Select an option:");
        System.out.println("1. Push");
        System.out.println("2. Pop");
        System.out.println("3. Count");
        System.out.println("4. End");
        
        int option = 0;
        while (option < 1 || option > 4) {
            try {
                option = nscan.nextInt();
                if (option < 1 || option > 4) {
                    System.out.println("Invalid option. Please enter a number from 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter a number from 1 to 4.");
                nscan.nextLine(); 
            }
        }
        
        switch (option) {
            case 1:
    if (isIntegerQueue) {
        System.out.println("Enter an integer:");
        int intElement = 0;
        while (true) {
            try {
                intElement = nscan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter an integer.");
                nscan.nextLine(); 
            }
        }
        queue.push(intElement);
    } else {
        System.out.println("Enter a string:");
        String strElement = nscan.next();
        queue.push(strElement);
    }
    break;

            case 2:
                Object element = queue.pop();
                if (element != null) {
                    System.out.println("Popped element: " + element.toString());
                }
                break;
            case 3:
                System.out.println("Number of elements in queue: " + queue.count());
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    }
}