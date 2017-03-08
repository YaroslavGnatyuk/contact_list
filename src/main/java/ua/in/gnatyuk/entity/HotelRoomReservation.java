package ua.in.gnatyuk.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "room_reservation")
public class HotelRoomReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @OneToOne
    @JoinColumn(name = "client")
    Client client;

    @OneToOne
    @JoinColumn(name = "hotel_room")
    HotelRoom hotelRoom;

    @Column(name = "begin_rent")
    Timestamp beginRent;

    @Column(name = "end_rent")
    Timestamp endRante;

    @Column(name = "prepaid")
    Double prepaid;

    public HotelRoomReservation(Client client, HotelRoom hotelRoom, Timestamp beginRent, Timestamp endRante, Double prepaid) {
        this.client = client;
        this.hotelRoom = hotelRoom;
        this.beginRent = beginRent;
        this.endRante = endRante;
        this.prepaid = prepaid;
    }

    public HotelRoomReservation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public Timestamp getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Timestamp beginRent) {
        this.beginRent = beginRent;
    }

    public Timestamp getEndRante() {
        return endRante;
    }

    public void setEndRante(Timestamp endRante) {
        this.endRante = endRante;
    }

    public Double getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(Double prepaid) {
        this.prepaid = prepaid;
    }
}
