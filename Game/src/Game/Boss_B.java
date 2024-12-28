package Game;

public class Boss_B extends Creature{

	@Override
	public String toString() {
		return "※보스몹※ 애니 [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}
	
	public Boss_B() {
		hp = 200;
		str = 5;
	}
	
	@Override
	public void skill(Creature target) {
		System.out.println("애니의 티버 소환술!");
	}

	@Override
	public void attackByType(Creature target) {
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {
			
			System.out.println("[TargetHit] 애니가 " + target.name + "를 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if(target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println("애니가 " + ((Player) target).name + "를 공격합니다.");
			if(target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}
}
