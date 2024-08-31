package com.transaction.Transaction.Demo.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.Objects;

@Getter
@Setter
public class PageRequestDto {
    private Integer pageNo = 0;
    private Integer pagesSize = 10;

    public Pageable getPagable(PageRequestDto pageRequestDto){
        Integer page = Objects.nonNull(pageRequestDto.getPageNo()) ? pageRequestDto.getPageNo() : this.pageNo;
        Integer size = Objects.nonNull(pageRequestDto.getPagesSize()) ? pageRequestDto.getPagesSize() : this.pagesSize;

        PageRequest request = PageRequest.of(page, size);
        return (Pageable) request;
    }

}
