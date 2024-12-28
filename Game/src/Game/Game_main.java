package Game;

import java.util.Scanner;

public class Game_main {

	static int kill = 0;
	static boolean b = false;
	static boolean bb = true;
	static boolean DoubleAttack = false;
	static int gold = 0;
	static int exp = 0;
	static int expLever = 100;
	static int Lever = 1;
	static int doubleAttack = 24;
	static Player[] party = new Player[4];
	static nowKill nk = new nowKill();
	static d d = new d();
	static r r = new r();
	static t t = new t();
	static m m = new m();
	
	public static void main(String[] args) throws InterruptedException {
		while (bb) {
			int remainingExperience = expLever - exp;
			System.out.println("전투[b], 상점[s], 종료 [out], 안내사항 [g], 골드 : " + gold + " 레벨 : " + Lever + " 경험치 : " + exp
					+ " 다음 레벨 까지 남은 경험치 : " + remainingExperience);
			Scanner sc3 = new Scanner(System.in);
			String str3 = sc3.nextLine();
			switch (str3) {
			case "b":
				pick();
				round: for (int i = 0; i < 10; i++) {
					System.out.println("일반전 [c] 난이도 ★☆☆☆☆ ~ ★★★☆☆ 보스전 [b] 난이도 ★★★★☆ ~ ★★★★★ ");
					Scanner sc1 = new Scanner(System.in);
					String str1 = sc1.nextLine();

					switch (str1) {
					case "c":
						MRound();
						break round;
					case "b":
						loop:
						while(true) {
							System.out.println("보스 애니[a] 난이도 ★★★★☆ 보스 바론 [b] 난이도★★★★★");
							Scanner sc2 = new Scanner(System.in);
							String str2 = sc2.nextLine();
							switch (str2) {
							case "b":
								B_ARound();
								break round;
							case "a":
								B_BRound();
								break round;
							default:
								System.out.println("두가지중 하나를 입력하시오");
								break;
							}
						}
					default:
						System.out.println("두 가지중 하나를 입력하시오");
						i--;
						break;
					}
				}
				break;
			case "s":
				shop();
				break;
			case "out":
				bb = false;
				break;
			case "g":
				GuideBook();
				break;
			default:
				System.out.println("네 가지중 하나를 입력하시오");
			}
		}
	}

	
	
