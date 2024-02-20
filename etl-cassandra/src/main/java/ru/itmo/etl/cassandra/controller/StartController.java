package ru.itmo.etl.cassandra.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.etl.cassandra.service.EtlService;

/**
 * Контроллер для входа/регистрации пользователя
 * */
@RestController
@RequestMapping("cassandra/start")
@RequiredArgsConstructor
public class StartController {

    private final EtlService etlService;


    @PostMapping("")
    public void start() {
        etlService.start();
    }
}
