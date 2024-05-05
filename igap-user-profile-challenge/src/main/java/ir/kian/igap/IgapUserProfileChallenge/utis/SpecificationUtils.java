package ir.kian.igap.IgapUserProfileChallenge.utis;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.PersonPageRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.entity.Person;
import ir.kian.igap.common.filters.BaseFilterImpl;
import ir.kian.igap.common.filters.Filter;
import ir.kian.igap.common.filters.joins.StringEqualJoinsFilter;
import ir.kian.igap.common.filters.stringfilters.StringLikeFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class SpecificationUtils {
    public static Specification<Person> vehicleTypeSpecification(PersonPageRequestDto requestDto) {
        return (root, query, criteriaBuilder) -> {
            Filter filter = new BaseFilterImpl();
            StringEqualJoinsFilter cityFilter = new StringEqualJoinsFilter(List.of("address", "city", "title"), requestDto.getCity(), filter);
            StringEqualJoinsFilter provinceFilter=new StringEqualJoinsFilter(List.of("address", "province", "title"),requestDto.getProvince(),cityFilter);
            StringEqualJoinsFilter mobileFilter=new StringEqualJoinsFilter(List.of("mobile","mobileNo"), requestDto.getMobile(), provinceFilter);
            StringLikeFilter usernameFilter=new StringLikeFilter("username", requestDto.getUsername(), mobileFilter);
            StringLikeFilter emailFilter=new StringLikeFilter("email", requestDto.getEmail(), usernameFilter);
            StringLikeFilter nameFilter=new StringLikeFilter("name", requestDto.getName(), emailFilter);
            StringLikeFilter surnameFilter=new StringLikeFilter("surname", requestDto.getSurname(), nameFilter);
            return criteriaBuilder.and(surnameFilter.filters(criteriaBuilder, root).toArray(new Predicate[0]));
        };
    }
}