	public static void pick() {
		d d2 = d;
		r r2 = r;
		t t2 = t;
		m m2 = m;
		for (int i = 0; i < party.length; i++) {
			System.out.println("[" + i + "/4]용사들을 선택해 적을 섬멸하라! {말파이트 [m], 다리우스 [d], 르블랑 [l], 탈론[t] ");
			Scanner job = new Scanner(System.in);
			String str = job.nextLine();
			switch (str) {
			case "d":
				party[i] = new d(d2.name, d2.hp, d2.str);
				break;
			case "l":
				party[i] = new r(r2.name, r2.hp, r2.str);
				break;
			case "t":
				party[i] = new t(t2.name, t2.hp, t2.str);
				break;
			case "m":
				party[i] = new m(m2.name, m2.hp, m2.str);
				break;
			default:
				System.out.println("네 가지중 하나를 입력하시오");
				i--;
				break;
			}
		}
	}
	
	
	public static void shop() {
		i: while(true) {
			System.out.println("현재 골드 : " + gold);
			System.out.println("롱소드 350gold [롱소드] : str + 10");
			System.out.println("톱날단검 1100gold [톱날단검] : str + 40");
			System.out.println("천갑옷 300gold [천갑옷] : hp + 300");
			System.out.println("파수꾼의갑옷 1000gold [파수꾼의갑옷] : hp + 1100");
			System.out.println("장신구 뽑기 100000gold [가챠] : ");
			System.out.println("종료 [out]");
			Scanner sc4 = new Scanner(System.in);
			String str4 = sc4.nextLine();
			switch (str4) {
			case "out":
				break i;
			case "롱소드":
				if (gold < 350) {
					System.out.println("골드가 부족합니다. 파밍하시오");
				} else {
					d.str += 10;
					r.str += 10;
					t.str += 10;
					m.str += 10;
					gold -= 350;
				}
				break;
			case "톱날단검":
				if (gold < 1100) {
					System.out.println("골드가 부족합니다. 파밍하시오");
				} else {
					d.str += 40;
					r.str += 40;
					t.str += 40;
					m.str += 40;
					gold -= 1100;
				}
				break;
			case "천갑옷":
				if (gold < 300) {
					System.out.println("골드가 부족합니다. 파밍하시오");
				} else {
					d.hp += 300;
					r.hp += 300;
					t.hp += 300;
					m.hp += 300;
					gold -= 300;
				}
				break;
			case "파수꾼의갑옷":
				if (gold < 1000) {
					System.out.println("골드가 부족합니다. 파밍하시오");
				} else {
					d.hp += 1100;
					r.hp += 1100;
					t.hp += 1100;
					m.hp += 1100;
					gold -= 1000;
				}
				break;
			case "가챠":
				if (gold <= 100000) {
					System.out.println("골드가 부족합니다. 파밍하시오");
				} else {
					gold -= 100000;
					int random = (int) (Math.random() * 100) + 1;
					if (random == 1) {
						System.out.println("죽음의 반지 획득");
						kill++;
						System.out.println("현재 즉사 확률 : " + kill + "%");
					} else if (random >= 2 && 26 >= random) {
						d.hp += d.hp * 0.2;
						r.hp += r.hp * 0.2;
						t.hp += t.hp * 0.2;
						m.hp += m.hp * 0.2;
						System.out.println("거인의 허리띠 획득");
						System.out.println("hp 20%증가");
					} else if (random >= 27 && random <= 40) {
						d.str += d.str * 0.15;
						r.str += r.str * 0.15;
						t.str += t.str * 0.15;
						m.str += m.str * 0.15;
						System.out.println("암흑의 인장 획득");
						System.out.println("str 15%증가");
					} else if (random >= 41 && random <= 50) {
						System.out.println("시간의 반지 획득");
						DoubleAttack = true;
						doubleAttack++;
					} else {
						System.out.println("꽝");
					}
				}
				break;
			default:
				System.out.println("다섯 가지중 하나를 입력하시오");
				break;
			}
		}
	}
	
