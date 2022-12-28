package com.rag.advent.day_7_2;

import java.util.List;
import java.util.Set;

record Folder(String dirName, Folder parentDirectory, Set<Folder> folders, List<Integer> files ){

}
