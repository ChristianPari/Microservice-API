# Service Registry

### Notes From Project
- @EnableEurekaServer
  - Declared (in yaml):
    - server: port: ${PORT_NUMBER}
  - Also declaring this application not as a Eureka Client via the configuration (in yaml):
    - eureka: client:
      - register-with-false: false
      - fetch-registry: false