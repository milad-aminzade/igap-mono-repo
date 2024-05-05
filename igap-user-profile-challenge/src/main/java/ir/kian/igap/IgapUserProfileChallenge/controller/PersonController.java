package ir.kian.igap.IgapUserProfileChallenge.controller;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.CreatePersonRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.PersonPageRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.CreatePersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.PersonService;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.domain.dto.restapi.result.Pagination;
import ir.kian.igap.common.transformer.ResponseHandlerTransformer;
import ir.kian.igap.common.transformer.impl.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
@Slf4j
public class PersonController {
    private final PersonService service;

    @PostMapping
    public ResponseEntity<APIResultDtoWithData<CreatePersonResponseDto>> createPerson(@RequestHeader("username") String username,
                                                                                      @RequestBody CreatePersonRequestDto requestDto) {
        CreatePersonResponseDto person = service.createPerson(requestDto);
        APIResultDtoWithData<CreatePersonResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(person);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResultDtoWithData<PersonResponseDto>> getById(@RequestHeader("username") String username,
                                                                           @PathVariable("id") UUID id) {
        PersonResponseDto personResponseDto = service.getById(id);
        APIResultDtoWithData<PersonResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(personResponseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @GetMapping
    public ResponseEntity<APIResultDtoWithData<List<PersonResponseDto>>> getPersons(@RequestHeader("username") String username,
                                                                                    PersonPageRequestDto requestDto){
        Pagination<List<PersonResponseDto>> vehicleTypeResponseDTOs = service.getPersons(username,requestDto);
        APIResultDtoWithData<List<PersonResponseDto>> successResult = ResponseHandler.getSuccessResultWithPagination(vehicleTypeResponseDTOs);
        return ResponseHandler.handleResponseWithBody(successResult);
    }
}
