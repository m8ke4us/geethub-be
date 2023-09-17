package com.m8ke4us.geethub.config;

import lombok.Getter;
import org.kohsuke.github.*;

import java.io.IOException;

public class GithubApi {
    String token = "";

    @Getter
    GitHub github;

    private GithubApi() throws IOException {
        github = new GitHubBuilder().withOAuthToken(token).build();

//        // Api 테스트
//        GHUser loginUser = github.getUser("yuhyeminn");
//
//        // 팔로잉 리스트
//        GHPersonSet<GHUser> followlist = loginUser.getFollows();
//        for(GHUser user : followlist){
//            System.out.println(user.getLogin()); //login id
//            System.out.println(user.getName()); //name
//
//            // 커밋 리스트
//           GHCommitSearchBuilder builder = github.searchCommits()
//                                                    .author(user.getLogin())
//                                                    .sort(GHCommitSearchBuilder.Sort.AUTHOR_DATE);
//           PagedSearchIterable<GHCommit> commits = builder.list().withPageSize(10);
//           System.out.println(commits.getTotalCount());
//        }

    }
}
