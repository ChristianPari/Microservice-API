# Players Services

### Notes From Project
- @Entity
  - Class can be mapped to a table
- @JsonIgnoreProperties
  - Ignores the specified logical properties in JSON serialization and deserialization
- @GeneratedValue
  - strategy: The primary key generation strategy that the persistence provider must use to generate the annotated entity primary key
    - Types:
      - AUTO: Indicates that the persistence provider should pick an appropriate strategy for the particular database
      - IDENTITY: Assign primary keys for the entity using a database identity column
      - SEQUENCE: Assign primary keys for the entity using a database sequence
      - TABLE: Assign primary keys for the entity using an underlying database table to ensure uniqueness
- JpaRepository
  - The standard way of persisting Java objects into relational databases
  - Contains methods for performing CRUD operations, sorting and paginating data
  - Can declare own methods that services can use
- @Query
  - Used to define an SQL statement to be executed for a Spring Data repository method
  - `#{#entityName}`: inserts the entity name of the domain type associated with the given repository
    - Resolved as follows:
      - Domain type has @Entity annotation then it'll be used
      - Otherwise, the simple class name wil be used
  - @Param
    - Allows you to assign parameter names to data from the method and insert them into the SQL statement using ':parameterName' notation
