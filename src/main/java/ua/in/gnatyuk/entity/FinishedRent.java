package ua.in.gnatyuk.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "finished_rent")
public class FinishedRent {
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

    @Column(name = "summ")
    Double summ;

    public FinishedRent(Client client, HotelRoom hotelRoom, Timestamp beginRent, Timestamp endRante, Double summ) {
        this.client = client;
        this.hotelRoom = hotelRoom;
        this.beginRent = beginRent;
        this.endRante = endRante;
        this.summ = summ;
    }

    public FinishedRent() {
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

    public Double getSumm() {
        return summ;
    }

    public void setSumm(Double summ) {
        this.summ = summ;
    }
}
