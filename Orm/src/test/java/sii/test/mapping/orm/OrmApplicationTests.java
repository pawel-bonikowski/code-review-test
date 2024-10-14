package sii.test.mapping.orm;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sii.test.mapping.orm.model.Subject;
import sii.test.mapping.orm.model.Student;
import sii.test.mapping.orm.model.StudentAverageScoreView;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class OrmApplicationTests {

    @Autowired
    private StudentRepositoryRepository rootEntityRepository;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void testSave() {
        //given
        rootEntityRepository.deleteAll();
        rootEntityRepository.saveAllAndFlush(createTestEntity());


        //when
        List<Student> all = rootEntityRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getId))
                .toList();


        //then
        Assertions.assertEquals(2, all.size());
        Assertions.assertEquals(3, all.get(0).getSubjects().size());
        Assertions.assertEquals(4, all.get(1).getSubjects().size());
    }


    @Test
    @Transactional
    void testAverageScore() {
        //given
        rootEntityRepository.deleteAll();
        rootEntityRepository.saveAllAndFlush(createTestEntity());

        //when
        var averageScores = rootEntityRepository.getAverageScoreForAllStudents();

        //then
        Assertions.assertEquals(2, averageScores.size());
        Optional<StudentAverageScoreView> kowalskiScore = averageScores.stream().filter(i -> i.getLastName().equals("Kowalski")).findFirst();
        Assertions.assertTrue(kowalskiScore.isPresent());
        Assertions.assertEquals("Kowalski", kowalskiScore.get().getLastName());
        Assertions.assertEquals("Jan", kowalskiScore.get().getFirstName());
        Assertions.assertEquals(0, new BigDecimal("54.8").compareTo(kowalskiScore.get().getScore()));

        Optional<StudentAverageScoreView> nowakScore = averageScores.stream().filter(i -> i.getLastName().equals("Nowak")).findFirst();
        Assertions.assertTrue(nowakScore.isPresent());
        Assertions.assertEquals("Nowak", nowakScore.get().getLastName());
        Assertions.assertEquals("Adam", nowakScore.get().getFirstName());
        Assertions.assertEquals(0, new BigDecimal("55.875").compareTo(nowakScore.get().getScore()));
    }

    private List<Student> createTestEntity() {

        Student student1 = new Student("Jan", "Kowalski");
        student1.setSubjects(List.of(
                new Subject("Match", student1, BigDecimal.valueOf(42.7)),
                new Subject("History", student1, BigDecimal.valueOf(44.6)),
                new Subject("Geography", student1, BigDecimal.valueOf(77.1))
        ));

        Student student2 = new Student("Adam", "Nowak");
        student2.setSubjects(List.of(
                new Subject("Match", student2, BigDecimal.valueOf(11.7)),
                new Subject("History", student2, BigDecimal.valueOf(78.6)),
                new Subject("Geography", student2, BigDecimal.valueOf(33.2)),
                new Subject("Sport", student2, BigDecimal.valueOf(100))
        ));
        return List.of(student1, student2);
    }

}
