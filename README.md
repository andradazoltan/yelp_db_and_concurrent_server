Restaurants, Queries and Statistical Learning
===

This project explores the following aspects of software construction:
+ managing complex ADTs;
+ multithreading and the client-server pattern;
+ query parsing and execution.

In addition to these aspects, the project also touches upon rudimentary methods for statistical inference and learning.

### Background

This project uses an excerpt from the [Yelp Academic Dataset](https://www.yelp.com/academic_dataset). Specifically, the data comes in [JSON](https://en.wikipedia.org/wiki/JSON) format and is about restaurants, reviews of the restaurants, and user information (for those contributing reviews).The dataset is used to create and maintain a simple in-memory database with restaurants, users and reviews.

### Part I: A Database as a Datatype

The first part of this project involved building a datatype (`YelpDB`) that represents Yelp's restaurant dataset.

As a requirement from the assigment:

+ This datatype must implement the `MP5Db` interface, and
+ This datatype should have a constructor that takes three `String`s as arguments: these `Strings` represent filenames. The first file is the list of restaurants, the second file is the list of reviews and the third file is the user list.

Before we began writing a large portion of the code, we designed the datatypes, operations and rep invariants for these types. The initial plan can be seen in the [Design.md](https://github.com/andradazoltan/yelp_db_and_concurrent_server/blob/master/Design.md) document. The goal was to enable useful operations for the database that could make it reusable for a variety of applications, as well as allow for easy extensibility later.

### Part II: Statistical Learning

This portion of the project includes implementation of two approaches to statistical machine learning: one is an instance of unsupervised learning and the second is an instance of supervised learning. Statistical learning is an exciting area for computing today!

#### k-means Clustering

Suppose you are given a set of (x, y) coordinates, you may sometimes want to group the points into _k_ clusters such that no point is closer to the center point (centroid) of a cluster other than the one to which it is assigned. In the case of restaurants, this approach may allow us to group restaurants that are in the same neighbourhood even without knowing anything about the neighbourhoods in a city. _A similar approach is used to group similar products on online shopping services such as Amazon._

The k-means algorithm finds k centroids within a dataset that each correspond to a cluster of inputs. To do so, k-means clustering begins by choosing k centroids at random, then alternates between the following two steps:

1. Group the restaurants into clusters, where each cluster contains all restaurants that are closest to the same centroid.
2. Compute a new centroid (average position) for each non-empty cluster.

This [visualization](http://tech.nitoyon.com/en/blog/2013/11/07/k-means/) is a good way to understand how the algorithm works.

The visualization of the implemented algorithm can be run using the provided `python` (Python 3) method. The visualization is called a [Voronoi tesselation](https://en.wikipedia.org/wiki/Voronoi_diagram).

> One can visualize the tessalation produced by k-means clustering by writing the JSON formatted cluster information to `voronoi.json` in the `visualize` directory and then launch `visualize.py` as follows: `python3 visualize.py`

#### Least Squares Regression

As an instance of supervised learning, an algorithm for predicting the rating that a user may give to a restaurant was implemented.

By analyzing a user's past ratings, we can try to predict what rating the user might give to a new restaurant.

To predict ratings, we implemented a simple least-squares linear regression, a widely used statistical method that approximates a relationship between some input feature (such as price) and an output value (the rating) with a line. The algorithm takes a sequence of input-output pairs and computes the slope and intercept of the line that minimizes the mean of the squared difference between the line and the outputs.

Implement the `getPredictorFunction` method, which takes a user and returns a _function_ that predicts the users ratings. Use the restaurant's priciness as the feature (`x` values in the regression) to predict the user's rating (`y` values in the regression).

One method of computing these values is by calculating the sums of squares, S<sub>xx</sub>, S<sub>yy</sub>, and S<sub>xy</sub>:

+ S<sub>xx</sub> = Σ<sub>i</sub> (x<sub>i</sub> - mean(x))<sup>2</sup>
+ S<sub>yy</sub> = Σ<sub>i</sub> (y<sub>i</sub> - mean(y))<sup>2</sup>
+ S<sub>xy</sub> = Σ<sub>i</sub> (x<sub>i</sub> - mean(x))(y<sub>i</sub> - mean(y))

After calculating the sums of squares, the regression coefficients, and R<sup>2</sup> (`r_squared`), which is an estimate of the quality of the predictor, are defined as follows:

+ b = S<sub>xy</sub> / S<sub>xx</sub>
+ a = mean(y) - b * mean(x)
+ R<sup>2</sup> = S<sub>xy</sub><sup>2</sup> / (S<sub>xx</sub> S<sub>yy</sub>)

### Part III: A YelpDB Server

In the next part of this machine problem, you should implement a multi-threaded server application, `YelpDBServer` that wraps a `YelpDB` instance.

One should be able to start the server from the command line using

```
java ca.ece.ubc.cpen221.mp5.YelpDBServer 4949
```

where `4949` is the port number at which the server should listen for connection requests. The server should use the command line argument to decide which port number to bind to.

The server should be able to handle more than one connection at the same time (and hence the need for multithreading).

### Part IV: Handling Simple Requests

The server should be able to handle some simple requests from a client that connects to it.

Here are five simple requests that you should implement:

+ `GETRESTAURANT <business id>`: To this request, the server should respond with the restaurant details in JSON format for the restaurant that has the provided business identifier. If there is no such restaurant then one should use the error message as above. (Note that the business is is not wrapped in `< >`. The use of `< >` is to indicate that the command should be followed by a required argument. So the request will look like this: `GETRESTAURANT h_we4E3zofRTf4G0JTEF0A` and this example refers to the restaurant Fondue Fred in the provided dataset.)
+ `ADDUSER <user information>`: This request is a string that begins with the keyword (in our protocol), `ADDUSER`, followed by user details in JSON, formatted as suited for the Yelp dataset. Since we are adding a new user the JSON formatted information will contain only the user's name. So the JSON string may look like this `{"name": "Sathish G."}`. The server should interact with the RestaurantDB to create a new user, generate a new userid (it does not have to be in the Yelp userid format, you can use your own format for new users), generate a new URL (although it is a dummy URL) and then acknowledge that the user was created by responding with a more complete JSON string such as:
  `{"url": "http://www.yelp.com/user_details?userid=42", "votes": {}, "review_count": 0, "type": "user", "user_id": "42", "name": "Sathish G.", "average_stars": 0}`. If the argument to the `ADDUSER` command is invalid (not JSON format, missing name, etc.) then the server would respond with the message `ERR: INVALID_USER_STRING`. Note that the server can create a new user if the argument to this command is a valid JSON string and has a field called `name` but also has other information (which can be ignored).
+ `ADDRESTAURANT <restaurant information>`: This command has structure similar to the `ADDUSER` command in that the JSON string representing a restaurant should have all the necessary details to create a new restaurant except for details such as `business_id` and `stars`. If the provided string is incomplete or erroneous , the error message should `ERR: INVALID_RESTAURANT_STRING`.
+ `ADDREVIEW <review information>`: The last simple command to implement is an `ADDREVIEW` command which has the same principle as the other commands. The possible error codes are `ERR: INVALID_REVIEW_STRING`, `ERR: NO_SUCH_USER` and `ERR: NO_SUCH_RESTAURANT`.

Remember that when multiple clients are making such requests to change the database you will need to deal with potential data races and other concurrency-related conflicts.

For any other errors in the requests, you can send an `ERR: ILLEGAL_REQUEST`.

### Part V: Structured Queries

The final part of this machine problem is to support structured queries over the database you have constructed. The request-response pattern will be handled by the `RestaurantDBServer` as was the case with "simple" requests earlier.

We would like to process queries such as "list all restaurants in a neighbourhood that serve Chinese food and have moderate ($$) price."

In our request-response model, the request would begin with the keyword `QUERY` followed by a string that represents the query.

A query string may be: `in(Telegraph Ave) && (category(Chinese) || category(Italian)) && price <= 2`. This query string represents a query to obtain a list of Chinese and Italian restaurants in the Telegraph Avenue neighbourhood that have a price range of 1-2.

For the query string above, the server would respond with a list of restaurants in JSON notation. If no restaurants match the query (for any reason) then the server should respond with `ERR: NO_MATCH`. If no query string is sent or if the query is ill-formed then the response should be `ERR: INVALID_QUERY`.

The grammar for the query language looks something like this:

```
<orExpr> ::= <andExpr>(<or><andExpr>)*
<andExpr> ::= <atom>(<and><atom>)*
<atom> ::= <in>|<category>|<rating>|<price>|<name>|<LParen><orExpr><RParen>
<or> ::= "||"
<and> ::= "&&"
ineq ::= <gt>|<gte>|<lt>|<lte>|<eq>
<gt> ::= ">"
<gte> ::= ">="
<lt> ::= "<"
<lte> ::= "<="
<eq> ::= "="
<num> ::= [1-5]
<in> ::= "in" <LParen><string><RParen>
<category> ::= "category" <LParen><string><RParen>
<name> ::= "name" <LParen><string><RParen>
<rating> ::= "rating" <ineq><num>
<price> ::= "price" <ineq><num>
<LParen> ::= "("
<RParen> ::= ")"
```
