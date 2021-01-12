# Film Locations Service

Service build with Spring returns film locations data originating from https://data.sfgov.org/Culture-and-Recreation/Film-Locations-in-San-Francisco/yitu-d5am.

The service fetches the data during bootstrap and persists it using an H2-Database.

The data structure has been split into two tables `film` and `location` related with a many-to-many relationship to reduce redundancy. 

Service is deployed on a K8s cluster and available at:

Endpoints:

- `/films`
    - Returns Film Locations Data as JSON.
    - Accepts query param `title` as filter for film title.
        - e.g. 
- `/films/view`
    - Returns Film Location Data as super simple HTML.
        - e. g.


