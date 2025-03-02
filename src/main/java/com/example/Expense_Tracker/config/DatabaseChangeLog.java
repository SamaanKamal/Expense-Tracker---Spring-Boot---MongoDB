package com.example.Expense_Tracker.config;

import com.example.Expense_Tracker.model.Expense;
import com.example.Expense_Tracker.model.ExpenseCategory;
import com.example.Expense_Tracker.repository.ExpenseRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.example.Expense_Tracker.model.ExpenseCategory.*;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001", id = "seedDatabase", author = "Samaan")
    public void seedDatabase(ExpenseRepository expenseRepository){
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("Movie Tickets", ENTERTAINMENT, BigDecimal.valueOf(70)));
        expenseList.add(createNewExpense("Dinner", RESTAURANT, BigDecimal.valueOf(60)));
        expenseList.add(createNewExpense("Netflix", ENTERTAINMENT, BigDecimal.valueOf(10)));
        expenseList.add(createNewExpense("Gym", MISC, BigDecimal.valueOf(20)));
        expenseList.add(createNewExpense("Internet", UTILITIES, BigDecimal.valueOf(30)));
        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseCategory(expenseCategory);
        expense.setExpenseAmount(expenseAmount);
        return expense;
    }
}
