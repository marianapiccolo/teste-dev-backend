![Oli Saúde|100x397,20%](https://hs-7708371.f.hubspotfree.net/hub/7708371/hubfs/logo-olisaude.png?upscale=true&width=288&upscale=true&name=logo-olisaude.png)

# The Challenge
Create a simple API to manage Clients. This API should allow:
- Create a customer
- Edit a customer
- Get a specific customer
- List customers

A Client must have the following fields:
- Name
- birth date
- gender
- [ health problems ]
- creation date
- update date

Health problems
- Name
- degree of problem (1 to 2)
    
    ``
    ex: diabetes, degree 2
    ``
Create an endpoint to bring the 10 clients with the highest health risk, in which the calculation is:
    
    ```
        sd = soma do grau dos problemas
        score = (1 / (1 + eˆ-(-2.8 + sd ))) * 100
    ```

# Technologies used
- Java
- SpringBoot
- Postman
- MySQL

# Spring Boot Flow Architecture
- Layers: Model, Repository and Controller.
- Methods: Get, Put, Post.
- Get: Get the API data.
- Post: Create a new data.
- Put: Update the data.

# Endpoint
- Score: Calculates the sum of the degrees of each client's health problem and then calculates the client's score.
- showTenClients: Show the 10 clients with the highest health risk.


