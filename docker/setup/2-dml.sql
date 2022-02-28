INSERT INTO sales(item_name,price) VALUES
    ('柔軟剤','178'),
    ('歯磨き粉','138'),
    ('台所用洗剤','198'),
    ('トイレットペーパー','398'),
    ('マスク','298'),
    ('シャンプー','198')
;

INSERT INTO users(name,password) VALUES
    ('misaka','mikoto'),
    ('sirai','kuroko'),
    ('shokuho','misaki')
;

INSERT INTO roles(user_id,name) VALUES
    (1,'USER'),
    (1,'ADMIN'),
    (2,'USER')
;

INSERT INTO authorities(user_id,name) values
    (1,'brows'),
    (1,'register'),
    (2,'delete')
;

INSERT INTO cards(user_id,name) values
    (1,'MISAKA'),
    (1,'KUROKO'),
    (2,'TEITOKU')
;