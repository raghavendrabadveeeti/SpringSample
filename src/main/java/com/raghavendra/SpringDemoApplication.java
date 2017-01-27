package com.raghavendra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@SpringBootApplication
public class SpringDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDemoApplication.class, args);
  }

  @RequestMapping("/")
  String home() {
    return "Hello World!";
  }

  @RequestMapping("/logout")
  Object logout(HttpServletRequest request, HttpServletResponse response) {

    Object principal = null;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication != null) {
      principal = authentication.getPrincipal();
      new SecurityContextLogoutHandler().logout(request, response, authentication);
    }

    return principal;
  }
}
