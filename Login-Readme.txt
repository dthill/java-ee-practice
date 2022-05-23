# Login Page
This JavaEE App implements a very simple Login page that establishes a session with the users email saved in it. If the user logs in with test@test.com and the password test he will be able to access the landing page and the dashboard from where he can log out.
If the user tries to access the landing page or the dashboard before he is logged in, a filter will stop him and redirect him to the login page. The login will also display an error message if applicable that was saved as a request attribute.git add .


GitHub Repository:
https://github.com/dthill/java-ee-practice
