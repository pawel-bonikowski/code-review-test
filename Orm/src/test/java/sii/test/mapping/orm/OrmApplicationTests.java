package sii.test.mapping.orm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sii.test.mapping.orm.model.ChildEntity;
import sii.test.mapping.orm.model.RootEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class OrmApplicationTests {

    @Autowired
    private RootEntityRepository rootEntityRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testSave() {
        //given
        rootEntityRepository.deleteAll();
        rootEntityRepository.saveAndFlush(createTestEntity());

        //when
        Optional<RootEntity> byId = rootEntityRepository.findAll().stream().findFirst();

        //then
        Assertions.assertTrue(byId.isPresent());
        Assertions.assertEquals(3, byId.get().getChidren().size());
    }

    private RootEntity createTestEntity() {

        RootEntity root = new RootEntity();
        root.setChidren(List.of(
                new ChildEntity("test1"),
                new ChildEntity("test2"),
                new ChildEntity("test3")
        ));
        return root;
    }

}
