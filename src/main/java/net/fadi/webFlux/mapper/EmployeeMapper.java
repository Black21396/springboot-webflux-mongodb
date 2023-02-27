package net.fadi.webFlux.mapper;

import net.fadi.webFlux.dto.EmployeeDto;
import net.fadi.webFlux.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getBirthday());
    }

    public static Employee mapToEmployee(EmployeeDto employee){
        return new Employee(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getBirthday());
    }
}
