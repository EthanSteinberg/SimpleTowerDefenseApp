package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class TowerScreen implements Screen {

    TowerGame game;
    
  
    MapRenderer render;
    
    
    
    TowerScreenInputProcessor proc = new TowerScreenInputProcessor();
    
    
    SpriteBatch batch;
    

    
    TowerMap map;
    
    
    EnemyManager e;
    
    
    HUD hud = new HUD();
    
    public TowerScreen(TowerGame g) {
        game = g;
        
       
        render = new MapRenderer();
        batch = new SpriteBatch();
        
 

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        
       if (map != null)
       {
           render.render();
           e.render(delta);
           hud.render();
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
                map = new TowerMap(Gdx.files.local(text + ".json"));
                render.setMap(map);
                e = new EnemyManager(map);
                
            }
            
            @Override
            public void canceled() {
                // TODO Auto-generated method stub
                
            }
        }, "FileName", "foo");

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

    }
    
    class TowerScreenInputProcessor implements InputProcessor
    {

        @Override
        public boolean keyDown(int keycode) {
            // TODO Auto-generated method stub
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
            
            hud.touchDown(touchPos.x, touchPos.y);
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
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean scrolled(int amount) {
            // TODO Auto-generated method stub
            return false;
        }
        
    }

}
