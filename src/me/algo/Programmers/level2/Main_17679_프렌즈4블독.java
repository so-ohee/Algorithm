package me.algo.Programmers.level2;

/* 프렌즈4블록
 * 2021. 04. 03
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 * 참고: https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%94%84%EB%A0%8C%EC%A6%884%EB%B8%94%EB%A1%9D-Java
 */

public class Main_17679_프렌즈4블독 {
    static int M,N;
    static String[][] arr;

    private static void drop(){
        for(int i=0; i<N; i++){
            for(int j=M-1; j>=0; j--){
                if(arr[j][i].equals("-")){
                    for(int j2=j-1; j2>=0; j2--){
                        if(!arr[j2][i].equals("-")){
                            arr[j][i] = arr[j2][i];
                            arr[j2][i] = "-";
                            break;
                        }
                    }
                }
            }
        }
    }
    private static void checkFour(int x, int y, boolean[][] visit){
        for(int i=x; i<x+2; i++){
            for(int j=y; j<y+2; j++){
                if(!arr[x][y].equals(arr[i][j])) return;
            }
        }
        for(int i=x; i<x+2; i++){
            for(int j=y; j<y+2; j++){
                visit[i][j] = true;
            }
        }
    }
    private static int dfs(){
        boolean[][] visit = new boolean[M][N];
        for(int i=0; i<M-1; i++){
            for(int j=0; j<N-1; j++){
                if(arr[i][j].equals("-")) continue;
                checkFour(i,j,visit);
            }
        }

        int count = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(visit[i][j]){
                    count++;
                    arr[i][j] = "-";
                }
            }
        }
        return count;
    }
    public static int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        arr = new String[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = board[i].charAt(j)+"";
            }
        }

        int answer = 0;
        while(true) {
            int cnt = dfs();
            if(cnt == 0) break;
            answer += cnt;
            drop();
        }
        return answer;
    }
}
