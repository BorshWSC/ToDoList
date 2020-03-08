package ru.tpu.msk30.todolist.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id;

    @NonNull
    private String title;

    @NonNull
    private String description;

    @Column(updatable = false)
    private LocalDateTime creationDate;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<CheckablePoint> checkablePoints;
}
