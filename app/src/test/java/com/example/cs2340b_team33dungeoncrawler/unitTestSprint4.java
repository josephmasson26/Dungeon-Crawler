package com.example.cs2340b_team33dungeoncrawler;

import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.ImageView;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.BossEnemy;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.GruntEnemy;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.LargeEnemy;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.SmallEnemy;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveUpObserver;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.Enemy;

public class unitTestSprint4 {

    //Joseph's Tests

    @Test
    public void testLargeEnemy() {
        EnemyFactory.clearArray();
        EnemyFactory.createEnemy("large");
        assertEquals(EnemyFactory.getEnemies().get(0).getDamage(), 15.0, 0);
    }

    @Test
    public void testSmallEnemyFactory() {
        EnemyFactory.clearArray();
        EnemyFactory.createEnemy("small");
        assertEquals(EnemyFactory.getEnemies().get(0).getDamage(), 10.0, 0);
    }

    //Yuzif's Tests
    @Test
    public void testEnemyListAfterCreation() {
        EnemyFactory.clearArray();
        EnemyFactory.createEnemy("small");
        EnemyFactory.createEnemy("large");
        assertEquals(2, EnemyFactory.getEnemies().size());
    }

    @Test
    public void testClearEnemyList() {
        EnemyFactory.getInstance();
        EnemyFactory.clearArray();
        assertTrue(EnemyFactory.getEnemies().isEmpty());
    }

    //Austin's Tests
    @Test
    public void testEnemyFactoryCreatesBossEnemy() {
        EnemyFactory.clearArray();
        Enemy enemy = EnemyFactory.createEnemy("boss");
        assertTrue(enemy instanceof BossEnemy);
    }
    @Test
    public void testEnemyFactoryCreatesGruntEnemy() {
        EnemyFactory.clearArray();
        Enemy enemy = EnemyFactory.createEnemy("grunt");
        assertTrue(enemy instanceof GruntEnemy);
    }

    //Shube's Tests
    @Test
    public void testEnemyFactoryCreatesLargeEnemy() {
        Enemy enemy = EnemyFactory.createEnemy("large");
        assertTrue(enemy instanceof LargeEnemy);
    }
    @Test
    public void testEnemyFactoryCreatesSmallEnemy() {
        Enemy enemy = EnemyFactory.createEnemy("small");
        assertTrue(enemy instanceof SmallEnemy);
    }
    
    //Aadi's Tests
    @Test
    public void testGruntEnemy() {
        EnemyFactory.clearArray();
        EnemyFactory.createEnemy("grunt");
        assertEquals(EnemyFactory.getEnemies().get(0).getDamage(), 5, 0);
    }

    @Test
    public void testBossEnemy() {
        EnemyFactory.clearArray();
        EnemyFactory.createEnemy("boss");
        assertEquals(EnemyFactory.getEnemies().get(0).getDamage(), 20, 0);
    }
}
