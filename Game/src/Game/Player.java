package Game;

public class Player extends Creature {
	final String name;

	public Player() {
		this.name = "";
	}

	public Player(String name) {
		this.name = name;
	}

	public Player(String name, int hp, int str) {
		this.name = name;
		this.hp = hp;
		this.str = str;
	}

	public Player Creature;

	
	
	@Override
	public void skill(Creature target) {
		String typeMatch = this.type.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {

			System.out.println("[TargetHit! ] " + this.name + "가(이) 스킬 사용!");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 2) {
				target.hp -= this.str * 2;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "가(이) 스킬 사용!");
			if (target.hp >= this.str*1.5) {
				target.hp -= this.str*1.5;
			} else {
				target.hp = 0;
			}
		}
	}

	@Override
	public void attackByType(Creature target) {

		String typeMatch = this.type.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {

			System.out.println("[TargetHit! ] " + this.name + "가(이) 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "가(이) 공격합니다.");
			if (target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}

	@Override
	public String toString() {
		return this.name +" [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}

}
