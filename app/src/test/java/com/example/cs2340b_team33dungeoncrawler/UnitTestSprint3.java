package com.example.cs2340b_team33dungeoncrawler;

import org.junit.Test;
import static org.junit.Assert.*;

import android.widget.ImageView;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.cs2340b_team33dungeoncrawler.model.Player;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveDown;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveLeft;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveRight;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MoveUp;
import com.example.cs2340b_team33dungeoncrawler.model.moveModels.MovementStrategy;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveDownObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveLeftObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveRightObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MoveUpObserver;
import com.example.cs2340b_team33dungeoncrawler.model.observers.MovementSubject;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestSprint3 {
    //Joseph Tests
    @Mock
    private ImageView sprite = new ImageView(null);
    @Test
    public void testMoveUp() {
        Player player = Player.getInstance();
        MovementStrategy moveUp = new MoveUp();
        player.setMovementStrategy(moveUp);
        assertEquals(moveUp, player.getMovementStrategy());
    }

    @Test
    public void testMoveDown() {
        Player player = Player.getInstance();
        MovementStrategy moveDown = new MoveDown();
        player.setMovementStrategy(moveDown);
        assertEquals(moveDown, player.getMovementStrategy());
    }
    //Austin Tests
    @Test
    public void testMoveLeft() {
        Player player = Player.getInstance();
        MovementStrategy moveLeft = new MoveLeft();
        player.setMovementStrategy(moveLeft);
        assertEquals(moveLeft, player.getMovementStrategy());
    }

    @Test
    public void testMoveRight() {
        Player player = Player.getInstance();
        MovementStrategy moveRight = new MoveRight();
        player.setMovementStrategy(moveRight);
        assertEquals(moveRight, player.getMovementStrategy());
    }


    //Yuzif Tests

    @Test
    public void testUpObserver() {
        MovementSubject moveUp = new MovementSubject();
        moveUp.addObserver(new MoveUpObserver());
        MovementSubject finalMoveUp = moveUp;
        assertEquals(moveUp, finalMoveUp);
    }

    @Test
    public void testDownObserver() {
        MovementSubject moveDown = new MovementSubject();
        moveDown.addObserver(new MoveDownObserver());
        MovementSubject finalMoveDown = moveDown;
        assertEquals(moveDown, finalMoveDown);
    }


    //Shube Tests
    
    @Test
    public void TestLeftObserver() {
        MovementSubject moveLeft = new MovementSubject();
        moveLeft.addObserver(new MoveLeftObserver());
        MovementSubject finalMoveLeft = moveLeft;
        assertEquals(moveLeft.getObserver(), finalMoveLeft.getObserver());
    }

    @Test
    public void TestRightObserver() {
        MovementSubject moveRight = new MovementSubject();
        moveRight.addObserver(new MoveRightObserver());
        MovementSubject finalMoveRight = moveRight;
        assertEquals(moveRight.getObserver(), finalMoveRight.getObserver());
    }



    //Aadi Tests
    @Test
    public void testUpBoundary() {

        sprite.setX(800);
        sprite.setY(30);
        MovementSubject moveUp = new MovementSubject();
        moveUp.addObserver(new MoveUpObserver());
        MovementSubject finalMoveUp = moveUp;
        finalMoveUp.notifyObservers(sprite);
        assertEquals(0, sprite.getY(), 0);
    }

    @Test
    public void testDownBoundary() {
        sprite.setX(800);
        sprite.setY(450);
        MovementSubject moveDown = new MovementSubject();
        moveDown.addObserver(new MoveDownObserver());
        MovementSubject finalMoveDown = moveDown;
        finalMoveDown.notifyObservers(sprite);
        assertEquals(0, sprite.getY(), 0);
    }

}
