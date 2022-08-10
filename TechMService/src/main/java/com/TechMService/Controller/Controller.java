package com.TechMService.Controller;

import com.TechMService.Dao.EmployeeRepository;
import com.TechMService.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controller {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public String getHealthCheck() {
        return "Welcome to TechM app";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee) {
        System.out.println("saveEmployee");
        employeeRepository.save(employee);
        return "Employee saved";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAll() {
        System.out.println("getAllEmployees");
        return employeeRepository.findAll();
    }

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable Integer id) {
        System.out.println("getEmployee Id" +id);
        return employeeRepository.findById(id).get();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        System.out.println("getEmployee Id" +id);
        employeeRepository.deleteById(id);
        return "Deleted Successfully";
    }

    @PutMapping("/putEmployee")
    public String putEmployee(@RequestBody Employee employee) {
        System.out.println("getEmployee Id" +employee.getId());
        System.out.println("put name" +employee.getName());
        employeeRepository.save(employee);
        return "Updated Successfully";
    }


}