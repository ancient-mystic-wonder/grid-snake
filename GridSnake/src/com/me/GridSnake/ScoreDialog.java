package com.me.GridSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.me.GridSnake.GameScreen.Grid;

public class ScoreDialog extends Dialog {

	private Grid grid;
	
	public ScoreDialog(String title, Skin skin) {
		super(title, skin);
		// TODO Auto-generated constructor stub
	}
	
	public ScoreDialog(String title, Skin skin, Grid grid)
	{
		super(title, skin);
		this.grid = grid;
		
		this.text("Your Score Here");
		this.button("Play again");
	}
	
	public ScoreDialog(String title, WindowStyle style, Grid grid)
	{
		super(title, style);
		this.grid = grid;

		
		this.text("Your Score Here");
	}
}