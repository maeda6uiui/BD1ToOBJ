package com.github.dabasan.bd1_to_obj;

public class BD1ToOBJMain {
	public static void main(String[] args) {
		// コマンドライン引数の形式
		// 0: BD1ファイルのファイルパス (変換元)
		// 1: OBJファイルのファイルパス (変換先)
		// 2: Z軸を反転させるかどうか
		// 3: テクスチャのV座標を反転するかどうか
		if (args.length != 4) {
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

		boolean flipV;
		if (args[3].equals("false")) {
			flipV = false;
		} else {
			flipV = true;
		}

		var bd1ToObj = new BD1ToOBJ();
		int ret = bd1ToObj.convert(filepathBD1, filepathOBJ, invertZ, flipV);
		if (ret == -1) {
			System.err.println("Java-side error: Failed to convert.");
			return;
		}
	}
}
