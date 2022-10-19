import java.util.*;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Car> map = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i], " ");
            String time = st.nextToken();
            String carName = st.nextToken();
            String status = st.nextToken();

            if (map.containsKey(carName)) {
                Car car = map.get(carName);
                if (status.equals("IN")) {
                    car.enterTime = time;
                    car.isEntered = true;
                    car.leaveTime = "null";
                } else {
                    car.leaveTime = time;
                    car.isEntered = false;
                    car.cumulativeTime += cal_time(car.enterTime, car.leaveTime);
                }
                map.put(carName, car);
            } else {
                map.put(carName, new Car(time, "null", true, 0));
            }
        }

        int[] answer = new int[map.size()];
        int index = 0;

        for (String key : map.keySet()) {
            Car car = map.get(key);
            if (car.leaveTime.equals("null")) {
                car.leaveTime = "23:59";
                car.cumulativeTime += cal_time(car.enterTime, car.leaveTime);
            }

            if (car.cumulativeTime < fees[0]) {
                answer[index++] = fees[1];
            } else {
                answer[index++] = fees[1]
                        + ((int) Math.ceil((car.cumulativeTime - (double) fees[0]) / fees[2]) * fees[3]);
            }
        }

        return answer;
    }

    static int cal_time(String enterTime, String leaveTime) {
        StringTokenizer st = new StringTokenizer(enterTime, ":");
        StringTokenizer st2 = new StringTokenizer(leaveTime, ":");

        return (Integer.parseInt(st2.nextToken()) - Integer.parseInt(st.nextToken())) * 60 +
                (Integer.parseInt(st2.nextToken()) - Integer.parseInt(st.nextToken()));
    }

    static class Car {
        public String enterTime;
        public String leaveTime;
        public boolean isEntered;
        public int cumulativeTime;

        public Car(String enterTime, String leaveTime, boolean isEntered, int cumulativeTime) {
            this.enterTime = enterTime;
            this.leaveTime = leaveTime;
            this.isEntered = isEntered;
            this.cumulativeTime = cumulativeTime;
        }
    }
}
