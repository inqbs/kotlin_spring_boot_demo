import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	idea

	id("org.springframework.boot") version "2.2.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.9.RELEASE"
	kotlin("jvm") version "1.3.61"
	kotlin("plugin.spring") version "1.3.61"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
	runtimeClasspath {
		extendsFrom(developmentOnly)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.1")
	implementation("org.springframework.session:spring-session-core")
	implementation("org.thymeleaf.extras:thymeleaf-extras-java8time")

	runtimeOnly("mysql:mysql-connector-java")

	testImplementation(kotlin("test"))
	/*developmentOnly("junit:junit:5.3.2")*/
	/*testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.2")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.3.2")*/
	testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.61")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.3.61")

	developmentOnly("org.springframework.boot:spring-boot-devtools")


	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}


idea {
	module {
		inheritOutputDirs = false
		outputDir = file("$buildDir/classes/kotlin/main")
	}
}

//  auto reload resources on kotlin spring boot
tasks.getByName<org.springframework.boot.gradle.tasks.run.BootRun>("bootRun") {
	sourceResources(sourceSets["main"])
}
