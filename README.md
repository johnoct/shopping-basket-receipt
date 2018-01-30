# shopping-basket-receipt

This is a solution to the Shopping basket receipt coding test.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project.

### Prerequisites

### Prerequisites

- JDK
- Maven
- Your favourite IDE (I chose IntelliJ)

### Installing

The application uses maven for build. Run the commands below to install the application.

macOSX or Linux:

```
./mvnw clean package
```

Windows:
```
./mvnw.cmd clean package
```

## Running the tests

The unit test framework used is JUnit. Execute the following to run the tests:

```
./mvnw test
```

## Test Assumptions

The example given requires a few assumptions
```
Basic sales tax is applicable at a flat rate of 10% on all goods, except books, food, and drugs.
Import duty is an additional sales tax applicable on all imported goods at a rate of 100%, with no
exemptions.

Example Output: (your output doesn’t need to be exactly same format)
1 imported bottle of perfume 33.50
1 bottle of perfume: 19.99
1 packet of headache pills: 9
1 imported box of chocolates: 9.99
Sales Taxes: 50.74
Total: 123.20
```

I found that the only way this total would work out is if the following was assumed:
 - 1 packet of headache pills is subject to Basic Sales Tax 10%
 - 1 imported box of chocolates is subject to Basic Sales Tax 10%

 It is contradictory to rules in the example because headache pills fall to the drugs category in my opinion. As well with the chocolates falling to the food category. 


## Built With

* [JUnit](http://junit.org/) - The test framework used
* [Maven](https://maven.apache.org/) - Dependency Management / Build


## Author

* **John Octubre** 


## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

