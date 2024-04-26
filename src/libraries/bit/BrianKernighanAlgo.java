package libraries.bit;

// n&(n-1) 트릭 이용
// 이진수 비트에서 1의 개수를 세기 위한 알고리즘

// n = n & (n-1) 을 할 때마다 맨 오른쪽의 1이 0으로 바뀐다.
// 0으로 바뀔 때마다 count 를 늘려주면 된다.

public class BrianKernighanAlgo {
    public int countOneBit(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}