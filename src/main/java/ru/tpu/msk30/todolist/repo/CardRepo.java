package ru.tpu.msk30.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.msk30.todolist.domain.Card;

public interface CardRepo extends JpaRepository<Card, Long> {
}
