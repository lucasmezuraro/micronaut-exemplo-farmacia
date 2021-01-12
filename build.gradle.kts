plugins {
    id("org.jetbrains.kotlin.jvm") version "1.4.10"
    id("org.jetbrains.kotlin.kapt") version "1.4.10"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("io.micronaut.application") version "1.2.0"
}

version = "0.1"
group = "br.com.lucasmezuraro"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
    jcenter()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("br.com.lucasmezuraro.*")
    }
}




dependencies {
    compile("io.micronaut.configuration:micronaut-micrometer-core:1.3.1")
    //compile("io.micronaut.configuration:micronaut-micrometer-registry-statsd:1.3.1")
    compile("io.micronaut:micronaut-management:2.2.1")
    implementation("io.micronaut.cache:micronaut-cache-caffeine")
    implementation("io.micronaut.configuration:micronaut-micrometer-registry-prometheus:1.3.1")

    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-http-server-netty")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.micronaut:micronaut-http-client")
    implementation("javax.annotation:javax.annotation-api")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    implementation("io.micronaut:micronaut-validation")

    annotationProcessor("io.micronaut.data:micronaut-data-processor:2.2.1")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa:2.2.1")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("io.micronaut:micronaut-inject-java:2.2.1")




}


application {
    mainClass.set("br.com.lucasmezuraro.ApplicationKt")
}

java {
    sourceCompatibility = JavaVersion.toVersion("1.8")
}

/*tasks.withType<Jar> {
    // Otherwise you'll get a "No main manifest attribute" error
    manifest {
        attributes["Main-Class"] = "br.com.lucasmezuraro.ApplicationKt"
    }

    // To add all of the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })

}*/



tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }




}

