package ir.kian.igap.IgapUserProfileChallenge.controller;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.otp.OTPAnswerRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.otp.OTPRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.CreatePersonRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.PersonPageRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.otp.OTPResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonIdResponseDto;
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
    public ResponseEntity<APIResultDtoWithData<PersonIdResponseDto>> createPerson(@RequestHeader("username") String username,
                                                                                  @RequestBody CreatePersonRequestDto requestDto) {
        PersonIdResponseDto person = service.createPerson(username, requestDto);
        APIResultDtoWithData<PersonIdResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(person);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @PostMapping("/otp/send")
    public ResponseEntity<APIResultDtoWithData<OTPResponseDto>> sendOTP(@RequestBody OTPRequestDto requestDto) {
        OTPResponseDto responseDto = service.sendOTP(requestDto);
        APIResultDtoWithData<OTPResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(responseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @PatchMapping("/otp/enable")
    public ResponseEntity<APIResultDtoWithData<PersonIdResponseDto>> enablePersonByOTP(@RequestBody OTPAnswerRequestDto requestDto) {
        PersonIdResponseDto personIdResponseDto = service.enablePerson(requestDto);
        APIResultDtoWithData<PersonIdResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(personIdResponseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResultDtoWithData<PersonResponseDto>> getById(@RequestHeader("username") String username,
                                                                           @PathVariable("id") UUID id) {
        PersonResponseDto personResponseDto = service.getById(username, id);
        APIResultDtoWithData<PersonResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(personResponseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResultDtoWithData<PersonIdResponseDto>> deleteById(@RequestHeader("username") String username,
                                                                              @PathVariable("id") UUID id){
        PersonIdResponseDto personIdResponseDto = service.deletePerson(username, id);
        APIResultDtoWithData<PersonIdResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(personIdResponseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @GetMapping
    public ResponseEntity<APIResultDtoWithData<List<PersonResponseDto>>> getPersons(@RequestHeader("username") String username,
                                                                                    PersonPageRequestDto requestDto) {
        Pagination<List<PersonResponseDto>> vehicleTypeResponseDTOs = service.getPersons(username, requestDto);
        APIResultDtoWithData<List<PersonResponseDto>> successResult = ResponseHandler.getSuccessResultWithPagination(vehicleTypeResponseDTOs);
        return ResponseHandler.handleResponseWithBody(successResult);
    }
}
