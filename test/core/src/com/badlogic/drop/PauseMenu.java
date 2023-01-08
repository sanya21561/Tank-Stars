package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
public class PauseMenu implements Screen {

    final TankStars game;
    private Texture backgroundImage;
    private GameState gamestate1;
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

    private OrthographicCamera camera;

    public PauseMenu(final TankStars game) {
        this.game = game;
        this.gamestate1 = new GameState();
        backgroundImage = new Texture(Gdx.files.internal("background1.png"));

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
        game.font.draw(game.batch, "Press S to Save.", 300, 250);
        game.font.draw(game.batch, "Press L to Load.", 300, 200);
        game.font.draw(game.batch, "Press G for Game Screen.", 300, 150);
        game.font.draw(game.batch, "Press E to exit application.", 300, 100);
        game.font.draw(game.batch, "Press T to select tanks and start game.", 300, 300);
//        game.font.draw(game.batch, "Welcome to Drop!", 300, 240);
//        game.font.draw(game.batch, "Click anywhere to begin.", 300, 140);

        game.batch.end();
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            game.setScreen(new GameScreen(game));
//            dispose();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.T)) {
            game.setScreen(new SelectTanks(game));
//            dispose();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            gamestate1.save(GameScreen.tankA.x, GameScreen.tankA.y);             //halp
        }
        if(Gdx.input.isKeyPressed(Input.Keys.L)){
            game.setScreen(new MainMenu(game));
        }

        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            Gdx.app.exit();
//            System.exit(-1);
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
