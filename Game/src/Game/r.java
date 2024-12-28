package Game;

public class r extends Player {
	 String name = "르블랑";
	 boolean b = false;

	 public r() {
		 hp = 1200;
		 str = 60;
	 }
	 
	 public r(String name, int hp, int str) {
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

			System.out.println("[TargetHit! ] " + this.name + "이 악의의 인장 사용!");
			// 체력이 감소 가능한 상태일때
			if (target.hp >= this.str * 2) {
				if(b == true) {
					if (target.hp >= this.str * 2.5) {
						System.out.println("인장 폭발!");
						target.hp -= this.str * 2.5;
						b = false;
					} else {
						System.out.println("인장 폭발!");
						b = false;
						target.hp = 0;
					}
				}
				else {
				System.out.println("상대에게 표식을 남기고 다음턴에 추가데미지를 준다.");
				target.hp -= this.str * 2;
				b = true;
				}
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "이 악의의 인장 사용!");
			if (target.hp >= this.str*1.5) {
				if(b == true) {
					if (target.hp >= this.str * 2) {
						System.out.println("인장 폭발!");
						b = false;
						target.hp -= this.str * 2;
					} else {
						System.out.println("인장 폭발!");
						b = false;
						target.hp = 0;
					}
				}
				else {
				System.out.println("상대에게 표식을 남기고 다음턴에 추가데미지를 준다.");
				target.hp -= this.str*1.5;
				b = true;
				}
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

			System.out.println("[TargetHit! ] " + this.name + "이 공격합니다.");
			// 체력이 감소 가능한 상태일때
			if(b == true) {
				if (target.hp >= this.str * 2) {
					System.out.println("인장 폭발!");
					target.hp -= this.str * 2;
					b = false;
				} else {
					System.out.println("인장 폭발!");
					target.hp = 0;
					b = false;
				}
			}
			else if (target.hp >= this.str * 1.5) {
				target.hp -= this.str * 1.5;
			} else {
				target.hp = 0;
			}
		}
		// 일반 공격
		else {
			System.out.println(this.name + "이 공격합니다.");
			if(b==true) {
				if (target.hp >= this.str*1.5) {
					System.out.println("인장 폭발!");
					target.hp -= this.str*1.5;
					b = false;
				} else {
					target.hp = 0;
					System.out.println("인장 폭발!");
					b = false;
				}
			}
			if (target.hp >= this.str) {
				target.hp -= this.str;
			} else {
				target.hp = 0;
			}
		}
	}

	@Override
	public String toString() {
		return "법사 : "+this.name +" [hp=" + hp + ",str=" + str +", type=" + type +"]";
	}

}

