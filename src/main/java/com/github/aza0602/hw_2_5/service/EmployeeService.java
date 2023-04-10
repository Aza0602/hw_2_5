package com.github.aza0602.hw_2_5.service;

import com.github.aza0602.hw_2_5.exception.EmployeeAlreadyAddedException;
import com.github.aza0602.hw_2_5.exception.EmployeeNotFoundException;
import com.github.aza0602.hw_2_5.exception.EmployeeStoragesFullException;
import com.github.aza0602.hw_2_5.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class EmployeeService {

    private static final int SIZE = 3;

    private static final Collection<Employee> employees = new ArrayList<>();

    public static Employee add(String firstName, String lastName) {
        if (employees.size() < SIZE) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStoragesFullException();
    }
    public static Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }
    public static Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> employees() {
        return Collections.unmodifiableCollection(employees);
    }
}
