package ir.kian.igap.common.transformer;

import ir.kian.igap.common.domain.dto.restapi.result.APIResultDto;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.domain.dto.restapi.result.Context;
import ir.kian.igap.common.domain.dto.restapi.result.Pagination;
import ir.kian.igap.common.domain.dto.restapi.result.enumstatus.BaseStatusEnum;
import org.springframework.http.ResponseEntity;

public class ResponseHandlerTransformer {
    public static <TData> ResponseEntity<APIResultDtoWithData<TData>> handleResponseWithBody(APIResultDtoWithData<TData> apiResultDtoWithData) {
        return ResponseEntity
                .status(apiResultDtoWithData.getContext().getStatusEnum().getCode())
                .body(apiResultDtoWithData);
    }

    public static ResponseEntity<APIResultDto> handleResponse(APIResultDto apiResultDto) {
        return ResponseEntity
                .status(apiResultDto.getContext().getStatusEnum().getCode())
                .body(apiResultDto);
    }

    public static <TData> APIResultDtoWithData<TData> getSuccessResult(TData data) {
        APIResultDtoWithData<TData> resultDto = new APIResultDtoWithData<>();
        resultDto.setData(data);
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.DONE)
                .detailMessage("successful done")
                .build());
        return resultDto;
    }

    //    @Override
    public static <TData> APIResultDtoWithData<TData> getSuccessResultWithPagination(Pagination<TData> pagination) {
        APIResultDtoWithData<TData> resultDto = new APIResultDtoWithData<>();
        resultDto.setData(pagination.getData());
        resultDto.setContext(Context.builder()
                .statusEnum(BaseStatusEnum.DONE)
                .pagination(Pagination.builder()
                        .pageNo(pagination.getPageNo())
                        .pageSize(pagination.getPageSize())
                        .totalElement(pagination.getTotalElement())
                        .totalPages(pagination.getTotalPages())
                        .build())
                .detailMessage("successful done")
                .build());
        return resultDto;
    }
    public static ResponseEntity<APIResultDto> getSuccessResult(){
        APIResultDto resultDto = APIResultDto.builder().context(
                Context.builder()
                        .detailMessage("success")
                        .statusEnum(BaseStatusEnum.DONE)
                        .build()
        ).build();
        return ResponseHandlerTransformer.handleResponse(resultDto);
    }
}
