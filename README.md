# todoapp


Aim of the project:
To Implement a simple todo application 

It is done by  NetBeans (8.0.2) development environment as a Maven project.GUI part is done with html. 

•	Spring Boot, 
•	JPA Repository, 
•	Java JDK 1.8
•	H2 database is used

I used H2 because it was easy to use and no need to install any database. But it stores all the data after every run of the project. 

Project structure is the same as in here github.

How to run project? Here is the steps:

With a development tool:
   1- Download the zipped file, 
   2- Unzip the file to the a desired place,
   3- Open the project from NetBeans (File->Open Project),
   4- Choose the unzip project file,
   5- Go to the project in the development tool and right click,
   6- "Clean and Build" then run with the editor and use:
         http://localhost:8080 to view the page 

 OR: (without any development tool, without installing maven)
   1- Download the zipped file 
   2- Unzip the file to the a desired place
   3- run "mvnw clean install" 
   4- use cmd or terminal and go to target directory of the project, if there is no .jar file repeat the steps
   5- run "java -jar todoapp-0.0.1-SNAPSHOT.jar"  
   6- go to http://localhost:8080 to view the page from browser.

OR:
    To run the project: (From cmd/terminal)
    Download the source code and go to the root directory of the project. Then run these two commands:

    export PATH=/YOUR_LOCAL_LOCATION/apache-maven-3.6.41/bin:$PATH

    mvn exec:java and go to http://localhost:8080

- Click on "Add User" button to save a user. All the fields are obligatory for user record.
- Delete or Update user from table.
- If user added is succesfully then add todo.
- At saving todo issue user should choose user name from combobox while adding todo.

Assumptions:
   -First user is added then todo is created.
   -An user has many todo(one to many).
   -At run, some default sample data are added.
   -User enters all the fields especially at todo add.

TODO:
   -Some validations like email.
   -Code Coverage Report is not 70%

To run the test files:
make sure that skiptest parameter is set to false, I made true to avoid test files to run when project’s other source files are building.

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>2.12.4</version>
                <configuration>
                    <skipTests>false</skipTests>
                </configuration>
            </plugin>  



