package com.github.lalaland.simpletowerdefense;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector3;

public class MapEditor implements Screen {

    TowerGame game;
    
  
    MapRenderer render;

    MapEditInputProcessor processor = new MapEditInputProcessor();
    
    
    
    int tileType = 0;
    
    TowerMap map;
    
    
    public MapEditor(TowerGame g) {
        game = g;
        
       
        render = new MapRenderer();
       
       
        
        
        
        
       
        
        
        
        
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        if (map!= null)
            render.render();

    }

    @Override
    public void resize(int width, int height) {
        

    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(processor);
        
        Gdx.input.getTextInput(new TextInputListener() {
            
            @Override
            public void input(String text) {
                map = new TowerMap(Gdx.files.local(text + ".json"));
                render.setMap(map);
                
            }
            
            @Override
            public void canceled() {
                map = new TowerMap();
                render.setMap(map);
                
            }
        }, "FileName", "foo");

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);

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
    
    class MapEditInputProcessor implements InputProcessor
    {
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
        public boolean touchDown(int screenX, int screenY, int pointer, int button) {
            // TODO Auto-generated method stub
            Vector3 touchPos = new Vector3(screenX,screenY,0);
            render.getCamera().unproject(touchPos);
            
            Gdx.app.log("MyMessage", "This is it" + touchPos+ " " + screenX + ":" + screenY);
            
            
            map.setPos((int) touchPos.x, (int) touchPos.y, tileType);
            
            switch(starType)
            {
            case 0:
                break;
            case 1:
                map.startX = (int) touchPos.x;
                map.startY = (int) touchPos.y;
                break;
            case 2:
                map.stopX = (int) touchPos.x;
                map.stopY = (int) touchPos.y;
                break;    
            }
            return false;
        }
        
        @Override
        public boolean scrolled(int amount) {
            // TODO Auto-generated method stub
            return false;
        }
        
        @Override
        public boolean mouseMoved(int screenX, int screenY) {
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
        public boolean keyDown(int keycode) {
            // TODO Auto-generated method stub
            
            switch(keycode)
            {
            case Keys.S:
                    Gdx.input.getTextInput(new TextInputListener() {
                    
                    @Override
                    public void input(String text) {
                        map.save(Gdx.files.local(text + ".json"));
                        
                    }
                    
                    @Override
                    public void canceled() {
                        // TODO Auto-generated method stub
                        
                    }
                }, "FileName", "");
                break;
            case Keys.Q:
                tileType = 0;
                starType = 0;
                break;
            case Keys.W:
                tileType = 1;
                starType = 0;
                break;
            case Keys.F:
                tileType = 1;
                starType = 1;
                break;
            case Keys.P:
                tileType = 1;
                starType = 2;
                break;
            }
            
          
    
                
            return false;
        }
    }
    
    int starType = 0;

}
