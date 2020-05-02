package algorithm;

import java.util.*;


class Twitter {
    class Node {
        // 关注者集合
        Set<Integer> followee = new HashSet<>();
        // 推特链表
        List<Integer> tweet = new LinkedList<>();
    }
    // getNewsFeed 检索的推文的上限以及 tweetId 的时间戳
    int recentMax= 10, time = 0;
    // 用户列表
    Map<Integer, Node> users = new HashMap<>();
    // 每条推特发送时间
    Map<Integer, Integer> tweetTime = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (users.get(userId) == null) {
            users.put(userId, new Node());
        }
        Node userNode = users.get(userId);
        userNode.tweet.add(tweetId);
        users.put(userId, userNode);
        tweetTime.put(tweetId, time);
        time++;
        return;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user
     * followed or by the user herself. Tweets must be ordered from most
     * recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (users.get(userId) == null) {
            return feed;
        }
        Node userNode = users.get(userId);
        feed.addAll(userNode.tweet);
        for (int followeeId : userNode.followee) {
            // System.out.println(followeeId);
            feed.addAll(users.get(followeeId).tweet);
        }
        // System.out.println(feed.toString());
        Collections.sort(feed, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (tweetTime.get(o1) > tweetTime.get(o2)) {
                    return -1;
                }
                return 1;
            }
        });
        if (feed.size() <= 10) {
            return feed;
        }
        return feed.subList(0, 10);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // 要点 关注时不能关注自己
        if (followerId == followeeId) {
            return;
        }
        if (users.get(followerId) == null) {
            users.put(followerId, new Node());
        }
        if (users.get(followeeId) == null) {
            users.put(followeeId, new Node());
        }
        Node userNode = users.get(followerId);
        userNode.followee.add(followeeId);
        return;
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // followerId, followeeId任一不存在就直接返回
        if (users.get(followeeId) == null || users.get(followerId) == null) {
            return;
        }
        Node userNode = users.get(followerId);
        // 关注列表中不存在followeeId
        if (!userNode.followee.contains(followeeId)) {
            return;
        }
        userNode.followee.remove(followeeId);
        return;
    }
}

/**
 * Your algorithm.Twitter object will be instantiated and called as such:
 * algorithm.Twitter obj = new algorithm.Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */