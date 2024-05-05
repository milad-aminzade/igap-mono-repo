package ir.kian.igap.common.utils;

import ir.kian.igap.common.domain.dto.restapi.result.Pagination;

public class PaginationUtil extends BaseUtil {
    public static <TData> Pagination<TData> toPaginationWithAddOneToPageNoDto(TData dataList, Long totalElement, Integer pageNo, Integer pageSize, Integer totalPages) {
        return Pagination.<TData>builder()
                .data(dataList)
                .totalElement(totalElement)
                .pageNo(pageNo)
                .pageSize(pageSize)
                .totalPages(totalPages)
                .build();
    }
}
