package emp.com.Services;

import emp.com.Entity.Employee;
import emp.com.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
    public class EmployeeService
{
        @Autowired
        private EmployeeRepository repo;

        public Employee addEmployee(Employee employee)
        {
            return repo.save(employee);
        }
     public List<Employee> addEmployees(List<Employee> employees)
     {
        return repo.saveAll(employees);
    }


    public List<Employee> getAllActive(

        ) {
            return repo.findAllActiveEmployees();
        }

        public Employee getById(Long id)
        {
            return repo.findById(id).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        }

        public Employee updateEmployee(Long id, Employee newData)
        {
            Employee e = getById(id);

            e.setName(newData.getName());
            e.setEmail(newData.getEmail());
            e.setSalary(newData.getSalary());
            e.setCity(newData.getCity());
            e.setRole(newData.getRole());
            e.setCompany(newData.getCompany());
            e.setGender(newData.getGender());

            return repo.save(e);
        }

        public String softDelete(Long id)
        {
            Employee e = getById(id);
            e.setDeletedAt(LocalDateTime.now());
            repo.save(e);
            return "Employee deleted successfully ";
        }

        public void hardDelete(Long id)
        {
            repo.deleteById(id);
        }

        public List<Employee> searchByCity(String city)
        {
            return repo.findByCity(city);
        }

        public List<Employee> searchByRole(String role)
        {
            return repo.findByRole(role);
        }

        public List<Employee> searchByCompany(String company)
        {
            return repo.findByCompany(company);
        }
}


