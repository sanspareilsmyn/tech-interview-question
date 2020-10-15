# https://www.daleseo.com/sort-merge/
# Merge Sort
# 시간복잡도 O(nlogn) : 절반으로 split하는 데 O(logN), 모든 값을 비교하는데 O(N)이다.
# 공간복잡도 O(N) : 두 개의 배열을 병합할 때 병합 결과를 담아놓을 배열이 추가로 필요하므로
# 다른 정렬과 달리 swap은 일어나지 않는다.

def merge_sort(arr):
    def sort(low, high):
        if high - low < 2:
            return
        mid = (low + high) // 2
        sort(low, mid)
        sort(mid, high)
        merge(low, mid, high)

    def merge(low, mid, high):
        temp = []
        l, h = low, mid

        while l < mid and h < high:
            if arr[l] < arr[h]:
                temp.append(arr[l])
                l += 1
            else:
                temp.append(arr[h])
                h += 1
        while l < mid:
            temp.append(arr[l])
            l += 1
        while h < high:
            temp.append(arr[h])
            h += 1
        for i in range(low, high):
            arr[i] = temp[i - low]

    return sort(0, len(arr))


if __name__ == "__main__":
    arr = [3, 2, 4, 1, 8, 0, 11, 5, 6]
    print('Quick Sort')
    merge_sort(arr)
    print(arr)