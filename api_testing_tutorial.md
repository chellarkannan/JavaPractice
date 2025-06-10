# Advanced API Testing & Automation with Java Rest Assured


---



### **1.1 API Testing Landscape **

#### **API Types & Testing Scope**
- **REST APIs**: Stateless, resource-based, HTTP methods (GET, POST, PUT, DELETE, PATCH)
- **GraphQL APIs**: Single endpoint, query-based data fetching
- **SOAP APIs**: Protocol-based, XML messaging
- **WebSocket APIs**: Real-time, bidirectional communication

#### **API Testing Pyramid**
```
    /\
   /UI\     ← Few, expensive, slow
  /----\
 / API  \   ← Many, moderate cost, fast
/--------\
|  Unit   |  ← Most, cheap, very fast
----------
```

#### **API Testing Categories**
- **Functional Testing**: Endpoint behavior, data validation, business logic
- **Performance Testing**: Load, stress, spike, volume testing
- **Security Testing**: Authentication, authorization, injection attacks
- **Contract Testing**: Schema validation, API versioning
- **Integration Testing**: Service-to-service communication

### **1.2 Rest Assured Framework Deep Dive **

#### **Why Rest Assured?**
- **Domain Specific Language (DSL)**: Human-readable test syntax
- **BDD Style**: Given-When-Then structure
- **Rich Validation**: JSONPath, XPath, Hamcrest matchers
- **Authentication Support**: OAuth, Basic Auth, API Keys
- **Request/Response Logging**: Detailed debugging capabilities

#### **Project Setup & Dependencies**
```xml
<!-- Maven Dependencies -->
<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.3.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>json-schema-validator</artifactId>
        <version>5.3.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.15.2</version>
    </dependency>
</dependencies>
```

#### **Base Test Configuration**
```java
public class APITestBase {
    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        
        // Global request specifications
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .addHeader("User-Agent", "RestAssured-Tests")
            .build();
    }
}
```

### **1.3 Core Rest Assured Patterns **

#### **Basic Request Structure**
```java
@Test
public void testGetAllUsers() {
    given()
        .pathParam("userId", 1)
    .when()
        .get("/users/{userId}")
    .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("name", notNullValue())
        .body("email", containsString("@"));
}
```

#### **Advanced Request Building**
```java
@Test
public void testCreateUserWithComplexData() {
    Map<String, Object> address = new HashMap<>();
    address.put("street", "123 Main St");
    address.put("city", "New York");
    address.put("zipcode", "10001");
    
    Map<String, Object> user = new HashMap<>();
    user.put("name", "John Doe");
    user.put("email", "john.doe@example.com");
    user.put("address", address);
    
    ValidatableResponse response = given()
        .body(user)
        .contentType(ContentType.JSON)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("name", equalTo("John Doe"))
        .body("address.city", equalTo("New York"));
    
    // Extract response data for subsequent tests
    int userId = response.extract().path("id");
    System.out.println("Created user ID: " + userId);
}
```

#### **Response Validation Techniques**
```java
@Test
public void testAdvancedResponseValidation() {
    given()
    .when()
        .get("/users")
    .then()
        .statusCode(200)
        .body("size()", greaterThan(0))
        .body("findAll{it.email.contains('@')}.size()", greaterThan(0))
        .body("[0].name", notNullValue())
        .body("email", everyItem(containsString("@")))
        .time(lessThan(2000L)); // Response time validation
}
```

---

## **Hour 2: Advanced Testing Patterns & Automation Framework **

### **2.1 Data-Driven Testing & Test Organization**

#### **POJO Serialization/Deserialization**
```java
// User POJO
public class User {
    private int id;
    private String name;
    private String email;
    private Address address;
    
    // Constructors, getters, setters
    public User() {}
    
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Getters and setters...
}

// Address POJO
public class Address {
    private String street;
    private String city;
    private String zipcode;
    
    // Constructors, getters, setters...
}
```

