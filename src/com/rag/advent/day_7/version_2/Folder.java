package com.rag.advent.day_7.version_2;

import java.util.List;
import java.util.Set;

public record Folder(Set<Folder> folders, List<Integer> list) {

}
