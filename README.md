## This is a demo Spring Boot Rest API that can search for flights and store them.

In order to run this application the application.properties file needs to be setup as per appPropExample.
In order to perform a low fare searh a key for the [Amadeus SDK](https://developers.amadeus.com/) is required.
Flight searches are performed using the Amadeus Sandbox Environment - results may differ from real flights.


### A Demo version is currently hosted on AWS (SQL database still to be integrated)

Travel Demo uses [Swagger2 documentation](http://traveldemo2-env.gus2umu43z.eu-north-1.elasticbeanstalk.com/swagger-ui.html) of the end-points and model.


A flight searh can be performed using the demo app on AWS as per:

url: Traveldemo2-env.gus2umu43z.eu-north-1.elasticbeanstalk.com/flightsearch

Sample get request:
```
{
	"origin" : "STO",
	"destination" :  "LON",
	"departureDate" : "2019-08-01",
	"nonStop" : "true",
	"max" : 1
}
```

Sample response:
```
 { 
        "id": null,
        "origin": "ARN",
        "destination": "LHR",
        "airline": "SK",
        "number": "1523",
        "departureTime": "2019-08-01T16:15:00+02:00",
        "arrivalTime": "2019-08-01T17:50:00+01:00",
        "priceTotal": 48.05,
        "taxesTotal": 33.05,
        "fareBasis": "OSOLIGHT"
    }
```
