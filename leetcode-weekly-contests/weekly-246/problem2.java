class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = convertToMinutes(startTime);
        int end = convertToMinutes(finishTime);

        int ceilStart = nextQuarter(start);
        int floorFinish = prevQuarter(end);

        if (start > end)
            return (24 * 60 - ceilStart + floorFinish) / 15;

        return Math.max(0, (floorFinish - ceilStart) / 15);
    }

    private int nextQuarter(int start) {
        return ((start + 14) / 15) * 15;
    }

    private int prevQuarter(int end) {
        return (end / 15) * 15;
    }

    private int convertToMinutes(String s) {
        return Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
    }
}