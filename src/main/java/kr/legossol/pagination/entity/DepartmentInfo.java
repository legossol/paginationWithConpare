package kr.legossol.pagination.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentInfo {
    //부서가 위치한 정보
    private String step;
    //해당 부서 이름
    private String departmentName;
    //부모 부서 이름

    private String parentDepartmentName;
    //샘플이 되는 부서들의 정보
    public static List<DepartmentInfo> getSampleDepartment() {
        List<DepartmentInfo> infos = new ArrayList<>();
        infos.add(new DepartmentInfo("나의회사",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|전라지사|전라1팀",null,null));
        infos.add(new DepartmentInfo("나의회사|정산부|정산2팀",null,null));
        infos.add(new DepartmentInfo("나의회사|개발부",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|경남지사2팀",null,null));
        infos.add(new DepartmentInfo("나의회사|정산부",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|경남지사1팀",null,null));
        infos.add(new DepartmentInfo("나의회사|개발부|백엔드팀",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부",null,null));
        infos.add(new DepartmentInfo("나의회사|개발부|프론트팀",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|전라지사",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|영업1팀",null,null));
        infos.add(new DepartmentInfo("나의회사|정산부|정산1팀",null,null));
        infos.add(new DepartmentInfo("나의회사|개발부|인프라팀",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|영업2팀",null,null));
        infos.add(new DepartmentInfo("나의회사|영업부|전라지사|전라2팀",null,null));
        return infos;
    }
}
