package com.Group4.ExpensesTrack.app.controller;

import com.Group4.ExpensesTrack.app.model.Expenses;
import com.Group4.ExpensesTrack.app.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExpensesController {

    private final ExpensesService expensesService;

    @Autowired
    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping("/expenses")
    public List<Expenses> getExpenses() {
        return expensesService.getExpenses();
    }

    @GetMapping("/expense/{id}")
    public ResponseEntity<Expenses> getExpenseById(@PathVariable Long id) {
        Optional<Expenses> expenses = expensesService.getExpenseById(id);

        return expenses.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/expense")
    public ResponseEntity<Expenses> createExpense(@RequestBody Expenses expenses) {
        Expenses createdExpense = expensesService.createExpense(expenses);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
    }

    @PutMapping("/expense/{id}")
    public ResponseEntity<Void> updateExpense(@PathVariable Long id, @RequestBody Expenses expenses) {
        expensesService.updateExpense(id, expenses);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/expense/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expensesService.deleteExpense(id);

        return ResponseEntity.noContent().build();
    }
}