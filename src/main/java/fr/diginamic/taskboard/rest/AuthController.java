package fr.diginamic.taskboard.rest;

import java.util.Arrays;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.taskboard.util.enums.Authority;
import fr.diginamic.taskboard.util.models.Role;
import fr.diginamic.taskboard.util.models.UserSecret;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class AuthController {

  @GetMapping("/me")
  public Mono<UserSecret> validate() {
    log.info("i was here ^^");
    return Mono.just(
      UserSecret.builder()
        .email("admin@test.com")
        .token("token")
        .roles(Arrays.asList(
          Role.builder()
            .id(1)
            .authority(Authority.ADMIN)
            .build(),
          Role.builder()
            .id(2)
            .authority(Authority.USER)
            .build()))
        .build());
  }

}
