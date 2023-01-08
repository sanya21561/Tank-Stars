package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.io.Serializable;
import java.util.Iterator;

//87
public class GameScreen implements Screen {
    private GameState gamestate1;


    final TankStars game;
    private Texture backgroundImage;
    private Texture tank1;
    private Texture missile1;
    private Texture tank2;
    private Texture missile2;
    public static Rectangle tankA;
    public Rectangle tankB;

//    public Rectangle getTankA() {
//        return tankA;
//    }
//
//    public Rectangle getTankB() {
//        return tankB;
//    }

    private Rectangle missileA;
    private Rectangle missileB;
    private float health2=100;
    private float health1=100;

    private Texture healthbar1;
    private Texture healthbar2;
    private Rectangle healthA;
    private Rectangle healthB;



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
    SpriteBatch spriteBatch = new SpriteBatch();

    public void setBackgroundTexture(TextureRegion backgroundTexture) {
        this.backgroundTexture = backgroundTexture;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

//    public GameScreen(TankStars game, int healthval1, int healthval2) {
//        this.game = game;
//        this.healthval1 = healthval1;
//        this.healthval2 = healthval2;
//    }

    public static int getHealthval1() {
        return healthval1;
    }

    public static int getHealthval2() {
        return healthval2;
    }
    int angleA;
    int angleB;

    private static int healthval1;
    private static int healthval2;
    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
//    int xbulletSpeed=1;
//    int ybulletSpeed=1;
//    int xbulletSpeedR=1;
//    int ybulletSpeedR=1;

    private TextureRegion backgroundTexture;
    private OrthographicCamera camera;
    Array<Rectangle> bulletsA;
    Array<Rectangle> bulletsB;
    int flag;

    public GameScreen(final TankStars game) {
        this.gamestate1 = new GameState();
        this.game = game;
        this.healthval1 = healthval1;
        this.healthval2 = healthval2;
//        this.stage=new Stage();
        tankA = new Rectangle();
        tankA.x = 80;
        tankA.y = 0;
        tankB = new Rectangle();
        tankB.x = 480;
        tankB.y = 0;
        missileA = new Rectangle();
        missileB = new Rectangle();
        missileA.x = tankA.x + 140;   //here
        missileB.x = tankB.x - 5;
        tank1 = new Texture(Gdx.files.internal("tank 2.png"));
        tank2 = new Texture(Gdx.files.internal("tank11.png"));
        healthbar1 = new Texture(Gdx.files.internal("BlueBar.png"));
        healthbar2 = new Texture(Gdx.files.internal("BlueBar.png"));
        missile1 = new Texture(Gdx.files.internal("rmbga.png"));
        missile2 = new Texture(Gdx.files.internal("rmbgb.png"));
//        healthA = new Rectangle();
//        healthB = new Rectangle();

        healthval1 = 200;
        healthval2 = 200;
        backgroundImage = new Texture(Gdx.files.internal("background1.png"));
//        private World world;


//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 3, 4);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 761, 400);
        bulletsA = new Array<Rectangle>();
        bulletsB = new Array<Rectangle>();
        spawnbullet1();
        spawnbullet2();
//        FitViewport game_port = new FitViewport(TankStars.400 / TankStars.PPM, TankStars.200 / TankStars.PPM, camera);
    }
    private void spawnbullet1() {
//        Rectangle bullet = new Rectangle();
        missileA.x = tankA.x + 140;
        missileA.y = 45;
        missileA.width = 20;
        missileA.height = 20;
        bulletsA.add(missileA);
//        lastDropTime = TimeUtils.nanoTime();
    }
    private void spawnbullet2() {
//        Rectangle bullet = new Rectangle();
        missileB.x = tankB.x - 5;
        missileB.y = 43;
        missileB.width = 20;
        missileB.height = 20;
        bulletsB.add(missileB);
//        lastDropTime = TimeUtils.nanoTime();
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
        game.batch.draw(tank1, tankA.x, tankA.y, 150, 80);
        game.batch.draw(tank2, tankB.x, tankB.y, 180, 80);
        game.batch.draw(missile1, missileA.x, 45, 20, 20);
        game.batch.draw(missile2, missileB.x, 43, 20, 20);
        game.batch.draw(healthbar1, 20, 350, healthval1, 30);
        game.batch.draw(healthbar2, 540, 350, healthval2, 30);
        game.font.draw(game.batch, "angle:" + angleA, 20, 200);
        game.font.draw(game.batch, "angle:" + angleB, 500, 200);

//        game.font.draw(game.batch, "Welcome to Drop!", 300, 240);
//        game.font.draw(game.batch, "Click anywhere to begin.", 300, 140);
        flag = 1;


        if (Gdx.input.isKeyPressed(Input.Keys.X))
            healthval1 -= 10;
        if (Gdx.input.isKeyPressed(Input.Keys.Y))
            healthval2 -= 10;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            tankA.x -= 1;
            missileA.x = tankA.x + 140;   //here
            missileB.x = tankB.x - 5;
        }
//            missileA.x -= 1;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if(tankA.x==tankB.x-40){
                tankA.x+=1;
                tankB.x+=1;
//                missileA.x+=1;
//                missileB.x+=1;
            }
            else{
                tankA.x+=1;
//                missileA.x += 1;
            }
            missileA.x = tankA.x + 140;   //here
            missileB.x = tankB.x - 5;
        }

        if (tankA.x < 20)
            tankA.x = 20;
