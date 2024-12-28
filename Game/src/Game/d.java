package Game;

public class d extends Player {

	String name = "다리우스";

	public d() {
		hp = 2400;
		str = 30;
	}

	 public d(String name, int hp, int str) {
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

			System.out.println("[TargetHit! ] " + this.name + "가 학살을 사용!");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 2) {
				target.hp -= this.str * 2;
				this.hp += this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "가 학살을 사용!");
			if (target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
				this.hp += this.str;
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

			System.out.println("[TargetHit! ] " + this.name + "가 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "가 공격합니다.");
			if (target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}

	@Override
	public String toString() {
		return "전사 : " + this.name + " [hp=" + hp + ",str=" + str + ", type=" + type + "]";
	}

}
