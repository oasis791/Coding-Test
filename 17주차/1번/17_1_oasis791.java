import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

class Solution {
    public String solution(String m, String[] musicinfos) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String answer = "(None)";
        long answerTime = 0;

        m = sharpToOther(m);
        for (int i = 0; i < musicinfos.length; i++) {
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            LocalTime start = LocalTime.parse(st.nextToken(), formatter);
            LocalTime end = LocalTime.parse(st.nextToken(), formatter);
            String songName = st.nextToken();
            String sheet = sharpToOther(st.nextToken());

            StringBuilder sb = new StringBuilder();
            int index = 0;
            long playTime = ChronoUnit.MINUTES.between(start, end);
            for (int j = 0; j < playTime; j++) {
                if (index == sheet.length())
                    index = 0;
                sb.append(sheet.charAt(index++));
            }
            sheet = sb.toString();

            if (sheet.contains(m) && playTime > answerTime) {
                answerTime = playTime;
                answer = songName;
            }
        }
        return answer;
    }

    static String sharpToOther(String m) {
        while (m.contains("#")) {
            int i = m.indexOf("#");
            m = m.substring(0, i - 1) +
                    String.valueOf(m.charAt(i - 1)).toLowerCase() +
                    m.substring(i + 1);
        }
        return m;
    }
}