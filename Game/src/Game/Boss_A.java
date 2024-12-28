package Game;

public class Boss_A extends Creature{

	@Override
	public String toString() {
		return "※보스몹※ 바론 [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}
	
	public Boss_A() {
		hp = 40000;
		str = 10;
	}
	
	@Override
	public void skill(Creature target) {
		if(this.str < 200) {
		System.out.println("남작의 시선!");
		this.str = (int)(this.str*1.5);
		System.out.println("바론의 공격력이 증가되었다");
		if(this.str > 200) {
			this.str = 200;
		}
	}else {
		System.out.println("산성 발사!");
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWATER") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {
			
			System.out.println("[TargetHit] 바론이 " + ((Player) target).name + "에게 산성 발사!");
			// 체력이 감소 가능한 상태일때
			if(target.hp >= this.str * 2) {
				target.hp -= this.str * 2;
				System.out.println();
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println("바론이 " + ((Player) target).name + "에게 산성 발사!");
			if(target.hp >= this.str*1.5) {
				target.hp -= this.str*1.5;
			} else {
				target.hp = 0;
			}
		}
		
	}
		
	}
	@Override
	public void attackByType(Creature target) {
		String typeMatch = this.toString() + target.type.toString();
		// 우세한 타입인 경우
		if (typeMatch.equals("FIRWWARTH") || typeMatch.equals("WATERFIRE") || typeMatch.equals("AIRWATER")
				|| typeMatch.equals("EARTHAIR")) {
			
			System.out.println("[TargetHit] 바론이 " + target.name + "를 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if(target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println("바론이 " + ((Player) target).name + "를 공격합니다.");
			if(target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}
	
}
