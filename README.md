# Serenity and Cucumber with SpringBoot


```bash
mkdir lab-tas
cd lab-tas
git clone https://github.com/rehmanuet/serenity-java.git
mvn clean verify -Dcucumber.filter.tags="@dev" -Dbrowser=chrome
```

Following parameter needs to be provided to the runner
1. `-Dcucumber.filter.tags="@dev"` (run specifically tagged testcases)
2. `-Dbrowser=chrome` (run on specific browser eg. firefox/edge/safari)
SpringBoot is used for Dependency Injection

```java
@RunWith(SerenityRunner.class)
@SpringBootTest(classes = TestContextConfiguration.class)

public class LoginSteps extends UIInteractionSteps {
    @Steps
    SpringConfiguration configuration;

    @Autowired
    ScenarioContext context;

    @Rule
    public SpringIntegrationMethodRule springIntegrationMethodRule =
            new SpringIntegrationMethodRule();

    @Steps
    LoginPage loginPage;

    @Given("{string} is logged into the dashboard")
    public void isLoggedIntoTheDashboard(String user) {
        openUrl("https://www.saucedemo.com/");
        loginPage.login(this.context.getUser(user));
    }
}
```

@Bean injected
```java
@Configuration
public class SpringConfiguration {

    @Bean
    public Map<String, User> users() {
        try {
            String usersJson = Files.readString(Path.of(Paths.get(Objects.requireNonNull
                    (getClass().getResource("/user.json")).toURI()).toString()));
            return jsonToMap(usersJson, User.class);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to read users configuration", e);
        }
    }
}

```