	public static void GuideBook() {
		loop1: while (true) {
			System.out.println("Guide Book");
			System.out.println("캐릭터 설명 [c], 몬스터 설명 [m], 아이템 설명 [i], 타입 설명 [t], 나가기 [out]");
			Scanner sc4 = new Scanner(System.in);
			String str4 = sc4.nextLine();
			switch (str4) {
			case "c":
				loop2: while (true) {
					System.out.println("말파이트 [m], 다리우스 [d], 르블랑 [l], 탈론[t] 나가기 [out]");
					Scanner sc5 = new Scanner(System.in);
					String str5 = sc5.nextLine();
					switch (str5) {
					case "m":
						System.out.println("이름 : 말파이트");
						System.out.println("기본 능력치 : hp 5000, str 15");
						System.out.println("현재 능력치 : hp " + m.hp + ", str " + m.str);
						System.out.println("스킬 : 천둥소리");
						System.out.println("천둥소리 : 자신의 str의 50%만큼 추가데미지를 주고 자신의 hp의 10%만큼 회복");
						break;
					case "d":
						System.out.println("이름 : 다리우스");
						System.out.println("기본 능력치 : hp 2400, str 30");
						System.out.println("현재 능력치 : hp " + d.hp + ", str " + d.str);
						System.out.println("스킬 : 학살");
						System.out.println("학살 : 자신의 str의 50%만큼 추가데미지를 주고 자신의 str만큼 hp를 회복");
						break;
					case "l":
						System.out.println("이름 : 르블랑");
						System.out.println("기본 능력치 : hp 1200, str 60");
						System.out.println("현재 능력치 : hp " + r.hp + ", str " + r.str);
						System.out.println("스킬 : 악의의 인장");
						System.out.println(
								"악의의 인장 : 자신의 str의 50%만큼 추가데미지를 주고 공격 대상에게 표식 부여, 다음 공격시 표식이 터지며 str의 50%만큼 추가 공격");
						break;
					case "t":
						System.out.println("이름 : 탈론");
						System.out.println("기본 능력치 : hp 2400, str 60");
						System.out.println("현재 능력치 : hp " + t.hp + ", str " + t.str);
						System.out.println("스킬 : 녹서스식 외교");
						System.out.println("녹서스식 외교 : 자신의 str의 50%만큼 추가데미지를 주고 녹서스식 외교로 적 처치시 자신의 hp의 50%만큼 회복");
						break;
					case "out":
						break loop2;
					default:
						System.out.println("다섯 가지중 하나를 입력하시오");
						break;
					}
				}
				break;
			case "m":
				loop3: while (true) {
					System.out.println("보스 몬스터 [b] 일반 몬스터 [c] 나가기 [out]");
					Scanner sc5 = new Scanner(System.in);
					String str5 = sc5.nextLine();
					switch (str5) {
					case "b":
						loop4: while (true) {
							System.out.println("바론 [b] 애니 [a] 티버 [t] 나가기 [out]");
							Scanner sc6 = new Scanner(System.in);
							String str6 = sc6.nextLine();
							switch (str6) {
							case "b":
								System.out.println("이름 : 바론");
								System.out.println("기본 능력치 : hp 40000, str 10");
								System.out.println("스킬 : 남작의 시선, 산성 발사");
								System.out.println("깐도의 억울한 외침 : 자신의 str을 현재 str의 50%만큼 증가 ※최대 200만큼 증가※");
								System.out.println("깐도의 넘어지기 3초전 : 자신의 str을 str의 50%만큼 추가데미지");
								break;
							case "a":
								System.out.println("이름 : 애니");
								System.out.println("기본 능력치 : hp 200, str 5");
								System.out.println("스킬 : 애니의 티버 소환술");
								System.out.println("애니의 티버 소환술 : 소환수 티버를 소환한다");
								break;
							case "t":
								System.out.println("이름 : 티버");
								System.out.println("기본 능력치 : hp 100000, str 100");
								System.out.println("스킬 : 티버의 솟구침");
								System.out.println("티버의 솟구침 : 자신의 str의 300%만큼 추가데미지");
								break;
							case "out":
								break loop4;
							default:
								System.out.println("네 가지중 하나를 입력하시오");
							}
						}
						break;
					case "c":
						loop4: while (true) {
							System.out.println("두꺼비 [두꺼비] 칼날부리 [칼날부리] 늑대 [늑대] 레드 [레드] 바위게 [바위게] 블루 [블루] 나가기 [out]");
							Scanner sc8 = new Scanner(System.in);
							String str7 = sc8.nextLine();
							switch (str7) {
							case "두꺼비":
								System.out.println("이름 : 두꺼비");
								System.out.println("기본 능력치 : hp 2500, str 10");
								System.out.println("스킬 : 할퀴기, 힐링팩터");
								System.out.println("할퀴기 : 자신의 str의 50%만큼 추가데미지");
								System.out.println("힐링팩터 : 자신의 hp를 20만큼 회복");
								break;
							case "칼날부리":
								System.out.println("이름 : 칼날부리");
								System.out.println("기본 능력치 : hp 1000, str 100");
								System.out.println("스킬 : 할퀴기, 힐링팩터");
								System.out.println("할퀴기 : 자신의 str의 50%만큼 추가데미지");
								System.out.println("힐링팩터 : 자신의 hp를 20만큼 회복");
								break;
							case "늑대":
								System.out.println("이름 : 늑대");
								System.out.println("기본 능력치 : hp 1000, str 100");
								System.out.println("스킬 : 할퀴기, 힐링팩터");
								System.out.println("할퀴기 : 자신의 str의 50%만큼 추가데미지");
								System.out.println("힐링팩터 : 자신의 hp를 20만큼 회복");
								break;
							case "레드":
								System.out.println("이름 : 레드");
								System.out.println("기본 능력치 : hp 3000, str 100");
								System.out.println("스킬 : 할퀴기, 힐링팩터");
								System.out.println("할퀴기 : 자신의 str의 50%만큼 추가데미지");
								System.out.println("힐링팩터 : 자신의 hp를 20만큼 회복");
								break;
							case "바위게":
								System.out.println("이름 : 바위게");
								System.out.println("기본 능력치 : hp 100, str 5");
								System.out.println("스킬 : 할퀴기, 힐링팩터");
								System.out.println("할퀴기 : 자신의 str의 50%만큼 추가데미지");
								System.out.println("힐링팩터 : 자신의 hp를 20만큼 회복");
								break;
							case "블루":
								System.out.println("이름 : 블루");
								System.out.println("기본 능력치 : hp 5000, str 50");
								System.out.println("스킬 : 할퀴기, 힐링팩터");
								System.out.println("할퀴기 : 자신의 str의 50%만큼 추가데미지");
								System.out.println("힐링팩터 : 자신의 hp를 20만큼 회복");
								break;
							case "out":
								break loop4;
							default:
								System.out.println("일곱 가지중 하나를 입력하시오");
							}
						}
						break;
					case "out":
						break loop3;
					default:
						System.out.println("세 가지중 하나를 입력하시오");
					}
				}
			case "i":
				System.out.println("거인의 허리띠");
				System.out.println("확률 : 25%");
				System.out.println("능력 : 현재 hp 20%증가");
				System.out.println("--------------------");
				System.out.println("암흑의 인장");
				System.out.println("확률 : 14");
				System.out.println("능력 : 현재 str 15증가");
				System.out.println("--------------------");
				System.out.println("죽음의 반지");
				System.out.println("확률 : 1%");
				System.out.println("능력 : 즉사 확률 1% 증가");
				System.out.println("--------------------");
				System.out.println("시간의 반지");
				System.out.println("확률 : 10");
				System.out.println("능력 : 2번 공격 ※25%부터 뽑을때마다 1%씩 증가※");
				System.out.println("--------------------");
				System.out.println("꽝");
				System.out.println("확률 : 50%");
				System.out.println("능력 : 없음");
				break;
			case "t":
				System.out.println("WATER, FIRE, EARTH, AIR");
				System.out.println("상성 : 물 > 불 > 땅 > 공기 > 물");
				break;
			case "out":
				break loop1;
			default:
				System.out.println("다섯 가지중 하나를 입력하시오");
			}
		}

	}

