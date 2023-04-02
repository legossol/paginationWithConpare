package kr.legossol.pagination.conpare;


import kr.legossol.pagination.entity.DepartmentInfo;
import org.springframework.util.ObjectUtils;

import java.util.Comparator;
public class DepartmentInfoComparator implements Comparator<DepartmentInfo> {

    @Override
    public int compare(DepartmentInfo info1, DepartmentInfo info2) {
        String[] steps1 = info1.getStep().split("\\|");
        String[] steps2 = info2.getStep().split("\\|");
        if (ObjectUtils.isEmpty(info1.getDepartmentName())) {
            if (steps1.length == 1) {
                info1.setDepartmentName(steps1[0]);
                info1.setParentDepartmentName("");
            } else if (steps1.length > 1) {
                info1.setDepartmentName(steps1[steps1.length-1]);
                info1.setParentDepartmentName(steps1[steps1.length-2]);
            }
        }
        if (ObjectUtils.isEmpty(info2.getDepartmentName())) {
            if (steps2.length == 1) {
                info2.setDepartmentName(steps2[0]);
                info2.setParentDepartmentName("");
            } else if (steps1.length > 1) {
                info2.setDepartmentName(steps2[steps2.length-1]);
                info2.setParentDepartmentName(steps2[steps2.length-2]);
            }
        }
        int minLength = Math.min(steps1.length, steps2.length);
        for (int i = 0; i < minLength; i++) {
            int cmp = steps1[i].compareTo(steps2[i]);
            if (cmp != 0) {
                return cmp;
            }
        }
        return Integer.compare(steps1.length, steps2.length);
    }
}
