package com.radu.bankofradu.Repositories;

import com.radu.bankofradu.Data.Customer;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Customer, Integer> {}
