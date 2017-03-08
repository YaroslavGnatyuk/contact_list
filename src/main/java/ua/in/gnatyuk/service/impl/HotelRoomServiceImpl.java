package ua.in.gnatyuk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.gnatyuk.entity.HotelRoom;
import ua.in.gnatyuk.repository.HotelRoomRepository;
import ua.in.gnatyuk.service.HotelRoomService;

@Service
public class HotelRoomServiceImpl implements HotelRoomService {
    @Autowired
    HotelRoomRepository hotelRoomRepository;

    @Override
    public void addNewHotelRoom(HotelRoom hotelRoom) {
        hotelRoomRepository.save(hotelRoom);
    }

    @Override
    public long getTotalRoomCount() {
        return hotelRoomRepository.count();
    }

    @Override
    public void deleteHotelRoom(HotelRoom hotelRoom) {
        hotelRoomRepository.delete(hotelRoom);
    }


}
