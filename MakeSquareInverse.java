import java.util.ArrayList;
import java.util.Arrays;

public class MakeSquareInverse {
    
    public static void main(String[] args) {
        System.out.println(makesquare(new int[]{5,5,5,5,2,2,2,2}));
    }

    static int count;
	static boolean[] used;
    public static boolean makesquare(int[] nums) {
    	
    	int sum=0;
    	for(int i:nums) {
    		sum+=i;
    	}
    	if(sum%4!=0) return false;
    	
    	int side=sum/4;
    	int end=nums.length;
    	Arrays.sort(nums);//sort
    	count=0;used=new boolean[end];
    	
    	backtrack(new ArrayList<>(),nums,end-1,0,side);
    	
    	return count==4;
    }

	private static void backtrack(ArrayList<Integer> list,int[] nums, int start, int end, int target) {
		if(target==0) {
			count++;
			for(int index:list) {
				used[index]=true;
			}
		}else {
			for(int i=start;i>=end;i--) {
				for(int index:list) {
					if(used[index])
						return;
				}
				if(!used[i] && nums[i]<=target) {
					list.add(i);
					backtrack(new ArrayList<>(list),nums,i-1,end,target-nums[i]);
					list.remove(list.size()-1);
				}
			}
		}
	}
}