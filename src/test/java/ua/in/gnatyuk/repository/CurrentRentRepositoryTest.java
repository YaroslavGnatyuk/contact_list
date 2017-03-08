package ua.in.gnatyuk.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.PersistentTestContext;
import ua.in.gnatyuk.entity.Client;
import ua.in.gnatyuk.entity.CurrentRent;
import ua.in.gnatyuk.entity.HotelRoom;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistentTestContext.class})
@ComponentScan("ua.in.gnatyuk")
public class CurrentRentRepositoryTest {
    @Autowired
    CurrentRentRepository currentRentRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    @Test
    public void createCurrentRent(){
        HotelRoom hotelRoom = new HotelRoom(0,"V.I.P.",100.00,15);
        hotelRoom = hotelRoomRepository.save(hotelRoom);
        System.out.println(hotelRoom);

        Client client = new Client("qqq", "www", "eee");
        client = clientRepository.save(client);

        int rentPeriod = 10;

        CurrentRent currentRent = new CurrentRent();
        LocalDateTime beginRent = LocalDateTime.now();
        LocalDateTime endRent = beginRent.plusDays(rentPeriod);

        currentRent.setClient(client);
        currentRent.setHotelRoom(hotelRoom);
        currentRent.setBeginRent(Timestamp.valueOf(beginRent));
        currentRent.setEndRent(Timestamp.valueOf(endRent));
        currentRent.setAlreadyPaid(100.00);
        currentRent.setTotalShouldPay(hotelRoom.getOneHourCost()*rentPeriod);

        currentRentRepository.save(currentRent);

    }
}
