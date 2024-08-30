package sii.test.mapping.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import sii.test.mapping.orm.model.RootEntity;

public interface RootEntityRepository  extends JpaRepository<RootEntity, Long> {
}
