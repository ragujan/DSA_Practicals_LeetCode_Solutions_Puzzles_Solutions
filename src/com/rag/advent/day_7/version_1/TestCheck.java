package com.rag.advent.day_7.version_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TestCheck {
    //directories and their file sizes without sub directory sizes is not added
    Map<String, Integer> dirFileSizes = new HashMap<>();
    List<List<String>> list = new LinkedList<>();

    public void insertToMap() {

        dirFileSizes.put("e", 584);
        dirFileSizes.put("d", 24933642);
        dirFileSizes.put("a", 94629);
        dirFileSizes.put("/", 23352670);

    }

    public void insertList() {
        List<String> dirE = new LinkedList<>();
        dirE.add("e");
        List<String> dirD = new LinkedList<>();
        dirD.add("d");
        List<String> dirA = new LinkedList<>();
        dirA.add("e");
        dirA.add("a");
        List<String> dirSlash = new LinkedList<>();
        dirSlash.add("d");
        dirSlash.add("a");
        dirSlash.add("/");
        list.add(dirE);
        list.add(dirD);
        list.add(dirA);
        list.add(dirSlash);

    }

    public TestCheck() {
        insertToMap();
        insertList();
    }

    public static void main(String[] args) {
        TestCheck tc = new TestCheck();

        tc.list.forEach(strings -> System.out.println(strings));
    }
}
