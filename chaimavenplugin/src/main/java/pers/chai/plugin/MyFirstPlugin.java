package pers.chai.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

/**
 * @Copyright: www.hikvision.com Inc. All rights reserved.
 * @ClassName: MyFirstPlugin
 * @Description: MyFirstPlugin,支持msg，List数组和带参数的使用
 * @author: chaishuai
 * @date: 2020/3/12 17:07
 * @version: V1.0.0
 */
@Mojo(name = "myfirstplugin", defaultPhase = LifecyclePhase.PACKAGE)
public class MyFirstPlugin extends AbstractMojo{

    @Parameter
    private String msg;
    @Parameter
    private List<String> options;
    @Parameter
    private String args;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("hello, this is msg: " + msg);
        System.out.println("hello, this is options: " + options);
        System.out.println("hello, this is args: " + args);
    }
}
