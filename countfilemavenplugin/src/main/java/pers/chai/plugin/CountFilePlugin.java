package pers.chai.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

/**
 * @Copyright: www.hikvision.com Inc. All rights reserved.
 * @ClassName: CountFilePlugin
 * @Description: TODO
 * @author: chaishuai
 * @date: 2020/3/13 11:07
 * @version: V1.0.0
 */
@Mojo(name = "countFile", defaultPhase = LifecyclePhase.PACKAGE)
public class CountFilePlugin extends AbstractMojo {

    @Parameter(property = "path")
    private String path;

    private int num1 = 0;
    private int num2 = 0;
    private int num3 = 0;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("*****" + path);
        System.out.println("*****" + countFile(path));
    }

    public String countFile(String path) {
        File file = new File(path);
        File fs[] = file.listFiles();
        if (fs != null) {
            for (int i=0; i < fs.length; i++) {
                File currentFile = fs[i];
                if (currentFile.isFile()) {
                    num1 += 1;
                    String fileName = currentFile.getName();
                    String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                    if (suffix.equalsIgnoreCase("java")) {
                        num3++;
                    }
                } else {
                    //directors
                    num2++;
                    countFile(currentFile.getAbsolutePath());
                }
            }
        }
        return "Total number of File:" + num1
                + "@@@ The number of dir is:" + num2
                + "@@@ Total number of Java File:" + num3;
    }
}
