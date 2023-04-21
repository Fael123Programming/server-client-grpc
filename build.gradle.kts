import com.google.protobuf.gradle.id

plugins {
    java
    id("com.google.protobuf") version "0.9.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val grpcVersion = "1.54.0"
val protocVersion = "3.22.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:${protocVersion}")
    implementation("io.grpc:grpc-netty:${grpcVersion}");
    implementation("io.grpc:grpc-protobuf:${grpcVersion}");
    implementation("io.grpc:grpc-stub:${grpcVersion}");
    implementation("javax.annotation:javax.annotation-api:1.3.1")
    implementation("ch.qos.logback:logback-classic:1.4.6")
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:${protocVersion}" }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:${grpcVersion}"
        }
    }
    generateProtoTasks {
        all()
            .forEach {
                it.plugins {
                    id("grpc") {}
                }
            }
    }
}