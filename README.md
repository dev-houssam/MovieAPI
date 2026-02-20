# MovieAPI
MovieAPI : a movie api

Afficher la structure de la table movie 


DESCRIBE movie;


Pour inserer dans la base de données :
INSERT INTO movie (id, promo, age_minimum, annee_realisation, genre, prix_location, simple_date, titre) VALUES (NULL, 3, 6, "2003", "Action", 23, "2003-11-12", "Chat GPT, le mortel");


API :

https://github.com/dev-houssam/MovieAPI

https://github.com/dev-houssam/HeyGatewayBySpring

https://github.com/dev-houssam/FrontendAPIGestionReservationsFilm

https://github.com/dev-houssam/PaymentAPI


# PORTS (uniquement dédiés au HEY)

Plage de port (HEY) en production(/developpement) : 

12100 - 12119

Répartition par API : 
- GatewayAPI : 12100 -> host : http://localhost:12100
- MovieAPI : 12101   -> host : http://localhost:12101
- Paymentapi : 12102    -> host : http://localhost:12102
- ArtistAPI : 12103  -> host : http://localhost:12103
- UserAPI : 12104   -> host : http://localhost:12104
- Frontend : 12105   -> host : http://localhost:12105


Note : Pour Frontend, possible reverse proxy vers 80.

