package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
//import org.testng.annotations.Test;

import java.util.ArrayList;

//import static org.testng.AssertJUnit.assertEquals;

public class StartScreen implements Screen {

    final TankStars game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    public TankStars getGame() {
        return game;
    }

    public Texture getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Texture backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public TextureRegion getBackgroundTexture() {
        return backgroundTexture;
    }

    public void setBackgroundTexture(TextureRegion backgroundTexture) {
        this.backgroundTexture = backgroundTexture;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    OrthographicCamera camera;

    public StartScreen(final TankStars game) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("tank stars.png"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 3, 4);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 761, 400);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 0, 0, 1);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundImage, 0,0, 761, 400);
//        game.font.draw(game.batch, "Welcome to Drop!", 300, 240);
        game.font.draw(game.batch, "Click anywhere to begin.", 300, 140);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new PauseMenu(game));
//            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}

