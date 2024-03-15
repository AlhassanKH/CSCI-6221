"""
Write a program/function in any programming language that will implement Calling Subprograms Indirectly as discussed on the slides of ch9.

Your program/function will take 2 non-zero, positive integers, e.g., 6 and 12 OR 16 and 2, as input parameters, and output any prime numbers between these 2 inputs.  

e.g.,

> printPrime 40 31

31 is a prime number

37 is a prime number


Please DO NOT hard-code any input values, output values in your code.

"""


def is_prime(n):
    if n <= 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True

def find_primes(start, end):
    primes = []
    for number in range(min(start, end), max(start, end) + 1):
        if is_prime(number):
            primes.append(number)
    return primes

def print_primes(prime_list):
    for prime in prime_list:
        print(f"{prime} is a prime number")

def print_prime(start, end):
    prime_list = find_primes(start, end)
    print_primes(prime_list)

# Example usage
start = int(input("Enter the first number: "))
end = int(input("Enter the second number: "))
print_prime(start, end)
