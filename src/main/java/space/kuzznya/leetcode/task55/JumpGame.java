package space.kuzznya.leetcode.task55;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int budget = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            budget = Math.max(budget - 1, nums[i]);
            if (budget == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));
    }
}
