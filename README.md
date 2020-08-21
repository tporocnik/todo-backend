# Todo app backend

REST backend for a simple Todo application implemented with Quarkus. The app supports 

* List tasks
* Add and update tasks
* Delete tasks

The code is part of the blog post [https://medium.com/@porocnik/microprofile-webcomponents-der-neue-standard-teil-1-a53c16fcd867](MicroProfile & WebComponents — der neue Standard (Teil 1))

### Configuration 

To configure ports etc use:

	src/main/resources/application.properties
	
NB: The *DB_CLOSE_DELAY=-1*	parameter avoids closing of the database when last connection is closed (due to inactivity).

### Start developer mode

    mvn quarkus:dev

### Start

For running the app outside of an IDE run.bat can be used. It simply calls:
	
	java -jar -Dquarkus.http.host=0.0.0.0 todo-1.0-SNAPSHOT-runner.jar

### Testing

For simple checking the responsiveness of the backend you can call: [http://localhost:8088/todo/tasks/](http://localhost:8088/todo/tasks/)

Once the app is started, the integration tests can be used to make a simple CRUD test against the backend. 


### Debugging

Start application with -Ddebug. Default debug port is 5005
	

### See also 

 * https://quarkus.io/guides/getting-started-guide
 


