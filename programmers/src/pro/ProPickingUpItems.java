package pro;

class ProPickingUpItems {
    static int[][] map = new int[110][110];
    static int[] y = new int[]{0, 1, 0, -1};
    static int[] x = new int[]{1, 0, -1, 0};
    static int answer = Integer.MAX_VALUE;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        for(int[] i: rectangle){
            int x1 = i[0]*2;
            int y1 = i[1]*2;
            int x2 = i[2]*2;
            int y2 = i[3]*2;

            for(int j=x1;j<=x2;j++){
                map[y1][j] = 1;
                map[y2][j] = 1;
            }

            for(int j=y1; j<=y2;j++){
                map[j][x1] = 1;
                map[j][x2] = 1;
            }
        }

        for(int[] i: rectangle){
            int x1 = i[0]*2;
            int y1 = i[1]*2;
            int x2 = i[2]*2;
            int y2 = i[3]*2;

            for(int j = y1+1;j<y2;j++){
                for(int k=x1+1;k<x2;k++){
                    map[j][k] = 0;
                }
            }
        }

        map[characterY*2][characterX*2] = 0;
        dfs(characterY*2, characterX*2, itemY*2, itemX*2, 0);


        return answer/2;
    }

    static void dfs(int cY, int cX, int iY, int iX, int n){
        if(cY == iY && cX == iX){
            answer = Math.min(answer, n);
            map[iY][iX] = 1;
            return;
        }

        for(int i=0;i<4;i++){
            int nextY = cY + y[i];
            int nextX = cX + x[i];

            if(nextY < 0 || nextX < 0){
                continue;
            }

            if(map[nextY][nextX] == 1){
                map[nextY][nextX] = 0;
                dfs(nextY, nextX, iY, iX, n+1);
            }
        }

    }
}
