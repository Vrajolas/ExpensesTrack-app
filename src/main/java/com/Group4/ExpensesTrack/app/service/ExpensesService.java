package com.Group4.ExpensesTrack.app.service;

import com.Group4.ExpensesTrack.app.model.Expenses;
import com.Group4.ExpensesTrack.app.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;

    @Autowired
    public ExpensesService(ExpensesRepository expenseRepository) {
        this.expensesRepository = expenseRepository;
    }

    public List<Expenses> getExpenses() {
        return expensesRepository.findAll();
    }

    public Optional<Expenses> getExpenseById(Long id) {
        return expensesRepository.findById(id);
    }

    public Expenses createExpense(Expenses expense) {
        return expensesRepository.save(expense);
    }

    public void updateExpense(Long id, Expenses expense) {
        Optional<Expenses> expenseToUpdate = expensesRepository.findById(id);

        if (expenseToUpdate.isPresent()) {
            expense.setId(id);
            expensesRepository.save(expense);
        }
    }

    public void deleteExpense(Long id) {
        expensesRepository.deleteById(id);
    }
}