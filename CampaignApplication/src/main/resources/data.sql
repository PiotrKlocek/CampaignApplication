
INSERT INTO USERS (id, username, password, emerald_balance) VALUES (1, 'admin', 'password', 1000);

INSERT INTO CAMPAIGN (id, campaign_name, keywords, bid_amount, campaign_fund, status, city, radius, user_id)
VALUES (1, 'Tech Conference Promo', 'tech,conference,startup', 4.0, 120, true, 'Warsaw', 10, 1);

INSERT INTO CAMPAIGN (id, campaign_name, keywords, bid_amount, campaign_fund, status, city, radius, user_id)
VALUES (2, 'Fitness Gear Sale', 'fitness,gym,health', 2.5, 180, true, 'Krakow', 12, 1);

INSERT INTO CAMPAIGN (id, campaign_name, keywords, bid_amount, campaign_fund, status, city, radius, user_id)
VALUES (3, 'Gaming Laptop Ads', 'gaming,laptop,performance', 5.5, 250, false, 'Gdansk', 20, 1);
