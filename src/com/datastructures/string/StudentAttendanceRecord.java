package com.datastructures.string;

public class StudentAttendanceRecord {

    public boolean checkRecord(String s) {

        boolean isAcameBefore = false;
        int lastLPos = -1;
        int i = 0;
        for(; i < s.length(); i++){
            if(s.charAt(i) == 'A' && isAcameBefore) return false;
            else if(s.charAt(i)== 'A'){
                isAcameBefore = true;
                lastLPos = i;
            }
            if(s.charAt(i) == 'L' && (i - lastLPos) >= 3) return false;
            else if(s.charAt(i) != 'L') lastLPos = i;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new StudentAttendanceRecord().checkRecord("PPALLPP"));
    }


}
