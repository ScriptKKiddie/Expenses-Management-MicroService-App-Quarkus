package com.oy.tech;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;


@ApplicationScoped
public class ExpensesService {

    Set<Expenses> expenses = Collections.newSetFromMap(Collections.synchronizedMap(new HashMap<>()));

    // READ :: GET
    public Set<Expenses> list() {
        return expenses;
    }

    // CREATE :: POST
    public Expenses create(Expenses expense) {
        expenses.add(expense);
        return expense;
    }

    // UPDATE :: UPDATE
    public void update(Expenses expense) {
        delete(expense.getUuid());
        create(expense);
    }

    // DELETE :: DELETE
    public boolean delete(UUID uuid) {
        return expenses.removeIf(expense -> expense.getUuid().equals(uuid));
    }




}
