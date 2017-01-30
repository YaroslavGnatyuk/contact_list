CREATE TABLE hotel_room (
    id id_hotel_room PRIMARY KEY,
    room_number integer NOT NULL,
    room_class varchar(25) NOT NULL,
    one_hour_cost integer NOT NULL,
    floor integer NOT NULL
);