package com.core.entities.employee.services;
import com.core.entities.employee.model.Employee;

public class EmployeeMapper {
    public static Employee employeeFromDTO(EmployeeDTO edto) throws Exception{
        
        return Employee.getInstance(edto.getName(), 
                                    edto.getSurname(), 
                                    edto.getEmail(), 
                                    edto.getAddress(), 
                                    edto.getDni(), 
                                    edto.getNumber(),
                                    edto.getAntiquity(),
                                    edto.getIdEmployee(),
                                    edto.getPosition(),  
                                    edto.getSalary());
    }

    public static EmployeeDTO dtoFromEmployee(Employee e){
        
        return new EmployeeDTO(
        
            e.getName(), 
            e.getSurname(), 
            e.getEmail(), 
            e.getAddress(), 
            e.getDni(), 
            e.getNumber(), 
            e.getAntiquity(), 
            e.getIdEmployee(), 
            e.getPosition(), 
            e.getSalary()
            );
    }   

}
