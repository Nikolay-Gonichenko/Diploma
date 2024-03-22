package ru.itmo.etl.cassandra.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itmo.etl.cassandra.load.model.*;
import ru.itmo.etl.cassandra.load.model.pk.*;
import ru.itmo.etl.cassandra.load.repository.*;
import ru.itmo.etl.cassandra.service.GenerateService;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class GenerateServiceImpl implements GenerateService {

    private final AgeGroupedByFlightFrequencyRepository ageGroupedByFlightFrequencyRepository;
    private final FLightsHumansCostRepository fLightsHumansCostRepository;
    private final OptionsByFlightsTimeRepository optionsByFlightsTimeRepository;
    private final ProfitFlightsRepository profitFlightsRepository;
    private final ProfitableFlightsRoutesRepository profitableFlightsRoutesRepository;



    @Override
    public void generate1() {
        var random = new Random();
        var routes = List.of(
                "Шереметьево(Москва,Россия) - Пулково(Санкт-Петербург,Россия)",
                "Звартноц(Ереван,Армения) - Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия) - Национальный аэропорт Минск(Минск,Республика Беларусь)",
                "Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет) - Международный аэропорт Стамбул(Стамбул,Турция)",
                "Международный аэропорт Каира(Каир,Египет) - Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)",
                "Аэропорт Берлин — Бранденбург имени Вилли Брандта(Берлин,Германия) - Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Галеан(Рио-де-Жанейро,Бразилия) - Международный аэропорт Сидней имени Кингсфорда Смита(Сидней,Австралия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия) - Анкара Эсенбога(Анкара,Турция)",
                "Международный аэропорт Дубай(Дубай,ОАЭ) - Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)",
                "Международный аэропорт Токио(Токио,Япония) - Международный аэропорт Кейптаун(Кейптаун,ЮАР)",
                "Пулково(Санкт-Петербург,Россия) - Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)",
                "Толмачёво(Новосибирск,Россия) - Шереметьево(Москва,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь) - Звартноц(Ереван,Армения)",
                "Международный аэропорт Стамбул(Стамбул,Турция) - Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)",
                "Аэропорт Ла-Гвардия(Нью-Йорк,США) - Международный аэропорт Каира(Каир,Египет)",
                "Толмачёво(Новосибирск,Россия) - Пулково(Санкт-Петербург,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь) - Пулково(Санкт-Петербург,Россия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия) - Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Международный аэропорт Токио(Токио,Япония) - Галеан(Рио-де-Жанейро,Бразилия)",
                "Международный аэропорт Кейптаун(Кейптаун,ЮАР) - Шереметьево(Москва,Россия)",
                "Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия) - Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Елизово(Петропавловск-Камчатский,Россия) - Национальный аэропорт Минск(Минск,Республика Беларусь)"
        );

        var months = List.of(
          "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"
        );

        for (int age = 6; age <= 53; age++) {
            var list = new ArrayList<AgeGroupedByFlightFrequency>();
            for (var route: routes) {
                for (var month: months) {
                    var entity =
                            AgeGroupedByFlightFrequency
                                    .builder()
                                    .ageGroupedByFlightFrequencyPK(
                                            AgeGroupedByFlightFrequencyPK
                                                    .builder()
                                                    .age(age)
                                                    .month(month)
                                                    .route(route)
                                                    .build()
                                    )
                                    .count(random.nextInt(100) + 1)
                                    .build();
                    list.add(entity);
                }
            }
            ageGroupedByFlightFrequencyRepository.saveAll(list);
        }
    }

    @Override
    public void generate2() {
        var random = new Random();
        var routes = List.of(
                "Шереметьево(Москва,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Звартноц(Ереван,Армения)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)_Национальный аэропорт Минск(Минск,Республика Беларусь)",
                "Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)_Международный аэропорт Стамбул(Стамбул,Турция)",
                "Международный аэропорт Каира(Каир,Египет)_Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)",
                "Аэропорт Берлин — Бранденбург имени Вилли Брандта(Берлин,Германия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Галеан(Рио-де-Жанейро,Бразилия)_Международный аэропорт Сидней имени Кингсфорда Смита(Сидней,Австралия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Анкара Эсенбога(Анкара,Турция)",
                "Международный аэропорт Дубай(Дубай,ОАЭ)_Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)",
                "Международный аэропорт Токио(Токио,Япония)_Международный аэропорт Кейптаун(Кейптаун,ЮАР)",
                "Пулково(Санкт-Петербург,Россия)_Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)",
                "Толмачёво(Новосибирск,Россия)_Шереметьево(Москва,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Звартноц(Ереван,Армения)",
                "Международный аэропорт Стамбул(Стамбул,Турция)_Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)",
                "Аэропорт Ла-Гвардия(Нью-Йорк,США)_Международный аэропорт Каира(Каир,Египет)",
                "Толмачёво(Новосибирск,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Пулково(Санкт-Петербург,Россия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Международный аэропорт Токио(Токио,Япония)_Галеан(Рио-де-Жанейро,Бразилия)",
                "Международный аэропорт Кейптаун(Кейптаун,ЮАР)_Шереметьево(Москва,Россия)",
                "Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)_Национальный аэропорт Минск(Минск,Республика Беларусь)"
        );



        var firstDate = LocalDateTime.of(2010, 1, 1, 0, 0);
        var lastDate = LocalDateTime.of(2023, 5, 5, 0, 0);


        for (int flightId = 1000281; flightId < 3_000_000; flightId+=100) {
            var list = new ArrayList<FLightsHumansCost>();
            for (long j = flightId; j < flightId + 100; j++) {
                var startTime = generateRandomLocalDateTimeBetween(firstDate, lastDate);
                var route = getRandomChestItem(routes).split("_");
                for (int k = 0; k < 16; k++) {
                    list.add(
                            FLightsHumansCost
                                    .builder()
                                    .fLightsHumansCostPK(FLightsHumansCostPK
                                            .builder()
                                            .flight(j)
                                            .human((long) (random.nextInt(1936247) + 1))
                                            .cost(random.nextInt(100000 - 1000) + 1000)
                                            .build())
                                    .dateStart(startTime)
                                    .dateFinish(startTime.plusSeconds(random.nextInt(86400) + 3600))
                                    .humanAge(random.nextInt(53 - 6) + 6)
                                    .placeTo(route[0])
                                    .placeFrom(route[1])
                                    .build()
                    );
                }
            }
            fLightsHumansCostRepository.saveAll(list);
            System.out.println("Сохранено. Текущий flightId " + flightId);
        }

    }

    @Override
    public void generate3() {
        var random = new Random();
        var routes = List.of(
                "Шереметьево(Москва,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Звартноц(Ереван,Армения)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)_Национальный аэропорт Минск(Минск,Республика Беларусь)",
                "Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)_Международный аэропорт Стамбул(Стамбул,Турция)",
                "Международный аэропорт Каира(Каир,Египет)_Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)",
                "Аэропорт Берлин — Бранденбург имени Вилли Брандта(Берлин,Германия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Галеан(Рио-де-Жанейро,Бразилия)_Международный аэропорт Сидней имени Кингсфорда Смита(Сидней,Австралия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Анкара Эсенбога(Анкара,Турция)",
                "Международный аэропорт Дубай(Дубай,ОАЭ)_Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)",
                "Международный аэропорт Токио(Токио,Япония)_Международный аэропорт Кейптаун(Кейптаун,ЮАР)",
                "Пулково(Санкт-Петербург,Россия)_Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)",
                "Толмачёво(Новосибирск,Россия)_Шереметьево(Москва,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Звартноц(Ереван,Армения)",
                "Международный аэропорт Стамбул(Стамбул,Турция)_Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)",
                "Аэропорт Ла-Гвардия(Нью-Йорк,США)_Международный аэропорт Каира(Каир,Египет)",
                "Толмачёво(Новосибирск,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Пулково(Санкт-Петербург,Россия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Международный аэропорт Токио(Токио,Япония)_Галеан(Рио-де-Жанейро,Бразилия)",
                "Международный аэропорт Кейптаун(Кейптаун,ЮАР)_Шереметьево(Москва,Россия)",
                "Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)_Национальный аэропорт Минск(Минск,Республика Беларусь)"
        );

        var optionTypes = List.of(
          "Дополнительный багаж", "Премиум класс", "Двойная порция еды", "Негабаритный багаж"
        );

        var firstDate = LocalDateTime.of(2010, 1, 1, 0, 0);
        var lastDate = LocalDateTime.of(2023, 5, 5, 0, 0);

        for (long optionId = 42146700; optionId < 44_560_000; optionId+=100) {
            var list = new ArrayList<OptionsByFlightsTime>();

            for (long j = optionId; j < optionId + 100; j++) {
                var flightTime = random.nextInt(86400) + 3600;
                var startTime = generateRandomLocalDateTimeBetween(firstDate, lastDate);
                var route = getRandomChestItem(routes);
                var placeTo = route.split("_")[0];
                var placeFrom = route.split("_")[1];

                list.add(
                        OptionsByFlightsTime
                                .builder()
                                .optionsByFlightsTimePK(
                                        OptionsByFlightsTimePK
                                                .builder()
                                                .flight((long) (random.nextInt(5_002_045) + 1))
                                                .human((long) (random.nextInt(1936687) + 1))
                                                .option(j)
                                                .flightTime(flightTime / 3600.0)
                                                .build()
                                )
                                .dateStart(startTime)
                                .dateFinish(startTime.plusSeconds(flightTime))
                                .humanAge(random.nextInt(53 - 6) + 6)
                                .optionName(getRandomChestItem(optionTypes))
                                .airportTo(placeTo.split("\\(")[0])
                                .cityTo(placeTo.split("\\(")[1].split(",")[0])
                                .countryTo(placeTo.split("\\(")[1].split(",")[1].replace(")", ""))
                                .airportFrom(placeFrom.split("\\(")[0])
                                .cityFrom(placeFrom.split("\\(")[1].split(",")[0])
                                .countryFrom(placeFrom.split("\\(")[1].split(",")[1].replace(")", ""))
                                .build()
                );
            }
            optionsByFlightsTimeRepository.saveAll(list);
            System.out.println("Сохранено. ИД опции " + optionId);
        }
    }

    @Override
    public void generate4() {
        var random = new Random();

        var routes = List.of(
                "Шереметьево(Москва,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Звартноц(Ереван,Армения)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)_Национальный аэропорт Минск(Минск,Республика Беларусь)",
                "Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)_Международный аэропорт Стамбул(Стамбул,Турция)",
                "Международный аэропорт Каира(Каир,Египет)_Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)",
                "Аэропорт Берлин — Бранденбург имени Вилли Брандта(Берлин,Германия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Галеан(Рио-де-Жанейро,Бразилия)_Международный аэропорт Сидней имени Кингсфорда Смита(Сидней,Австралия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Анкара Эсенбога(Анкара,Турция)",
                "Международный аэропорт Дубай(Дубай,ОАЭ)_Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)",
                "Международный аэропорт Токио(Токио,Япония)_Международный аэропорт Кейптаун(Кейптаун,ЮАР)",
                "Пулково(Санкт-Петербург,Россия)_Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)",
                "Толмачёво(Новосибирск,Россия)_Шереметьево(Москва,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Звартноц(Ереван,Армения)",
                "Международный аэропорт Стамбул(Стамбул,Турция)_Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)",
                "Аэропорт Ла-Гвардия(Нью-Йорк,США)_Международный аэропорт Каира(Каир,Египет)",
                "Толмачёво(Новосибирск,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Пулково(Санкт-Петербург,Россия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Международный аэропорт Токио(Токио,Япония)_Галеан(Рио-де-Жанейро,Бразилия)",
                "Международный аэропорт Кейптаун(Кейптаун,ЮАР)_Шереметьево(Москва,Россия)",
                "Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)_Национальный аэропорт Минск(Минск,Республика Беларусь)"
        );

        var pilotsPositions = List.of("Пилот", "Старший пилот");

        var firstDate = LocalDateTime.of(2010, 1, 1, 0, 0);
        var lastDate = LocalDateTime.of(2023, 5, 5, 0, 0);

        for (long flightId = 1; flightId <= 2_000_002; flightId+=20) {
            var list = new ArrayList<ProfitFlights>();


            for (long j = flightId; j < flightId + 20; j++) {

                var route = getRandomChestItem(routes);
                var routeId = getItemIdFromList(routes, route);
                var startTime = generateRandomLocalDateTimeBetween(firstDate, lastDate);
                var flightTime = random.nextInt(86400) + 3600;

                var pilot = getRandomChestItem(pilotsPositions);
                list.add(
                      ProfitFlights
                              .builder()
                              .profitFlightsPK(
                                  ProfitFlightsPK
                                          .builder()
                                          .flight(j)
                                          .employee((long) (random.nextInt(95002) + 1))
                                          .route(routeId)
                                          .build()
                              )
                              .dateStart(startTime)
                              .dateFinish(startTime.plusSeconds(flightTime))
                              .flightTime(flightTime / 3600.0)
                              .routeName(route)
                              .workTime(random.nextInt(10) + 1)
                              .positionId(5L)
                              .positionName(pilot)
                              .employeeSalary((random.nextInt(200000) + 25000) / 168.0)
                              .build()
                );

                for (int k = 0; k < 4; k++) {
                    var stewardList = List.of("Бортпроводник", "Старший бортпроводник", "Стажёр");
                    var steward = getRandomChestItem(stewardList);

                    list.add(
                            ProfitFlights
                                    .builder()
                                    .profitFlightsPK(
                                            ProfitFlightsPK
                                                    .builder()
                                                    .flight(j)
                                                    .employee((long) (random.nextInt(95002) + 1))
                                                    .route(routeId)
                                                    .build()
                                    )
                                    .dateStart(startTime)
                                    .dateFinish(startTime.plusSeconds(flightTime))
                                    .flightTime(flightTime / 3600.0)
                                    .routeName(route)
                                    .workTime(random.nextInt(10) + 1)
                                    .positionId(6L)
                                    .positionName(steward)
                                    .employeeSalary((random.nextInt(200000) + 25000) / 168.0)
                                    .build()
                    );
                }
            }
            profitFlightsRepository.saveAll(list);
            System.out.println("Сохранено. ИД полёта " + flightId);
        }
    }

    @Override
    public void generate5() {
        var random = new Random();
        var routes = List.of(
                "Шереметьево(Москва,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Звартноц(Ереван,Армения)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)_Национальный аэропорт Минск(Минск,Республика Беларусь)",
                "Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)_Международный аэропорт Стамбул(Стамбул,Турция)",
                "Международный аэропорт Каира(Каир,Египет)_Международный аэропорт Шарм-эль-Шейх(Шарм-эль-Шейх,Египет)",
                "Аэропорт Берлин — Бранденбург имени Вилли Брандта(Берлин,Германия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Галеан(Рио-де-Жанейро,Бразилия)_Международный аэропорт Сидней имени Кингсфорда Смита(Сидней,Австралия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Анкара Эсенбога(Анкара,Турция)",
                "Международный аэропорт Дубай(Дубай,ОАЭ)_Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)",
                "Международный аэропорт Токио(Токио,Япония)_Международный аэропорт Кейптаун(Кейптаун,ЮАР)",
                "Пулково(Санкт-Петербург,Россия)_Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)",
                "Толмачёво(Новосибирск,Россия)_Шереметьево(Москва,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Звартноц(Ереван,Армения)",
                "Международный аэропорт Стамбул(Стамбул,Турция)_Международный аэропорт Порту имени Франсишку Са Карнейру(Порту,Португалия)",
                "Аэропорт Ла-Гвардия(Нью-Йорк,США)_Международный аэропорт Каира(Каир,Египет)",
                "Толмачёво(Новосибирск,Россия)_Пулково(Санкт-Петербург,Россия)",
                "Национальный аэропорт Минск(Минск,Республика Беларусь)_Пулково(Санкт-Петербург,Россия)",
                "Аэропорт Осло, Гардермуэн(Осло,Норвегия)_Аэропорт Ла-Гвардия(Нью-Йорк,США)",
                "Международный аэропорт Токио(Токио,Япония)_Галеан(Рио-де-Жанейро,Бразилия)",
                "Международный аэропорт Кейптаун(Кейптаун,ЮАР)_Шереметьево(Москва,Россия)",
                "Международный аэропорт Сочи имени В. И. Севастьянова(Сочи,Россия)_Толмачёво(Новосибирск,Россия)",
                "Международный аэропорт Елизово(Петропавловск-Камчатский,Россия)_Национальный аэропорт Минск(Минск,Республика Беларусь)"
        );

        var planes = List.of("Малый самолёт", "Большой самолёт", "Аэробус");

        var firstDate = LocalDateTime.of(2010, 1, 1, 0, 0);
        var lastDate = LocalDateTime.of(2023, 5, 5, 0, 0);

        for (long flightId = 1; flightId < 5_002_045; flightId+=100) {
            var list = new ArrayList<ProfitableFlightsRoutes>();

            for(long j = flightId; j < flightId + 100; j++) {
                var route = getRandomChestItem(routes);
                var routeId = getItemIdFromList(routes, route);
                var placeTo = route.split("_")[0];
                var placeFrom = route.split("_")[1];
                var startTime = generateRandomLocalDateTimeBetween(firstDate, lastDate);
                var totalCost = (random.nextInt(100000) + 1000) * 25;
                var totalExpense = (random.nextInt(95002) + 1) * 5 / 168.0;

                list.add(
                        ProfitableFlightsRoutes
                                .builder()
                                .profitableFlightsRoutesPK(
                                        ProfitableFlightsRoutesPK
                                                .builder()
                                                .flight(j)
                                                .route(routeId)
                                                .dateTime(startTime)
                                                .cleanProfit(totalCost - totalExpense)
                                                .build()
                                )
                                .placeTo(placeTo)
                                .placeFrom(placeFrom)
                                .totalCost((double) totalCost)
                                .totalExpense(totalExpense)
                                .planeModel(getRandomChestItem(planes))
                                .build()
                );
            }

            profitableFlightsRoutesRepository.saveAll(list);
            System.out.println("Сохранено. ИД полёта " + flightId);
        }
    }

    public LocalDateTime generateRandomLocalDateTimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        var zone = ZoneOffset.UTC; // Получаем текущий часовой пояс
        var startZonedDateTime = startDateTime.atZone(zone);
        var endZonedDateTime = endDateTime.atZone(zone);

        var startEpochSecond = startZonedDateTime.toEpochSecond();
        var endEpochSecond = endZonedDateTime.toEpochSecond();
        var randomEpochSecond = ThreadLocalRandom.current().nextLong(startEpochSecond, endEpochSecond);

        return LocalDateTime.ofEpochSecond(randomEpochSecond, 0, ZoneOffset.UTC);
    }

    public static String getRandomChestItem(List<String> items) {
        return items.get(new Random().nextInt(items.size()));
    }

    public static Long getItemIdFromList(List<String> items, String item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item))
                return (long) (i + 1);
        }
        return 0L;
    }
}
