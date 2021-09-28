# Cloud Gateway

### Notes From Project
- @EnableEurekaClient
  - Makes the Spring Boot application act as a Eureka client
  - To register this client one must add the configuration (this is yaml):
    - register-with-eureka: true
    - fetch-registry: true
    - service-url: defaultZone: ${SERVICE_URL}
    - instance: hostname: ${HOSTNAME}
- Allowing cloud access to different routes requires the configuration (this is yaml):
  - spring: cloud: gateway: routes: "now each route is written in a way to produce it as a list for the configuration"
    - " - id: ${NAME_OF_SERVICE} uri: lb://${SERVICE_NAME} predicates: - Path=/${ACCESS_PATH_URL}/** "