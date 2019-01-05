package com.acozac.myhomeexpenses.controllers;

import com.acozac.myhomeexpenses.models.Expense;
import com.acozac.myhomeexpenses.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpenseController {

    @Autowired
    ExpenseRepository expenseRepository;

    @RequestMapping(method = RequestMethod.GET, value="/expenses")
    public Iterable<Expense> expense() {
        return expenseRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/expenses")
    public Expense save(@RequestBody Expense expense) {
        expenseRepository.save(expense);

        return expense;
    }

    @RequestMapping(method = RequestMethod.GET, value="/expenses/{id}")
    public Optional<Expense> show(@PathVariable String id) {
        return expenseRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "expenses/{id}")
    public Optional<Expense> update(@PathVariable String id, @RequestBody Expense expense) {
        Optional<Expense> exp = expenseRepository.findById(id);
        exp.ifPresent(e -> {
            e.setPrice(expense.getPrice());
            e.setTitle(expense.getTitle());
            e.setDescription(expense.getDescription());
            expenseRepository.save(e);
        });

        return exp;
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/expenses/{id}")
    public String delete(@PathVariable String id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        expenseRepository.delete(expense.get());

        return id;
    }
}
