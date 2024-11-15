package com.evan.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("evanTest") {
            it.doLast {
                project.logger.lifecycle("Test 0.2.0 task completed successfully")
            }
        }
    }
}