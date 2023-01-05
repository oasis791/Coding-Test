import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static String solution(String m, String[] musicinfos) {
        String answer = "";
        String[][] musicInfo = getMusicInfo(musicinfos);

        for (int i = 0; i < musicInfo.length; i++ ) {
            int streamingTime = getStreamingTime(musicInfo[i][0], musicInfo[i][1]);
            Queue<String> streamingMelody = makeMelody(musicInfo[i][3]);

            if (chkMusic(streamingMelody, m, streamingTime)) {
                System.out.println(musicInfo[i][2]);
                return musicInfo[i][2];
            }
        }
        System.out.println("(None)");
        return "(None)";
    }

    public static String[][] getMusicInfo(String[] musicinfos) {
        String[][] musicInfo = new String[musicinfos.length][4];

        for (int i = 0; i < musicinfos.length; i++) {
            musicInfo[i] = musicinfos[i].split(",");
        }

        return musicInfo;
    }

    public static int getStreamingTime(String start, String end) {
        String[] startTime = start.split(":");
        String[] endTime = end.split(":");
        int startHour = Integer.parseInt(startTime[0]);
        int startMin =Integer.parseInt(startTime[1]);
        int endHour =Integer.parseInt(endTime[0]);
        int endMin =  Integer.parseInt(endTime[1]);

        if (endHour == 0) {
            endHour = 24;
        }

        return ((endMin - startMin) + (endHour - startHour) * 60);
    }

    public static Queue<String> makeMelody(String melody) {
        Queue<String> streamingMelody = new LinkedList<>();

        for (int i = 0; i < melody.length(); i++) {
            if (i < melody.length() - 1 && melody.charAt(i + 1) == '#') {
                streamingMelody.add(melody.substring(i, i + 2));
                i++;
            } else{
                streamingMelody.add(melody.substring(i, i + 1));
            }
        }

        return streamingMelody;
    }

    public static boolean chkMusic(Queue<String> streamingMelody, String m, int streamingTime) {
        int index = 0;

        for (int i = 0; i < streamingTime; i++) {
            String target = streamingMelody.peek();
            if (index < m.length() - 1 && m.charAt(index + 1) == '#') {
                if (m.substring(index, index + 2).equals(target)) {
                    index += 2;
                    streamingMelody.add(streamingMelody.poll());
                } else{
                    if (index == 0) {
                        streamingMelody.add(streamingMelody.poll());
                    } else{
                        index = 0;
                        i--;
                    }
                }
            } else{
                if (m.substring(index, index + 1).equals(target)) {
                    index++;
                    streamingMelody.add(streamingMelody.poll());
                } else{
                    if (index == 0) {
                        streamingMelody.add(streamingMelody.poll());
                    } else{
                        index = 0;
                        i--;
                    }
                }
            }
            if (index == m.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String m = "DF";
        String[] musicinfos = {"03:00,03:00,FOO,DDF"};

        solution(m, musicinfos);
    }

}