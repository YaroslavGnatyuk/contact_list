package ua.in.gnatyuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.entity.Client;

@Transactional(propagation = Propagation.MANDATORY)
public interface ClientRepository extends JpaRepository<Client, Long> {
}
