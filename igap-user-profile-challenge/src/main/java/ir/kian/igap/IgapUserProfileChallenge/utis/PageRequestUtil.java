package ir.kian.igap.IgapUserProfileChallenge.utis;


import ir.kian.igap.common.domain.dto.request.BasePaginationRequestDto;
import ir.kian.igap.common.domain.dto.restapi.result.Pagination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class PageRequestUtil {
    public static <TINPUT extends BasePaginationRequestDto> PageRequest toPageRequest(TINPUT tInput) {
        return PageRequest.of(tInput.getPageNumber(), tInput.getPageSize(),
                Sort.by(tInput.getIsASC() ? Sort.Direction.ASC : Sort.Direction.DESC, tInput.getSortBy().toArray(new String[0])));
    }

    public static <TData> Pagination<TData> toPaginationWithAddOneToPageNoDto(TData dataList, Page page) {
        return Pagination.<TData>builder()
                .data(dataList)
                .totalElement(page.getTotalElements())
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .totalPages(page.getTotalPages())
                .build();
    }
}
