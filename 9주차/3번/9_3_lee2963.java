import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, String> in = new HashMap<>();
        TreeMap<String, Integer> fee = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] info = records[i].split(" ");

            if (info[2].equals( "IN")) {
                in.put(info[1], info[0]);
            } else{
                String[] inTime = in.get(info[1]).split(":");
                String[] outTime = info[0].split(":");
                in.remove(info[1]);

                int hour = (Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0])) * 60;
                int minute = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);

                if (fee.containsKey(info[1])) {
                    int curFee = fee.get(info[1]);
                    fee.put(info[1], curFee + hour + minute);
                } else{
                    fee.put(info[1], hour + minute);
                }
            }
        }

        for (Map.Entry<String, String> entry : in.entrySet()) {

            String[] inTime = in.get(entry.getKey()).split(":");

            int hour = (23 - Integer.parseInt(inTime[0])) * 60;
            int minute = 59 -Integer.parseInt(inTime[1]);

            if (fee.containsKey(entry.getKey())) {
                int curFee = fee.get(entry.getKey());
                fee.put(entry.getKey(), curFee + hour + minute);
            } else{
                fee.put(entry.getKey(), hour + minute);
            }
        }

        for (Integer value : fee.values()) {

            if (value > fees[0]) {
                int num = 0;
                if((value - fees[0]) %  fees[2] !=0){
                    num = 1;
                }
                answer.add(fees[1] + (((value - fees[0]) / fees[2]) + num) * fees[3]);
            } else{
                answer.add(fees[1]);
            }
        }

        return  answer;
    }
}