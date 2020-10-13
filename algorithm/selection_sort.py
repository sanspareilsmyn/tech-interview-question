# Selection Sort
# 시간복잡도 : O(n^2)
# 공간복잡도는 O(1) 원래 있는 배열 그대로 쓴다.
# 앞에서부터 최솟값 세팅하는데 그 뒤 배열에서 가장 작은 애 골라서 swap.
# Bubble Sort보다 Swap 덜 하긴 함.

def selection_sort(arr):
    length = len(arr)
    for i in range(length-1):
        minidx = i
        for j in range(i+1, length):
            if arr[minidx] > arr[j]:
                minidx = j
        arr[i], arr[minidx] = arr[minidx], arr[i]

if __name__ == "__main__":
    arr = [2,3,1,4]
    selection_sort(arr)
    print(arr)