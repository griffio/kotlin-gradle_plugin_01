package griffio.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

fun Project.configure(exec: Project.() -> Unit) = exec()

class SimplePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.configure {
            afterEvaluate {
                it.tasks.create("simpleTask", SimpleTask::class.java)
            }
        }
    }
}