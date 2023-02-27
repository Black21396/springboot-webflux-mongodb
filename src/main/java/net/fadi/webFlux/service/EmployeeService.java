package net.fadi.webFlux.service;

import net.fadi.webFlux.dto.EmployeeDto;
import net.fadi.webFlux.entity.Employee;
import net.fadi.webFlux.mapper.EmployeeMapper;
import net.fadi.webFlux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

    @Service
    public class EmployeeService {

        @Autowired
        private EmployeeRepository employeeRepository;

        public Mono<EmployeeDto> getEmployee(String id){
            return employeeRepository.findById(id).map(e-> EmployeeMapper.mapToEmployeeDto(e));
        }

        public Flux<EmployeeDto> getEmployees(){
            return employeeRepository.findAll().map(e-> EmployeeMapper.mapToEmployeeDto(e));
        }

        public Mono<EmployeeDto> addEmployee(EmployeeDto employeeDto){
             Mono<Employee> employeeMono = employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
             return employeeMono.map(e->EmployeeMapper.mapToEmployeeDto(e));
        }

        public Mono<EmployeeDto> updateEmployee(String id, EmployeeDto employeeDto){
            Mono<Employee> employeeMono = employeeRepository.findById(id);

            return employeeMono.flatMap((e)->{
                e.setName(employeeDto.getName());
                e.setEmail(employeeDto.getEmail());
                e.setBirthday(employeeDto.getBirthday());
                return employeeRepository.save(e);
            }).map(e -> EmployeeMapper.mapToEmployeeDto(e));
        }

        public void deleteEmployee(String id){
            employeeRepository.deleteById(id);
        }
    }
