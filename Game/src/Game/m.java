package Game;

public class m extends Player {
	 String name = "말파이트";

	 public m() {
		 hp = 5000;
		 str = 15;
	 }
	
	 public m(String name, int hp, int str) {
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

			System.out.println("[TargetHit! ] " + this.name + "가 천둥소리 시전!");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 2) {
				target.hp -= this.str * 2;
				this.hp += this.hp*0.1;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "가 천둥소리 시전!");
			if (target.hp >= this.str*1.5) {
				target.hp -= this.str*1.5;
				this.hp += this.hp*0.1;
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
		return "탱커 : "+this.name +" [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}

}
