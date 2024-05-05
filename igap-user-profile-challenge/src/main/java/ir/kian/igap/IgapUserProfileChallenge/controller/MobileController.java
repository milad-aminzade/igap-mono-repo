package ir.kian.igap.IgapUserProfileChallenge.controller;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.mobile.CreateMobileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.mobile.CreateMobileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.MobileService;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.transformer.ResponseHandlerTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/mobile")
@Slf4j
public class MobileController {
    private final MobileService service;

    @PostMapping
    public ResponseEntity<APIResultDtoWithData<CreateMobileResponseDto>> createMobile(@RequestHeader("username") String username,
                                                                                      @RequestBody CreateMobileRequestDto requestDto) {
        log.info("MobileController-createMobile || username: {} , CreateMobileRequestDto: {}", username, requestDto);
        CreateMobileResponseDto mobileResponseDto = service.createMobile(requestDto, username);
        APIResultDtoWithData<CreateMobileResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(mobileResponseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }
}
