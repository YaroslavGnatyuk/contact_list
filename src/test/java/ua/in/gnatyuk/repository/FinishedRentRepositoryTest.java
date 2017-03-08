package ua.in.gnatyuk.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.PersistentTestContext;
import ua.in.gnatyuk.entity.Client;
import ua.in.gnatyuk.entity.FinishedRent;
import ua.in.gnatyuk.entity.HotelRoom;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistentTestContext.class})
@ComponentScan("ua.in.gnatyuk")
public class FinishedRentRepositoryTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;
    @Autowired
    FinishedRentRepository finishedRentRepository;

    @Test
    public void createCurrentRent() {
        HotelRoom hotelRoom = new HotelRoom(0, "V.I.P.", 100.00, 15);
        hotelRoom = hotelRoomRepository.save(hotelRoom);

        Client client = new Client("qqq", "www", "eee");
        client = clientRepository.save(client);

        int rentPeriod = 10;

        FinishedRent finishedRent = new FinishedRent();
        LocalDateTime beginRent = LocalDateTime.now();
        LocalDateTime endRent = beginRent.plusDays(rentPeriod);

        finishedRent.setClient(client);
        finishedRent.setHotelRoom(hotelRoom);
        finishedRent.setBeginRent(Timestamp.valueOf(beginRent));
        finishedRent.setEndRante(Timestamp.valueOf(endRent));
        finishedRent.setSumm(hotelRoom.getOneHourCost()*rentPeriod);

        finishedRentRepository.save(finishedRent);
    }
}
