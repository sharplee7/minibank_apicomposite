package com.minibank.apicomposite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minibank.apicomposite.domain.entity.Account;
import com.minibank.apicomposite.domain.entity.Customer;
import com.minibank.apicomposite.domain.entity.TransferLimit;
import com.minibank.apicomposite.rest.account.AccountFeignClient;
import com.minibank.apicomposite.rest.customer.CustomerFeignClient;
import com.minibank.apicomposite.rest.transfer.TransferFeignClient;

@Service("apiCompositeService")
public class ApiCompositeServiceImpl implements ApiCompositeService {
    @Autowired
    TransferFeignClient transferFeignClient;

    @Autowired
    AccountFeignClient accountFeignClient;
    
    @Autowired
    CustomerFeignClient customerFeiginClient;
    
	@Override
	public Customer retrieveCustomerDetail(String cstmId) throws Exception {
        //고객 기본 조회
    	Customer customer = customerFeiginClient.retrieveCustomer(cstmId);
        
        // 이체 한도 조회
        TransferLimit transferLimit = transferFeignClient.retrieveTransferLimit(cstmId);
    	
        customer.setOneDyTrnfLmt(transferLimit.getOneDyTrnfLmt());
        customer.setOneTmTrnfLmt(transferLimit.getOneTmTrnfLmt());
        
        // 계좌 목록 조회
        List<Account> accountList = accountFeignClient.retrieveAccountList(cstmId);
        
        customer.addAllAccounts(accountList);
        
        return customer;
	}
}
