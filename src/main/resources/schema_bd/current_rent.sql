CREATE TABLE current_rent
(
    begin_rent TIMESTAMP NOT NULL,
    id INTEGER PRIMARY KEY NOT NULL,
    hotel_room INTEGER NOT NULL,
    client INTEGER NOT NULL,
    end_rent TIMESTAMP NOT NULL,
    already_paid INTEGER NOT NULL,
    total_should_pay INTEGER NOT NULL,
    CONSTRAINT current_rent_to_hotel_room_fk FOREIGN KEY (hotel_room) REFERENCES hotel_room (id),
    CONSTRAINT current_rent_to_client_fk FOREIGN KEY (client) REFERENCES contact (id)
);
CREATE UNIQUE INDEX current_rent_id_uindex ON current_rent (id);