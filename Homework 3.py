import random

"""

Write a program/function in any programming language that will implement Loop Guarded Command (LGC) as discussed on the last slide of ch8.

Your program/function will take 3 non-zero, positive integers, e.g., 3, 6, and 12.  Please note that your code should be able to take different values other than 3, 6, and 12.

The first two input integers should have different values, e.g., 3 and 6. These 2 integers will be used to create a range of integers (e.g., from 3 to 6), which will be used to create a list of Boolean expressions as follows:

    the first Boolean expression will be defined as “x%3 == 0”, i.e., to check if x%3 has 0 remainder.  
    the second Boolean expression will be defined as “x%4 ==0”
    the third Boolean expression will be defined as “x%5==0”
    The last Boolean expression will be defined as “x%6==0”

  where variable x will take the third input integer as explained below.

 

The statement corresponding to each Boolean expression defined above will print out the Fibonacci numbers that are less than the integer used in the Boolean expression.  E.g., the statement for the second Boolean expression x%4==0 will print out “0 1 1 2 3”; for the fourth Boolean expression x%6==0 will print out “0 1 1 2 3 5”.

The third input integer to your program/function will be used as input value for variable x defined in the Boolean expressions above.  E.g., if the third input integer is 12, the first, second, and fourth Boolean expressions will have a true value (i.e., 12%3 = 12%4 = 12%6 = 0). The LGC will randomly, non-deterministically choose ONE of 3 corresponding statements to print out the Fibonacci numbers, as described above.

If the third input integer to your program function failed all Boolean expressions defined, your program should throw runtime errors and be terminated.

Please DO NOT hard-code any input values, output values in your code.

"""

def fibonacci(n):
    fib_sequence = [0, 1]
    while fib_sequence[-1] < n:
        fib_sequence.append(fib_sequence[-1] + fib_sequence[-2])
    return fib_sequence[:-1]

def LGC(start, end, x):
    guards = [(x % i == 0, i) for i in range(start, end + 1)]
    true_guards = [(fibonacci(guard[1]), guard[1]) for guard in guards if guard[0]]

    if not true_guards:
        raise RuntimeError("All guards evaluated to False. Terminating the program.")

    chosen_guard = random.choice(true_guards)
    print(f"Fibonacci numbers less than {chosen_guard[1]}: {chosen_guard[0]}")

# Example usage
start = int(input("Enter the start of the range: "))
end = int(input("Enter the end of the range: "))
x = int(input("Enter the value of x: "))
LGC(start, end, x)
