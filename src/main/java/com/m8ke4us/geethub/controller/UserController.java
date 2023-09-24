package com.m8ke4us.geethub.controller;

import com.m8ke4us.geethub.config.GithubApi;
import jakarta.servlet.http.HttpSession;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @PostMapping("/{userId}/login")
    public ResponseEntity<String> userLogin(@PathVariable String userId, HttpSession session){
        GitHub github;
        try{
            github = GithubApi.getGithub();
            // 추후 OAuth 통한 실제 로그인 구현할 것
            GHUser loginUser = github.getUser(userId);

            if(loginUser != null && userId.equals(loginUser.getLogin())){
                // 세션에 해당 user ID 저장
                session.setAttribute("loginUser", loginUser.getLogin());
                return new ResponseEntity(userId, HttpStatus.OK);
            }

            // 존재 하지 않는 ID
            return new ResponseEntity("undefined user", HttpStatus.BAD_REQUEST);

        }catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
