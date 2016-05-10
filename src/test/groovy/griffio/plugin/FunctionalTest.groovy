package griffio.plugin

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification;

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS

public class FunctionalTest extends Specification {

  @Rule final TemporaryFolder testProjectDir = new TemporaryFolder()
  File buildFile

  def setup() {
    buildFile = testProjectDir.newFile('build.gradle')
  }

  def "simple task"() {
    given:
    buildFile << """
                plugins {
                id 'simple-plugin'
            }
        """
    when:
    def result = GradleRunner.create()
            .withProjectDir(testProjectDir.root)
            .withArguments('simpleTask')
            .withPluginClasspath()
            .build()

    then:
    result.output.contains('Simple task!')
    println result.task(":simpleTask").outcome == SUCCESS
  }
}
