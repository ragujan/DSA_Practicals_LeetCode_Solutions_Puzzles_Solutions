package com.rag.advent.day_7_2;

import java.util.List;
import java.util.Map;

public class Dir {
    public Dir(String dirName, Dir parent, List<File> files, Map<String, Dir> children) {
        this.dirName = dirName;
        this.parent = parent;
        this.files = files;
        this.children = children;
    }

    public String getDirName() {
        return dirName;
    }

    public Dir getParent() {
        return parent;
    }

    public List<File> getFiles() {
        return files;
    }

    public Map<String, Dir> getChildren() {
        return children;
    }

    String dirName;
    Dir parent;
    List<File> files;
    Map<String,Dir> children;
}

