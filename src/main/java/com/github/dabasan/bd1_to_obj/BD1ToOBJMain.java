package com.github.dabasan.bd1_to_obj;

public class BD1ToOBJMain {
	public static void main(String[] args) {
		// コマンドライン引数の形式
		// 0: BD1ファイルのファイルパス (変換元)
		// 1: OBJファイルのファイルパス (変換先)
		// 2: Z軸を反転させるかどうか
		if (args.length != 3) {
			System.err.println("Java-side error: Invalid number of command-line arguments.");
			return;
		}

		String filepathBD1 = args[0];
		String filepathOBJ = args[1];

		boolean invertZ;
		if (args[2].equals("false")) {
			invertZ = false;
		} else {
			invertZ = true;
		}

		var bd1ToObj = new BD1ToOBJ();
		int ret = bd1ToObj.convert(filepathBD1, filepathOBJ, invertZ);
		if (ret == -1) {
			System.err.println("Java-side error: Failed to convert.");
			return;
		}
	}
}
