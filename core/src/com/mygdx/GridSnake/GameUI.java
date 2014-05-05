package com.mygdx.GridSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.GridSnake.GameScreen.Grid;

public class GameUI extends Table {

	
	private float BUTTON_WIDTH = 300f;
    private final float BUTTON_HEIGHT = 60f;
    private final float BUTTON_SPACING = 10f;
	private Grid grid;
	Label tapScreenLabel;
	Label scoreLabel;
	
	Color gray = new Color(74/255f, 78/255f, 79/255f, 1);
	
	public GameUI(Grid grid)
	{
		this.grid = grid;
        //Table table = new Table();
        setFillParent(true);        
        
        BitmapFont buttonFont = new BitmapFont(Gdx.files.internal("fonts/digiffiti.fnt"),
        		Gdx.files.internal("fonts/digiffiti.png"),false);

		LabelStyle labelStyle = new LabelStyle(buttonFont, gray);
		
		int s = grid.points;
        
		tapScreenLabel = new Label( "DRAG THE SNAKE HEAD...",labelStyle );
        //tapScreenLabel.setFontScale(0.5f);
		scoreLabel = new Label("SCORE: 0",labelStyle);
        //Label subtitle = new Label("Ancient Mystic Wonder Games", labelStyle);

		float origX = 320;
        float origY = 480;
        
        float scaleX = Gdx.graphics.getWidth()/origX;
        float scaleY = Gdx.graphics.getHeight()/origY;
        
        tapScreenLabel.setFontScale(scaleX, scaleY);
        scoreLabel.setFontScale(scaleX, scaleY);
        
        add(scoreLabel).right().pad(10);
        row();
        add(tapScreenLabel).expand();
        row();
	}
	
	
	public void start()
	{
		tapScreenLabel.setText("");
	}
	
	public void stop()
	{
		tapScreenLabel.setText("DRAG THE SNAKE HEAD...");
		scoreLabel.setText("SCORE: 0");
	}
	
	public void updateScore(int score)
	{
		String newScore = Integer.toString(score);
		scoreLabel.setText("SCORE: " + newScore);
	}
	
	/*
	@Override
	public void act(float delta)
	{
		
		if(grid.isPlaying)
		{
			tapScreen.setText("");
		}
		
		else
		{
			tapScreen.setText("Tap and hold on the snake head to start...");
		}
	}
	*/
	
}