# https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221230994142&proxyReferer=https:%2F%2Fwww.google.com%2F
# Kruskal 알고리즘
# Minimal Spanning Tree를 만드는 알고리즘
# 모든 간선 정보를 오름차순으로 정렬한 뒤, 비용이 적은 간선부터 그래프에 포함!
# 1) 거리를 기준으로 오름차순 정렬
# 2) 앞에서부터 포함시키는데, 이 때 사이클 테이블을 확인함. 사이클이 생기면 포함 안 시킴.
#    싸이클이 발생하는지 여부는 Union-Find  알고리즘을 적용.

def getParent(set, x):
    if set[x] == x: return x
    return getParent(set, set[x])

def unionParent(set, a, b):
    a = getParent(set, a)
    b = getParent(set, b)
    if a < b:
        set[b] = a
    else:
        set[a] = b

def find(set, a, b):
    a = getParent(set, a)
    b = getParent(set, b)
    if a == b:
        return 1
    else:
        return 0

n = 7
v = []
v.append((-1, -1, -1))
v.append((1, 7, 12))
v.append([1, 4, 28])
v.append([1, 2, 67])
v.append([1, 5, 17])
v.append([2, 4, 24])
v.append([2, 5, 62])
v.append([3, 5, 20])
v.append([3, 6, 37])
v.append([4, 7, 13])
v.append([5, 6, 45])
v.append([5, 7, 73])

v = sorted(v, key=lambda x:x[2])

set = [0] * (n+1)
for i in range(1, n+1):
    set[i] = i

sum = 0
for i in range(len(v)):
    if not find(set, v[i][0], v[i][1]):
        sum += v[i][2]
        unionParent(set, v[i][0], v[i][1])

print(sum)