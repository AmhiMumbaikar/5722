INSERT INTO Price (price_id, amount, currency_code)
VALUES (1, 100, 'Eur');
INSERT INTO Price (price_id, amount, currency_code)
VALUES (2, 200, 'Eur');

INSERT INTO SEGMENT (segment_id, arrival_code, arrival_date, departure_code, departure_date, duration_in_minutes,
                     flight_no, travel_class, waiting_time_in_minutes, price_id, score)
VALUES ('BOM-DUB-2022-09-03-2022-09-03-1234', 'DUB', '2022-09-03', 'BOM', '2022-09-03', 600, 1234, 'Economy', 0, 1,
        0.7);

INSERT INTO SEGMENT (segment_id, arrival_code, arrival_date, departure_code, departure_date, duration_in_minutes,
                     flight_no, travel_class, waiting_time_in_minutes, price_id, score)
VALUES ('DUB-BOM-2022-10-03-2022-10-03-5678', 'BOM', '2022-10-03', 'DUB', '2022-10-03', 600, 5678, 'Economy', 0, 2,
        0.7);