package w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로 탐색_s1_2178 {

    static Queue<int[]> q;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[]{0,0,1,-1};
    static int[] dy = new int[]{1,-1,0,0};
    static int n,m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i = 1; i <= n; i++){
            String k = br.readLine();
            for(int j = 1; j <=m; j++){
                arr[i][j] = k.charAt(j-1) - '0';
            }
        }

        // bfs
        bfs(1,1);

        System.out.println(arr[n][m]);
    }

    private static void bfs(int x, int y) {

        q = new LinkedList<>();

        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] poll = q.poll();

            int nowX = poll[0];
            int nowY = poll[1];

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;

                if(nx > 0 && nx <= n && ny > 0 && ny <= m){
                    if(!visited[nx][ny] && arr[nx][ny] != 0){
                        arr[nx][ny] = arr[nowX][nowY]+1;
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
