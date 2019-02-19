# traveldemo
This is a demo Spring Boot Rest API that can search for flights and store them.

In order to run this application you need to set up the application.properties file as per example.
A key from https://developers.amadeus.com/ is also required if you wish to use the low fare search.

A Demo version is currently hosted on AWS (with no database as of yet)

The API documentation at: 
http://traveldemo2-env.gus2umu43z.eu-north-1.elasticbeanstalk.com/swagger-ui.html

As no database is implemented yet for the AWS version only the flightsearch is active:

url: Traveldemo2-env.gus2umu43z.eu-north-1.elasticbeanstalk.com/flightsearch

Sample get request:
{
	"origin" : "STO",
	"destination" :  "LON",
	"departureDate" : "2019-08-01",
	"nonStop" : "true",
	"max" : 5
}

Sample response:
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
    },
    {
        "id": null,
        "origin": "ARN",
        "destination": "LHR",
        "airline": "AY",
        "number": "5933",
        "departureTime": "2019-08-01T21:20:00+02:00",
        "arrivalTime": "2019-08-01T22:50:00+01:00",
        "priceTotal": 154.73,
        "taxesTotal": 58.73,
        "fareBasis": "QVA0SE"
    },
    {
        "id": null,
        "origin": "ARN",
        "destination": "LGW",
        "airline": "D8",
        "number": "2859",
        "departureTime": "2019-08-01T21:00:00+02:00",
        "arrivalTime": "2019-08-01T22:35:00+01:00",
        "priceTotal": 72.73,
        "taxesTotal": 20.73,
        "fareBasis": "XJIPPI"
    },
    {
        "id": null,
        "origin": "ARN",
        "destination": "LHR",
        "airline": "SK",
        "number": "531",
        "departureTime": "2019-08-01T11:15:00+02:00",
        "arrivalTime": "2019-08-01T12:50:00+01:00",
        "priceTotal": 48.05,
        "taxesTotal": 33.05,
        "fareBasis": "OSOLIGHT"
    },
    {
        "id": null,
        "origin": "ARN",
        "destination": "LHR",
        "airline": "BA",
        "number": "783",
        "departureTime": "2019-08-01T21:20:00+02:00",
        "arrivalTime": "2019-08-01T22:50:00+01:00",
        "priceTotal": 70.73,
        "taxesTotal": 20.73,
        "fareBasis": "OZ0HO"
    }
