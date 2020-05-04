public class Stairs {
    /**
     * Given n which is the number of steps a stair has what are the possible
     * combinations in which that stair can be "" either going 1 stair up at a time
     * or 2 e.g. A stair with 3 steps can be done {[0,1,2,3], [0,1,3], [0,2,3]} A
     * stair with 2 steps can be done {[0,1,2], [0,2]}
     **/

    public static void main(String[] args) {
        // System.out.println(num_ways_recursive(50));
        System.out.println(num_ways_bottom_up(88));
    }

    private static int num_ways_recursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return num_ways_recursive(n - 1) + num_ways_recursive(n - 2);
    }

    private static long num_ways_bottom_up(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long[] steps = new long[2];
        steps[0] = 1;
        steps[1] = 1;

        int times = (n-1)/2;
        for (int i = 0; i < times; i++) {
            steps[0] = steps[0] +  steps[1];
            steps[1] = steps[0] +  steps[1];
        }
        return steps[(n-1)%2];
    }

}