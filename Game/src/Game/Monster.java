package Game;

public class Monster extends Creature {

	int random = (int) (Math.random() * 5);
	String name;
	Monster() {
		if (random == 0) {
			name = "두꺼비";
			this.hp = 2500;
			this.str = 10;
		}else if(random == 1) {
			name = "칼날부리";
			this.hp = 1000;
			this.str = 100;
		}else if(random == 2) {
			name = "늑대";
			this.hp = 1000;
			this.str = 100;
		}else if(random == 3) {
			name = "레드";
			this.hp = 3000;
			this.str = 100;
		}else if(random == 4) {
			name = "바위게";
			this.hp = 100;
			this.str = 5;
		}else {
			name = "블루";
			this.hp = 5000;
			this.str = 50;
		}
	}

	@Override
	public String toString() {
		if (random == 0) {
			return "두꺼비 [hp=" + hp + ", type=" + type + "]";
		} else if (random == 1) {
			return "칼날부리 [hp=" + hp + ", type=" + type + "]";
		}else if(random == 2) {
			return "늑대 [hp=" + hp + ", type=" + type +"]";
		}else if(random == 3) {
			return "레드 [hp=" + hp + ", type=" + type +"]";
		}else if(random == 4) {
			return "바위게 [hp=" + hp + ", type=" + type +"]";
		}else {
			return "블루 [hp=" + hp + ", type=" + type +"]";
		}
		

	}

	@Override
	public void skill(Creature target) {
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {

			System.out.println("[TargetHit] " +this.name+"가(이) "+  ((Player) target).name + "한테 할퀴기!");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 2) {
				target.hp -= this.str * 2;
			} else {
				target.hp = 0;
			}
		}
		// 스킬 공격
		else {
			if (this.hp >= this.hp) {
				if (target.hp >= this.str * 1.5) {
					System.out.println(this.name+"가(이) 할퀴기!");
					target.hp -= this.str * 1.5;
				} else {
					target.hp = 0;
				}
			} else if (this.hp < this.hp-5) {
				System.out.println(this.name+"가(이) 힐링팩터 발동!");
				this.hp += 20;
			}

		}
	}

	@Override
	public void attackByType(Creature target) {
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {

			System.out.println("[TargetHit] "+this.name +"가(이) " + ((Player) target).name + "를 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name +"가(이) "+ ((Player) target).name + "를 공격합니다.");
			if (target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}
}
