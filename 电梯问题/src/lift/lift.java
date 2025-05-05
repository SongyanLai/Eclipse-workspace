package lift;

import java.io.*;

public class lift {
	private String firealarm;
	private String floorselect;
	private String quite;
	private int floor = 1;

	public void setquite() {
		System.out.println("Thank you, good bye!");
	}

	public void setfloorselect() throws IOException {
		String floorcs;
		System.out.println("输入你要前往的楼层");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in), 1);
		floorcs = stdin.readLine();
		int floorchoice = Integer.parseInt(floorcs);
		try {
			if (floorchoice < 1 || floorchoice > 100) {
				throw new RuntimeException();
			}
		} catch (RuntimeException e) {
			System.out.println("错误");
		}
		if (floorchoice > floor && floorchoice <= 100) {
			System.out.print("电梯上升");
			for (int b = 1; floor < floorchoice; b++) {
				floor++;
				System.out.print(".." + (floor));
			}
			System.out.println("...Ding!");
		} else if (floor > floorchoice && floorchoice >= 1) {
			System.out.print("电梯下降");
			for (int b = 1; floor > floorchoice; b++) {
				floor--;
				System.out.print(".." + floor);
			}
			System.out.println("...Ding!");
		}
	}

	public void setfirealarm() {
		System.out.println("Dnage! You must exit the bulding now!");
		if (floor > 1) {
			System.out.print("Gowing down");
			for (int b = 0; floor > 1; b++) {
				floor--;
				System.out.print(".." + floor);
			}
			System.out.println("...Ding!");
		}
	}
}