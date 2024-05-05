package ir.kian.igap.IgapUserProfileChallenge.service.interfaces;


import ir.kian.igap.IgapUserProfileChallenge.domain.dto.request.auth.LoginRequestDto;
import ir.kian.igap.IgapUserProfileChallenge.domain.dto.response.auth.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto request);
}
