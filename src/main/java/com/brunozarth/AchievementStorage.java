package com.brunozarth;

import java.util.List;

public interface AchievementStorage extends AchievementObserver {
    void addAchievement(String user, Achievement a);
    List<Achievement> getAchievements(String user);
    Achievement getAchievement(String user, String achievementName);
}
