package ua.in.gnatyuk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ua.in.gnatyuk.entity.HotelRoom;

@Component
//@Transactional(propagation = Propagation.MANDATORY)
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Long> {
}
