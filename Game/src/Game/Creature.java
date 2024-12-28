package Game;

public abstract class Creature {
	String name;
	int str;
	int hp;
	Type type;
	
	Creature() {
		Type[] typearr = Type.values();
		int i = (int) (Math.random()*4);
		this.type = typearr[i];
	}
	public void printInfo() {
		System.out.println(this.toString());
	}
	
	public abstract void skill(Creature p);
	
	public abstract void attackByType(Creature p);
}