	public static void B_ARound() throws InterruptedException {
		int targetIdx = 0;
		boolean round = true;
		int PIdx = 0;
		Boss_A ggando = new Boss_A();
		while (round) {
			// player가 공격할 요소 : targetPIdx
			// monster가 공격할 요소 : targetMIdx
			// player가 공격할 몬스터의 hp가 0인 경우 targetIdx++;
			// 만약 targetIdx == mon.length-1 & 그 몬스터의 체력도 0이라면 -> break;
			if (ggando.hp <= 0) {
				targetIdx++;
			}
			if (party[PIdx].hp <= 0) {
				PIdx++;
			}
			int randomPlayer = (int) (Math.random() * 4);
			int randomSkill = (int) (Math.random() * 2);
			boolean tr = true;
			tr: while (tr) { // 때리는 유닛이 죽어있다면 계속 랜덤함수 뽑게 한다. 근데 왜 이거 안 먹냐 내가 생각을 잘 못 한건가? 왜 와일을
				// 역시 킹갓 디버깅 디버깅은 신이고 디버깅을 경배하라
				if (randomSkill == 0) {
					if (party[randomPlayer].hp <= 0) { // 때리는 유닛이 죽어있다면 공격 X
						randomPlayer = (int) (Math.random() * 4);
					} else if (party[randomPlayer].hp > 0) {
						int random = (int) (Math.random() * 100) + 1;
						if (random <= kill && random > 0) {
							nk.skill(ggando);
							System.out.println("즉사 효과 발동");
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							ggando.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						} else if (DoubleAttack == true) {
							if (random >= 0 && random <= doubleAttack) {
								System.out.println("더블어택 발동!");
								for (int k1 = 0; k1 < 2; k1++) {
									party[randomPlayer].attackByType(ggando);
								}
								ggando.attackByType(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								ggando.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);
							} else {
								party[randomPlayer].attackByType(ggando);
								ggando.attackByType(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								ggando.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);
							}
						} else {
							party[randomPlayer].attackByType(ggando);
							ggando.attackByType(party[PIdx]);
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							ggando.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						}
					}
				} else if (randomSkill == 1) {
					if (party[randomPlayer].hp <= 0) {
						randomPlayer = (int) (Math.random() * 4);
					} else if (party[randomPlayer].hp > 0) {
						int random = (int) (Math.random() * 100) + 1;
						if (random <= kill && random > 0) {
							nk.skill(ggando);
							System.out.println("즉사 효과 발동");
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
								ggando.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						} else if (DoubleAttack == true) {
							if (random >= 0 && random <= doubleAttack) {
								System.out.println("더블어택 발동!");
								for (int k1 = 0; k1 < 2; k1++) {
									party[randomPlayer].skill(ggando);
								}
								ggando.skill(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								ggando.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);

							} else {
								party[randomPlayer].skill(ggando);
								ggando.skill(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								ggando.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);
							}
						} else {
							party[randomPlayer].skill(ggando);
							ggando.skill(party[PIdx]);
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							ggando.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						}
					}
				}
			}
			if (ggando.hp == 0) {
				System.out.println("승리~");
				gold += 30000;
				exp += 3000;
				in: while (true) {
					if (exp >= expLever) {
						d.hp += 300;
						r.hp += 300;
						t.hp += 300;
						m.hp += 300;
						d.str += 10;
						r.str += 10;
						t.str += 10;
						m.str += 10;

						Lever++;
						expLever += expLever * 2;
					} else {
						break in;
					}
				}
				System.out.println("30000 골드 획득");
				System.out.println("현재 골드 : " + gold);
				System.out.println("현재 경험치 : " + exp);
				System.out.println("현재 레벨 : " + Lever);
				round = false;
			}
			if (PIdx == party.length - 1 && party[PIdx].hp == 0) {
				System.out.println("패배..");
				System.out.println("상점에서 장비 구매");
				round = false;
			}
		}
	}
	
