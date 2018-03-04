import java.util.Deque;
import java.util.LinkedList;

public class slidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0 ) return new int[0];

        if( k == 1) return nums;

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int index = 0;

        deque.offer(index);
        for(int i = 1; i < nums.length; i++){

            while(!deque.isEmpty() && deque.peek() < i-k+1){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }

            deque.offer(i);

            if(i >= k - 1){
                result[index++] = nums[deque.peekFirst()];
            }

        }
        return  result;
    }

    public static void main(String[] args){
        slidingWindowMax t = new slidingWindowMax();

        int[] temp = t.maxSlidingWindow(new int[]{19,8,3,6,7},3);

        for(int i: temp){
            System.out.println(i);
        }

    }
}
