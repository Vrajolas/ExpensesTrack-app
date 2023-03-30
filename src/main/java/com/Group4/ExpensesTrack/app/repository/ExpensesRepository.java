package com.Group4.ExpensesTrack.app.repository;

import com.Group4.ExpensesTrack.app.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
