package ua.in.gnatyuk.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "current_rent")
public class CurrentRent implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "hotel_room")
    private HotelRoom hotelRoom;

    @OneToOne
    @JoinColumn(name = "client")
    private Client client;


    @Column(name = "begin_rent")
    private Timestamp beginRent;

    @Column(name = "end_rent")
    private Timestamp endRent;

    @Column(name = "already_paid")
    private Double alreadyPaid;

    @Column(name = "total_should_pay")
    private Double totalShouldPay;

    public CurrentRent(HotelRoom hotelRoom, Client client, Timestamp beginRent, Timestamp endRent, Double alreadyPaid, Double totalShouldPay) {
        this.hotelRoom = hotelRoom;
        this.client = client;
        this.beginRent = beginRent;
        this.endRent = endRent;
        this.alreadyPaid = alreadyPaid;
        this.totalShouldPay = totalShouldPay;
    }

    public CurrentRent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HotelRoom getHotelRoom() {
        return hotelRoom;
    }

    public void setHotelRoom(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Timestamp getBeginRent() {
        return beginRent;
    }

    public void setBeginRent(Timestamp beginRent) {
        this.beginRent = beginRent;
    }

    public Timestamp getEndRent() {
        return endRent;
    }

    public void setEndRent(Timestamp endRent) {
        this.endRent = endRent;
    }

    public Double getAlreadyPaid() {
        return alreadyPaid;
    }

    public void setAlreadyPaid(Double alreadyPaid) {
        this.alreadyPaid = alreadyPaid;
    }

    public Double getTotalShouldPay() {
        return totalShouldPay;
    }

    public void setTotalShouldPay(Double totalShouldPay) {
        this.totalShouldPay = totalShouldPay;
    }
}
