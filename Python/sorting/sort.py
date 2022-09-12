
from merge_sort import mergeSort
from quick_sort import quickSort
from random import randint
from sys import maxsize
from time import time

def genList(listSize):
    return [randint(0-maxsize, maxsize) for i in range(listSize)]

def isSorted(array):
    for i in range(1,len(array)):
        if array[i] < array[i-1]: return False
    return True

if __name__ == '__main__':
    unsorted = genList(1000000)
    t0 = time()
    mSorted = mergeSort(unsorted)
    mtime = time() - t0
    print("Merge Sorted:", mtime if isSorted(mSorted) else "List not sorted.")
    t0 = time()
    qSorted = quickSort(unsorted)
    qtime = time() - t0
    print("Quick Sorted:", qtime if isSorted(qSorted) else "List not sorted.")
