INSERT INTO USERS (id, username, password, emerald_balance) VALUES (1, 'admin', 'password', 1000);

INSERT INTO CITY (id, city_name) VALUES (1, 'Warsaw');
INSERT INTO CITY (id, city_name) VALUES (2, 'Cracow');
INSERT INTO CITY (id, city_name) VALUES (3, 'Gdansk');
INSERT INTO CITY (id, city_name) VALUES (4, 'Wroclaw');
INSERT INTO CITY (id, city_name) VALUES (5, 'Poznan');
INSERT INTO CITY (id, city_name) VALUES (6, 'Katowice');
INSERT INTO CITY (id, city_name) VALUES (7, 'Lodz');
INSERT INTO CITY (id, city_name) VALUES (8, 'Lublin');
INSERT INTO CITY (id, city_name) VALUES (9, 'Rzeszow');
INSERT INTO CITY (id, city_name) VALUES (10, 'Szczecin');

INSERT INTO CAMPAIGN (campaign_name, keywords, bid_amount, campaign_fund, status, city_id, radius, user_id)
VALUES ('Tech Conference Promo', 'tech,conference,startup', 4.0, 120, true, 1, 10, 1);

INSERT INTO CAMPAIGN (campaign_name, keywords, bid_amount, campaign_fund, status, city_id, radius, user_id)
VALUES ('Fitness Gear Sale', 'fitness,gym,health', 2.5, 180, true, 2, 12, 1);

INSERT INTO CAMPAIGN (campaign_name, keywords, bid_amount, campaign_fund, status, city_id, radius, user_id)
VALUES ('Gaming Laptop Ads', 'gaming,laptop,performance', 5.5, 250, false, 3, 20, 1);
