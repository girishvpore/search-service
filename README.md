# search-service : 
A micro service that invokes AWS elastic search and make it available using API gateway
<BR>

#Run
Before run set environment variables for AWS role (i.e access key and secret)
    

This is a spring Boot Application so you can run it directly from your IDE by using 
*com.girishpore.searchservice.SearchServiceApplication* starter class. 


You may run also run Spring boot application from command line or by configuring your IDE to run the following following
mvn target:

    mvn spring-boot:run

for sample API
Once application is running open a browser and hit http://localhost:8080/swagger-ui.html# for swagger-ui 
Alternatively, you can also run application from Docker container:

    # build
    mvn clean install
    docker build -t searchservice .
    # run
    docker run -p 8080:8080 searchservice:latest


Open a browser and hit [http://LOCAL_DOCKER_IP:8080/](http://LOCAL_DOCKER_IP:8080/) 

Api request and responses
###1. search by Plan name
```
$ curl -X GET "http://localhost:8080/employees/search/byPlanName?offset=0&size=2&value=BORO" -H "accept: application/json" | jq .
     % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                    Dload  Upload   Total   Spent    Left  Speed
   100   393    0   393    0     0    944      0 --:--:-- --:--:-- --:--:--   944
   [
     {
       "ein": "231997150",
       "planName": "BORO DEVELOPERS, INC. RETIREMENT PLAN",
       "sponsorName": "BORO DEVELOPERS, INC.",
       "sponsorState": "PA",
       "ackId": "20181011150916P030171114541001",
       "businessCode": "236200"
     },
     {
       "ein": "231997150",
       "planName": "BORO CONSTRUCTION HEALTH AND WELFARE PLAN",
       "sponsorName": "BORO DEVELOPERS, INC.",
       "sponsorState": "PA",
       "ackId": "20181220175039P030098766381001",
       "businessCode": "236200"
     }
```
##2. search by Sponsor name
```$xslt
~ $ curl -X GET "http://localhost:8080/employees/search/bySponsorName?offset=0&size=1&value=BORO%20DEVELOPERS%2C%20INC." -H "accept: application/json" | jq .
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   195    0   195    0     0    789      0 --:--:-- --:--:-- --:--:--   789
[
  {
    "ein": "231997150",
    "planName": "BORO DEVELOPERS, INC. RETIREMENT PLAN",
    "sponsorName": "BORO DEVELOPERS, INC.",
    "sponsorState": "PA",
    "ackId": "20181011150916P030171114541001",
    "businessCode": "236200"
  }
]
```

###3. search by Sponsor state
```$xslt
~ $ curl -X GET "http://localhost:8080/employees/search/bySponsorState?offset=0&size=3&value=PA" -H "accept: application/json" | jq .
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   550    0   550    0     0   5445      0 --:--:-- --:--:-- --:--:--  5445
[
  {
    "ein": "822399322",
    "planName": "MLW FUN, INC. RETIREMENT PLAN",
    "sponsorName": "MLW FUN, INC.",
    "sponsorState": "PA",
    "ackId": "20180920105010P040130759581001",
    "businessCode": "812990"
  },
  {
    "ein": "251673066",
    "planName": "AB SPECIALTIES, INC. PROFIT SHARING PLAN",
    "sponsorName": "AB SPECIALTIES, INC.",
    "sponsorState": "PA",
    "ackId": "20180731102319P030070982493001",
    "businessCode": "238900"
  },
  {
    "ein": "251890050",
    "planName": "ACUSIS 401(K) PROFIT SHARING PLAN",
    "sponsorName": "ACUSIS",
    "sponsorState": "PA",
    "ackId": "20180731131716P030093767431001",
    "businessCode": "518210"
  }
]
```

