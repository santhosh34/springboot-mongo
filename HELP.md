# Springboot application with  for benchmarking MongoDB Writes and Reads.


## How to use this APP:

### Pagination Request from PostMan
    <<TODO>>
localhost:8085/benchmark/trades/paginated?size=10&page=1&sort=externalRefNumber,desc

Why below one is not working but working from compass

{"contractDetails.description._children.meta._children.globalKey._value" : '25kb'}

Working in repo:
@Query(value= "{'contractDetails.contractId' : ?0}")
List<Trade> searchHereThereTradesWithGlobalKey(String globalKey);

POSTMAN Collection Path: 



### Local  Run from Jar
cd <<Workging Dir>>>
cp <<pwd>>/springboot-mongo/build/libs/tradeflow-0.0.1-SNAPSHOT.jar ./tradeflow.jar
java -jar  tradeflow.jar com.aureole.tradeflow.TradeflowApplication


localhost:8085/benchmark/trades/search-at/depth1/8

### Observability & API Doc Links
1. Open API Spec
   1. http://localhost:8085/benchmark/v3/api-docs
   2. http://localhost:8085/benchmark/swagger-ui/index.html
2. Health
   1. http://localhost:8085/benchmark/actuator
   2. http://localhost:8085/benchmark/actuator/health
3. Metrics
   1. http://localhost:8085/benchmark/actuator/metrics

### Contact Me 
     https://www.linkedin.com/in/santhosh34/