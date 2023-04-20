# Algorithm.md
## 정렬
### 버블정렬
* 인접한 두 데이터의 크기를 비교하여 정렬하는 알고리즘

### 선택 정렬
* 주어진 데이터 중 최소값을 찾아 순서대로 정렬하는 알고리즘
* 후보군 중 최솟값을 찾아낸 후 맨 앞의 데이터와 교체한다.
* 교체된 맨 앞의 데이터를 제외한 나머지 후보군에서 다시 최솟값을 찾아낸다

### 삽입 정렬
* 1번 인덱스에 위치한 데이터를 기준으로 해당 데이터의 앞 쪽에 위치한 데이터와 비교한다.
* 더 작은값을 찾을 때까지 데이터를 뒤로 밀어내며 정렬하는 알고리즘이다.
* 삽입된 데이터보다 작은 데이터를 만날 때까지 반복하며, 없는 경우 0번 인덱스에 위치하게 된다.

### 퀵 정렬
* 데이터에서 기준점을 정하여 기준점보다 작다면 좌측, 크다면 우측에 정렬한다.
* 좌 / 우측으로 1차 정렬된 데이터에서 좌/우측 각각의 기준점을 다시 선정하고 정렬을 수행한다.
* 이 과정을 재귀함수를 사용하여 반복하며 최종적으로 정렬된 데이터를 반환한다.

### 병합 정렬
* 분할 정복 알고리즘을 기반한 정렬이며, 재귀함수를 사용한다.
* 리스트를 절반으로 잘라 비슷한 크기의 두 부분 리스트로 나눈다.
* 각 부분 리스트를 재귀적으로 합병 정렬을 이용해 정렬한다.
* 두 부분 리스트를 다시 하나의 정렬된 리스트로 합병한다.

## 탐색
### 이진탐색
* 탐색할 자료를 반으로 나누어 찾는 데이터가 있을만한 곳을 찾아가며 탐색하는 방식

### 순차탐색
* 데이터가 담겨있는 리스트를 앞에서부터 하나씩 순차적으로 비교하며 원하는 데이터를 찾는 방식

## 그래프
### 너비우선탐색(BFS)
* 정점과 같는 레벨이 있는 노드를 먼저 탐색하는 방식

### 깊이우선탐색(DFS)
* 정점의 자식 노드를 먼저 탐색하는 방식

### 최단거리 알고리즘
* 그래프에서 두 노드를 잇는 가장 짧은 경로를 찾는 알고리즘
* 간선의 가중치합이 최소인 경로를 찾는 것이 목적

#### 단일출발
* 특정 노드와 그 외 노드들 간의 최단경로

#### 단일출발 및 단일 도착
* 특정 노드 2개의 최단경로

#### 전체 쌍
* 모든 노드간의 연결 조합에 대한 최단 경로

### 다익스트라
* 최단경로 알고리즘에서 단일출발에 해당한다.
* 첫 정점을 기준으로 연결되어있는 인접 노드를 추가해가며 최단거리를 갱신하는 방법이다.
* 가장 개선된 알고리즘 구현 방법은 우선순위 큐를 활용하는 것이다.

### 플로이드워셜
* 최단경로 알고리즘에서 전체 쌍에 해당한다.
* 거쳐가는 정점들을 기준으로 최단거리를 구하는 방법이다.
* 3중 for문을 통해 구현할 수 있다.

## 문제해결전략
### 재귀호출
* 함수 안에서 함수가 호출되는 형태를 말한다.
* 재귀함수는 마치 stack처럼 동작한다.
* dfs의 경우 재귀호출 또는 stack을 사용하여 구현할 수 있다.

### 동적 계획법(DP)
* 하나의 큰 문제를 해결하기 위해 큰 문제를 작은 문제로 나누어 해결한 후, 작은 문제로부터 계산된 결과값을 이용해 전체문제를 해결하는 알고리즘이다.
* 메모이제이션 : 프로그램 실행 시 중복되는 연산이 2번 수행되지 않도록 이전에 계산한 값을 저장하여 전체적인 연산실행속도를 빠르게하는 방법이다.
* DP를 사용하는 이유는, 중복연산을 제거하고 재활용하여 전체적인 코드 수행 및 연산 효율을 증가시키기 위함이다.

### 분할정복
* 하나의 큰 문제를 해결하기 위해 작은 문제로 나누어 해결하고, 다시 병합하여 상위문제의 답을 얻는 방식이다.
* DP와의 차이는 나누어진 부분 문제에 중복이 없다는 것과, 하향식 접근법을 사용하고, 메모이제이션을 사용하지 않는다.

### 탐욕알고리즘
* 최적의 해에 가까운 값을 구하기 위해 사용되는 알고리즘이다.
* 여러가지 경우 중 하나를 결정해야 할 때 상황에따라 매 순간 최선의 선택을 하여 최종적인 값을 구하는 방식이다.

### 백트래킹
* 해를 찾기위해 어떤 후보군을 대상으로 제약조건을 체크하다가, 해당 후보군이 제약조건을 만족할 수 없다면 즉시 백트랙 한 후 다른 후보군으로 넘어가는 방식으로 해를 찾는 방법이다.
* 연산의 대상이 되는 후보군이 적어지고 그만큼 시간복잡도가 줄어들어 빠르게 최적의 해를 찾을 수 있다.