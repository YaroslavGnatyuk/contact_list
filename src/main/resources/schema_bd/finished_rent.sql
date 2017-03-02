CREATE TABLE finished_rent
(
    id INTEGER PRIMARY KEY NOT NULL,
    begin_rent TIMESTAMP NOT NULL,
    end_rent TIMESTAMP NOT NULL,
    summ INTEGER NOT NULL,
    client INTEGER NOT NULL,
    hotel_room INTEGER NOT NULL,
    CONSTRAINT finished_rent_to_client_fk FOREIGN KEY (client) REFERENCES contact (id),
    CONSTRAINT finished_rent_to_hotel_room_fk FOREIGN KEY (hotel_room) REFERENCES hotel_room (id)
);
CREATE UNIQUE INDEX finished_rent_id_uindex ON finished_rent (id);