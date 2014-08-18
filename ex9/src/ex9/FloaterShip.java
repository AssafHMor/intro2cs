package ex9;

/**
 * DESCRIPTION: This spaceship does no actions at all. It floats around at a
 * constant initial speed and does not turn nor accelerate.
 */
public class FloaterShip extends AIShip {

	/**
	 * construct new FloaterShip object
	 */
	public FloaterShip(){
		super();
	}
	
    /**
	 *  Does the actions of this ship for this round. 
	 *  This is called once per round by the SpaceWars game driver.
	 * @param game the game object to which this ship belongs.
	 */
	public void doAction(SpaceWars game) {
		//keeps floating in the same direction
		getPhysics().move(false, 0);
		timeTick();
	}
}
