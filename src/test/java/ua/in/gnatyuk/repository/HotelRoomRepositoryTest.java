package ua.in.gnatyuk.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.configuration.PersistentTestContext;
import ua.in.gnatyuk.entity.HotelRoom;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("ua.in.gnatyuk")
@ContextConfiguration(classes = {PersistentTestContext.class})
public class HotelRoomRepositoryTest {
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    @Test
    public void createNewHotelRoom() {
        HotelRoom hotelRoom = new HotelRoom(0, "V.I.P.", 100.00, 15);
        long roomsCountBefore = hotelRoomRepository.count();
        hotelRoomRepository.save(hotelRoom);
        long roomsCountAfter = hotelRoomRepository.count();
        assertTrue(roomsCountBefore < roomsCountAfter);
        System.out.println("Rooms before" + roomsCountBefore);
        System.out.println("Rooms after" + roomsCountAfter);
    }
}
