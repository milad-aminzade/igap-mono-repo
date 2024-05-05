package ir.kian.igap.IgapUserProfileChallenge.controller;

import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.auth.LoginRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.auth.LoginResponseDto;
import ir.kian.igap.IgapUserProfileChallenge.service.interfaces.AuthService;
import ir.kian.igap.common.domain.dto.restapi.result.APIResultDtoWithData;
import ir.kian.igap.common.transformer.ResponseHandlerTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<APIResultDtoWithData<LoginResponseDto>> login(@RequestBody LoginRequestDto loginReq) {
        LoginResponseDto login = authService.login(loginReq);
        APIResultDtoWithData<LoginResponseDto> successResult = ResponseHandlerTransformer.getSuccessResult(login);
        return ResponseHandlerTransformer.handleResponseWithBody(successResult);
    }


}
