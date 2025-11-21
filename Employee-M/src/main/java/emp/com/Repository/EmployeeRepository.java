package emp.com.Repository;

import emp.com.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{

    @Query("SELECT e FROM Employee e WHERE e.deletedAt IS NULL")
    List<Employee> findAllActiveEmployees();

    @Query("SELECT e FROM Employee e WHERE e.city = :city AND e.deletedAt IS NULL")
    List<Employee> findByCity(@Param("city") String city);

    @Query("SELECT e FROM Employee e WHERE e.role = :role AND e.deletedAt IS NULL")
    List<Employee> findByRole(@Param("role") String role);

    @Query("SELECT e FROM Employee e WHERE e.company = :company AND e.deletedAt IS NULL")
    List<Employee> findByCompany(@Param("company") String company);
}


