# E-commerce - Add product details
Based on the previous implementation, the app provides a form to add product details or view the product details for a product which already exists. Even though that persistance was not required the three additional fields of product details are saved in a designated database table with a relationship of one-to-one to the main product table sharing a mapped Id.
All the product details fields are optional. The user is informed if the product details he just entered were saved correctly or if an error occurred. The product details are saved in a dedicated ProductDetails object which is persisted through Hibernate in the already existing MySql database.
The saved product details are also retrieved through Hibernate to be displayed on a separate product details page.

GitHub repository:
https://github.com/dthill/java-ee-practice
