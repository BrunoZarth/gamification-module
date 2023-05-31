package com.brunozarth;

import java.util.List;

public class NullAchievementStorage implements AchievementStorage {
    @Override
    public void addAchievement(String user, Achievement a) {

    }

    @Override
    public List<Achievement> getAchievements(String user) {
        return null;
    }

    @Override
    public Achievement getAchievement(String user, String achievementName) {
        return null;
    }

    @Override
    public void achievementUpdate(String user, Achievement a) {

    }
}
