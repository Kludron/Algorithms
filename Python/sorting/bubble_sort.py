import random

class BubbleSort():
    
    def sort(self, nums: [int]) -> [int]:
        for i in range(len(nums)-1):
            swapped = False
            for j in range(len(nums)-i-1):
                if nums[j] > nums[j+1]:
                    tmp = nums[j]
                    nums[j] = nums[j+1]
                    nums[j+1] = tmp
                    swapped = True
            if not swapped:
                break
        return nums

if __name__ == '__main__':
    b = BubbleSort()
    nums=[random.randint(-10, 10) for i in range(10)]
    print(nums)
    print(b.sort(nums))
