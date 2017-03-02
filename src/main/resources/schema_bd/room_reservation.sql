CREATE TABLE room_reservation
(
  id INTEGER PRIMARY KEY NOT NULL,
  client INTEGER NOT NULL,
  hotel_room INTEGER NOT NULL,
  begin_rent TIMESTAMP NOT NULL,
  end_rent TIMESTAMP NOT NULL,
  prepaid INTEGER NOT NULL,
  CONSTRAINT room_reservation_to_client_fk FOREIGN KEY (client) REFERENCES contact (id),
  CONSTRAINT room_reservation_to_hotel_room_fk FOREIGN KEY (hotel_room) REFERENCES hotel_room (id)
);
CREATE UNIQUE INDEX room_reservation_id_uindex ON room_reservation (id);