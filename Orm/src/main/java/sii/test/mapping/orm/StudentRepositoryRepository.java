package sii.test.mapping.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sii.test.mapping.orm.model.Student;
import sii.test.mapping.orm.model.StudentAverageScoreView;

import java.util.List;

/*
 * Expected table structure:
 *   table students (
 *        id bigint not null,
 *        name varchar(255),
 *        surname varchar(255)
 *   );
 *
 *   table subjects (
 *        id bigint not null,
 *        final_score numeric(38,2),
 *        name varchar(255),
 *        student_id bigint
 *   );
 */
public interface StudentRepositoryRepository extends JpaRepository<Student, Long> {

    @Query(nativeQuery = true, value = "@TODO write query")
   List<StudentAverageScoreView> getAverageScoreForAllStudents();
}
