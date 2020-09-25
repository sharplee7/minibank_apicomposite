package com.minibank.apicomposite.service;

import com.minibank.apicomposite.domain.entity.Customer;

public interface ApiCompositeService {
	public Customer retrieveCustomerDetail(String cstmId) throws Exception;
}
