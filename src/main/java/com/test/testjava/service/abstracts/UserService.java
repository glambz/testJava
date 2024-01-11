package com.test.testjava.service.abstracts;

import com.test.testjava.dto.AccountDTO;

public interface UserService {
    AccountDTO getUserAccount(String username);
}
