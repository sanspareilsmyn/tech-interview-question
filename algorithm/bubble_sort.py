# https://www.daleseo.com/sort-bubble/
# Bubble Sort
# O(n^2)
# 뒤에서부터 앞으로 정렬.
# 제일 큰 값을 제일 뒤로 보내고, 제일 큰 값 앞에 두번째로 큰 값을 보냄

'''def bubblesort(arr):
    length = len(arr)
    for i in range(length-1):
        for j in range(length-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

if __name__ == "__main__":
    arr = [2,3,1,4]
    bubblesort(arr)
    print(arr)'''

# 최적화 방안 1. 스왑이 일어나지 않으면 중단한다.
'''def bubble_sort(arr):
    for i in range(len(arr)-1):
        flag = False
        for j in range(len(arr)-i-1):
            if arr[j] > arr[j+1]:
                flag = True
                arr[j], arr[j+1] = arr[j+1], arr[j]
        if flag == False:
            break'''

# 최적화 방안 2. 마지막으로 스왑 있었던 위치 기억하면 거기서부터 돌리면 된다.
def bubble_sort(arr):
    end = len(arr) - 1
    while end > 0:
        last_swap = 0
        for i in range(end):
            if arr[i] > arr[i+1]:
                arr[i], arr[i+1] = arr[i+1], arr[i]
                last_swap = i
        end = last_swap

if __name__ == "__main__":
    arr = [2,3,1,4]
    bubble_sort(arr)
    print(arr)