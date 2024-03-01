package pro;

class ProBackToSchool {
    static int num = 1_000_000_007;
    static int[][] map;

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n+1][m+1];
        map[1][1] = 1;

        if(puddles != null){
            for(int[] p : puddles){
                map[p[1]][p[0]] = -1;
            }
        }

        for(int i=2;i<=m;i++){
            if(map[1][i-1] == -1 || map[1][i] == -1){
                continue;
            }
            map[1][i] = map[1][i-1];
        }

        for(int i=2;i<=n;i++){
            if(map[i-1][1] == -1 || map[i][1] == -1){
                continue;
            }
            map[i][1] = map[i-1][1];
        }

        for(int i=2;i<=n;i++){
            for(int j=2;j<=m;j++){
                int sum = 0;

                if(map[i][j] == -1){
                    continue;
                }

                if(map[i-1][j] != -1){
                    sum += map[i-1][j] % num;
                }

                if(map[i][j-1] != -1){
                    sum += map[i][j-1] % num;
                }
                map[i][j] = sum % num;
            }
        }

        return map[n][m];
    }
}
