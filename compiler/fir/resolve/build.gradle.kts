/*
 * Copyright 2000-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

plugins {
    kotlin("jvm")
    id("jps-compatible")
}

jvmTarget = "1.6"

dependencies {
    compile(project(":core:descriptors"))
    compile(project(":core:deserialization"))
    compile(project(":compiler:fir:cones"))
    compile(project(":compiler:fir:tree"))
    compile(commonDep("org.jetbrains:annotations"))

    compileOnly(intellijCoreDep()) { includeJars("intellij-core") }

    testCompileOnly(intellijDep()) { includeJars("openapi", "idea", "idea_rt", "util", "asm-all", rootProject = rootProject) }


    testRuntime(intellijDep())

    testCompile(commonDep("junit:junit"))
    testCompileOnly(project(":kotlin-test:kotlin-test-jvm"))
    testCompileOnly(project(":kotlin-test:kotlin-test-junit"))
    testCompile(projectTests(":compiler:tests-common"))
    
    testCompileOnly(project(":kotlin-reflect-api"))
    testRuntime(project(":kotlin-reflect"))

}

sourceSets {
    "main" { projectDefault() }
    "test" { projectDefault() }
}

projectTest {
    workingDir = rootDir
}

testsJar()