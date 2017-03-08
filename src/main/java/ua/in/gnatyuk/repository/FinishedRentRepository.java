package ua.in.gnatyuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.entity.FinishedRent;

@Transactional(propagation = Propagation.MANDATORY)
public interface FinishedRentRepository extends JpaRepository<FinishedRent, Long> {
}
