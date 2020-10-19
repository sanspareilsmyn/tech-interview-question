# https://ratsgo.github.io/data%20structure&algorithm/2017/09/27/heapsort/
# Heap Sort
# Heap과 BST의 차이점 : Heap은 Parent가 Child보다 크기만 하면 됨. BST는 왼쪽 자식과 오른쪽 자식의 크기 matters
# Heap은 Insert와 Delete를 생각하면 됨.
# 시간복잡도 Best, avg, worst 모두 nlong

def heapify(unsorted, index, heap_size):
    largest = index
    left_index = 2 * index + 1
    right_index = 2 * index + 2
    if left_index < heap_size and unsorted[left_index] > unsorted[largest]:
        largest = left_index
    if right_index < heap_size and unsorted[right_index] > unsorted[largest]:
        largest = right_index
    if largest != index:
        unsorted[largest], unsorted[index] = unsorted[index], unsorted[largest]
        heapify(unsorted, largest, heap_size)

def heap_sort(unsorted):
    n = len(unsorted)

    for i in range(n//2-1, -1, -1): # n//2-1 왜냐면 리프노드 단은 검토할 필요가 없으므로. heapify는 밑으로 타고 내려오기 때문
        heapify(unsorted, i, n)

    # 여기까지 하면 max heap이 만들어짐
    print('start', unsorted)
    # 여기서부터 정렬
    # 1. 원소의 첫 요소와 마지막 요소를 교환 -> 다시 heapify 반복
    # 왜냐면 heapify는 밑으로 타고 내려오기 때문
    # 제일 큰 애를 제일 마지막 노드랑 바꾼다는 건 제일 큰 애를 마지막에 박아놓겠다는 뜻
    for i in range(n-1, 0, -1):
        unsorted[0], unsorted[i] = unsorted[i], unsorted[0]
        heapify(unsorted, 0, i)
        print(unsorted)
    return unsorted


unsorted = [16, 4, 10, 14, 7, 9, 3, 2, 8, 1]
heap_sort(unsorted)