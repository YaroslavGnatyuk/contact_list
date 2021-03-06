package ua.in.gnatyuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.in.gnatyuk.entity.HotelRoom;

@Transactional(propagation = Propagation.MANDATORY)
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
}
