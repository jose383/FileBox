# FileBox

File storage service using JSTL, JSP and and JDBC (SQL).

## Getting Started

I created new packages with singular names (for ex: models -> model) in case you want to add the files to the current Workspace. It doesn't conflict but I recommend using a separate IDE such as IntelliJ IDEA or creating a new Workspace on Eclipse.

### Installing

Avoid ```web.xml``` file is using the same Workspace as the class. Keep a copy a your web.xml file in case you replace it by mistake.

## Running the tests

Run the HomeServlet in the Controller package or Run the Tomcat server and go to

```
/Home
```

If you Run from IntelliJ IDEA, I already set up so it automatically redirects to Home once the server starts.

The default credentials for the Login Page is:

```
Email: asd
Password: asd
```

[See all Login Credentials Here](http://cs3.calstatela.edu:8080/cs3220stu115/lab7/query.jsp?sql=select+username%2C+password+from+users&query=Execute+Query)

## Deployment

We haven't choose whose server we will use.

## Built With

* [Blocs](https://blocsapp.com) - A fast, easy to use and powerful visual web design tool, that lets you create responsive websites without writing code.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE from JetBrains ([Free Here](https://www.jetbrains.com/student/)).
* [Eclipse for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/release/kepler/sr2/eclipse-ide-java-ee-developers) - IDE.

## Authors

* **Jose Lopez**
* **Hismark Carrera**
* **Roman Arias**