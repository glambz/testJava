package com.test.testjava.restController;

import com.test.testjava.security.ApplicationUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseController {
    protected String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var test = authentication.getPrincipal();
        return authentication.getName();
    }
    protected String getRoleName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var principal = (ApplicationUserDetails)authentication.getPrincipal();
        var returned = principal.getAuthorities().toArray()[0].toString();
        return returned;
    }
}
