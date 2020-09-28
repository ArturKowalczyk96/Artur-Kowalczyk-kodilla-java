package com.kodilla.testing.forum.ststistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateStatistics {
    private final Statistics statistics;

    public CalculateStatistics(Statistics statistics){
        this.statistics = statistics;
    }
    public Map<String, Double> calculateAdvStatistics(Statistics statistics){
        //New map of statistics
        Map<String, Double> statisticsMap = new HashMap<>();

        //Number of users
        final String stringNumberOfUsers = "Number of users: ";
        List<String> usersList = statistics.usersNames();
        double numberOfUsers = (double) usersList.size();
        statisticsMap.put(stringNumberOfUsers, numberOfUsers);

        //Number of posts
        final String stringNumberOfPosts = "Number of posts: ";
        double numberOfPosts = (double) statistics.postsCount();
        statisticsMap.put(stringNumberOfPosts, numberOfPosts);

        //Number of comments
        final String stringNumberOfComments = "Number of comments: ";
        double numberOfComments = (double) statistics.commentsCount();
        statisticsMap.put(stringNumberOfComments, numberOfComments);

        //Average of posts per user
        final String stringAveragePostsPerUser = "Average number of posts per user: ";
        if (numberOfUsers == 0){
            statisticsMap.put(stringAveragePostsPerUser + "Number of users: 0", numberOfUsers);
        } else {
            double averagePostsPerUser = numberOfPosts / numberOfUsers;
            statisticsMap.put(stringAveragePostsPerUser, averagePostsPerUser);
        }

        //Average of comments per user
        final String stringAverageCommentsPerUser = "Average number of comments per user: ";
        if (numberOfUsers == 0){
            statisticsMap.put(stringAveragePostsPerUser + "Number of users: 0", numberOfUsers);
        } else {
            double averageCommentsPerUser = numberOfComments / numberOfUsers;
            statisticsMap.put(stringAverageCommentsPerUser, averageCommentsPerUser);
        }
        //Average of comments per post
        final String stringAverageCommentsPerPost = "Average number of comments per post: ";
        if (numberOfPosts == 0){
            statisticsMap.put(stringAveragePostsPerUser + "Number of users: 0", numberOfPosts);
        } else {
            double averageCommentsPerPost = numberOfComments / numberOfPosts;
            statisticsMap.put(stringAverageCommentsPerPost, averageCommentsPerPost);
        }
        return statisticsMap;
    }
    public String showStatistics(){
        return "statistics";
    }
}
