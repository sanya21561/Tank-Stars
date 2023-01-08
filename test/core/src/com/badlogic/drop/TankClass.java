package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TankClass {

        private int health;
        private Texture tank;
        private float angle;
        public void TankClass(){
                this.angle = angle;
                this.health = health;
                this.tank = new Texture(Gdx.files.internal("tank 2.png"));
        }
        public void movement(){

        }
        public void shoot(){

        }

    }

