package ir.kian.igap.IgapUserProfileChallenge.adapter.fallbacks;

import feign.FeignException;
import feign.RetryableException;
import io.github.resilience4j.timelimiter.TimeLimiter;
import ir.kian.igap.common.exception.InternalServerException;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.nio.file.AccessDeniedException;

@Slf4j
public class BaseFallbackFactory implements Serializable {
    public ResponseEntity handle(Throwable cause) {
        if (cause instanceof FeignException.BadRequest)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (cause instanceof FeignException.NotFound)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (cause instanceof FeignException.Conflict)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        if (cause instanceof FeignException.Unauthorized)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        if (cause instanceof RetryableException)
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        if (cause instanceof FeignException.Forbidden)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        if (cause instanceof FeignException.FeignServerException)
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        if (cause instanceof TimeLimiter)
            return new ResponseEntity<>(HttpStatus.GATEWAY_TIMEOUT);
        if (cause instanceof InternalServerException)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        if (cause instanceof BadRequestException)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (cause instanceof AccessDeniedException)
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        if (cause instanceof NotFoundException)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
