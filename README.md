This is a REST API made with Spring Boot for a Twitter clone application. 

The project can be run with the command:

```
./mvnw clean spring-boot:run
```

Here's a short demo of some of the features.

Create a user:
```
curl -X POST "localhost:8080/api/signin?userName=joe&password=password"
```

Response:
```json
{
    "id": 577,
    "userName": "joe",
    "role": "USER"
}
```

Obtain an access token:
```
curl twitter:secret@localhost:8080/oauth/token -dgrant_type=password -dscope=any -dusername=joe -dpassword=password
```
Response:
```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXBpIl0sInVzZXJfbmFtZSI6ImpvZSIsInNjb3BlIjpbImFueSJdLCJleHAiOjE2MDkzODAwMjEsImF1dGhvcml0aWVzIjpbIlVTRVIiXSwianRpIjoicENJVFY0UUhlUk00Q3pyUmRNai9qaU5DYUFVPSIsImNsaWVudF9pZCI6InR3aXR0ZXIifQ.7_HrYa852P4wEnLy701ZXmUnlvwf2KKsogDuFLd3SA4",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXBpIl0sInVzZXJfbmFtZSI6ImpvZSIsInNjb3BlIjpbImFueSJdLCJhdGkiOiJwQ0lUVjRRSGVSTTRDenJSZE1qL2ppTkNhQVU9IiwiZXhwIjoxNjA5MzgwOTIxLCJhdXRob3JpdGllcyI6WyJVU0VSIl0sImp0aSI6Ik5idG5XcGl2dHdraEZhVWROVG5nTk1CVXVFUT0iLCJjbGllbnRfaWQiOiJ0d2l0dGVyIn0.qzqebWk1_sxBWqVhfaoh6_V-43IkWeLm8PVcAwDh0Zg",
    "expires_in":99,
    "scope":"any",
    "jti": "pCITV4QHeRM4CzrRdMj/jiNCaAU="
}
```

Post a tweet:
```
curl \
-H "Authorization: Bearer <ACCESS_TOKEN>" \
-H "Content-Type: application/json" \
-d '{"content":"this is my tweet"}' \
localhost:8080/api/users/577/tweets
```

Response:
```json
{
    "id": 578,
    "content": "this is my tweet",
    "user": {
        "id": 577,
        "userName": "joe",
        "role": "USER"
    }
{
```

Follow another user:
```
curl -X POST -H "Authorization: Bearer <ACCESS_TOKEN>" localhost:8080/api/follows?followerId=586&followingId=581
```

Get a user's timeline:
```
curl -H "Authorization: Bearer <ACCESS_TOKEN>" localhost:8080/api/users/{userId}/timeline
```
Response:
```json
[{
    "id": 582,
    "content": "very cool tweet",
    "user": {
        "id": 581,
        "userName": "Fred Smith",
        "role": "USER"
    },
    "createdAt": "2020-12-30T18:16:31.425772"
}, {
    "id": 583,
    "content": "another cool tweet",
    "user": {
        "id": 581,
        "userName": "Fred Smith",
        "role": "USER"
    },
    "createdAt": "2020-12-30T18:16:31.432003"
}]
```

