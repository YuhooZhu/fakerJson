package cn.fakejson.fakejson;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Hello world!
 *
 */
@Mojo(name = "hello") // Mojo的名称
public class App extends AbstractMojo {

	// Mojo的参数，可以在使用插件的项目中配置
	@Parameter(property = "test.word.test", defaultValue = "nothing")
	private String word;

	// 执行hello插件时候就执行execute方法
	public void execute() throws MojoExecutionException, MojoFailureException {
		getLog().info("hello word.");
		getLog().info(this.word);
	}
}
