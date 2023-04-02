package kr.legossol.pagination.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagincationDto<T> {
    private int total;
    private int page;
    private int size;
    private List<T> content;
}
