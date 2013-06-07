package com.klusman.lasermixer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.collision.Ray;

public class Input implements InputProcessor{
	

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

        Vector2 touchPos = new Vector2();
        touchPos.set(Gdx.input.getX(), Gdx.input.getY());

        Ray cameraRay = MainLaserMixer.camera.getPickRay(touchPos.x, touchPos.y);
        Gdx.app.log("RAY", "Touch Ray Coords:  X:"  + cameraRay.origin.x + " Y:" + cameraRay.origin.y);
        
		boolean lazer = MainLaserMixer.lazerStart.getBoundingRectangle().contains(cameraRay.origin.x, cameraRay.origin.y);
		boolean ball = MainLaserMixer.ball.getBoundingRectangle().contains(cameraRay.origin.x, cameraRay.origin.y);
		boolean corner = MainLaserMixer.corner.getBoundingRectangle().contains(cameraRay.origin.x, cameraRay.origin.y);
		boolean tube = MainLaserMixer.tube.getBoundingRectangle().contains(cameraRay.origin.x, cameraRay.origin.y);
		//MainRolling.drawLine(tt.origin.x, tt.origin.y);
		if(lazer == true){
			
			Gdx.app.log("TOUCHED", "Laser:" + lazer);
			MainLaserMixer.powerUp.play();
			
			//MainRolling.drawLazerLine();  Broken
			
			 
		}
		if(ball == true){
			Gdx.app.log("TOUCHED", "Ball:" + ball);
			MainLaserMixer.bounce.play();
		}
		if(corner == true){
			Gdx.app.log("TOUCHED", "Corner:" + lazer);
			MainLaserMixer.metalDing.play();
		}
		if(tube == true){
			Gdx.app.log("TOUCHED", "Metal Tube:" + lazer);
			MainLaserMixer.metalDing.play();
		}
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
