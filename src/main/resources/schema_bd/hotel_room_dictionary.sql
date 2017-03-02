CREATE TABLE hotel_room
(
    id INTEGER PRIMARY KEY NOT NULL,
    room_number INTEGER NOT NULL,
    room_class VARCHAR(25) NOT NULL,
    one_hour_cost INTEGER NOT NULL,
    floor INTEGER NOT NULL
);