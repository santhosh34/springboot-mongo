# Springboot application with  for benchmarking MongoDB Writes and Reads.

### Open API 3

http://localhost:8085/benchmark/v3/api-docs

### Open API UI ( Swagger)

http://localhost:8085/benchmark/swagger-ui/index.html

### Actuator:

http://localhost:8085/benchmark/actuator

### Pagination Request from PostMan:

localhost:8085/benchmark/trades/paginated?size=10&page=1&sort=externalRefNumber,desc

Why below one is not working but working from compass

{"contractDetails.description._children.meta._children.globalKey._value" : '25kb'}

Working in repo:
@Query(value= "{'contractDetails.contractId' : ?0}")
List<Trade> searchHereThereTradesWithGlobalKey(String globalKey);

POSTMAN Collection Path: 



