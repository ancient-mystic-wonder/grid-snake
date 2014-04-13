package com.me.GridSnake;

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
import com.me.GridSnake.GameScreen.Grid;

public class GameUI extends Table {

	
	private float BUTTON_WIDTH = 300f;
    private final float BUTTON_HEIGHT = 60f;
    private final float BUTTON_SPACING = 10f;
	private Grid grid;
	Label tapScreenLabel;
	Label scoreLabel;
	
	public GameUI(Grid grid)
	{
		this.grid = grid;
        //Table table = new Table();
        setFillParent(true);        
        
        Texture upTexture =  new Texture(Gdx.files.internal("data/grass_platform.png"));
        Texture downTexture =  new Texture(Gdx.files.internal("data/block.png"));

        TextureRegion upRegion = new TextureRegion(upTexture);
        TextureRegion downRegion = new TextureRegion(downTexture);
        BitmapFont buttonFont = new BitmapFont(Gdx.files.internal("data/digiffiti.fnt"),
        		Gdx.files.internal("data/digiffiti.png"),false);
        TextButtonStyle style = new TextButtonStyle();
        style.up = new TextureRegionDrawable(upRegion);
        style.down = new TextureRegionDrawable(downRegion);
        style.font = buttonFont;
        
        TextButton button1 = new TextButton("PLAY",style);
        button1.setWidth(BUTTON_WIDTH);
        button1.setHeight(BUTTON_HEIGHT);
        
		
		LabelStyle labelStyle = new LabelStyle(buttonFont, Color.WHITE);
		
		int s = grid.points;
        
		tapScreenLabel = new Label( "DRAG THE SNAKE HEAD...",labelStyle );
        //tapScreenLabel.setFontScale(0.5f);
		scoreLabel = new Label("000",labelStyle);
        //Label subtitle = new Label("Ancient Mystic Wonder Games", labelStyle);

        
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
	}
	
	public void updateScore(int score)
	{
		String newScore = Integer.toString(score);
		scoreLabel.setText(newScore);
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
