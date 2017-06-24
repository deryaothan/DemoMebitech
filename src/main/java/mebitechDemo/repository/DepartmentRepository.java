package mebitechDemo.repository;

import mebitechDemo.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Derya Othan
 * @version 0.0.1
 * @since 24.06.2017
 */
public interface DepartmentRepository extends JpaRepository<Department, String> {
}
