
Starter project for a reactive backend with Kotlin, Spring and MongoDB

## Usual use-cases

1. Create a new module
Use the maven archetype org.jetbrains.kotlin:kotlin-archetype-jvm 1.4.32

Replace the created .pom with this template:

```xml
<project xmlns="..." xmlns:xsi="..." xsi:schemaLocation="...">
    <parent>
        <artifactId>starter</artifactId>
        <groupId>com.bogdansalau</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <modelVersion>4.0.0</modelVersion>

    <artifactId>%module name%</artifactId>
    <name>%module name%</name>
    <packaging>jar</packaging>

    <dependencies>
        <!-- This contains Spring dependencies -->
        <dependency>
            <groupId>com.bogdansalau</groupId>
            <artifactId>starter-core</artifactId>
        </dependency>
        <!-- Add test dependencies as needed -->
    </dependencies>

    <build>
        <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
        <testSourceDirectory>${project.basedir}/src/test/kotlin</testSourceDirectory>

        <plugins>
            <plugin>
                <groupId>org.jetbrains.kotlin</groupId>
                <artifactId>kotlin-maven-plugin</artifactId>
                <version>${kotlin.version}</version>
                <executions>
                    <execution>
                        <id>compile</id>
                        <phase>compile</phase>
                        <goals>
                            <goal>compile</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>test-compile</id>
                        <phase>test-compile</phase>
                        <goals>
                            <goal>test-compile</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>
```
Add module to the main `pom.xml`'s `<modules>` and update the `<dependencyManagement>` accordingly.
