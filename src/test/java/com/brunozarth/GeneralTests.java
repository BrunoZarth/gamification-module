package com.brunozarth;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeneralTests {

    ForumServiceGamificationProxy proxy;
    AchievementStorage mock;

    @Before
    public void configuration(){
        this.mock = new MemoryAchievementStorageMock();
        AchievementStorageFactory.setAchievementStorage(mock);
        this.proxy = new ForumServiceGamificationProxy();
    }

    @Test
    public void addTopicAndVerifyIfCorrectlyInsertedAchievementsToUser(){
        proxy.addTopic("Bob", "Welcome Topic");
        Achievement creationPoints = mock.getAchievement("Bob", "CREATION");
        Achievement iCanTalkBadge = mock.getAchievement("Bob", "I CAN TALK");
        assertEquals("CREATION", creationPoints.getName());
        assertEquals(5, ((Points) creationPoints).getPoints());
        assertEquals("I CAN TALK", iCanTalkBadge.getName());
    }

    @Test
    public void addCommentAndVerifyIfCorrectlyInsertedAchievementsToUser(){
        proxy.addComment("Bob", "Welcome Topic", "Hi Everybody!");
        Achievement creationPoints = mock.getAchievement("Bob", "PARTICIPATION");
        Achievement iCanTalkBadge = mock.getAchievement("Bob", "LET ME ADD");
        assertEquals("PARTICIPATION", creationPoints.getName());
        assertEquals(3, ((Points) creationPoints).getPoints());
        assertEquals("LET ME ADD", iCanTalkBadge.getName());
    }

    @Test
    public void likeTopicAndVerifyIfCorrectlyInsertedAchievementsToUser(){
        proxy.likeTopic("Bob", "Welcome Topic", "Marley");
        Achievement creationPoints = mock.getAchievement("Bob", "CREATION");
        assertEquals("CREATION", creationPoints.getName());
        assertEquals(6, ((Points) creationPoints).getPoints());
    }

    @Test
    public void likeCommentAndVerifyIfCorrectlyInsertedAchievementsToUser(){
        proxy.likeComment("Bob", "Welcome Topic", "Hello everybody!", "Marley");
        Achievement creationPoints = mock.getAchievement("Bob", "PARTICIPATION");
        assertEquals("PARTICIPATION", creationPoints.getName());
        assertEquals(4, ((Points) creationPoints).getPoints());
    }

    @Test
    public void addTopicTwiceAndVerifyIfCorrectlyInsertedAchievementsToUser(){
        proxy.addTopic("Bob", "Welcome Topic");
        proxy.addTopic("Bob", "Welcome Topic");
        Achievement creationPoints = mock.getAchievement("Bob", "CREATION");
        Achievement iCanTalkBadge = mock.getAchievement("Bob", "I CAN TALK");
        assertEquals("CREATION", creationPoints.getName());
        assertEquals(16, ((Points) creationPoints).getPoints());
        assertEquals("I CAN TALK", iCanTalkBadge.getName());
    }

    public void add100PointsToCREATIONAndVerifyIfUserEarnsINVENTORBadge(){
        Points points = new Points("CREATION", 100);
        mock.addAchievement("Bob", points);
        Achievement inventorBadge = mock.getAchievement("Bob", "INVENTOR");
        assertEquals("INVENTOR", inventorBadge.getName());
    }

    public void add100PointsToPARTICIPATIONAndVerifyIfUserEarnsPARTOFTHECOMMUNITYBadge(){
        Points points = new Points("CREATION", 100);
        mock.addAchievement("Bob", points);
        Achievement inventorBadge = mock.getAchievement("Bob", "PART OF THE COMMUNITY");
        assertEquals("PART OF THE COMMUNITY", inventorBadge.getName());
    }
}
