/*
Write a program/function in any programming language that will print out data type, number of byte(s) used by the data type, and its range of data value for ALL primitive/built-in data types.
E.g., in Java, byte data type will have the following output:
byte           1       -128 to 127
Please declare variables with different data types in your code and use these variables to print out the requested outcome above.  

---------------------------------
 *
 * @author Hassan
 */

public class CSCI6221HW2 {

   public static void main(String[] args) {
        System.out.println("Data type\tNum of Bytes\t\tRange");

        byte b = 127;
        System.out.println("byte\t\t" + Byte.BYTES + "\t\t" + Byte.MIN_VALUE + " to " + Byte.MAX_VALUE);

        short s = 32767;
        System.out.println("short\t\t" + Short.BYTES + "\t\t" + Short.MIN_VALUE + " to " + Short.MAX_VALUE);

        int i = 2147483647;
        System.out.println("int\t\t" + Integer.BYTES + "\t" + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);

        long l = 9223372036854775807L;
        System.out.println("long\t\t" + Long.BYTES + "\t" + Long.MIN_VALUE + " to " + Long.MAX_VALUE);

        float f = 3.40282347f;
        System.out.println("float\t\t" + Float.BYTES + "\t\t" + Float.MIN_VALUE + " to " + Float.MAX_VALUE);

        double d = 1.7976931348623157;
        System.out.println("double\t\t" + Double.BYTES + "\t" + Double.MIN_VALUE + " to " + Double.MAX_VALUE);

        char c = '\u0000';
        System.out.println("char\t\t" + Character.BYTES + "\t\t" + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);

        boolean bool = true;
        System.out.println("boolean\t\t" + (Byte.BYTES) + "\t\t" + bool + " or " + !bool);
    }
}

/*

--------------------------------------
Output: 

Data type	Num of Bytes		Range
byte		1		-128 to 127
short		2		-32768 to 32767
int		4	-2147483648 to 2147483647
long		8	-9223372036854775808 to 9223372036854775807
float		4		1.4E-45 to 3.4028235E38
double		8	4.9E-324 to 1.7976931348623157E308
char		2		0 to 65535
boolean		1		true or false

*/