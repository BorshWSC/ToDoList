package ru.tpu.msk30.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.msk30.todolist.domain.CheckablePoint;

public interface CheckablePointRepo extends JpaRepository<CheckablePoint, Long> {
}
