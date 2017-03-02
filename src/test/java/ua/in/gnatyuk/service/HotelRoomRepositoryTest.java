package ua.in.gnatyuk.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ua.in.gnatyuk.entity.HotelRoom;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan("ua.in.gnatyuk")
@ContextConfiguration(classes = {HotelRoomServiceImpl.class, HotelRoomService.class})
public class HotelRoomRepositoryTest {
    @Autowired
    HotelRoomService hotelRoomService;

    @Test
    public void addNewHotelRoom() {
        HotelRoom newRoom = new HotelRoom(1, "VIP", 10F, 100);
        hotelRoomService.addNewHotelRoom(newRoom);
        long count = hotelRoomService.getTotalRoomCount();
        assertTrue(count >= 1);
        hotelRoomService.deleteHotelRoom(newRoom);
    }
}
