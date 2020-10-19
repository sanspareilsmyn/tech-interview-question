# https://m.blog.naver.com/ndb796/221240660061
# https://baeharam.github.io/posts/algorithm/kmp/
# KMP 알고리즘
# 단순 문자열 비교 알고리즘을 쓰면 O(N*M)임.
# 모든 문자열을 비교하면 연산량이 너무 많으니 접두사와 접미사 개념 사용
# 접두사와 접미사가 일치하는 최대 길이에 한해서 점프가 가능!
# KMP 쓰면 O(N+M)이다.

def make_table(pattern):
    pattern_size = len(pattern)
    table = [0 for _ in range(pattern_size)]
    j = 0
    for i in range(1, pattern_size):
        while j > 0 and pattern[i] != pattern[j]:
            j = table[j-1]

        if pattern[i] == pattern[j]:
            table[i] = j+1
            j += 1
    print(table)
    return table


def KMP(parent, pattern):
    table = make_table(pattern)
    parent_size = len(parent)
    pattern_size = len(pattern)
    j = 0
    for i in range(parent_size):
        while j > 0 and parent[i] != pattern[j]:
            j = table[j-1]
        if parent[i] == pattern[j]:
            if j == pattern_size - 1:
                print("{}번째에서 찾았습니다.", i-pattern_size+2)
                j = table[j]
            else:
                j += 1


parent = "ababacabacaabacaaba"
pattern = "abacaaba"
KMP(parent, pattern)