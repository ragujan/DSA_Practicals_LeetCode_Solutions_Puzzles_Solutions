package com.rag.advent.day_7.tryperfect;

import java.util.List;
import java.util.Set;

record Folder2(String dirName, Folder parentDirectory, Set<Folder> folders, List<Integer> files ){

}
