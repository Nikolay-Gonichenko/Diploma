package ru.itmo.etl.cassandra.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.etl.cassandra.service.EtlService;
import ru.itmo.etl.cassandra.service.GenerateService;

/**
 * Контроллер для входа/регистрации пользователя
 * */
@RestController
@RequestMapping("cassandra/start")
@RequiredArgsConstructor
public class StartController {

    private final EtlService etlService;
    private final GenerateService generateService;


    @PostMapping("")
    public void start() {
        etlService.start();
    }

    @PostMapping("generate1")
    public void generateQuery1() {
        generateService.generate1();
    }

    @PostMapping("generate2")
    public void generateQuery2() {
        generateService.generate2();
    }

    @PostMapping("generate3")
    public void generateQuery3() {
        generateService.generate3();
    }

    @PostMapping("generate4")
    public void generateQuery4() {
        generateService.generate4();
    }

    @PostMapping("generate5")
    public void generateQuery5() {
        generateService.generate5();
    }


}
