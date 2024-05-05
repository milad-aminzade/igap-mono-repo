package ir.kian.igap.IgapUserProfileChallenge.controller;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.person.PersonPageRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.profile.CreateProfileRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.person.PersonResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.CreateProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.profile.ProfileResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.ProfileService;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.domain.dto.restapi.result.Pagination;
import ir.kian.igap.common.transformer.ResponseHandlerTransformer;
import ir.kian.igap.common.transformer.impl.ResponseHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profile")
@Slf4j
public class ProfileController {
    private final ProfileService service;

    @PostMapping
    public ResponseEntity<APIResultDtoWithData<CreateProfileResponseDto>> createProfile(@RequestHeader("username") String username,
                                                                                        @RequestBody CreateProfileRequestDto requestDto) {
        CreateProfileResponseDto profile = service.createProfile(requestDto, username);
        APIResultDtoWithData<CreateProfileResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(profile);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }

    @GetMapping
    public ResponseEntity<APIResultDtoWithData<ProfileResponseDto>> getMyProfile(@RequestHeader("username") String username) {
        ProfileResponseDto profileResponseDto = service.getMyProfile(username);
        APIResultDtoWithData<ProfileResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(profileResponseDto);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }
}
