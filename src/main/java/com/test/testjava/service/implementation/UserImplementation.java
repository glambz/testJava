package com.test.testjava.service.implementation;

import com.test.testjava.dao.JobRepository;
import com.test.testjava.dao.UserDetailRepository;
import com.test.testjava.dao.UserRepository;
import com.test.testjava.dto.AccountDTO;
import com.test.testjava.dto.UserDetailDTO;
import com.test.testjava.dto.UserJobDTO;
import com.test.testjava.entity.User;
import com.test.testjava.security.ApplicationUserDetails;
import com.test.testjava.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserImplementation implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Autowired
    private JobRepository jobRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        long id =userRepository.findIdByUsername(username);
        User userLogin = userRepository.findById(id).get();
        return new ApplicationUserDetails(userLogin);
    }

    @Override
    public AccountDTO getUserAccount(String username) {
        long id = userRepository.findIdByUsername(username);
        UserDetailDTO userDetailDTO = userDetailRepository.getDetailByUserId(id);
        List<UserJobDTO> userJobDTO = jobRepository.getJobByUserId(id);
        return null;
    }
}