#### **POJO-Based Testing**
```java
@Test
public void testUserCreationWithPOJO() {
    Address address = new Address("456 Oak Ave", "Boston", "02101");
    User newUser = new User("Jane Smith", "jane.smith@example.com");
    newUser.setAddress(address);
    
    User createdUser = given()
        .body(newUser)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .extract()
        .as(User.class);
    
    assertThat(createdUser.getName(), equalTo("Jane Smith"));
    assertThat(createdUser.getAddress().getCity(), equalTo("Boston"));
}
```

#### **TestNG Data Providers**
```java
@DataProvider(name = "userData")
public Object[][] getUserData() {
    return new Object[][] {
        {"Alice Johnson", "alice@example.com", "Manager"},
        {"Bob Wilson", "bob@example.com", "Developer"},
        {"Carol Brown", "carol@example.com", "Tester"}
    };
}

@Test(dataProvider = "userData")
public void testUserCreationWithMultipleData(String name, String email, String role) {
    User user = new User(name, email);
    user.setRole(role);
    
    given()
        .body(user)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .body("name", equalTo(name))
        .body("email", equalTo(email));
}
```

### **2.2 Authentication & Security Testing**

#### **API Key Authentication**
```java
@Test
public void testWithAPIKey() {
    given()
        .header("X-API-KEY", "your-api-key-here")
        .queryParam("userId", 1)
    .when()
        .get("/secure/users")
    .then()
        .statusCode(200);
}
```

#### **OAuth 2.0 Bearer Token**
```java
public class AuthHelper {
    public static String getBearerToken() {
        return given()
            .formParam("grant_type", "client_credentials")
            .formParam("client_id", "your-client-id")
            .formParam("client_secret", "your-client-secret")
        .when()
            .post("/oauth/token")
        .then()
            .statusCode(200)
            .extract()
            .path("access_token");
    }
}

@Test
public void testWithBearerToken() {
    String token = AuthHelper.getBearerToken();
    
    given()
        .auth().oauth2(token)
    .when()
        .get("/protected/resource")
    .then()
        .statusCode(200);
}
```

#### **Basic Security Tests**
```java
@Test
public void testUnauthorizedAccess() {
    given()
        // No authentication headers
    .when()
        .get("/protected/users")
    .then()
        .statusCode(401)
        .body("error", equalTo("Unauthorized"));
}

@Test
public void testSQLInjectionAttempt() {
    given()
        .queryParam("userId", "1' OR '1'='1")
    .when()
        .get("/users")
    .then()
        .statusCode(400); // Should reject malicious input
}
```

### **2.3 Schema Validation & Contract Testing (15 minutes)**

#### **JSON Schema Validation**
```java
@Test
public void testUserResponseSchema() {
    given()
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body(matchesJsonSchemaInClasspath("schemas/user-schema.json"));
}
```

#### **User Schema (user-schema.json)**
```json
{
    "$schema": "http://json-schema.org/draft-07/schema#",
    "type": "object",
    "required": ["id", "name", "email"],
    "properties": {
        "id": {
            "type": "integer"
        },
        "name": {
            "type": "string",
            "minLength": 1
        },
        "email": {
            "type": "string",
            "format": "email"
        },
        "address": {
            "type": "object",
            "properties": {
                "street": {"type": "string"},
                "city": {"type": "string"},
                "zipcode": {"type": "string", "pattern": "^[0-9]{5}$"}
            }
        }
    }
}
```

#### **Dynamic Schema Validation**
```java
@Test
public void testDynamicSchemaValidation() {
    // Get schema from API documentation endpoint
    String schema = given()
        .when()
            .get("/api/schema/user")
        .then()
            .statusCode(200)
            .extract()
            .asString();
    
    // Validate actual response against dynamic schema
    given()
    .when()
        .get("/users/1")
    .then()
        .statusCode(200)
        .body(matchesJsonSchema(schema));
}
```

