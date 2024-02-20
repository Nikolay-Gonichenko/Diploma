package ru.itmo.etl.cassandra.extract.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Билет
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tickets")
public class Ticket {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "human_id")
    private Human human;

    @Column(name = "cost", nullable = false)
    @Min(value = 0, message = "Стоимость билета не может быть меньше 0")
    private Integer cost;

    @Column(name = "place", nullable = false)
    @Size(max = 255, message = "Место в самолёте не должно содержать более 255 символов")
    private String place;

    @OneToMany()
    @JoinColumn(name = "ticket_id")
    private List<Option> options;
}
