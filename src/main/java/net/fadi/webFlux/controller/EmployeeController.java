package net.fadi.webFlux.controller;

import lombok.Getter;
import net.fadi.webFlux.dto.EmployeeDto;
import net.fadi.webFlux.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Flux<EmployeeDto> getAllEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("{id}")
    public Mono<EmployeeDto> getEmployeeById(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Mono<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.addEmployee(employeeDto);
    }

    @PutMapping("{id}")
    public Mono<EmployeeDto> editEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id){
         employeeService.deleteEmployee(id);
         return "successfully deleted";
    }
}
