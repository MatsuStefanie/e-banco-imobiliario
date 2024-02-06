-- auto-generated definition
create table player
(
    id int auto_increment
        primary key
);

INSERT INTO monopoly_mysql.player (id) VALUES (1);
INSERT INTO monopoly_mysql.player (id) VALUES (2);
INSERT INTO monopoly_mysql.player (id) VALUES (3);
INSERT INTO monopoly_mysql.player (id) VALUES (4);
INSERT INTO monopoly_mysql.player (id) VALUES (5);
INSERT INTO monopoly_mysql.player (id) VALUES (6);


-- auto-generated definition
create table account
(
    id        int auto_increment
        primary key,
    balance   int null,
    player_id int null,
    constraint UK_kg7vik887ogx8sjjdvi3odvjp
        unique (player_id),
    constraint FKd9r47sf57y28sijw2wnbrab1f
        foreign key (player_id) references player (id)
);

INSERT INTO monopoly_mysql.account (id, balance, player_id) VALUES (1, 0, 1);
INSERT INTO monopoly_mysql.account (id, balance, player_id) VALUES (2, 0, 2);
INSERT INTO monopoly_mysql.account (id, balance, player_id) VALUES (3, 0, 3);
INSERT INTO monopoly_mysql.account (id, balance, player_id) VALUES (4, 0, 4);
INSERT INTO monopoly_mysql.account (id, balance, player_id) VALUES (5, 0, 5);
INSERT INTO monopoly_mysql.account (id, balance, player_id) VALUES (6, 0, 6);


-- auto-generated definition
create table street
(
    id                        bigint       not null
        primary key,
    amount_buy_property       int          null,
    mortgage_amount           int          null,
    name                      varchar(255) null,
    buildings_made            int          null,
    buy_home_amount           int          null,
    buy_hotel_amount          int          null,
    rental_amount             int          null,
    rental_four_house_amount  int          null,
    rental_hotel_amount       int          null,
    rental_one_house_amount   int          null,
    rental_three_house_amount int          null,
    rental_two_house_amount   int          null,
    player_id                 int          null,
    constraint FKsnexojvfmm8nb41yujtk1ixoa
        foreign key (player_id) references player (id)
);


INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (1, 1000, 500, 'Av 9 de julho', 0, 500, 500, 60, 4000, 5000, 300, 2700, 900, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (2, 750, 500, 'Av Beira Mar', 0, 500, 500, 20, 1600, 2500, 100, 900, 300, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (3, 600, 500, 'Av Brasil', 0, 500, 500, 40, 3200, 4500, 200, 1800, 600, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (4, 2400, 1200, 'Av Rio Branco', 0, 1500, 1500, 200, 9250, 11000, 1000, 7500, 3000, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (5, 1800, 1000, 'Rua da Consolação', 0, 1000, 1000, 140, 7500, 9500, 700, 5500, 2000, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (6, 2000, 1000, 'Av Rebouças', 0, 1000, 1000, 160, 8000, 10000, 800, 6000, 2200, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (7, 2200, 1100, 'Av do Estado', 0, 1500, 1500, 180, 8750, 10500, 900, 7000, 2500, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (8, 2200, 1100, 'Av do Contorno', 0, 1500, 1500, 180, 8750, 10500, 900, 7000, 2500, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (9, 1800, 1000, 'Av Santo Amaro', 0, 1000, 1000, 140, 7500, 9500, 700, 5500, 2000, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (10, 4000, 2000, 'Av Morumbi', 0, 2000, 2000, 500, 17000, 20000, 2000, 14000, 6000, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (11, 3500, 1750, 'Av Higienópolis', 0, 2000, 2000, 350, 13000, 15000, 1750, 14000, 5000, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (12, 1000, 500, 'Av Ipiranga', 0, 500, 500, 60, 4000, 5000, 300, 2700, 900, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (13, 1400, 700, 'Av Recife', 0, 1000, 1000, 100, 6250, 7500, 500, 4500, 1500, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (14, 1400, 700, 'Av Brigadeiro Faria Lima', 0, 1000, 1000, 100, 6250, 7500, 500, 4500, 1500, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (15, 1600, 800, 'Av Paulista', 0, 1000, 1000, 120, 7000, 9000, 600, 5000, 1800, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (16, 1200, 600, 'Av São João', 0, 500, 500, 80, 4500, 6000, 400, 3000, 1000, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (17, 3200, 1600, 'Av Juscelino Kubitschek', 0, 2000, 2000, 280, 12000, 14000, 1500, 10000, 4500, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (18, 3000, 1500, 'Av Oscar Freire', 0, 2000, 2000, 260, 11000, 12750, 1300, 9000, 3900, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (19, 3000, 1500, 'Av Ibirapuera', 0, 2000, 2000, 260, 11000, 12750, 1300, 9000, 3900, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (20, 2800, 1400, 'Av Vieira Souto', 0, 1500, 1500, 260, 10250, 12000, 1300, 8500, 3600, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (21, 2600, 1300, 'Av Presidente Vargas', 0, 1500, 1500, 220, 9750, 11500, 1100, 8000, 3300, null);
INSERT INTO monopoly_mysql.street (id, amount_buy_property, mortgage_amount, name, buildings_made, buy_home_amount, buy_hotel_amount, rental_amount, rental_four_house_amount, rental_hotel_amount, rental_one_house_amount, rental_three_house_amount, rental_two_house_amount, player_id) VALUES (22, 2600, 1300, 'Av Niemeyer', 0, 1500, 1500, 220, 9750, 11500, 1100, 8000, 3300, null);


-- auto-generated definition
create table notice
(
    id_notice     int auto_increment
        primary key,
    is_misfortune bit          not null,
    notice        varchar(255) null,
    value         int          null
);

INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (1, true, null, 1000);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (2, true, null, 1000);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (3, true, null, 150);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (4, true, null, 200);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (5, true, null, 200);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (6, true, null, 220);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (7, true, null, 300);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (8, true, null, 300);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (9, true, null, 400);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (10, true, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (11, true, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (12, true, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (13, true, null, 90);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (14, true, null, 250);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (15, false, null, 1500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (16, false, null, 1000);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (17, false, null, 1000);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (18, false, null, 1000);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (19, false, null, 1500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (20, false, null, 200);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (21, true, null, 300);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (22, false, null, 450);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (23, false, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (24, false, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (25, false, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (26, false, null, 500);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (27, false, null, 600);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (28, false, null, 750);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (29, false, null, 800);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (30, false, null, 800);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (31, false, null, 0);
INSERT INTO monopoly_mysql.notice (id_notice, is_misfortune, notice, value) VALUES (32, true, null, 0);
