package com.test.testjava.restController;

import com.test.testjava.dto.AccountDTO;
import com.test.testjava.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountRestController extends BaseController{
@Autowired
    UserService userService;

    @GetMapping
    public AccountDTO get(){
        String username = getUsername();
        AccountDTO userId = userService.getUserAccount(username);
        return new AccountDTO();
    }
}
