package ir.kian.igap.common.domain.dto.request;

import io.swagger.annotations.ApiParam;
import ir.kian.igap.common.config.properties.PaginationProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@ToString
public class BasePaginationRequestDto extends RequestDto {
    @ApiParam(value = "min and default 1", example = "1")
    private Integer pageNumber = PaginationProperties.START_PAGE_NUMBER;
    @ApiParam(value = "default 50 , max 100", example = "50")
    private Integer pageSize = PaginationProperties.MAX_PAGE_SIZE;
    private List<String> sortBy = Collections.singletonList("id");
    private Boolean isASC = false;

    public BasePaginationRequestDto(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        if (Objects.isNull(this.pageSize))
            this.pageSize = PaginationProperties.MAX_PAGE_SIZE;
        return this.pageSize;
    }

    public Integer getPageNumber() {
        if (Objects.isNull(this.pageNumber))
            this.pageNumber = PaginationProperties.START_PAGE_NUMBER;
        return pageNumber;
    }


}
