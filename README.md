## Spring Hexagonal Architecture
This project illustrates usage of Hexagonal Architecture in Spring Boot.

The hexagonal architecture is based on three principles and techniques:

- Explicitly separate User-Side, Business Logic, and Server-Side
- Dependencies are going from User-Side and Server-Side to the Business Logic
- We isolate the boundaries by using Ports and Adapters

Outside the hexagon we have any real world thing that the application interacts with. 
These things include humans, other applications, or any hardware/software device. They are the actors. 
We could say that actors are the environment of the application.

Actors are arranged around the hexagon depending on who triggers the interaction between the application and the actor.

### Hexagonal architecture schema
![alt text](https://github.com/hedza06/hexagonal-spring/resources/data/hex-schema.png)

### Ports
The interactions between actors and the application are organized at the hexagon boundary by the reason why they 
are interacting with the application. Each group of interactions with a given purpose/intention is a port.

Ports should be named according to what they are for, not according to any technology. 
So, in order to name a port, we should use a verb ending with “ing” and we should say “this port is for …ing something”.
For example:

- This driver port is for “adding products to the shopping cart”;
- This driven port (repository) is “for obtaining information about products”;
- This driven port (recipient) is for “sending notifications”.

Ports are the application boundary, in the picture a port is an edge of the hexagon. From the outside world, actors 
can only interact with the hexagon ports, they shouldn’t be able to access the inside of the hexagon. 

Ports are interfaces that the application offers to the outside world for allowing actors interact with the application.

### Adapters
Actors interact with hexagon ports through adapters using a specific technology. An adapter is a software component 
that allows a technology to interact with a port of the hexagon. Given a port, there may be an adapter for each desired 
technology that we want to use. Adapters are outside the application.

A driver adapter uses a driver port interface, converting a specific technology request into a technology 
agnostic request to a driver port.

A driven adapter implements a driven port interface, converting the technology agnostic methods of the port into 
specific technology methods.

### Contribution/Suggestions
If someone is interested for contribution or have some suggestions please contact me on e-mail `hedzaprog@gmail.com`.
There are more to come from hexagonal architecture and first I'm planing to write tests for given examples in project.

### Author
Heril Muratović  
Software Engineer  
<br>
**Mobile**: +38269657962  
**E-mail**: hedzaprog@gmail.com  
**Skype**: hedza06  
**Twitter**: hedzakirk  
**LinkedIn**: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
**StackOverflow**: https://stackoverflow.com/users/4078505/heril-muratovic