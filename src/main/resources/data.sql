INSERT INTO TENANTS (id_tenant, name) VALUES
    (1, 'Najemca1'),
    (2, 'Najemca2'),
    (3, 'Najemca3'),
    (4, 'Najemca4'),
    (5, 'Najemca5'),
    (6, 'Najemca6'),
    (7, 'Najemca7'),
    (8, 'Najemca8');

INSERT INTO LANDLORDS (id_landlord, name) VALUES
    (1, 'Wynajmujacy1'),
    (2, 'Wynajmujacy2'),
    (3, 'Wynajmujacy3');

INSERT INTO PROPERTIES (id_property, name, price, rent_area, description) VALUES
    (1, 'Obiekt1', 5000.00, 72.00, 'Mieszkanie'),
    (2, 'Obiekt2', 5000.00, 65.00, 'Lokal'),
    (3, 'Obiekt3', 4000.00, 42.00, 'Mieszkanie'),
    (4, 'Obiekt4', 8500.00, 120.00, 'Lokal'),
    (5, 'Obiekt5', 9000.00, 130.00, 'Mieszkanie'),
    (6, 'Obiekt6', 3500.00, 35.00, 'Lokal');

INSERT INTO RESERVATIONS (id_reservation, id_tenant, id_landlord, id_property, rental_period_start, rental_period_end, price) VALUES
    (1, 1, 1, 2, '2022-07-01', '2022-08-31', 5000.00),
    (2, 2, 2, 3, '2022-08-01', '2022-09-30', 4000.00),
    (3, 3, 3, 1, '2022-02-01', '2022-10-31', 5000.00),
    (4, 4, 3, 4, '2022-04-01', '2022-12-31', 8500.00),
    (5, 5, 1, 5, '2022-07-01', '2022-08-31', 9000.00);