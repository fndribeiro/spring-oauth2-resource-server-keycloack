# Spring Oauth2 Resource Server Keycloack
Spring Boot resource server demo that connects with Keycloack using Oauth2 OpenID Connect protocol.

## How to get an HTTP 200 response from this server:

This server has one endpoint mapped to a GET request call to the path /hello:

![image](https://user-images.githubusercontent.com/45038374/169413709-38b6cadd-c88c-4b56-8456-0fce977dce66.png)

![image](https://user-images.githubusercontent.com/45038374/169414008-f64b3a25-17d7-478c-bd1b-b73391f7a699.png)

This API is protected and will only return SUCCESS response after receiving a valid Bearer token provided by Keycloack Authorization Server.
Otherwise will return an HTTP 401 Unauthorized.

### How to setup Keycloack Authorization Server with Client Credentials Grant Type:

1 - Run the Docker command:

docker run --name keycloak_test -p 8080:8080 \
        -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin \
        quay.io/keycloak/keycloak:latest \
        start-dev

2 - Go to http://localhost:8080/

3 - Go to administration console:

![image](https://user-images.githubusercontent.com/45038374/169414354-3e8a6a9c-82cf-40d7-9436-f78ceb2da8e9.png)

4 - Provide user "admin" and password "admin".

![image](https://user-images.githubusercontent.com/45038374/169414425-3bbade7d-06fd-4b1e-aa7f-d210bc97341e.png)

5 - Go to "Add realm":

![image](https://user-images.githubusercontent.com/45038374/169414503-53885004-dc22-42b5-965f-ff0cdbbfa9c1.png)

6 - Choose realm name and click create:

![image](https://user-images.githubusercontent.com/45038374/169414581-66004d8a-c288-47b8-b52d-380504d4f6d1.png)

7 - Click on OpenID Endpoint Configuration:

![image](https://user-images.githubusercontent.com/45038374/169414695-a5704904-75da-412c-9270-3c12b8d03585.png)

8 - Copy the "jwks_uri" value:

![image](https://user-images.githubusercontent.com/45038374/169414787-c69a92b1-fc66-4ad6-9c94-e0fbccf81f8e.png)

9 - Go to the application.properties of this project and paste the value in the spring.security.oauth2.resourceserver.jwt.jwk-set-uri property:

![image](https://user-images.githubusercontent.com/45038374/169415043-d53c5b93-12e0-4c6a-8e3d-43f005f740b0.png)

10 - Go to "Clients":

![image](https://user-images.githubusercontent.com/45038374/169415100-57a88643-797a-410d-8e19-058e81cb5f5c.png)

11 - Go to "Create" on the right side:

![image](https://user-images.githubusercontent.com/45038374/169415152-bf509b3c-f547-46d0-8dd1-757146d02e50.png)

12 - Choose a client id and click create:

![image](https://user-images.githubusercontent.com/45038374/169415204-08620f34-bb0d-4a42-8e1d-35b7e3d713d0.png)

13 - Choose the following configuration:

a) Disable "Standard Flow Enabled" option.
b) Disable "Direct Access Grants Enabled" option.
c) Select "Access Type" as "Confidential".
d) Enable "Service Accounts Enabled" option.
e) Save configurations.

14 - Go to "Credentials" and copy secret value:

![image](https://user-images.githubusercontent.com/45038374/169415776-09bfa3a1-d4e9-491c-81a6-63277bc0b965.png)

15 - Go back to your OpenID Endpoint Configuration and copy the value from "token_endpoint":

![image](https://user-images.githubusercontent.com/45038374/169415966-f116e68d-7fcd-481d-9631-134804d3eed0.png)

16 - Go to postman and set the following request call:

![image](https://user-images.githubusercontent.com/45038374/169416248-9ffe4b97-210a-4bd7-9735-612f595c2485.png)

Provide client_id and client_secret with correct values.

17 - Make the request call and copy the value from "access_token":

![image](https://user-images.githubusercontent.com/45038374/169416313-8d20ce4d-88f1-497e-b42e-2e135fa52f60.png)

18 - Start this Spring Boot Project.

19 - Go back to Postman, add the previous token as Bearer in Authorization tab and make a GET request to the endpoint: http://localhost:8081/hello

![image](https://user-images.githubusercontent.com/45038374/169416413-f4d70bb4-9d90-49c0-a00f-7f8324da751e.png)

## Client Credentials Grant Type Flow:

This Oauth2 flow is better used for API-2-API comunication.

![image](https://user-images.githubusercontent.com/45038374/169416730-44785ea8-6777-4aa2-8a51-386b28c25c15.png)

For public clients authorization code grant type is a better approach.

# All credits to Eazy Bytes!
This project was built with the help of the following course:
https://www.udemy.com/course/spring-security-zero-to-master/


