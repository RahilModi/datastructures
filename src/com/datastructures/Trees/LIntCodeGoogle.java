package com.datastructures.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LIntCodeGoogle {

    public int LongestPathWithSameValue(int[] A, int[] E) {
        // write your code here
        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0 ; i <= A.length;i++)
            temp.add(new ArrayList<>());
        for(int i = 0 ; i< A.length - 1 ; i++){
            temp.get(E[i*2]).add(E[(i*2)+1]);
            temp.get(E[(i*2)+1]).add(E[i*2]);
        }
        int[] ans = new int[1];
        int tmp = dfs(1,0,A,temp, ans);
        ans[0] = Math.max(ans[0],tmp);
        return ans[0] - 1;
    }

    public int dfs(int index,int father,int[] A,List<List<Integer>> ch, int[] ans){
        PriorityQueue<Integer> q = new PriorityQueue<>( (a, b) -> {return b-a;} );
        for (int son: ch.get(index)){
            if (son != father){
                if (A[son - 1] == A[index - 1]){
                    q.offer(dfs(son,index,A,ch, ans));
                }
                else{
                    dfs(son,index,A,ch, ans);
                }
            }
        }
        q.offer(0);
        q.offer(0);
        int n1 = q.poll();
        ans[0] = Math.max(ans[0],n1+q.peek()+1);
        return n1+1;
    }

    public static void main(String[] args) {
        new LIntCodeGoogle().LongestPathWithSameValue(new int[]{1,1,1,2,2},new int[]{1,2,1,3,2,4,2,5});
    }
}