//        missileA.x = tankA.x + 140;   //here
//        missileB.x = tankB.x - 5;

        if (tankA.x> tankB.x-120)
            tankA.x=tankB.x-120;
//        missileA.x = tankA.x + 140;   //here
//        missileB.x = tankB.x - 5;
//            missileA.x = missileB.x -100;

        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tankB.x -= 1;
        missileA.x = tankA.x + 140;   //here
        missileB.x = tankB.x - 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tankB.x += 1;
            missileA.x = tankA.x + 140;   //here
            missileB.x = tankB.x - 5;
        }
        if (tankB.x < 20)
            tankB.x = 20;
        if (tankB.x> 580)
            tankB.x=580;

        if(tankB.x <tankA.x+120)
            tankB.x=tankA.x+120;
        if (Gdx.input.isKeyPressed(Input.Keys.W)){

        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            gamestate1.save(tankA.x, tankA.y);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE) || healthval1 <= 0 || healthval2 <= 0) {
            game.setScreen(new PauseMenu(game));
//            dispose();
        }
        if (Gdx.input.isTouched()){
            Iterator<Rectangle> iter = bulletsA.iterator();
            while (iter.hasNext()) {
                Rectangle missileA = iter.next();
                missileA.y += 10;
                missileA.x += 1;


                if (missileA.x > tankB.x) {
                    healthval2 -= 40;
                    iter.remove();
                    spawnbullet1();
//                    flag = 0;

                }


            }
//            missileA.x += 2000 * Gdx.graphics.getDeltaTime();
//            if(missileA.x == tankB.x) {
//                healthval2 -= 40;
//                spawnbullet1();
//            }
//            game.batch.draw(missile1, tankA.x + 140, 45, 20, 20);
//            flag = 0;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            Iterator<Rectangle> iter = bulletsB.iterator();
            while (iter.hasNext()) {
                Rectangle missileB = iter.next();
                missileB.x -= 1;

                if (missileB.x < tankA.x) {
                    healthval1 -= 40;
                    iter.remove();
                    spawnbullet2();

                }

            }
//            missileA.x += 2000 * Gdx.graphics.getDeltaTime();
//            if(missileA.x == tankB.x) {
//                healthval2 -= 40;
//                spawnbullet1();
//            }
//            game.batch.draw(missile1, tankA.x + 140, 45, 20, 20);
//            flag = 1;
        }
        game.batch.end();
//        if (missileA.x == tankB.x)
//            spawnbullet1();
//        if (missileB.x == tankA.x)
//            spawnbullet2();

        // move the fruits, remove any that are beneath the bottom edge of
        // the screen or that hit the bucket. In the later case we increase the
        // value our drops counter and add a sound effect.

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
//    private void createBox(float x, float y, float width, float height) {
//        // Create a body definition
//        BodyDef bodyDef = new BodyDef();
//        bodyDef.type = BodyDef.BodyType.DynamicBody;
//        bodyDef.position.set(x, y);
//
//// Create a body from the definition
//        Body body = world.createBody(bodyDef);
//
//// Create a polygon shape
//        PolygonShape shape = new PolygonShape();
//        shape.setAsBox(width / 2, height / 2);
//
//// Create a fixture from the shape
//        FixtureDef fixtureDef = new FixtureDef();
//        fixtureDef.shape = shape;
//        fixtureDef.density = 1.0f;
//        fixtureDef.friction = 0.5f;
//        fixtureDef.restitution = 0.5f;
//        body.createFixture(fixtureDef);
//
//
//        public void handleInput(float delta){
//            if(Gdx.input.isTouched()){
//                camera.position.x+=100*delta;
//
//            }
//            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.getLinearVelocity().x <= 2){
//                player.b2body.applyLinearImpulse(new Vector2(0.1f, 0), player.b2body.getWorldCenter(), true);
//            }
//            if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.getLinearVelocity().x >= -2){
//                player.b2body.applyLinearImpulse(new Vector2(-0.1f, 0), player.b2body.getWorldCenter(), true);}
//        }


    }

