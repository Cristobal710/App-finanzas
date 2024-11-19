plugins {
	id("java")
	id("org.springframework.boot") version "3.3.5"
	id("io.spring.dependency-management") version "1.1.6"

}

group = "com.financeModule"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot dependencies
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Lombok (Compile only and annotation processor)
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// H2 database
	runtimeOnly("com.h2database:h2")

	// Testing dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	// Use JUnit Jupiter for testing.
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
	//Cucumber
	testImplementation ("io.cucumber:cucumber-java:7.4.1")
	testImplementation ("io.cucumber:cucumber-junit:7.4.1")
}

tasks.withType<ProcessResources> {
	duplicatesStrategy = DuplicatesStrategy.EXCLUDE // You can also use INCLUDE, WARN, or FAIL
}

sourceSets {
	named("test") {
		java.srcDirs("src/test/java")  // Include all Java files, including step definitions
		resources.srcDirs("src/test/resources")  // Location of feature files
	}
}
tasks.test {
	dependsOn(tasks.classes)  // Ensure testClasses are compiled before running tests
}


