package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MenuScreen  implements Screen{

    Stage stage;
    Skin skin;
    Table table;
    
    TextButton startButton;
    TextButton quitButton;
    
    TowerGame game;
    private TextButton mapEditorButton; 
    
    public MenuScreen(TowerGame g) {
        
        
        game = g;
        
        skin  = new Skin(Gdx.files.internal("skin/uiskin.json"));
        
        table = new Table(skin);
        table.setFillParent(true);
        table.debug();
        
        
        stage = new Stage();
        
        
        
        
        stage.addActor(table);
        
        startButton = new TextButton("Start Game",skin);
        
        quitButton = new TextButton("Quit",skin);
        
        mapEditorButton = new TextButton("Edit Map", skin);
       
        startButton.addListener(new ClickListener(){
            
            public void clicked(InputEvent event, float x, float y) 
            {
                startGame();
            };  
        });
        
        quitButton.addListener(new ClickListener(){
            public void clicked(InputEvent event, float x, float y) {
                quitGame();
            };
        });
        
        mapEditorButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                editMap();
            }
        });
        
        table.add(startButton).width(200);
        table.row();
        table.add().height(60);
        table.row();
        table.add(mapEditorButton).width(200);
        table.row();
        table.add().height(60);
        table.row();
        table.add(quitButton).width(200);
        
        
        
        //t.add(new TextButton("Blah", new TextButtonStyle()));
    }
    
    
    
    protected void editMap() {
        game.setScreen(game.mapEditScreen);
        
    }



    protected void quitGame() {
        Gdx.app.exit();
        
    }



    protected void startGame() {
        
        game.setScreen(game.towerScreen);
    }



    @Override
    public void render(float delta) {
        // TODO Auto-generated method stub
        
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
        
        Table.drawDebug(stage);
        
        
    }

    @Override
    public void resize(int width, int height) {
        stage.setViewport(width, height, true);
        
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        
    }

    @Override
    public void hide() {
        dispose();
        
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

      
        stage.dispose();
    }
    
    
}
