package sii.test.spring.transaction;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.UnexpectedException;

@SpringBootApplication
public class TransactionApplication {

    private final TestRepository repository;

    public TransactionApplication(TestRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }


    @PostConstruct
    void initData() {
        try {
            this.inTransaction();
        } catch (RuntimeException e) {
            //ignore just for test
        }
        long count = repository.count();
        System.out.println("Records in repository: " + count);
    }
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void inTransaction(){
        TestEntity testEntity = new TestEntity();
        testEntity.setMessage("Some test message");
        repository.save(testEntity);

        throw new RuntimeException("Oh no some error occur");
    }
}
