package com.eazybank.accounts.service;


import com.eazybank.accounts.dto.AccountsDto;
import com.eazybank.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

import javax.management.StandardEmitterMBean;

public interface IAccountService {


    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
