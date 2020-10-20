# https://m.blog.naver.com/ndb796/221230967614
# Union-Find(합집합 찾기) 알고리즘
# 여러 개의 노드가 존재할 때 두 개의 노드를 선택해서, 현재 이 두 노드가 서로 같은 그래프에 속하는지 판별
# 서로가 연결되지 않았으면, 모든 값이 자기 자신을 가리키게 만듬. 이 때 Key는 노드 번호, Value는 부모 노드 번호
# 1과 2가 연결되었다면, Key 2의 Value를 1로 바꿈

def getParent(parent, x):
    if parent[x] == x:
        return x
    return getParent(parent, parent[x])

def unionParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def findParent(parent, a, b):
    a = getParent(parent, a)
    b = getParent(parent, b)
    if a == b:
        return 1
    else:
        return 0

parent = [0] * 11
for i in range(1, 11):
    parent[i] = i

unionParent(parent, 1, 2)
unionParent(parent, 2, 3)
unionParent(parent, 3, 4)
unionParent(parent, 5, 6)
unionParent(parent, 6, 7)
unionParent(parent, 7, 8)

print("1-5 is connected?", findParent(parent, 1, 5))
unionParent(parent, 1, 5)
print("1-5 is connected?", findParent(parent, 1, 5))