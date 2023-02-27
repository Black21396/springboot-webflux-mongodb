package net.fadi.webFlux.mapper;

import net.fadi.webFlux.dto.EmployeeDto;
import net.fadi.webFlux.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/*
       * in this project this class isnt used, because I use
        the manuel method (Employee Mapper)
        * in next projects, I will used this method (using mapstruckt dependency)
         this is way is more proffesional and save the Time
 */
@Mapper
public interface EmployeeMapper2 {

    /*
        * when the variables name is different, I can custom it using @Mapping annotation
        * in this example the variables name are same, so the source variabel and target variable
         are same "name"
         * source: the parameter type (here is "EmployeeDto")
         * target: the return type (here is "Employee")
     */
    @Mapping(source = "name", target = "name")
    public Employee employeeToDto(EmployeeDto employeeDto);

    @Mapping(source = "name", target = "name")
    public EmployeeDto DtoToEmployee(Employee employee);
}
