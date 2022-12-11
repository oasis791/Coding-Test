from functools import reduce
import math

def find(array, gcd):
    for element in array:
        if element % gcd == 0:
            return 0
    return gcd


def solution(arrayA, arrayB):
    a_gcd, b_gcd = reduce(math.gcd, arrayA), reduce(math.gcd, arrayB)
    conditionA_result, conditionB_result = find(arrayB, a_gcd), find(arrayA, b_gcd)
    
    return max(conditionA_result, conditionB_result)