package sii.test.mapping.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sii.test.mapping.orm.model.Student;
import sii.test.mapping.orm.model.StudentAverageScoreView;

import java.util.List;

public interface StudentRepositoryRepository extends JpaRepository<Student, Long> {

    @Query(nativeQuery = true, value = "@TODO write query")
   List<StudentAverageScoreView> getAverageScoreForAllStudents();
}
