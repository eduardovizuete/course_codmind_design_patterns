package design.patterns.behavioral.iterator.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Employee implements IContainer<Employee> {
    
    private String name;
    
    private String role;
    
    private List<Employee> subordinates;

    public Employee(String name, String role, Employee... subordinates) {
        this.name = name;
        this.role = role;
        this.subordinates = Arrays.asList(subordinates);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
    
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", role=" + role + '}';
    }

    @Override
    public IIterator<Employee> createIterator() {
        return new TreeEmployeeIterator();
    }

    private class TreeEmployeeIterator implements IIterator<Employee> {

        private LinkedList<Employee> list = new LinkedList<Employee>();
        
        private int index = 0;
        
        public TreeEmployeeIterator() {
            addRecursive(Employee.this);
        }
        
        private void addRecursive(Employee employee) {
            list.add(employee);
            
            if (employee.getSubordinates() != null) {
                for (Employee subordinate: employee.getSubordinates()) {
                    addRecursive(subordinate);
                }
            }
        }

        @Override
        public boolean hasNext() {
            if (list.isEmpty()) {
                return false;
            }
            
            return index < list.size();
        }

        @Override
        public Employee next() {
            if (!hasNext()) {
                throw new RuntimeException("No hay mas elementos");
            }
            
            return list.get(index++);
        }

    }    
    
}
