package mebitechDemo.repository;

import mebitechDemo.models.Meetings;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Derya Othan
 * @version 0.0.1
 * @since 24.06.2017
 */
@Repository
public interface MeetingsRepository extends JpaRepository<Meetings, String> {
}
