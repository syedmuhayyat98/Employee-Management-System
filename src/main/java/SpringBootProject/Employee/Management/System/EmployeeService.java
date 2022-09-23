package SpringBootProject.Employee.Management.System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;}

    public List<Employee> getEmployee(){ return employeeRepository.findAll();}

    public void addEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException("Email is taken!");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeID){
        boolean exist = employeeRepository.existsById(employeeID);
        if(!exist){
            throw new IllegalStateException("Employee with ID "+ employeeID+" does not exist!");
        }
        employeeRepository.deleteById(employeeID);
    }

    public void updateEmployee(Long employeeID, String name, String email,
                               int salary,String contact,String address)
    {
        Employee employee = employeeRepository.findById(employeeID).
                orElseThrow(()->new IllegalStateException("Employee with ID "+ employeeID+" does not exist!"));

        if(name != null && name.length()> 0 && !Objects.equals(employee.getName(),name)){
            employee.setName(name);
        }
        if(email != null && email.length()> 0 && !Objects.equals(employee.getEmail(),email)){
            Optional<Employee> employeeOptional = employeeRepository.findEmployeeByEmail(employee.getEmail());
            if(employeeOptional.isPresent()){
                throw new IllegalStateException("Email is taken!");
            }
            employee.setEmail(email);
        }
        if(salary != employee.getSalary()){ employee.setSalary(salary);}

        if(contact != null && contact.length()> 0 && !Objects.equals(employee.getContact(),contact)){
            employee.setContact(contact);
        }

        if(address != null && address.length()> 0 && !Objects.equals(employee.getAddress(),address)){
            employee.setAddress(address);
        }
    }

}
