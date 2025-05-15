package ru.petryakov.NauJava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.petryakov.NauJava.entity.Reader;

import java.util.Optional;

@DataJpaTest
class ReaderRepositoryTest {
    @Autowired
    private ReaderRepository readerRepository;

    @Test
    void testSaveAndFindReader() {
        Reader reader = new Reader();
        reader.setName("Иван Иванов");
        reader = readerRepository.save(reader);

        Optional<Reader> found = readerRepository.findById(reader.getId());

        Assertions.assertTrue(found.isPresent());
        Assertions.assertEquals("Иван Иванов", found.get().getName());
    }
}
