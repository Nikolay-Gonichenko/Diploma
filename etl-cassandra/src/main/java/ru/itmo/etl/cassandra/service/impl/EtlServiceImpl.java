package ru.itmo.etl.cassandra.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itmo.etl.cassandra.extract.model.Crew;
import ru.itmo.etl.cassandra.extract.model.Option;
import ru.itmo.etl.cassandra.extract.model.Ticket;
import ru.itmo.etl.cassandra.extract.repository.CrewRepository;
import ru.itmo.etl.cassandra.extract.repository.FlightRepository;
import ru.itmo.etl.cassandra.extract.repository.OptionRepository;
import ru.itmo.etl.cassandra.extract.repository.TicketRepository;
import ru.itmo.etl.cassandra.load.threads.EtlCrewThread;
import ru.itmo.etl.cassandra.load.threads.EtlOptionThread;
import ru.itmo.etl.cassandra.load.threads.EtlThread;
import ru.itmo.etl.cassandra.service.EtlService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EtlServiceImpl implements EtlService {

    private final TicketRepository ticketRepository;
    private final CrewRepository crewRepository;
    private final OptionRepository optionRepository;
    private final AgeGroupedByFlightFrequencyService ageGroupedByFlightFrequencyService;
    private final FLightsHumansCostService fLightsHumansCostService;
    private final OptionsByFlightsTimeService optionsByFlightsTimeService;
    private final ProfitFlightsService profitFlightsService;

    @Override
    public void start() {
        System.out.println("Запрос пришёл");
        var pageSize = 1000;
        var pageNumber = 70030;

        System.out.println("Выполнен стартовый запрос к ticketRepository");
        var ticketPage = ticketRepository.findAll(PageRequest.of(pageNumber, pageSize));
        System.out.println("Выполнен стартовый запрос к crewRepository");
        var crewPage = crewRepository.findAll(PageRequest.of(pageNumber, pageSize));
        System.out.println("Выполнен стартовый запрос к optionRepository");
        var optionPage = optionRepository.findAll(PageRequest.of(pageNumber, pageSize));
        var threads = createThreads();
        System.out.println("Потоки созданы.");
        var threadss = new Thread[5];
        while (ticketPage.hasContent() && pageNumber < 75000) {
            var tickets = ticketPage.getContent();
            var crews = crewPage.getContent();
            var options = optionPage.getContent();
            System.out.println("Получены данные из всех репо. Страница " + pageNumber);

            setDataToThreads(threads, tickets, crews, options);

            try {
                System.out.println("Потоки запущены.");
                for (int i = 0; i < threads.size(); i++) {
                    var thread = new Thread(threads.get(i));
                    threadss[i] = thread;
                    threadss[i].start();
                }

                for (int j = 0; j < threads.size(); j++) {
                    try {
                        threadss[j].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Все потоки отработали по странице " + pageNumber);
            } catch (Exception e) {
                e.printStackTrace();
            }


            pageNumber++;
            ticketPage = ticketRepository.findAll(PageRequest.of(pageNumber, pageSize));
            crewPage = crewRepository.findAll(PageRequest.of(pageNumber, pageSize));
            optionPage = optionRepository.findAll(PageRequest.of(pageNumber, pageSize));
        }

    }

    private void setDataToThreads(List<Runnable> threads,
                                  List<Ticket> tickets,
                                  List<Crew> crews,
                                  List<Option> options) {
        for (int i = 0; i < 2; i++) {
            ((EtlThread) threads.get(i)).setTickets(tickets);
        }
        ((EtlOptionThread) threads.get(2)).setOptions(options);

        ((EtlCrewThread) threads.get(3)).setCrews(crews);
        System.out.println("установлены данные в потоки.");
    }

    private List<Runnable> createThreads() {
        var thread1 = new EtlThread(ageGroupedByFlightFrequencyService);
        var thread2 = new EtlThread(fLightsHumansCostService);
        var thread3 = new EtlOptionThread(optionsByFlightsTimeService);
        var thread4 = new EtlCrewThread(profitFlightsService);

        return new ArrayList<>(List.of(thread1, thread2, thread3, thread4));
    }
}
