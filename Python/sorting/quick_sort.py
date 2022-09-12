def quickSort( array: list) -> list:
    if len(array) < 2: return array
    # Set pivot to be the last element
    pivot = array.pop(-1)
    # Initialise left and right empty lists
    left: list = []
    right: list = []
    # Sort into left and right lists based off pivot
    for element in array:
        if element < pivot:
            left.append(element)
        else:
            right.append(element)        
    # Sort and then merge left and right lists
    return quickSort(left) + [pivot] + quickSort(right)

def quickSort2(array: list) -> list:
    if len(array) < 2: return array
    pivot = array.pop()
    left = list()
    right = list()
    for el in array:
        if el < pivot: left.append(el)
        else: right.append(el)
    return quickSort2(left)+[pivot]+quickSort2(right)
