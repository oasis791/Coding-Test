import java.util.*;

class Solution {
    static class Coordinate {
        long x;
        long y;

        public Coordinate(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String[] solution(int[][] line) {
        String[] answer;
        List<Coordinate> meet = new ArrayList<>();
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;


        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long numerator = (long) line[i][0] * line[j][1] - (long) line[i][1] * line[j][0];

                if (numerator != 0) {
                    long denominatorX = (long) line[i][1] * line[j][2] - (long) line[i][2] * line[j][1];
                    long denominatorY = (long) line[i][2] * line[j][0] - (long) line[i][0] * line[j][2];
                    if (denominatorX % numerator == 0 && denominatorY % numerator == 0) {
                        long x = denominatorX / numerator;
                        long y = denominatorY / numerator;

                        meet.add(new Coordinate(x, y));

                        maxX = Math.max(maxX, x);
                        minX = Math.min(minX, x);
                        maxY = Math.max(maxY, y);
                        minY = Math.min(minY, y);
                    }

                }
            }
        }

        answer = new String[(int) Math.abs(maxY - minY) + 1];
        int index = 0;

        for (long i = minY; i <= maxY; i++) {
            StringBuilder newLine = new StringBuilder();
            for (long j = minX; j <= maxX; j++) {
                newLine.append(".");
            }
            answer[index] = newLine.toString();
            index++;
        }


        for (Coordinate coordinate : meet) {
            String target = answer[(int) (maxY - coordinate.y)];
            int y = (int) (maxY - coordinate.y);
            int x = (int) (coordinate.x - minX);
            answer[y] = target.substring(0, x) + "*"
                    + target.substring((int) (coordinate.x - minX) + 1);
        }
        return answer;
    }
}