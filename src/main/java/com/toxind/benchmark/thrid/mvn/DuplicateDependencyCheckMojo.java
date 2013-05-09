package com.toxind.benchmark.thrid.mvn;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

/**
 * @author Ling Kong(Hong Xing)
 * @version 1.0
 * @goal check
 * @requiresDependencyResolution runtime
 */
public class DuplicateDependencyCheckMojo extends AbstractMojo {

    /**
     * The Maven project to analyze.
     *
     * @parameter expression="${project}"
     * @required
     * @readonly
     */
    private MavenProject project;

    /**
     *
     * @parameter
     */
    private boolean failOnWarning;

    @SuppressWarnings("unchecked")
    public void execute() throws MojoExecutionException, MojoFailureException {
        Set<Artifact> artifacts = project.getArtifacts();
        HashMap<String, Artifact> classAndArtifactMap = new HashMap<String, Artifact>();
        boolean hasWarnings = false;
        for (Artifact artifact : artifacts) {
            ZipInputStream zis = null;
            try {
                zis = new ZipInputStream(new BufferedInputStream(new FileInputStream(artifact.getFile())));
                ZipEntry entry;
                while ((entry = zis.getNextEntry()) != null) {
                    if (entry.isDirectory() || !entry.getName().endsWith(".class")) {
                        continue;
                    }
                    if (classAndArtifactMap.containsKey(entry.getName())) {
                        hasWarnings = true;
                        getLog().warn("DUPLICATED CLASS FOUND! " + entry.getName() +
                                "\r\n\t" + artifact +
                                "\r\n\t" + classAndArtifactMap.get(entry.getName()));
                        break;
                    }
                    classAndArtifactMap.put(entry.getName(), artifact);
                }
            } catch (Exception e) {
                throw new MojoExecutionException("Unknown errors...", e);
            } finally {
                try {
                    zis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
//                IOUtils.closeQuietly(zis);
            }
        }
        if (failOnWarning && hasWarnings) {
            throw new MojoFailureException("PLEASE CHECK ABOVE WARNINGS!!! There is duplicated classes found in your dependencies.");
        }
    }
}
