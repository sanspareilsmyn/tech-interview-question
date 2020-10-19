# https://m.blog.naver.com/PostView.nhn?blogId=ndb796&logNo=221240679247&proxyReferer=https:%2F%2Fwww.google.com%2F
# https://www.geeksforgeeks.org/python-program-for-rabin-karp-algorithm-for-pattern-searching/

# Rabin-Karp Algorithm
# 해싱을 사용하여 일치하는 문자열을 찾는 알고리즘
# 각 문자의 아스키 코드 값에 2의 제곱수를 차례로 곱하여 더해준 것
# 해시 값이 겹치는 경우가 거의 없기 때문에, 긴 글과 부분 문자열의 해시값이 일치하는 경우에만 문자열을 재검사!
# 이렇게 하면 O(N)의 시간복잡도
# 얘를 빨리 하는 방법! => 바로 앞에 있는 문자만큼의 수치를 빼준 뒤에 2를 곱하고 새로 들어온 수치를 더해준다!

def findString(parent, pattern):
    finded = False
    parentSize = len(parent)
    patternSize = len(pattern)
    parentHash, patternHash, power = 0, 0, 1
    for i in range(parentSize-patternSize+1):
        if i == 0:
            for j in range(patternSize):
                parentHash = parentHash + ord(parent[patternSize-1-j]) * power
                patternHash = patternHash + ord(pattern[patternSize-1-j]) * power
                if j < (patternSize-1):
                    power = power * 2
        else:
            parentHash = 2 * (parentHash - ord(parent[i-1])*power) + ord(parent[patternSize-1+i])

        if parentHash == patternHash:
            finded = True
            for j in range(patternSize):
                if parent[i+j] != pattern[j]:
                    finded = False
                    break

        if finded:
            print("{}번째에서 발견", i+1)


parent = "ABCDEEE"
pattern = "EE"
findString(parent, pattern)