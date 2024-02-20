package ru.itmo.diplomaairline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.diplomaairline.model.entity.Document;
import ru.itmo.diplomaairline.model.entity.Human;
import ru.itmo.diplomaairline.repository.DocumentRepository;
import ru.itmo.diplomaairline.repository.HumanRepository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Контроллер для генерации данных
 * */
@RestController
@RequestMapping("api/v1/airline/generate")
public class GenerateController {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private HumanRepository humanRepository;

    @PostMapping("human")
    public ResponseEntity<Boolean> generateHumans() {
        LocalDate dateStart = LocalDate.parse("1970-01-01");
        LocalDate dateFinish = LocalDate.parse("2003-12-30");
        List<String> names = new ArrayList<>(List.of("Николай", "Пётр", "Дмитрий", "Михаил", "Ярослав", "Никита", "Олег", "Леонид", "Артём"));
        List<String> surnames = new ArrayList<>(List.of("Петров", "Дмитриенко", "Мирохин", "Волков", "Воробьёв", "Лесов", "Рожков"));
        List<String> lastNames = new ArrayList<>(List.of("Иванович", "Маратович", "Александрович", "Максимович", "Олегович", "Юрьевич"));
        for (Document document: documentRepository.findAll()) {
            Human human = new Human();
            human.setName(names.get(0));
            human.setSurname(surnames.get(0));
            human.setLastName(lastNames.get(0));
            human.setDocument(document);
            human.setBirthDate(java.sql.Date.valueOf(between(dateStart, dateFinish)));
            humanRepository.save(human);
            Collections.shuffle(names);
            Collections.shuffle(surnames);
            Collections.shuffle(lastNames);
        }
        return ResponseEntity.ok(true);
    }

    private LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
