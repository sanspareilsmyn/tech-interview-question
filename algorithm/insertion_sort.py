# https://www.daleseo.com/sort-insertion/
# Insertion Sort
# 시간복잡도 O(n^2)
# 정렬 범위를 한 칸씩 늘리면서 올바른 위치에 꽂아주는 알고리즘
def insertion_sort(arr):
    for end in range(1, len(arr)):
        for j in range(end, 0, -1):
            if arr[j] < arr[j-1]:
                arr[j], arr[j-1] = arr[j-1], arr[j]

#1. 최적화 방안 1: 새롭게 추가된 값보다 작은 숫자를 만나는 최초의 순간까지만 돌리면 된다.
def insertion_sort(arr):
    for end in range(1, len(arr)):
        i = end
        while i > 0 and arr[i] < arr[i-1]:
            arr[i], arr[i-1] = arr[i-1], arr[i]
            i -= 1

if __name__ == "__main__":
    arr = [2,3,1,4]
    print('Insertion Sort')
    insertion_sort(arr)
    print(arr)