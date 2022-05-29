# E-commerce
This Java EE app uses a MySql database to search a small list of products, either by their exact Product ID number or by partially matching their product name.
The database is run using a docker container with a Docker-compose file. To start the databse and auto-populate it with data run ` docker composer up ` which will start the docker container containing the MySql server and run the db/init.sql query which creates the table and adds the products.
The products' page can be reached by the link on the main page or by directly going to .../products.jsp

GitHub repository:
https://github.com/dthill/java-ee-practice
