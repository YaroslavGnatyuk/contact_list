package ua.in.gnatyuk.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hotel_room")
public class HotelRoom implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "room_number")
    Integer roomNumber;
    @Column(name = "room_class")// TODO: 3/1/17 I want to use here enumeration
    String roomClass;
    @Column(name = "one_hour_cost")
    Float oneHourCost;
    @Column(name = "floor")
    Integer floor;

    public HotelRoom() {
    }

    public HotelRoom(Integer roomNumber, String roomClass, Float oneHourCost, Integer floor) {
        this.roomNumber = roomNumber;
        this.roomClass = roomClass;
        this.oneHourCost = oneHourCost;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(String roomClass) {
        this.roomClass = roomClass;
    }

    public Float getOneHourCost() {
        return oneHourCost;
    }

    public void setOneHourCost(Float oneHourCost) {
        this.oneHourCost = oneHourCost;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
