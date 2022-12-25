package com.rag.advent.day_7.tryperfect;

import java.util.List;
import java.util.Set;

public class Folder {
    public String getFolderName() {
        return dir;
    }

    public void setFolderName(String folderName) {
        this.dir = folderName;
    }

    public Set<Folder> getFolders() {
        return folders;
    }

    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }

    public List<Integer> getFiles() {
        return files;
    }

    public void setFiles(List<Integer> files) {
        this.files = files;
    }


    public Folder(String dir, String parentDir, Set<Folder> folders, List<Integer> files) {
        this.dir = dir;
        this.parentDir = parentDir;
        this.folders = folders;
        this.files = files;

    }


    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getParentDir() {
        return parentDir;
    }

    public void setParentDir(String parentDir) {
        this.parentDir = parentDir;
    }

    public int getDirSize() {
        return dirSize;
    }

    public void setDirSize(int dirSize) {
        this.dirSize = dirSize;
    }

    String dir;
    String parentDir;
    Set<Folder> folders;
    List<Integer> files;
    int dirSize;


}
