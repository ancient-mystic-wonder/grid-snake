package com.me.GridSnake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class InstructionsScreen implements Screen {

	GridSnakeGame game;
	private Stage stage;
	
	private float BUTTON_WIDTH = 200f;
    private float BUTTON_HEIGHT = 60f;
    private final float BUTTON_SPACING = 10f;
    
    Color gray = new Color(74/255f, 78/255f, 79/255f, 1);

    // constructor to keep a reference to the main Game class
     public InstructionsScreen(GridSnakeGame game){
             this.game = game;
             //create();
     }

     public void create () {
    	 
    	 
     }

     
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		//Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );
		Gdx.gl.glClearColor(182/255f, 222/255f, 159/255f, 1);
		//Gdx.gl.glClearColor(185/255f, 199/255f, 51/255f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Table.drawDebug(stage);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        
        
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Texture.setEnforcePotImages(false);
		 
		
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        
        float origX = 320;
        float origY = 480;
        
        float scaleX = Gdx.graphics.getWidth()/origX;
        float scaleY = Gdx.graphics.getHeight()/origY;
        
        
        /// Button style and font
        
        Texture upTexture =  new Texture(Gdx.files.internal("data/playButtonTexture.png"));
        Texture downTexture =  new Texture(Gdx.files.internal("data/playButtonTexture_down.png"));
        upTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        downTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
        
        TextureRegion upRegion = new TextureRegion(upTexture);
        TextureRegion downRegion = new TextureRegion(downTexture);
        BitmapFont buttonFont = new BitmapFont(Gdx.files.internal("data/digiffiti.fnt"),
        		Gdx.files.internal("data/digiffiti.png"),false);
        BitmapFont companyFont = new BitmapFont(Gdx.files.internal("data/digiffiti.fnt"),
        		Gdx.files.internal("data/digiffiti.png"),false);
        TextButtonStyle style = new TextButtonStyle();
        style.up = new TextureRegionDrawable(upRegion);
        style.down = new TextureRegionDrawable(downRegion);
        buttonFont.setScale(scaleX*1.25f, scaleY*1.25f);
        style.font = buttonFont;
        style.fontColor = gray;
        
        BUTTON_WIDTH = upTexture.getWidth()*scaleX*0.95f;
        BUTTON_HEIGHT = upTexture.getHeight()*scaleY*0.95f;
        
        
        
        
        // INSTRUCTIONS
        LabelStyle labelStyle = new LabelStyle(companyFont,gray);
        
        Label instructionText = new Label("INSTRUCTIONS", labelStyle);
        instructionText.setFontScale(scaleX*1.5f,scaleY*1.5f);
        
        Label instruction1 = new Label("EAT THE FOODS TO GET LONGER ", labelStyle);
        instruction1.setFontScale(scaleX*0.7f,scaleY*0.7f);

        Label instruction2 = new Label("EAT YOUR TAIL TO GET SHORTER", labelStyle);
        instruction2.setFontScale(scaleX*0.7f,scaleY*0.7f);

        Label instruction3 = new Label("GIVE DALE YOUR MONEY", labelStyle);
        instruction3.setFontScale(scaleX*0.7f,scaleY*0.7f);
        
        // BUTTON INSTANTIATION

        TextButton backButton = new TextButton("BACK",style);
        backButton.setWidth(BUTTON_WIDTH);
        backButton.setHeight(BUTTON_HEIGHT);
        
        backButton.addListener( new ClickListener()
        {
        	public void clicked(InputEvent event,float x,float y)
        	{
        		game.mainMenu();
        	}
        });

        
        table.add(instructionText);
        table.row();
        table.add(instruction1).pad(2);
        table.row();
        table.add(instruction2).pad(2);
        table.row();
        table.add(instruction3).pad(2);
        table.row();
        table.add(backButton).width(BUTTON_WIDTH).height(BUTTON_HEIGHT).pad(5);;
        stage.addActor(table);
        
        // Add widgets to the table here.
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
	}

}