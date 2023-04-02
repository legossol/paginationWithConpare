package kr.legossol.pagination.controller;

import kr.legossol.pagination.dto.PaginationRequestDto;
import kr.legossol.pagination.dto.PagincationDto;
import kr.legossol.pagination.entity.DepartmentInfo;
import kr.legossol.pagination.service.DepartmentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaginationCoontroller {
    private final DepartmentService departmentService;
    @GetMapping
    public PagincationDto<DepartmentInfo> getDepartmentWithPagination(
            @RequestParam(value = "size",defaultValue = "10")Integer size,
            @RequestParam(value = "page",defaultValue = "1")Integer page
    ) {
        return departmentService.findDepartmentWithPagination(PaginationRequestDto.builder()
                .page(page)
                .size(size)
                .build());
    }
}
