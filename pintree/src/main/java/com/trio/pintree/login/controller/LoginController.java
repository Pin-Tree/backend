package com.trio.pintree.login.controller;

import com.trio.pintree.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
}
