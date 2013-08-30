package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class TowerScreen implements Screen {

    TowerGame game;
    
  
    MapRenderer render;
    
    
    
    TowerScreenInputProcessor proc = new TowerScreenInputProcessor();
    
    
    SpriteBatch batch;
    ShapeRenderer sRender;
    

    
    
    
    

    
    public TowerScreen(TowerGame g) {
        game = g;
        
       
        render = new MapRenderer();
        batch = new SpriteBatch();
        sRender = new ShapeRenderer();
        
 

    }

    @Override
    public void render(float delta) {
    	
    	
    	
    	
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
       if (GameState.getInstance().isReady())
       {
    	   GameState.getInstance().update(delta);
    	   batch.setProjectionMatrix(render.camera.combined);

           render.render();
           
           
           batch.begin();
           GameState.getInstance().render(batch);
           batch.end();
           GameState.getInstance().hud.render();
           
    	   if (GameState.getInstance().creatingTower)
    	   {
    		   batch.begin();
    		  
    		   GameState.getInstance().towerToCreate.render(batch);
    		   batch.end();
    		   
    		   if (GameState.getInstance().map.validPlaceForTower( GameState.getInstance().towerToCreate.getX(), GameState.getInstance().towerToCreate.getY()))
    		   {
    			   sRender.setProjectionMatrix(render.camera.combined);
        		   GameState.getInstance().towerToCreate.renderAreaOfAttack(sRender);
    		   }
    		   else
    		   {
    			   sRender.setProjectionMatrix(render.camera.combined);
        		   GameState.getInstance().towerToCreate.renderBadPlacement(sRender);
    		   }
    		   
    		   
    	   }
       }
       
       

      

    }

    @Override
    public void resize(int width, int height) {
        

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(proc);
        
        Gdx.input.getTextInput(new TextInputListener() {
            
            @Override
            public void input(String text) {
            	GameState.getInstance().init(new TowerMap(Gdx.files.local(text + ".json")));
            	
                
            }
            
            @Override
            public void canceled() {
                // TODO Auto-generated method stub
                
            }
        }, "FileName", "text");

    }

    @Override
    public void hide() {
        

    }

    @Override
    public void pause() {
        

    }

    @Override
    public void resume() {
        

    }

    @Override
    public void dispose() {
        render.dispose();
        batch.dispose();
        sRender.dispose();

    }
    
    class TowerScreenInputProcessor implements InputProcessor
    {

        @Override
        public boolean keyDown(int keycode) {
            if (keycode == Keys.V)
            	GameState.getInstance().enemies.addGuy();
            return false;
        }

        @Override
        public boolean keyUp(int keycode) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean keyTyped(char character) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        	Vector3 touchPos = new Vector3(screenX,screenY,0);
            render.getCamera().unproject(touchPos);
            
           
            
            GameState.getInstance().touchDown(touchPos.x,touchPos.y);
           
            
         
            return false;
        }

        @Override
        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean touchDragged(int screenX, int screenY, int pointer) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean mouseMoved(int screenX, int screenY) {
        	Vector3 touchPos = new Vector3(screenX,screenY,0);
            render.getCamera().unproject(touchPos);
            
            if (GameState.getInstance().isReady() && GameState.getInstance().creatingTower)
            {
            	GameState.getInstance().towerToCreate.setPosition((int) Math.floor(touchPos.x),(int) Math.floor(touchPos.y));
            }
            
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            // TODO Auto-generated method stub
            return false;
        }
        
    }

}
