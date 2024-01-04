package ai.bak.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12100 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int mapSize;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        int[][] map = init();

        start(0, map);

        System.out.println(max);

    }

    public static void start(int n, int[][] map) {
        if (n == 5) {
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    max = Math.max(max, map[i][j]);
                }
            }
            return;
        }

        down(n, map);
        right(n, map);
        up(n, map);
        left(n, map);
    }


    public static void down(int n, int[][] originMap) {
        int[][] map = copyMap(originMap);
        for (int j = 0; j < mapSize; j++) {
            int zero = 0;
            for (int i = mapSize - 1; i >= 0; i--) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i + zero][j] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < mapSize; j++) {
            for (int i = mapSize - 1; i > 0; i--) {
                merge(new int[]{i, j}, new int[]{i - 1, j}, map);
            }
        }

        for (int j = 0; j < mapSize; j++) {
            int zero = 0;
            for (int i = mapSize - 1; i >= 0; i--) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i + zero][j] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }
        start(n + 1, map);
    }

    public static void right(int n, int[][] originMap) {
        int[][] map = copyMap(originMap);
        for (int i = 0; i < mapSize; i++) {
            int zero = 0;
            for (int j = mapSize - 1; j >= 0; j--) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i][j + zero] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = mapSize - 1; j > 0; j--) {
                merge(new int[]{i, j}, new int[]{i, j - 1}, map);
            }
        }

        for (int i = 0; i < mapSize; i++) {
            int zero = 0;
            for (int j = mapSize - 1; j >= 0; j--) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i][j + zero] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }
        start(n + 1, map);
    }

    public static void up(int n, int[][] originMap) {
        int[][] map = copyMap(originMap);
        for (int j = 0; j < mapSize; j++) {
            int zero = 0;
            for (int i = 0; i < mapSize; i++) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i - zero][j] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < mapSize; j++) {
            for (int i = 0; i < mapSize - 1; i++) {
                merge(new int[]{i, j}, new int[]{i + 1, j}, map);
            }
        }
        for (int j = 0; j < mapSize; j++) {
            int zero = 0;
            for (int i = 0; i < mapSize; i++) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i - zero][j] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }

        start(n + 1, map);
    }


    public static void left(int n, int[][] originMap) {
        int[][] map = copyMap(originMap);
        for (int i = 0; i < mapSize; i++) {
            int zero = 0;
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i][j - zero] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize - 1; j++) {
                merge(new int[]{i, j}, new int[]{i, j + 1}, map);
            }
        }

        for (int i = 0; i < mapSize; i++) {
            int zero = 0;
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j] == 0) {
                    zero++;
                } else if (map[i][j] != 0 && zero != 0) {
                    map[i][j - zero] = map[i][j];
                    map[i][j] = 0;
                }
            }
        }
        start(n + 1, map);
    }

    public static int[][] copyMap(int[][] originalMap) {
        int[][] newMap = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                newMap[i][j] = originalMap[i][j];
            }
        }
        return newMap;
    }

    public static void merge(int[] a, int[] b, int[][] map) {
        if (map[a[0]][a[1]] != 0 && map[a[0]][a[1]] == map[b[0]][b[1]]) {
            map[a[0]][a[1]] += map[b[0]][b[1]];
            map[b[0]][b[1]] = 0;
        }
    }



    public static int[][] init() throws IOException {
        mapSize = Integer.parseInt(br.readLine());
        int[][] map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return map;
    }
}
