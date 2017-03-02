package ua.in.gnatyuk.service;

import ua.in.gnatyuk.entity.HotelRoom;

public interface HotelRoomService {
    void addNewHotelRoom(HotelRoom hotelRoom);
    long getTotalRoomCount();
    void deleteHotelRoom(HotelRoom hotelRoom);
}
