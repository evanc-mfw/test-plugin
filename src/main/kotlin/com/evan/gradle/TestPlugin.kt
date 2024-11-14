package com.evan.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class TestPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("evanTest") {
            it.doLast {
                project.logger.lifecycle("Test task completed successfully")
            }
        }
    }
}