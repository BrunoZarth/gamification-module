package com.brunozarth;

public class ForumServiceGamificationProxy implements ForumService{

    AchievementStorage achievementStorage;

    public ForumServiceGamificationProxy(){
        this.achievementStorage = AchievementStorageFactory.getAchievementStorage();
    }


    @Override
    public void addTopic(String user, String topic) {
        Points points = new Points("CREATION", 5);
        achievementStorage.addAchievement(user, points);
        Badge badge = new Badge("I CAN TALK");
        achievementStorage.addAchievement(user, badge);
    }

    @Override
    public void addComment(String user, String topic, String comment) {
        Points points = new Points("PARTICIPATION", 3);
        achievementStorage.addAchievement(user, points);
        Badge badge = new Badge("LET ME ADD");
        achievementStorage.addAchievement(user, badge);
    }

    @Override
    public void likeTopic(String user, String topic, String topicUser) {
        Points points = new Points("CREATION", 1);
        achievementStorage.addAchievement(user, points);
    }

    @Override
    public void likeComment(String user, String topic, String comment, String commentUser) {
        Points points = new Points("PARTICIPATION", 1);
        achievementStorage.addAchievement(user, points);
    }
}
