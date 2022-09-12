def mergeSort(array):
    if len(array) <= 1: return array

    mid = int(len(array)/2)

    leftArray = array[:mid]
    rightArray= array[mid:]

    return merge(mergeSort(leftArray), mergeSort(rightArray))

def merge(leftArray, rightArray):
    result=[]
    i = j = 0
    while i < len(leftArray) and j < len(rightArray):
        if leftArray[i] < rightArray[j]:
            result.append(leftArray[i])
            i += 1
        else:
            result.append(rightArray[j])
            j += 1

    if i < len(leftArray):
        for element in range(i, len(leftArray)):
            result.append(leftArray[element])
    elif j < len(rightArray):
        for element in range(j, len(rightArray)):
            result.append(rightArray[element])
    return result
