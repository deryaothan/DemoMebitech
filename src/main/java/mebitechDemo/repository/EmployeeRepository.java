package mebitechDemo.repository;

import mebitechDemo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Derya Othan
 * @version 0.0.1
 * @since 24.06.2017
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
}
