package com.example.cs2340b_team33dungeoncrawler;

import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.ImageView;

import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.Enemy;
import com.example.cs2340b_team33dungeoncrawler.model.enemies.EnemyFactory;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.AttackRangePowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.HealthPowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.NukePowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PlayerAttackRangePowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PlayerHealthPowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PlayerNukePowerUp;
import com.example.cs2340b_team33dungeoncrawler.model.powerUps.PowerUp;

public class UnitTestSprint5 {

    //Joseph's Tests
    @Test
    public void testHealthPowerUp() {
        Player player = Player.getInstance();
        PowerUp playerHealthPowerUp = new PlayerHealthPowerUp(player);
        HealthPowerUp healthPowerUp = new HealthPowerUp(playerHealthPowerUp);
        player.setHp(80);
        healthPowerUp.usePowerUp(player);
        assertEquals(player.getHp(), 100.0, 0);
    }

    @Test
    public void testAttackRangePowerUp() {
        Player player = Player.getInstance();
        PowerUp playerAttackRangePowerUp = new PlayerAttackRangePowerUp(player);
        AttackRangePowerUp attackRangePowerUp = new AttackRangePowerUp(playerAttackRangePowerUp);
        attackRangePowerUp.usePowerUp(player);
        assertEquals(player.getAdditionalAttackRange(), 75., 0);
    }

    //Austin's Tests
    @Test
    public void testNukePowerUp() {
        Player player = Player.getInstance();
        PowerUp playerNukePowerUp = new PlayerNukePowerUp(player);
        NukePowerUp nukePowerUp = new NukePowerUp(playerNukePowerUp);
        nukePowerUp.usePowerUp(player);
        assertEquals(player.getAdditionalAttackRange(), 100000., 0);
    }

    @Test
    public void testEnemyDies() {
        Enemy enemyOne = EnemyFactory.createEnemy("grunt");
        enemyOne.die();
        assertEquals(enemyOne.isAlive(), false);
    }
}