	public static void B_BRound() throws InterruptedException {
		Boss_B gima = new Boss_B();
		int targetIdx = 0;
		boolean round = true;
		int PIdx = 0;
		while (round) {
			// player가 공격할 요소 : targetPIdx
			// monster가 공격할 요소 : targetMIdx
			// player가 공격할 몬스터의 hp가 0인 경우 targetIdx++;
			// 만약 targetIdx == mon.length-1 & 그 몬스터의 체력도 0이라면 -> break;
			if (gima.hp <= 0) {
				targetIdx++;
			}
			if (party[PIdx].hp <= 0) {
				PIdx++;
			}
			int randomPlayer = (int) (Math.random() * 4);
			int randomSkill = (int) (Math.random() * 2);
			boolean tr = true;
			tr: while (tr) { // 때리는 유닛이 죽어있다면 계속 랜덤함수 뽑게 한다. 근데 왜 이거 안 먹냐 내가 생각을 잘 못 한건가? 왜 와일을
				// 역시 킹갓 디버깅 디버깅은 신이고 디버깅을 경배하라
				if (randomSkill == 0) {
					if (party[randomPlayer].hp <= 0) { // 때리는 유닛이 죽어있다면 공격 X
						randomPlayer = (int) (Math.random() * 4);
					} else if (party[randomPlayer].hp > 0) {
						int random = (int) (Math.random() * 100) + 1;
						if (random <= kill && random > 0) {
							nk.skill(gima);						
							System.out.println("즉사 효과 발동");
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							gima.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						} else if (DoubleAttack == true) {
							if (random >= 0 && random <= doubleAttack) {
								System.out.println("더블어택 발동!");
								for (int k1 = 0; k1 < 2; k1++) {
									party[randomPlayer].attackByType(gima);	//ㅔ
								}
								gima.attackByType(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								gima.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);

							} else {
								party[randomPlayer].attackByType(gima);
								gima.attackByType(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								gima.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);
							}
						} else {
							party[randomPlayer].attackByType(gima);
							gima.attackByType(party[PIdx]);
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							gima.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						}
					}
				} else if (randomSkill == 1) {
					if (party[randomPlayer].hp <= 0) {
						randomPlayer = (int) (Math.random() * 4);
					} else if (party[randomPlayer].hp > 0) {
						int random = (int) (Math.random() * 100) + 1;
						if (random <= kill && random > 0) {
							nk.skill(gima);
							System.out.println("즉사 효과 발동");
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							gima.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						} else if (DoubleAttack == true) {
							if (random >= 0 && random <= doubleAttack) {
								System.out.println("더블어택 발동!");
								for (int k1 = 0; k1 < 2; k1++) {
									party[randomPlayer].skill(gima);
								}
								gima.skill(party[PIdx]);
								if (b == false) {
									gima = new Boss_C();
									b = true;
								}
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								gima.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);

							} else {
								party[randomPlayer].skill(gima);
								gima.skill(party[PIdx]);
								if (b == false) {
									gima = new Boss_C();
									b = true;
								}
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								gima.printInfo();
								System.out
										.println("-------------------------------------------");
								Thread.sleep(1000);
							}
						} else {
							party[randomPlayer].skill(gima);
							gima.skill(party[PIdx]);
							if (b == false) {
								gima = new Boss_C();
								b = true;
							}
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							gima.printInfo();
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						}
					}
				}
			}
			if (gima.hp == 0) {
				System.out.println("승리~");
				gold += 10000;
				exp += 1000;
				in: while (true) {
					if (exp >= expLever) {
						d.hp += 300;
						r.hp += 300;
						t.hp += 300;
						m.hp += 300;
						d.str += 10;
						r.str += 10;
						t.str += 10;
						m.str += 10;

						Lever++;
						expLever += expLever * 2;
					} else {
						break in;
					}
				}
				System.out.println("10000 골드 획득");
				System.out.println("현재 골드 : " + gold);
				System.out.println("현재 경험치 : " + exp);
				System.out.println("현재 레벨 : " + Lever);
				round = false;
			}
			if (PIdx == party.length - 1 && party[PIdx].hp == 0) {
				System.out.println("패배..");
				System.out.println("상점에서 장비 구매");
				round = false;
			}
		}
	}
	
	public static void MRound() throws InterruptedException{
		
		int num = (int) (Math.random() * 5) + 1;
		Monster[] mon = new Monster[num];
		for (int i = 0; i < mon.length; i++) {
			mon[i] = new Monster();
		}
		// 라운드 시작
		int targetIdx = 0;
		boolean round = true;
		int PIdx = 0;
		
		while (round) {
			// player가 공격할 요소 : targetPIdx
			// monster가 공격할 요소 : targetMIdx
			// player가 공격할 몬스터의 hp가 0인 경우 targetIdx++;
			// 만약 targetIdx == mon.length-1 & 그 몬스터의 체력도 0이라면 -> break;
			if (mon[targetIdx].hp <= 0) {
				targetIdx++;
			}
			if (party[PIdx].hp <= 0) {
				PIdx++;
			}
			int randomPlayer = (int) (Math.random() * 4);
			int randomSkill = (int) (Math.random() * 2);
			boolean tr = true;
			tr: while (tr) { 
				// 역시 킹갓 디버깅 디버깅은 신이고 디버깅을 경배하라
				if (randomSkill == 0) {
					if (party[randomPlayer].hp <= 0) {
						randomPlayer = (int) (Math.random() * 4);
					} else if (party[randomPlayer].hp > 0) {
						int random = (int) (Math.random() * 100) + 1;
						if (random <= kill && random > 0) {
							nk.skill(mon[targetIdx]);
							System.out.println("즉사 효과 발동");
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							for (int j = 0; j < mon.length; j++) {
								mon[j].printInfo();
							}
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						} else if (DoubleAttack == true) {
							if (random >= 0 && random <= doubleAttack) {
								System.out.println("더블어택 발동!");
								for (int k = 0; k < 2; k++) {
									party[randomPlayer].attackByType(mon[targetIdx]);
								}
								mon[targetIdx].attackByType(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								for (int j = 0; j < mon.length; j++) {
									mon[j].printInfo();
								}
								System.out.println("-------------------------------------------");
								Thread.sleep(1000);
							} else {
								party[randomPlayer].attackByType(mon[targetIdx]);
								mon[targetIdx].attackByType(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								for (int j = 0; j < mon.length; j++) {
									mon[j].printInfo();
								}
								System.out.println("-------------------------------------------");
								Thread.sleep(1000);
							}
						} else {
							party[randomPlayer].attackByType(mon[targetIdx]);
							mon[targetIdx].attackByType(party[PIdx]);
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							for (int j = 0; j < mon.length; j++) {
								mon[j].printInfo();
							}
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						}
					}
				} else if (randomSkill == 1) {
					if (party[randomPlayer].hp <= 0) {
						randomPlayer = (int) (Math.random() * 4);
					} else if (party[randomPlayer].hp > 0) {
						int random = (int) (Math.random() * 100) + 1;
						if (random <= kill && random > 0) {
							nk.skill(mon[targetIdx]);
							System.out.println("즉사 효과 발동");
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							for (int j = 0; j < mon.length; j++) {
								mon[j].printInfo();
							}
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						} else if (DoubleAttack == true) {
							if (random >= 0 && random <= doubleAttack) {
								System.out.println("더블어택 발동!");
								for (int k = 0; k < 2; k++) {
									party[randomPlayer].skill(mon[targetIdx]);
								}
								mon[targetIdx].skill(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								for (int j = 0; j < mon.length; j++) {
									mon[j].printInfo();
								}
								System.out.println("-------------------------------------------");
								Thread.sleep(1000);

							} else {
								party[randomPlayer].skill(mon[targetIdx]);
								mon[targetIdx].skill(party[PIdx]);
								for (int j = 0; j < party.length; j++) {
									party[j].printInfo();
									tr = false;
								}
								for (int j = 0; j < mon.length; j++) {
									mon[j].printInfo();
								}
								System.out.println("-------------------------------------------");
								Thread.sleep(1000);
							}
						} else {
							party[randomPlayer].skill(mon[targetIdx]);
							mon[targetIdx].skill(party[PIdx]);
							for (int j = 0; j < party.length; j++) {
								party[j].printInfo();
								tr = false;
							}
							for (int j = 0; j < mon.length; j++) {
								mon[j].printInfo();
							}
							System.out.println("-------------------------------------------");
							Thread.sleep(1000);
						}
					}
				}
				if (targetIdx == mon.length - 1 && mon[targetIdx].hp == 0) {
					System.out.println("승리~");
					gold += 100 * num;
					exp += 10 * num;
					in: while (true) {
						if (exp >= expLever) {
							d.hp += 300;
							r.hp += 300;
							t.hp += 300;
							m.hp += 300;
							d.str += 10;
							r.str += 10;
							t.str += 10;
							m.str += 10;

							Lever++;
							expLever += expLever * 2;
						} else {
							break in;
						}
					}
					System.out.println(100 * num + " 골드 획득");
					System.out.println("현재 골드 : " + gold);
					System.out.println("현재 경험치 : " + exp);
					System.out.println("현재 레벨 : " + Lever);
					round = false;
				}
				if (PIdx == party.length - 1 && party[PIdx].hp == 0) {
					System.out.println("패배..");
					System.out.println("상점에서 장비 구매");
					round = false;
				}
			}
		}
	}
}