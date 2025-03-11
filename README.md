# RabbitMQ send receive services

## Run the app
To run the project execute the following commands:
```shell
./receiver/mvnw clean package -f ./receiver/pom.xml
./sender/mvnw clean package -f ./sender/pom.xml
docker-compose build
docker-compose up
```

## Send a message

You can send the message by using [Postman](https://www.postman.com/):
- POST: http://localhost:8081/send
```json
{
    "content": "hello, mates!"
}
```

or you can send the request using `curl` (for MacOS and unix system (like Ubuntu, CentOS, etc...))
```shell
curl --location 'http://localhost:8081/send' \
--header 'Content-Type: application/json' \
--data '{
    "content": "hello, mates!"
}'
```

## What about RabbitMQ?
Once you run the app using docker-compose feel free to visit the http://localhost:15672/#/queues and verify the list of queues.
