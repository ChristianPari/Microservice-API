# Microservice
Using Spring Eureka and Gateway, I created an API that utilizes most CRUD requests to retrieve and alter data within my various sporting databases that are being hosted by my AWS RDS server. Each database has multiple servers on localhost and are accesed by the requesting to the local gateway endpoint with certain paths. Also incorporated custom "value objects" by way of allowing an endpoint to also reach out to another server and make a request for data, then merge both objects into a value object which is used in the response body.

## Project Breakdown
`FOLDERS`

Within MySQL I created 3 DBs for NFL, MLB, and NBA; each contains a team and a player table with data regarding each leagues information (this data was retrieved by web scraping I did in another project [here](https://github.com/ChristianPari/SportsWebScraper)). I decided tp create 2 services for each league regarding teams and players, then another for my service registry and my gateway service.
- `League Team and Player Services`
  - Example Endpoints: "localhost:{:PORT}/{:LEAUGE}/{:TEAMS_OR_PLAYERS}" -> simplified uri, but then their are more path variables that are added on for each request like "/id" or "/name" that then take the request parameter from the end of the path or the request body to use within the request
- `Gateway Service`
  - Use as the entry point for all requests that utilizes the "league/teams_or_players" path variables to direct requests to the correct endpoint of the other services  
- `Service Registry`
  - Utilize to see health and information of these services as well handle all the porting information which can then be decoupled from the Gateway Service and I can simply describe in my YAML for the Gateway application file what paths go to what service name retrived from this Service Registry since they are all clients of this registry.
- `Api-Doc`
  - Created with Insomnia Documenter, please [view](https://christianpari.github.io/Microservice-API/) to see example requests and responses from each of the endpoints for this project

## Technologies Used
- Spring
  - SpringBoot, Spring Initializer
  -  Cloud
  -  Eureka Server & Client
  -  Gateway
  -  Web
  -  JPA
- MySQL Connector
- Lombok
- SLF4J Logging


## Things I Learned
Ultimately making mulitple microservices which can all be used and accessed from a single gateway was entirely new for me, I've worked with creating my own APIs in the past but not multiple for a single application that don't have to all be accessed from their own port info directly.
- Understanding how to use Eureka to manage endpoints on different ports and naming these for access in other services is very handy
- Using Queries from JPA to make SQL statements to my databases via the repository upon a request was amazing, unsure how I hadn't came across this previously but found it so useful and much faster than handling the data within the Entity Service
- Using Springs' RestTemplate package to make requests to other services within another service
