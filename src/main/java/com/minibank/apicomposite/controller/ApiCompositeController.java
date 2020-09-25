package com.minibank.apicomposite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.minibank.apicomposite.domain.entity.Customer;
import com.minibank.apicomposite.service.ApiCompositeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ApiCompositeController {
	@Autowired
	ApiCompositeService apiCompositeServce;
	
    @ApiOperation(value = "고객상세조회", httpMethod = "GET", notes = "고객상세조회")
    @RequestMapping(method = RequestMethod.GET, path = "/detail/rest/v0.8/{cstmId}")
    public Customer retrieveCustomerDetail(@PathVariable(name = "cstmId") String cstmId) throws Exception{ 
       return apiCompositeServce.retrieveCustomerDetail(cstmId);
    }
}
