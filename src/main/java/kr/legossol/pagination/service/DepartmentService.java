package kr.legossol.pagination.service;

import kr.legossol.pagination.conpare.DepartmentInfoComparator;
import kr.legossol.pagination.dto.PaginationRequestDto;
import kr.legossol.pagination.dto.PagincationDto;
import kr.legossol.pagination.entity.DepartmentInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class DepartmentService {
    public static void main(String[] args) {
        List<DepartmentInfo> sampleDepartments = DepartmentInfo.getSampleDepartment();
        log.info("================ Before sorted ==================");
        for (DepartmentInfo departmentInfo : sampleDepartments) {
            log.info("department :: {}", departmentInfo.getStep());
        }
        log.info("================ After sorted ==================");
        Collections.sort(sampleDepartments, new DepartmentInfoComparator());

        for (DepartmentInfo departmentInfo : sampleDepartments) {
            log.info("department :: {}", departmentInfo.getStep());
            log.info("mydepartment-name :: {}", departmentInfo.getDepartmentName());
            log.info("parent-department-name :: {}", departmentInfo.getParentDepartmentName());
        }
    }

    public PagincationDto<DepartmentInfo> findDepartmentWithPagination(PaginationRequestDto paginationRequestDto) {
        int startIndex = (paginationRequestDto.getPage() - 1) * paginationRequestDto.getSize();
        int endIndex = startIndex + paginationRequestDto.getSize() -1;

        List<DepartmentInfo> sampleDepartment = DepartmentInfo.getSampleDepartment();
        List<DepartmentInfo> collectInfo = sampleDepartment.stream().sorted(Comparator.comparing(DepartmentInfo::getDepartmentName)).collect(Collectors.toList());

        List<DepartmentInfo> result = new ArrayList<>();
        for (int i = startIndex; i <= endIndex && i < collectInfo.size(); i++) {
            result.add(collectInfo.get(i));
        }
        PagincationDto<DepartmentInfo> resultDto = new PagincationDto<>();
        resultDto.setPage(paginationRequestDto.getPage());
        resultDto.setSize(paginationRequestDto.getSize());
        resultDto.setContent(result);
        return resultDto;

    }
}
