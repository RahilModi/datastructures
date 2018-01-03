package com.datastructures.arrays;

import java.util.*;

public class EmployeeImportance {

    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    private Map<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {

        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        Set<Integer> set = new HashSet<>();
        return getImportance(id);

    }

    public int getImportance(int id){
        List<Integer> subordinates = map.get(id).subordinates;
        int imp = map.get(id).importance;
        if(subordinates == null || subordinates.size() == 0) return imp;
        else{
            for(int emp : subordinates){
                imp += getImportance(emp);
            }
            return imp;
        }
    }
}
