from itertools import permutations

def is_prime_number(number):
    if number == 0 or number == 1:
        return False
    
    i = 2
    
    while i**2 <= number:
        if number % i == 0:
            return False
        i += 1
    
    return True


def solution(numbers):
    answer = set()
    max_digit_num = len(numbers)
    
    for i in range(1, max_digit_num + 1):
        lists = list((permutations(numbers, i)))
        
        for j in range(len(lists)):
            number = int("".join(lists[j]))
            
            if is_prime_number(number):
                answer.add(number)
    
    return len(answer)