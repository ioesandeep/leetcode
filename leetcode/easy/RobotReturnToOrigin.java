package leetcode.easy;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int leftMoves = 0;
        int upMoves = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'U') {
                upMoves++;
            }
            if (ch == 'D') {
                upMoves--;
            }
            if (ch == 'R') {
                leftMoves--;
            }
            if (ch == 'L') {
                leftMoves++;
            }
        }
        return leftMoves == 0 && upMoves == 0;
    }
}
