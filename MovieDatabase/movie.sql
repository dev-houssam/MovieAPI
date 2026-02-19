@Entity
CREATE Movie IF NOT EXISTS {
    id PRIMARY KEY INTEGER AUTO_INCREMENT,
    promo              INTEGER    ,
    age_minimum        INTEGER    ,
    annee_realisation  varchar(255)  ,
    genre              varchar(255)  ,
    prix_location      INTEGER    ,
    simple_date        date          ,
    titre              varchar(255)
}
