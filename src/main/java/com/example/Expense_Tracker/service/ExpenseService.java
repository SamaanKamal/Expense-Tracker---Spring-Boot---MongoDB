package com.example.Expense_Tracker.service;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense By ID %s", expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String expenseName){
        return expenseRepository.findByName(expenseName).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense By Name %s", expenseName)));
    }

    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }
}
