package com.erzbir.accountbook.backup;

import com.erzbir.accountbook.component.BackupStrategy;
import okhttp3.OkHttpClient;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.kohsuke.github.extras.okhttp3.OkHttpGitHubConnector;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GithubBackupStrategy implements BackupStrategy {
    private static final String TOKEN = "";
    private static final String REPOSITORY = "test";
    private static final String BRANCH = "master";

    @Override
    public void backup(Object object) {
        try {
            GitHub gitHub = new GitHubBuilder().withJwtToken(TOKEN)
                    .withConnector(new OkHttpGitHubConnector(new OkHttpClient()))
                    .build();
            GHRepository testRepository = gitHub.getRepository(REPOSITORY);
            if (testRepository == null) {
                return;
            }
            testRepository.createContent().content(getBytes(object)).branch(BRANCH).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "Github";
    }

    @Override
    public boolean isEnable() {
        return true;
    }

    private byte[] getBytes(Object object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(object);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
