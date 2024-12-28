package Game;

public class t extends Player {
	 String name = "탈론";

	 public t() {
		 hp = 2400;
		 str = 60;
	 }
	 
	 public t(String name, int hp, int str) {
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

			System.out.println("[TargetHit! ] " + this.name + "이 녹서스식 외교 사용!");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 2) {
				target.hp -= this.str * 2;
			} else {
				System.out.println("상대를 처치하였습니다. 체력을 회복합니다.");
				this.hp += this.hp*0.5;
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "이 녹서스식 외교 사용!");
			if (target.hp >= this.str*1.5) {
				target.hp -= this.str*1.5;
			} else {
				System.out.println("상대를 처치하였습니다. 체력을 회복합니다.");
				this.hp += this.hp*0.5;
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

			System.out.println("[TargetHit! ] " + this.name + "이 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "이 공격합니다.");
			if (target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}

	@Override
	public String toString() {
		return "닌자 : "+this.name +" [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}

}
