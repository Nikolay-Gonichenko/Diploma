package ru.itmo.etl.cassandra.extract.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Полёт
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_start", nullable = false)
    private LocalDateTime dateStart;

    @Column(name = "date_finish", nullable = false)
    private LocalDateTime dateFinish;

    @ManyToOne
    @JoinColumn(name = "flight_status_id", nullable = false)
    private FlightStatus flightStatus;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @OneToMany()
    @JoinColumn(name = "flight_id")
    private List<Ticket> tickets;

    @ManyToMany()
    @JoinTable(name="crew",
            joinColumns=  @JoinColumn(name="flight_id", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="employee_id", referencedColumnName="id") )
    private List<Employee> employees;
}
