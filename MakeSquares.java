import java.util.Arrays;

public class MakeSquares {
    public static void main(String[] args) {
        System.out.println(makeSquare(new int[] { 5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4 }));
    }

    // DFS backtracking approach
    public static boolean makeSquare(int nums[]) {
        if (nums.length == 0)
            return false;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 4 != 0)
            return false;

        // [10,6,5,5,5,3,3,3,2,2,2,2]
        Arrays.sort(nums);
        int targetSideSize = sum / 4;

        boolean[] visited = new boolean[nums.length];
        int numberOfSides = 4;

        return dfs(numberOfSides, nums, visited, 0, targetSideSize);
    }

    // This method will use Deep First Search approach which basically tries all
    // possible combinations using prunning
    // which allows this method that once a path is marked as the correct answer do
    // not try the same path
    private static boolean dfs(int numberOfSides, int[] nums, boolean[] visited, int sum, int targetSideSize) {
        if (sum == targetSideSize) {
            numberOfSides--;
            if (numberOfSides == 0) {
                return true;
            }
            return dfs(numberOfSides, nums, visited, 0, targetSideSize);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (sum + nums[i] > targetSideSize) {
                    return false;
                }

                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }

                visited[i] = true;
                if (dfs(numberOfSides, nums, visited, sum + nums[i], targetSideSize)) {
                    return true;
                }
                visited[i] = false;
            }
        }

        return false;
    }

}