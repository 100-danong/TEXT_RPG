package Game;

public class Boss_C extends Boss_B {

	@Override
	public String toString() {
		return "※소환수※ 티버 [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}
	public Boss_C() {
		hp = 100000;
		str = 100;
	}
	
	@Override
	public void skill(Creature target) {
		System.out.println("티버의 솟구침!");
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {
			
			System.out.println("[TargetHit] 티버가 " + target.name + "에게 티버의 솟구침을 시전!");
			// 체력이 감소 가능한 상태일때
			if(target.hp >= this.str * 6) {
				target.hp -= this.str * 6;
				System.out.println();
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println("티버가 " + target.name + "에게 티버의 솟구침!을 시전");
			if(target.hp >= this.str*3) {
				target.hp -= this.str*3;
			} else {
				target.hp = 0;
			}
		}		
	}

	@Override
	public void attackByType(Creature target) {
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {
			
			System.out.println("[TargetHit] 티버가 " + ((Player) target).name + "를 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if(target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println("티버가 " + ((Player) target).name + "를 공격합니다.");
			if(target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}
}
