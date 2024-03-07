#Serenity and Cucumber

_TODO Update README.MD_

```
mkdir lab-tas
cd lab-tas
git clone https://github.com/rehmanuet/serenity-java.git
mvn clean verify -Dcucumber.filter.tags="@dev" -Dbrowser=chrome
```

Following parameter are need to be provided to runner
1. `-Dcucumber.filter.tags="@dev"` (run specific tagged testcases)
2. `-Dbrowser=chrome` (run on specific browser eg. firefox/edge/safari)
