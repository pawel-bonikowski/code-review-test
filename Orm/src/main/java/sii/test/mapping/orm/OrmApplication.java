package sii.test.mapping.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  TODO:
 *   - Apply changes in Root and/or Child entity to generate SQL tables in most optimal way
 *   - Apply changes to make "saveTest" work ( do not make changes in test code)
 */



@SpringBootApplication
public class OrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }

}
