package com.acozac.myhomeexpenses.repositories;

import com.acozac.myhomeexpenses.models.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, String> {

}
