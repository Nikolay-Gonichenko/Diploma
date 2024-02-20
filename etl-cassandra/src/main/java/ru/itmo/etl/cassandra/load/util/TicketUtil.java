package ru.itmo.etl.cassandra.load.util;

import org.springframework.stereotype.Component;
import ru.itmo.etl.cassandra.extract.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

@Component
public class TicketUtil {

    /**
     * Получает разницу в годах между датой вылета и датой рождения по билету
     * @param ticket билету
     * @return разница в годах
     */
    public Integer getAgeFromTicket(Ticket ticket) {
        var dateStart = ticket.getFlight().getDateStart();
        var dateBirth = ticket.getHuman().getBirthDate();
        return dateStart.getYear() - dateBirth.getYear();
    }

    /**
     * Получает строковое представление маршрута
     * @param route маршрут
     * @return строковое представление маршрута
     */
    public String getRouteStrFromRoute(Route route) {
        var locationFrom = route.getFromLocation();
        var locationTo = route.getToLocation();

        var stringBuilder = new StringBuilder();

        return stringBuilder.append(locationFrom.getAirport())
                            .append("(")
                            .append(locationFrom.getCity())
                            .append(", ")
                            .append(locationFrom.getCountry())
                            .append(") - ")
                            .append(locationTo.getAirport())
                            .append("(")
                            .append(locationTo.getCity())
                            .append(", ")
                            .append(locationTo.getCountry())
                            .append(")")
                            .toString();
    }

    /**
     *
     * @param date
     * @return
     */
    public String getMonthFromDate(LocalDateTime date) {
        return date.getMonth().name();
    }

    public String getLocationName(Location location) {
        var stringBuilder = new StringBuilder();

        return stringBuilder.append(location.getAirport())
                .append("(")
                .append(location.getCity())
                .append(", ")
                .append(location.getCountry())
                .append(")")
                .toString();
    }

    public Double getFlightTime(Flight flight) {
        var dateFinish = flight.getDateFinish();
        var dateStart = flight.getDateStart();
        long secondsDifference = ChronoUnit.SECONDS.between(dateStart, dateFinish);
        double hoursDifference = secondsDifference / 3600.0;
        return Math.round(hoursDifference * 10.0) / 10.0;
    }

    public Integer getWorkTime(Employee employee, Flight flight) {
        var employeeDate = employee.getEmploymentDate();
        var dateStart = flight.getDateStart();
        var secondsDifference = ChronoUnit.SECONDS.between(dateStart, employeeDate);
        var yearDiff = secondsDifference / (3600 * 24 * 365);
        return (int) Math.abs(Math.round(yearDiff * 10.0) / 10);
    }


}
