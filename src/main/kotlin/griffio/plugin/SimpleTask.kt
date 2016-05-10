package griffio.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class SimpleTask : DefaultTask() {
    val greeting = "Simple task!"

    @TaskAction
    fun greet() {
        print(greeting)
    }
}
