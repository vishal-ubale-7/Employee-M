package emp.com.Controller;

import emp.com.Entity.Employee;
import emp.com.Services.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
@Tag(name = "Employee API", description = "CRUD operations for Employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService service;

    // add one employee
    @PostMapping("employee")
    @Operation(summary = "Add a new employee")
    public ResponseEntity<Employee> add(@RequestBody Employee employee)
    {
        return ResponseEntity.ok(service.addEmployee(employee));
    }

    // add multiple employee
    @PostMapping("employees")
    @Operation(summary = "Add multiple employees")
    public ResponseEntity<List<Employee>> addBatch(@RequestBody List<Employee> employees) {
        return ResponseEntity.ok(service.addEmployees(employees));
    }

    // get all employee
    @GetMapping("employees")
    @Operation(summary = "Get all active employees")
    public ResponseEntity<List<Employee>> getAll()
    {
        return ResponseEntity.ok(service.getAllActive());
    }

   // get employee by id
    @GetMapping("/{id}")
    @Operation(summary = "Get employee by ID")
    public ResponseEntity<Employee> getById (@PathVariable Long id)
    {
        return ResponseEntity.ok(service.getById(id));
    }
    // update employee bt id
    @PutMapping("/{id}")
    @Operation(summary = "Update employee details")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee newData)
    {
        return ResponseEntity.ok(service.updateEmployee(id, newData));
    }

    @DeleteMapping("/soft/{id}")
    @Operation(summary = "Soft delete employee")
    public ResponseEntity<String> softDelete(@PathVariable Long id)
    {
        return ResponseEntity.ok(service.softDelete(id));
    }

    @DeleteMapping("/hard/{id}")
    @Operation(summary = "Hard delete employee")
    public ResponseEntity<String> hardDelete(@PathVariable Long id)
    {
        service.hardDelete(id);
        return ResponseEntity.ok("Hard deleted successfully");
    }

    @GetMapping("/city/{city}")
    @Operation(summary = "Search employees by city")
    public ResponseEntity<List<Employee>> searchByCity(@PathVariable String city)
    {
        return ResponseEntity.ok(service.searchByCity(city));
    }

    @GetMapping("/role/{role}")
    @Operation(summary = "Search employees by role")
    public ResponseEntity<List<Employee>> searchByRole(@PathVariable String role)
    {
        return ResponseEntity.ok(service.searchByRole(role));
    }
    // search employees
    @GetMapping("/company/{company}")
    @Operation(summary = "Search employees by company")
    public ResponseEntity<List<Employee>> searchByCompany(@PathVariable String company)
    {
        return ResponseEntity.ok(service.searchByCompany(company));
    }
}
