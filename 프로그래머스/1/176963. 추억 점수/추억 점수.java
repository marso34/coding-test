import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String, Integer> d = new HashMap<String, Integer>();

        for (int i = 0; i < name.length; i++)
            d.put(name[i], yearning[i]);

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                String key = photo[i][j];

                if (d.containsKey(key)) {
                    answer[i] += d.get(key);
                }
            }
        }

        return answer;
    }
}