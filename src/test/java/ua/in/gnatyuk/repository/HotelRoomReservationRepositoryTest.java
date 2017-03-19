package ua.in.gnatyuk.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.PersistentTestContext;
import ua.in.gnatyuk.entity.Client;
import ua.in.gnatyuk.entity.HotelRoom;
import ua.in.gnatyuk.entity.HotelRoomReservation;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistentTestContext.class})
@ComponentScan("ua.in.gnatyuk")
public class HotelRoomReservationRepositoryTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    HotelRoomReservationRepository reservationRepository;
    @Test
    public void createCurrentRent() {
        HotelRoom hotelRoom = new HotelRoom(0, "V.I.P.", 100.00, 15);
        hotelRoom = hotelRoomRepository.save(hotelRoom);

        Client client = new Client("qqq", "www", "eee");
        clientRepository.save(client);

        int rentPeriod = 10;
        Double prepaid = 500.00;

        HotelRoomReservation roomReservation = new HotelRoomReservation();
        LocalDateTime beginRent = LocalDateTime.now();
        LocalDateTime endRent = beginRent.plusDays(rentPeriod);

        roomReservation.setClient(client);
        roomReservation.setHotelRoom(hotelRoom);
        roomReservation.setBeginRent(Timestamp.valueOf(beginRent));
        roomReservation.setEndRante(Timestamp.valueOf(endRent));
        roomReservation.setPrepaid(prepaid);

        reservationRepository.save(roomReservation);
    }
}
