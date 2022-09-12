import sys

sequence=[1,1]
def fib(a):
    if a < len(sequence):
        return sequence[a]
    else:
        ans = fib(a-2) + fib(a-1)
        sequence.append(ans)
        return ans

if __name__=='__main__':
    number = 50
    if len(sys.argv) > 1:
        try:
            number = int(sys.argv[1])
        except Exception:
            pass
    
    print(fib2(number-1))
