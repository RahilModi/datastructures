package com.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] result = new int[A.length];
        for(int i = 0;i<B.length;i++){
            m.put(B[i],i);
        }

        for(int i = 0; i<A.length;i++){
            result[i] = m.get(A[i]);
        }
        return result;
    }
}
