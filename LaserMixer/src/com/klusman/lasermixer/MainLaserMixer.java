package com.klusman.lasermixer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;



public class MainLaserMixer implements ApplicationListener {

	private final Input input = new Input();
	public static OrthographicCamera camera;
	public static SpriteBatch batch;
	public static Texture texture;
	public static Sprite bgSprite;
	public static Texture bucketTex;
	public static Sprite bucket;
	public static Texture ballTex;
	public static Sprite ball;
	public static Texture girderTex;
	public static Sprite girder;
	public static Texture girderTex2;
	public static Sprite girder2;
	public static Texture girderTex3;
	public static Sprite girder3;
	public static Texture angChangeOverlayTex;
	public static Sprite angChangeOverlay;
	public static Texture lazerStartTex;
	public static Sprite lazerStart;
	public static Texture cornerTex;
	public static Sprite corner;
	public static Texture tubeTex;
	public static Sprite tube;
	public static Sound metalDing;
	public static Sound bounce;
	public static Sound powerUp;
	public static Music bgMusic;
	float w;
	float h;
	
	@Override
	public void create() {		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
	
		Gdx.input.setInputProcessor(input);
		metalDing = Gdx.audio.newSound(Gdx.files.internal("audio/Metalping.wav"));
		bounce = Gdx.audio.newSound(Gdx.files.internal("audio/Ball_Bounce.wav"));
		powerUp = Gdx.audio.newSound(Gdx.files.internal("audio/Laser.wav"));
		bgMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/Ttimes.mp3"));
		
	    bgMusic.setLooping(false);  // Didn't want to kill u with this bad loop
	    bgMusic.setVolume(0.05f);
	    bgMusic.play();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
////  BACKGROUND  ////
		texture = new Texture(Gdx.files.internal("data/bgblue2.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
		
		bgSprite = new Sprite(region);
		bgSprite.setSize(1, h/w);
		bgSprite.setOrigin(bgSprite.getWidth()/2, bgSprite.getHeight()/2);
		bgSprite.setPosition(-bgSprite.getWidth()/2, -bgSprite.getHeight()/2);
		
////  Bucket ///////
		bucketTex = new Texture(Gdx.files.internal("data/bucket.png"));
		bucketTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion bucketRegion = new TextureRegion(bucketTex, 0, 0, bucketTex.getWidth(), bucketTex.getHeight());
		
		bucket = new Sprite(bucketRegion);
		bucket.setSize(.09f, .09f);
		bucket.setOrigin(bucket.getWidth()/2, bucket.getHeight()/2);
		bucket.setPosition(.0f - bucket.getWidth()/2, -0.22f - bucket.getHeight()/2);
		bucket.getBoundingRectangle();
		
//// BALL ////
		
		ballTex = new Texture(Gdx.files.internal("data/grnBall.png"));
		ballTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion ballRegion = new TextureRegion(ballTex, 0, 0, ballTex.getWidth(), ballTex.getHeight());
		
		ball = new Sprite(ballRegion);
		ball.setSize(.05f, .05f);
		ball.setOrigin(ball.getWidth()/2, ball.getHeight()/2);
		ball.setPosition(-.3f - -ball.getWidth()/2, -.01f - ball.getHeight()/2);
		
//// GIRDER ////
		
		girderTex = new Texture(Gdx.files.internal("data/girder.png"));
		girderTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion girderRegion = new TextureRegion(girderTex, 0, 0, girderTex.getWidth(), girderTex.getHeight());
		
		girder = new Sprite(girderRegion);
		girder.setSize(girderTex.getWidth() / w, girderTex.getHeight() / h);
		girder.setOrigin(girder.getWidth()/2, girder.getHeight()/2);
		girder.setPosition(-.4f - girder.getWidth()/2, -.2f - girder.getHeight()/2);
		girder.setRotation(-30);
		
//// GIRDER2 ////
		
		girderTex2 = new Texture(Gdx.files.internal("data/girder.png"));
		girderTex2.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion girderRegion2 = new TextureRegion(girderTex2, 0, 0, girderTex2.getWidth(), girderTex2.getHeight());
		
		girder2 = new Sprite(girderRegion2);
		girder2.setSize(girderTex2.getWidth() / w, girderTex2.getHeight() / h);
		girder2.setOrigin(girder2.getWidth()/2, girder2.getHeight()/2);
		girder2.setPosition(-.4f - girder2.getWidth()/2, -.045f - girder2.getHeight()/2);
		girder2.setRotation(-40);
		
//// GIRDER3 ////
		
		girderTex3 = new Texture(Gdx.files.internal("data/girder.png"));
		girderTex3.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion girderRegion3 = new TextureRegion(girderTex3, 0, 0, girderTex3.getWidth(), girderTex3.getHeight());
		
		girder3 = new Sprite(girderRegion3);
		girder3.setSize(girderTex3.getWidth() / w, girderTex3.getHeight() / h);
		girder3.setOrigin(girder3.getWidth()/2, girder3.getHeight()/2);
		girder3.setPosition(-.35f - girder3.getWidth()/2, .029f - girder3.getHeight()/2);
		girder3.setRotation(-50);
		
//// Angle Change Overlay ////
		
		angChangeOverlayTex = new Texture(Gdx.files.internal("data/angleChangeOverlay.png"));
		angChangeOverlayTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion angRegion = new TextureRegion(angChangeOverlayTex, 0, 0, angChangeOverlayTex.getWidth(), angChangeOverlayTex.getHeight());
		angChangeOverlay = new Sprite(angRegion);
		angChangeOverlay.setSize(.2f, .2f);
		angChangeOverlay.setOrigin(angChangeOverlay.getWidth()/2, angChangeOverlay.getHeight()/2);
		angChangeOverlay.setPosition((girder.getX() + girder.getWidth()/2)- angChangeOverlay.getWidth()/2 , (girder.getY() + girder.getHeight()/2 )- angChangeOverlay.getHeight()/2);
		
////  LAZER ///////
		lazerStartTex = new Texture(Gdx.files.internal("data/LaserSplitter.png"));
		lazerStartTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion lazRegion = new TextureRegion(lazerStartTex, 0, 0, lazerStartTex.getWidth(), lazerStartTex.getHeight());
		lazerStart = new Sprite(lazRegion);
		lazerStart.setSize(.1f, .1f);
		lazerStart.setOrigin(lazerStart.getWidth()/2, lazerStart.getHeight()/2);
		lazerStart.setPosition(.3f - lazerStart.getWidth()/2, (h/w)/-2);
		
		
////  Corner ///////
		cornerTex = new Texture(Gdx.files.internal("data/cornerTube.png"));
		cornerTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion cornerRegion = new TextureRegion(cornerTex, 0, 0, cornerTex.getWidth(), cornerTex.getHeight());
		corner = new Sprite(cornerRegion);
		corner.setSize(.1f, .1f);
		corner.setOrigin(corner.getWidth()/2, corner.getHeight()/2);
		corner.setPosition(lazerStart.getX() + lazerStart.getWidth()/2 - corner.getWidth()/2, 0 - corner.getWidth()/2);
		
////  tube ///////
		tubeTex = new Texture(Gdx.files.internal("data/straightTube.png"));
		tubeTex.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TextureRegion tubeRegion = new TextureRegion(tubeTex, 0, 0, tubeTex.getWidth(), tubeTex.getHeight());
		tube = new Sprite(tubeRegion);
		tube.setSize(.05f, .1f);
		tube.setRotation(-90);
		tube.setOrigin(tube.getWidth()/2, tube.getHeight()/2);
		tube.setPosition(0f , corner.getY() + corner.getWidth()/2 - tube.getWidth());
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		bgSprite.draw(batch);
		//bucket.draw(batch);
		ball.draw(batch);
		girder.draw(batch);
		//girder2.draw(batch);
		//girder3.draw(batch);
		corner.draw(batch);
		tube.draw(batch);
		lazerStart.draw(batch);
		angChangeOverlay.draw(batch);
		batch.end();	

		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		float startX = lazerStart.getX() + lazerStart.getWidth()/2;
		float startY = lazerStart.getY() + lazerStart.getHeight();
		
		float Xc = corner.getX() + corner.getWidth()/2;
		float Yc = corner.getY();
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(0, 1, 0, 1);
		Gdx.gl10.glLineWidth(10);
		shapeRenderer.line(startX, startY, Xc, Yc);
		shapeRenderer.end();
		
		
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
	
	public void drawLazerLine() {  // Not working 
		Gdx.app.log("drawFire", "BOOM");
		float startX = lazerStart.getX() + lazerStart.getWidth()/2;
		float startY = lazerStart.getY() + lazerStart.getHeight()/2;
		
		float Xc = corner.getX() + corner.getWidth()/2;
		float Yc = corner.getY() + corner.getHeight()/2;
		
		//float Xt = tube.getX() + tube.getWidth()/2;
		//float Yt = tube.getY() + tube.getHeight()/2;
		
		
		ShapeRenderer shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);
		 
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(1, 0, 0, 1);
		Gdx.gl10.glLineWidth(10);
		shapeRenderer.line(startX, startY, Xc, Yc);
		shapeRenderer.end();
		
//		shapeRenderer.begin(ShapeType.Line);
//		shapeRenderer.setColor(1, 0, 0, 1);
//		Gdx.gl10.glLineWidth(10);
//		shapeRenderer.line(Xc, Yc, Xt, Yt);
//		shapeRenderer.end();
		 
	}
	

}