### **2.4 Advanced Framework Patterns **

#### **Custom Response Specifications**
```java
public class ResponseSpecs {
    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectContentType(ContentType.JSON)
            .expectResponseTime(lessThan(3000L))
            .build();
    }
    
    public static ResponseSpecification createdResponse() {
        return new ResponseSpecBuilder()
            .expectStatusCode(201)
            .expectContentType(ContentType.JSON)
            .expectHeader("Location", notNullValue())
            .build();
    }
}

@Test
public void testWithCustomSpecs() {
    given()
    .when()
        .get("/users")
    .then()
        .spec(ResponseSpecs.successResponse())
        .body("size()", greaterThan(0));
}
```

#### **Request/Response Filters**
```java
public class CustomLogFilter implements Filter {
    @Override
    public Response filter(FilterableRequestSpecification requestSpec, 
                          FilterableResponseSpecification responseSpec, 
                          FilterContext context) {
        
        System.out.println("Request URL: " + requestSpec.getURI());
        System.out.println("Request Method: " + requestSpec.getMethod());
        
        Response response = context.next(requestSpec, responseSpec);
        
        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Time: " + response.getTime() + "ms");
        
        return response;
    }
}

@Test
public void testWithCustomFilter() {
    given()
        .filter(new CustomLogFilter())
    .when()
        .get("/users/1")
    .then()
        .statusCode(200);
}
```

---

## **Practical Exercises & Best Practices**

### **Exercise 1: End-to-End User Workflow**
```java
@Test
public void testCompleteUserWorkflow() {
    // 1. Create user
    User newUser = new User("Test User", "test@example.com");
    int userId = given()
        .body(newUser)
    .when()
        .post("/users")
    .then()
        .statusCode(201)
        .extract()
        .path("id");
    
    // 2. Retrieve created user
    given()
        .pathParam("id", userId)
    .when()
        .get("/users/{id}")
    .then()
        .statusCode(200)
        .body("name", equalTo("Test User"));
    
    // 3. Update user
    newUser.setName("Updated User");
    given()
        .pathParam("id", userId)
        .body(newUser)
    .when()
        .put("/users/{id}")
    .then()
        .statusCode(200)
        .body("name", equalTo("Updated User"));
    
    // 4. Delete user
    given()
        .pathParam("id", userId)
    .when()
        .delete("/users/{id}")
    .then()
        .statusCode(204);
    
    // 5. Verify deletion
    given()
        .pathParam("id", userId)
    .when()
        .get("/users/{id}")
    .then()
        .statusCode(404);
}
```

### **Key Best Practices**

#### **Test Organization**
- Group related tests in test classes
- Use meaningful test method names
- Implement proper setup and teardown
- Separate test data from test logic

#### **Assertion Strategies**
- Validate status codes, headers, and response body
- Use appropriate matchers for different data types
- Implement negative test scenarios
- Verify response times and performance

#### **Error Handling**
- Test error responses and status codes
- Validate error message formats
- Test boundary conditions and edge cases
- Implement retry mechanisms for flaky tests

#### **Maintenance & Scalability**
- Use configuration files for environment-specific data
- Implement page object model for API endpoints
- Create reusable utility classes
- Maintain test data independently

---

## **Summary & Next Steps**

### **What We've Covered**
- API testing fundamentals and Rest Assured setup
- Advanced request/response handling
- Authentication and security testing
- Schema validation and contract testing
- Framework design patterns

### **Advanced Topics for Further Learning**
- Performance testing with Rest Assured
- API mocking and virtualization
- Continuous integration/deployment integration
- Advanced reporting and test analytics
- Microservices testing strategies

### **Recommended Tools & Resources**
- **Postman**: API exploration and manual testing
- **Swagger/OpenAPI**: API documentation and contract testing
- **WireMock**: API mocking and simulation
- **TestNG/JUnit**: Test execution frameworks
- **Allure/ExtentReports**: Advanced test reporting
