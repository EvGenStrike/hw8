package ru.petryakov.NauJava.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.petryakov.NauJava.entity.LibraryCard;
import ru.petryakov.NauJava.entity.Reader;
import ru.petryakov.NauJava.repository.LibraryCardRepository;
import ru.petryakov.NauJava.repository.ReaderRepository;

import java.util.UUID;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final LibraryCardRepository libraryCardRepository;

    public ReaderService(ReaderRepository readerRepository, LibraryCardRepository libraryCardRepository) {
        this.readerRepository = readerRepository;
        this.libraryCardRepository = libraryCardRepository;
    }

    @Transactional
    public Reader registerReader(String name) {
        Reader reader = new Reader();
        reader.setName(name);
        reader = readerRepository.save(reader);

        LibraryCard card = new LibraryCard();
        card.setCardNumber(UUID.randomUUID().toString());
        card.setReader(reader);

        libraryCardRepository.save(card);

        reader.setLibraryCard(card);
        readerRepository.save(reader);

        return reader;
    }
}
