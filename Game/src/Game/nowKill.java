package Game;

public class nowKill extends Creature{

	@Override
	public void skill(Creature p) {

		p.hp = 0;
	}

	@Override
	public void attackByType(Creature p) {
		// TODO Auto-generated method stub
		
	}

}
