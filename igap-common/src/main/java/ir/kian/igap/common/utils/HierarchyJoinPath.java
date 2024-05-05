package ir.kian.igap.common.utils;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class HierarchyJoinPath {
    public static Path getPathFromHierarchyJoin(List<String> attributes, Root root) {
        int i = 0;
        Path pth = null;
        for (String attribute : attributes) {
            if (i > 0) {
                pth = pth.get(attribute);
            } else {
                pth = root.get(attribute);
            }
            i++;
        }
        return pth;
    }
}
