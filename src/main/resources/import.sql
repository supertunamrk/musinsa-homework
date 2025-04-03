--init categories
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('상의', 'TOP', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('아우터', 'OUTERWEAR', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('바지', 'PANTS', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('스니커즈', 'SNEAKERS', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('가방', 'BAGS', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('모자', 'HEADWEAR', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('양말', 'SOCKS', 'Y');
INSERT INTO category (title_kr, title_en, open_yn) VALUES ('액세서리', 'ACCESSORIES', 'Y');

--init brands
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('A', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('B', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('C', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('D', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('E', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('F', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('G', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('H', '강동원', NOW(), '강동원', NOW());
INSERT INTO brand (name, reg_by, reg_dt, mod_by, mod_dt) VALUES ('I', '강동원', NOW(), '강동원', NOW());

--init products
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 1, 11200, 11.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 2, 5500, 5.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 3, 4200, 4.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 4, 9000, 9.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 5, 2000, 2.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 6, 1700, 1.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 7, 1800, 1.80, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (1, 8, 2300, 2.30, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 1, 10500, 10.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 2, 5900, 5.90, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 3, 3800, 3.80, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 4, 9100, 9.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 5, 2100, 2.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 6, 2000, 2.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 7, 2000, 2.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (2, 8, 2200, 2.20, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 1, 10000, 10.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 2, 6200, 6.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 3, 3300, 3.30, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 4, 9200, 9.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 5, 2200, 2.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 6, 1900, 1.90, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 7, 2200, 2.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (3, 8, 2100, 2.10, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 1, 10100, 10.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 2, 5100, 5.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 3, 3000, 3.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 4, 9500, 9.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 5, 2500, 2.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 6, 1500, 1.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 7, 2400, 2.40, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (4, 8, 2000, 2.00, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 1, 10700, 10.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 2, 5000, 5.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 3, 3800, 3.80, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 4, 9900, 9.90, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 5, 2300, 2.30, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 6, 1800, 1.80, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 7, 2100, 2.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (5, 8, 2100, 2.10, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 1, 11200, 11.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 2, 7200, 7.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 3, 4000, 4.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 4, 9300, 9.30, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 5, 2100, 2.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 6, 1600, 1.60, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 7, 2300, 2.30, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (6, 8, 1900, 1.90, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 1, 10500, 10.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 2, 5800, 5.80, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 3, 3900, 3.90, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 4, 9000, 9.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 5, 2200, 2.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 6, 1700, 1.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 7, 2100, 2.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (7, 8, 2000, 2.00, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 1, 10800, 10.80, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 2, 6300, 6.30, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 3, 3100, 3.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 4, 9700, 9.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 5, 2100, 2.10, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 6, 1600, 1.60, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 7, 2000, 2.00, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (8, 8, 2000, 2.00, '강동원', NOW(), '강동원', NOW());

INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 1, 11400, 11.40, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 2, 6700, 6.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 3, 3200, 3.20, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 4, 9500, 9.50, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 5, 2400, 2.40, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 6, 1700, 1.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 7, 1700, 1.70, '강동원', NOW(), '강동원', NOW());
INSERT INTO product (brand_id, category_id, base_price_krw, base_price_usd, reg_by, reg_dt, mod_by, mod_dt) VALUES (9, 8, 2400, 2.40, '강동원', NOW(), '강동원', NOW());