package ru.itmo.etl.cassandra.extract.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Аккаунт пользователя
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false)
    @NotBlank(message = "Имя аккаунта не должно быть пустым")
    @Size(max = 255, message = "Имя аккаунта не должно содержать более 255 символов")
    private String nickname;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Пароль не должен быть пустым")
    @Size(max = 255, message = "Пароль не должен содержать более 255 символов")
    private String password;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "human_id", nullable = false)
    private Human human;

    @Column(name = "bonus_money", nullable = false)
    @Min(value = 0, message = "Количество бонусных миль не может быть меньше нуля")
    private Integer bonusMoney;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Column(name = "violation_count", nullable = false)
    @Min(value = 0, message = "Количество нарушений не может быть меньше нуля")
    @Max(value = 3, message = "Количество нарушений не может быть больше 3")
    private Integer violationCount;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
