# https://www.daleseo.com/sort-quick/
# Quick Sort
# Pivot 값을 어떻게 정하는지가 굉장히 중요한데, 이상적으로는 O(NlogN). 한 편에 치우치면 O(N^2)

'''def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    pivot = arr[len(arr) // 2]
    left, equal, right = [], [], []
    for e in arr:
        if e < pivot:
            left.append(e)
        elif e == pivot:
            equal.append(e)
        else:
            right.append(e)
    return quick_sort(left) + equal + quick_sort(right)'''

#1. 최적화 방안 - 리스트 생성 없는 in-place 정렬
def quick_sort(arr):
    def sort(low, high):
        if low >= high:
            return
        mid = partition(low, high)
        sort(low, mid-1)
        sort(mid, high)

    def partition(low, high):
        pivot = arr[(low + high) // 2]
        while low <= high:
            while arr[low] < pivot:
                low += 1
            while arr[high] > pivot:
                high -= 1
            if low <= high:
                arr[low], arr[high] = arr[high], arr[low]
                low, high = low + 1, high - 1
        return low

    return sort(0, len(arr)-1)

if __name__ == "__main__":
    arr = [2,3,1,4,0]
    print('Quick Sort')
    quick_sort(arr)
    print(arr)