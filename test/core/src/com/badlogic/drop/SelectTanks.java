package com.badlogic.drop;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class SelectTanks implements Screen {
    final TankStars game;

    private Texture bg;

    public TankStars getGame(){
        return game;
    }

    public Texture getBg() {
        return bg;
    }

    public void setBg(Texture bg) {
        this.bg = bg;
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

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    private Texture backgroundImage;
    private TextureRegion backgroundTexture;

    private OrthographicCamera camera;


    private Stage stage;

    public SelectTanks(final TankStars game) {
        this.game = game;
        this.stage = new Stage();
        // load the images for the droplet and the bucket, 64x64 pixels each
        bg = new Texture(Gdx.files.internal("3 tanks.png"));
//        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
//        backgroundImage = new Texture(Gdx.files.internal("background.jpg"));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1229);

        // load the drop sound effect and the rain background "music"
//        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
//        rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));
//        rainMusic.setLooping(true);

        // create the camera and the SpriteBatch
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 761, 400);

        // create a Rectangle to logically represent the bucket
//        bucket = new Rectangle();
//        bucket.x = 800 / 2 - 64 / 2; // center the bucket horizontally
//        bucket.y = 20; // bottom left corner of the bucket is 20 pixels above
//        // the bottom screen edge
//        bucket.width = 64;
//        bucket.height = 64;

        // create the raindrops array and spawn the first raindrop
        int row_height = Gdx.graphics.getHeight();
        int col_width = Gdx.graphics.getWidth();
        Skin mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        SpriteBatch batch = new SpriteBatch();
        Button button1 = new TextButton("Select Tank",mySkin,"small");
        button1.setSize(col_width*4,row_height);
        button1.setPosition(col_width*7,Gdx.graphics.getHeight()-row_height*3);
        button1.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Press a Button");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
//                outputLabel.setText("Pressed Text Button");
                game.setScreen(new GameScreen(game));
                return true;
            }
        });
        stage.addActor(button1);

    }



    @Override
    public void render(float delta) {

        // clear the screen with a dark blue color. The
        // arguments to clear are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        ScreenUtils.clear(0, 0, 0.2f, 1);
//
//        // tell the camera to update its matrices.
        camera.update();

//        // tell the SpriteBatch to render in the
//        // coordinate system specified by the camera.
        game.batch.setProjectionMatrix(camera.combined);
//
//        // begin a new batch and draw the bucket and
//        // all drops
        game.batch.begin();
        game.batch.draw(bg, 0,0, 761, 400);
        stage.act();
        stage.draw();
        Gdx.input.setInputProcessor(stage);
//        game.font.draw(game.batch, "Drops Collected: " + dropsGathered, 0, 480);
//        game.batch.draw(bucketImage, bucket.x, bucket.y, bucket.width, bucket.height);
//        for (Rectangle raindrop : raindrops) {
//            game.batch.draw(dropImage, raindrop.x, raindrop.y);
//        }
        game.batch.end();
//
//        // process user input
        if (Gdx.input.isKeyPressed(Keys.ENTER)) {
            game.setScreen(new GameScreen(game));
//            dispose();
        }
//        if (Gdx.input.isKeyPressed(Keys.LEFT))
//            bucket.x -= 200 * Gdx.graphics.getDeltaTime();
//        if (Gdx.input.isKeyPressed(Keys.RIGHT))
//            bucket.x += 200 * Gdx.graphics.getDeltaTime();
//
//        // make sure the bucket stays within the screen bounds
//        if (bucket.x < 0)
//            bucket.x = 0;
//        if (bucket.x > 800 - 64)
//            bucket.x = 800 - 64;
//
//        // check if we need to create a new raindrop
//        if (TimeUtils.nanoTime() - lastDropTime > 1000000000)
//            spawnRaindrop();
//
//        // move the raindrops, remove any that are beneath the bottom edge of
//        // the screen or that hit the bucket. In the later case we increase the
//        // value our drops counter and add a sound effect.
//        Iterator<Rectangle> iter = raindrops.iterator();
//        while (iter.hasNext()) {
//            Rectangle raindrop = iter.next();
//            raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
//            if (raindrop.y + 64 < 0)
//                iter.remove();
//            if (raindrop.overlaps(bucket)) {
//                dropsGathered++;
//                dropSound.play();
//                iter.remove();
//            }
//        }
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void show() {
        // start the playback of the background music
        // when the screen is shown
//        rainMusic.play();
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
//        dropImage.dispose();
//        bucketImage.dispose();
//        dropSound.dispose();
//        rainMusic.dispose();
    }

}
